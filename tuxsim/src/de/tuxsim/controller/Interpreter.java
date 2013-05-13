package de.tuxsim.controller;

import de.tuxsim.model.Instructions;

public class Interpreter {
	private Instructions instructions;
	private MainController mc;
	
	public Interpreter(Instructions i, MainController mc) {
		this.instructions = i;
		this.mc = mc;
	}
	
	public void execInstruction(int curInstruction) {
        String binInstruction = Integer.toBinaryString(curInstruction);
        while (binInstruction.length() < 14) binInstruction = "0" + binInstruction; //führende Nullen hinzufügen
        
		//String binInstruction = Integer.toBinaryString(curInstruction);
		
		if (binInstruction.matches("^000111.*")) {instructions.addwf(curInstruction); } //addwf
		if (binInstruction.matches("^000101.*")) {} //andwf
		if (binInstruction.matches("^0000011.*")) {} //clrf
		if (binInstruction.matches("^0000010.*")) {instructions.clrw(curInstruction);} //clrw
		if (binInstruction.matches("^001001.*")) {instructions.comf(curInstruction);} //comf
		if (binInstruction.matches("^000011.*")) {instructions.decf(curInstruction);} //decf
		if (binInstruction.matches("^001011.*")) {instructions.decfsz(curInstruction);} //decfsz
		if (binInstruction.matches("^001010.*")) {instructions.incf(curInstruction);} //incf
		if (binInstruction.matches("^001111.*")) {} //incfsz
		if (binInstruction.matches("^000100.*")) {} //iorwf
		if (binInstruction.matches("^001000.*")) {} //movf
		if (binInstruction.matches("^0000001.*")) {instructions.movwf(curInstruction);} //movwf
		if (binInstruction.matches("^0000000.*")) {} //nop
		if (binInstruction.matches("^001101.*")) {} //rlf
		if (binInstruction.matches("^001100.*")) {} //rrf
		if (binInstruction.matches("^000010.*")) {instructions.subwf(curInstruction);} //subwf
		if (binInstruction.matches("^001110.*")) {} //swapf
		if (binInstruction.matches("^000110.*")) {} //xorwf
		if (binInstruction.matches("^0100.*")) {instructions.bcf(curInstruction);} //bcf
		if (binInstruction.matches("^0101.*")) {instructions.bsf(curInstruction);} //bsf
		if (binInstruction.matches("^0110.*")) {instructions.btfsc(curInstruction);} //btfsc
		if (binInstruction.matches("^0111.*")) {instructions.btfss(curInstruction);} //btfss
		if (binInstruction.matches("^11111.*")) {instructions.addlw(curInstruction);} //addlw
		if (binInstruction.matches("^111001.*")) {} //andlw
		if (binInstruction.matches("^100.*")) {instructions.call(curInstruction);} //call
		if (binInstruction.matches("^101.*")) {instructions.iGoto(curInstruction); } //GOTO
		if (binInstruction.matches("^111000.*")) {} //iorlw
		if (binInstruction.matches("^1100.*")) {instructions.movlw(curInstruction);} //movlw
		if (binInstruction.matches("^00000000001001.*")) {} //retfie
		if (binInstruction.matches("^1101.*")) {instructions.retlw(curInstruction);} //retlw
		if (binInstruction.matches("^00000000001000.*")) {} //return
		if (binInstruction.matches("^11110.*")) {} //sublw
		if (binInstruction.matches("^111010.*")) {} //xorlw
		//else {curAddress=decoder.getInstructionMap().size()+1;}
		
		mc.setPC(mc.getPC()+1);
		mc.updateGui();
	}

}
