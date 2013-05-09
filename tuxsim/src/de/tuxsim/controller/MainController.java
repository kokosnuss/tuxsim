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
	 * Enable Gui & Reset View 
	 */
	public void initGui() {
		gui.setVisible(true);
		this.updateGui();
	}
	/**
	 * update/reset the Register(Model & View) to default, 
	 */
	public void updateGui() {
		gui.getTextPane("Wreg").setText(String.valueOf(interna.getRegW()));
		gui.getTextPane("FSRreg").setText(String.valueOf(interna.getValueAt(0x4)));
		gui.getTextPane("TMR0").setText(String.valueOf(interna.getValueAt(0x1)));
		gui.getTextPane("PCLreg").setText(String.valueOf(interna.getValueAt(0x2)));
		
		gui.getTextPane("RP0").setText(String.valueOf(interna.getBitAt(0x3, 5)));
		gui.getTextPane("TO").setText(String.valueOf(interna.getBitAt(0x3,4)));
		gui.getTextPane("PD").setText(String.valueOf(interna.getBitAt(0x3,3)));
		gui.getTextPane("Z").setText(String.valueOf(interna.getBitAt(0x3,2)));
		gui.getTextPane("DC").setText(String.valueOf(interna.getBitAt(0x3,1)));
		gui.getTextPane("C").setText(String.valueOf(interna.getBitAt(0x3,0)));
		
		gui.getTextPane("RA4").setText(String.valueOf(interna.getBitAt(0x5,4)));
		gui.getTextPane("RA3").setText(String.valueOf(interna.getBitAt(0x5,3)));
		gui.getTextPane("RA2").setText(String.valueOf(interna.getBitAt(0x5,2)));
		gui.getTextPane("RA1").setText(String.valueOf(interna.getBitAt(0x5,1)));
		gui.getTextPane("RA0").setText(String.valueOf(interna.getBitAt(0x5,0)));
		
		
		gui.getTextPane("RB7").setText(String.valueOf(interna.getBitAt(0x5,7)));
		gui.getTextPane("RB6").setText(String.valueOf(interna.getBitAt(0x5,6)));
		gui.getTextPane("RB5").setText(String.valueOf(interna.getBitAt(0x5,5)));
		gui.getTextPane("RB4").setText(String.valueOf(interna.getBitAt(0x5,4)));
		gui.getTextPane("RB3").setText(String.valueOf(interna.getBitAt(0x5,3)));
		gui.getTextPane("RB2").setText(String.valueOf(interna.getBitAt(0x5,2)));
		gui.getTextPane("RB1").setText(String.valueOf(interna.getBitAt(0x5,1)));
		gui.getTextPane("RB0").setText(String.valueOf(interna.getBitAt(0x5,0)));
		
		
		int rowReg=0x0;
		for (int i=0;i<gui.getRegister().getRowCount();i++) {
			for (int j=0;j<=7;j++) {
				gui.getRegister().setValueAt(interna.getValueAt(rowReg+j), i, j+1);
			}
			rowReg +=0x8;
		}
	}
	
	/**
	 * Initialize all Listener of gui
	 */
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
	 * Executes the instruction of current Adress
	 * 
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
		if (binInstruction.matches("^0000001.*")) {instructions.movwf(curInstruction);} //movwf
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
		this.updateGui();
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
			execInstruction();
		}
	}
	
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			curAddress=0;
			curInstruction=0;
			interna.setRegW(0);
			interna.initRegister();
			updateGui();
		}
	}
}



