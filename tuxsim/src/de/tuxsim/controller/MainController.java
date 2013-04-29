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
		if (binInstruction.matches("^000111.*")) { } //addwf
		if (binInstruction.matches("^000101.*")) {} //andwf
		if (binInstruction.matches("^0000011.*")) {} //clrf
		if (binInstruction.matches("^0000010.*")) {} //clrw
		if (binInstruction.matches("^001001.*")) {} //comf
		if (binInstruction.matches("^000011.*")) {} //decf
		if (binInstruction.matches("^001011.*")) {} //decfsz
		if (binInstruction.matches("^001010.*")) {} //incf
		if (binInstruction.matches("^001111.*")) {} //incfsz
		if (binInstruction.matches("^000100.*")) {} //iorwf
		if (binInstruction.matches("^001000.*")) {} //movf
		if (binInstruction.matches("^0000001.*")) {} //movwf
		if (binInstruction.matches("^0000000.*")) {} //nop
		if (binInstruction.matches("^001101.*")) {} //rlf
		if (binInstruction.matches("^001100.*")) {} //rrf
		if (binInstruction.matches("^000010.*")) {} //subwf
		if (binInstruction.matches("^001110.*")) {} //swapf
		if (binInstruction.matches("^000110.*")) {} //xorwf
		if (binInstruction.matches("^0100.*")) {} //bcf
		if (binInstruction.matches("^0101.*")) {} //bsf
		if (binInstruction.matches("^0110.*")) {} //btfsc
		if (binInstruction.matches("^0111.*")) {} //btfss
		if (binInstruction.matches("^11111.*")) {} //addlw
		if (binInstruction.matches("^111001.*")) {} //andlw
		if (binInstruction.matches("^100.*")) {} //call
		if (binInstruction.matches("^101.*")) {instructions.iGoto(curInstruction);} //GOTO
		if (binInstruction.matches("^111000.*")) {} //iorlw
		if (binInstruction.matches("^1100.*")) {instructions.movlw(curInstruction);} //movlw
		if (binInstruction.matches("^00000000001001.*")) {} //retfie
		if (binInstruction.matches("^1101.*")) {} //retlw
		if (binInstruction.matches("^00000000001000.*")) {} //return
		if (binInstruction.matches("^11110.*")) {} //sublw
		if (binInstruction.matches("^111010.*")) {} //xorlw
		if (binInstruction.matches("^101.*")) {instructions.iGoto(curInstruction);}
		if (binInstruction.matches("^1100.*")) {instructions.movlw(curInstruction);}
		else {curAddress=decoder.getInstructionMap().size()+1;}
		
		
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



