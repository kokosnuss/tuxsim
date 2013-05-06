package de.tuxsim.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import de.tuxsim.model.Decoder;
import de.tuxsim.model.Instructions;
import de.tuxsim.model.Interna;
import de.tuxsim.view.Mainview;
import de.tuxsim.view.OpenFile;


public class MainController {
	private Decoder decoder;
	private Mainview gui;
	private OpenFile of;
	private Instructions instructions;
	private Interna interna;
	


	private int curInstruction;
	private int curAddress = 0;
	
	public MainController() {
		this.decoder = new Decoder();
		this.gui = new Mainview();
		this.instructions = new Instructions(this);
		this.interna = new Interna();
		this.of = new OpenFile();
	}

	
	public void temp() {
		this.initGui();
		this.addListener();
		
	}

	/**
	 * Enable Gui
	 */
	public void initGui() {
		gui.setVisible(true);
	}
	
	public void addListener() {
		this.gui.setOpenListener(new OpenListener());
		this.gui.setHelpListener(new HelpListener());
		this.gui.setAboutTuxSimListener(new AboutTuxSimListener());
		this.gui.setStartListener(new StartListener());
		this.gui.setStopListener(new StopListener());
		this.gui.setStepListener(new StepListener());
		this.gui.setResetListener(new ResetListener());
	}
	
	
	
	
	/**
	 * Executes the Instruction to the given Adress
	 * @param address
	 */
	public void execInstruction() {
		curInstruction = decoder.getInstruction(curAddress);
        String binInstruction = Integer.toBinaryString(curInstruction);
        while (binInstruction.length() < 14) binInstruction = "0" + binInstruction;
        
		//String binInstruction = Integer.toBinaryString(curInstruction);
		
		if (binInstruction.matches("^000111.*")) { } //addwf
		if (binInstruction.matches("^000101.*")) {} //andwf
		if (binInstruction.matches("^0000011.*")) {} //clrf
		if (binInstruction.matches("^0000010.*")) {instructions.clrw(curInstruction);} //clrw
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
		if (binInstruction.matches("^0100.*")) {instructions.bcf(curInstruction);} //bcf
		if (binInstruction.matches("^0101.*")) {instructions.bsf(curInstruction);} //bsf
		if (binInstruction.matches("^0110.*")) {} //btfsc
		if (binInstruction.matches("^0111.*")) {} //btfss
		if (binInstruction.matches("^11111.*")) {} //addlw
		if (binInstruction.matches("^111001.*")) {} //andlw
		if (binInstruction.matches("^100.*")) {} //call
		if (binInstruction.matches("^101.*")) {instructions.iGoto(curInstruction); } //GOTO
		if (binInstruction.matches("^111000.*")) {} //iorlw
		if (binInstruction.matches("^1100.*")) {instructions.movlw(curInstruction);} //movlw
		if (binInstruction.matches("^00000000001001.*")) {} //retfie
		if (binInstruction.matches("^1101.*")) {} //retlw
		if (binInstruction.matches("^00000000001000.*")) {} //return
		if (binInstruction.matches("^11110.*")) {} //sublw
		if (binInstruction.matches("^111010.*")) {} //xorlw
		//else {curAddress=decoder.getInstructionMap().size()+1;}
		curAddress += 1;
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
	
	public void setCurAdress(int a) {
		curAddress = a;
	}
	
	/**
	 * @return the interna
	 */
	public Interna getInterna() {
		return interna;
	}
	/**
	 * Intern class for StartBtnListener
	 * @author tuxpad
	 *
	 */
	class OpenListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File file = of.openFile(gui.getParent());
			try {
				decoder.readLst(gui,file);
				for (int i=0; i<=3; i++) {
					execInstruction();
					
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
			
		}
		
	}
	
	class HelpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class AboutTuxSimListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class StartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class StopListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class StepListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
}



