package de.tuxsim.controller;


import de.tuxsim.model.Instructions;
/**
 * This Class interpretes the 14-bit opcode
 * @author tuxpad
 *
 */
public class Interpreter {
	private Instructions instructions;
	private MainController mc;
	
	public Interpreter(Instructions i, MainController mc) {
		this.instructions = i;
		this.mc = mc;
	}
	
	/**
	 * Execute Instruction to given opcode
	 * @param curInstruction Opcode from LST-File
	 */
	public void execInstruction(int curInstruction) {
		 mc.checkInterrupt();
		
        String binInstruction = Integer.toBinaryString(curInstruction);
        while (binInstruction.length() < 14) binInstruction = "0" + binInstruction; //führende Nullen hinzufügen
        
        //BYTE ORIENTED OPs
        if (binInstruction.matches("^00.*")) {
        	int f = curInstruction & 127;
        	if (f==0) f= mc.getInterna().getValueAt(0x4); //Indirect Addressing
        	int d = (curInstruction & 128) >> 7;
        
        
	        if (binInstruction.matches("^000111.*")) {instructions.addwf(f,d); } //addwf
	        if (binInstruction.matches("^000101.*")) {instructions.andwf(f, d);} //andwf
			if (binInstruction.matches("^0000011.*")) {instructions.clrf(f, d);} //clrf
			if (binInstruction.matches("^0000010.*")) {instructions.clrw();} //clrw
			if (binInstruction.matches("^001001.*")) {instructions.comf(f,d);} //comf
			if (binInstruction.matches("^000011.*")) {instructions.decf(f,d);} //decf
			if (binInstruction.matches("^001011.*")) {instructions.decfsz(f,d);} //decfsz
			if (binInstruction.matches("^001010.*")) {instructions.incf(f,d);} //incf
			if (binInstruction.matches("^001111.*")) {instructions.incfsz(f, d);} //incfsz
			if (binInstruction.matches("^000100.*")) {instructions.iorwf(f, d);} //iorwf
			if (binInstruction.matches("^001000.*")) {instructions.movf(f, d);} //movf
			if (binInstruction.matches("^0000001.*")) {instructions.movwf(f,d);} //movwf
			if (binInstruction.matches("^0000000.*")) {} //nop
			if (binInstruction.matches("^001101.*")) {instructions.rlf(f, d);} //rlf
			if (binInstruction.matches("^001100.*")) {instructions.rrf(f, d);} //rrf
			if (binInstruction.matches("^000010.*")) {instructions.subwf(f,d);} //subwf
			if (binInstruction.matches("^001110.*")) {instructions.swapf(f, d);} //swapf
			if (binInstruction.matches("^000110.*")) {instructions.xorwf(f, d);} //xorwf
        }
        //BIT ORIENTED OPs
        else if (binInstruction.matches("^01.*")) {
    		int f =  (curInstruction & 127);
    		int b = (curInstruction & 896) >> 7;
    		
			if (binInstruction.matches("^0100.*")) {instructions.bcf(f,b);} //bcf
			if (binInstruction.matches("^0101.*")) {instructions.bsf(f,b);} //bsf
			if (binInstruction.matches("^0110.*")) {instructions.btfsc(f,b);} //btfsc
			if (binInstruction.matches("^0111.*")) {instructions.btfss(f,b);} //btfss
        }
        else {
        //LITERAL AND CONTROL OPs
        	int k = curInstruction & 255;
			if (binInstruction.matches("^11111.*")) {instructions.addlw(k);} //addlw
			if (binInstruction.matches("^111001.*")) {instructions.andlw(k);} //andlw
			if (binInstruction.matches("^111000.*")) {instructions.iorlw(k);} //iorlw
			if (binInstruction.matches("^1100.*")) {instructions.movlw(k);} //movlw
			if (binInstruction.matches("^00000000001001.*")) {instructions.retfie();} //retfie
			if (binInstruction.matches("^1101.*")) {instructions.retlw(k);} //retlw
			if (binInstruction.matches("^00000000001000.*")) {instructions.Return();} //return
			if (binInstruction.matches("^11110.*")) {instructions.sublw(k);} //sublw
			if (binInstruction.matches("^111010.*")) instructions.xorlw(k);{} //xorlw
			k = curInstruction & 2047;
			if (binInstruction.matches("^100.*")) {instructions.call(k);} //call
			if (binInstruction.matches("^101.*")) {instructions.iGoto(k); } //GOTO
        }
        
		mc.setPC(mc.getPC()+1);
		mc.updateGui();
	}

}
