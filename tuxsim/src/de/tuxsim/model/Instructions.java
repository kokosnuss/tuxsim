package de.tuxsim.model;

import de.tuxsim.controller.MainController;

public class Instructions {
	private MainController mc;
	
	public Instructions(MainController mc) {
		this.mc = mc;
	}
	
	/**
	 * Pic - Goto address
	 * @param instruction
	 */
	public void iGoto(int instruction) {
		int newAddress =  instruction & 2047;
		mc.setCurAdress(newAddress-1);
		System.out.println("GOTO "+Integer.toHexString(newAddress)+"-1");
	}
	/**
	 * Move literal to W-Register
	 * @param instruction
	 */
	public void movlw(int instruction) {
		int literal = instruction & 1023;
		mc.getInterna().setRegW(literal);
		System.out.println("movlw "+Integer.toHexString(literal));
	}
	/**
	 * Set bit b at register reg
	 * @param instruction
	 */
	public void bsf(int instruction) {
		int reg =  (instruction & 127);
		int b = (instruction & 896) >> 7;
		mc.getInterna().setBitAt(reg, b);
		System.out.println("bsf "+b+" at "+Integer.toHexString(reg));
	}
	/**
	 * Clear bit b at register reg
	 * @param instruction
	 */
	public void bcf(int instruction) {
		int reg =  (instruction & 127);
		int b = (instruction & 896) >> 7;
		mc.getInterna().clearBitAt(reg, b);
		System.out.println("bcf "+b+" at "+Integer.toHexString(reg));
	}
	/**
	 * Clear W-Register, Zero flag affected
	 * @param instruction
	 */
	public void clrw(int instruction) {
		mc.getInterna().setRegW(0);
		mc.getInterna().setBitAt(3, 2);
		System.out.println("Clear Wreg");
	}
	/**
	 * Move content of W-Register to Register f
	 * @param instruction
	 */
	public void movwf(int instruction) {
		int f = instruction & 127;
		int w = mc.getInterna().getRegW();
		mc.getInterna().setValueAt(w, f);
		System.out.println("move "+w+" to "+Integer.toHexString(f));
		
	}
}
