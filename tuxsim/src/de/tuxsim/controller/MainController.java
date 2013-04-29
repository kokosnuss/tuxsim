package de.tuxsim.controller;

import java.io.IOException;
import de.tuxsim.model.Decoder;
import de.tuxsim.model.Instructions;
import de.tuxsim.model.Interna;
import de.tuxsim.view.Mainview;


public class MainController {
	private Decoder decoder;
	private Mainview gui;
	private Instructions instructions;
	private Interna interna;
	


	private int curInstruction;
	private int curAddress;
	
	public MainController() {
		this.decoder = new Decoder();
		this.gui = new Mainview();
		this.instructions = new Instructions(this);
		this.interna = new Interna();
	}

	
	public void temp() {
		this.initGui();
		this.readLst();
	}

	/**
	 * Enable Gui
	 */
	public void initGui() {
		gui.setVisible(true);
	}
	
	/**
	 * Call decoder function readLst
	 */
	public void readLst() {
		try {
			decoder.readLst(gui);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Executes the Instruction to the given Adress
	 * @param address
	 */
	public void execInstruction(int address) {
		curInstruction = decoder.getInstruction(address);
		curAddress = address;
		String binInstruction = Integer.toBinaryString(curInstruction);
		
		if (binInstruction.matches("^101.*")) {instructions.iGoto(curInstruction);}
		if (binInstruction.matches("^1100.*")) {instructions.movlw(curInstruction);}
		
		
	}
	/**
	 * @return the curInstruction
	 */
	public int getCurInstruction() {
		return curInstruction;
	}

	/**
	 * @return the curAdress
	 */
	public int getCurAdress() {
		return curAddress;
	}
	
	/**
	 * @return the interna
	 */
	public Interna getInterna() {
		return interna;
	}
}



