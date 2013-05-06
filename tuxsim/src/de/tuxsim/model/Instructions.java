package de.tuxsim.model;

import de.tuxsim.controller.MainController;

public class Instructions {
	private MainController mc;
	
	public Instructions(MainController mc) {
		this.mc = mc;
	}
	
	public void iGoto(int instruction) {
		int newAddress =  instruction & 2047;
		mc.setCurAdress(newAddress-1);
		System.out.println("GOTO "+newAddress+"-1");
	}
	
	public void movlw(int instruction) {
		int literal = instruction & 1023;
		mc.getInterna().setRegW(literal);
		System.out.println("movlw "+literal);
	}
	
	public void bsf(int instruction) {
		int reg =  (instruction & 127);
		int b = (instruction & 896) >> 7;
		mc.getInterna().setBitAt(reg, b);
		System.out.println("bsf "+b+" at "+reg);
	}
	
	public void bcf(int instruction) {
		int reg =  (instruction & 127);
		int b = (instruction & 896) >> 7;
		mc.getInterna().clearBitAt(reg, b);
		System.out.println("bcf "+b+" at "+reg);
	}

	public void clrw(int instruction) {
		mc.getInterna().setRegW(0);
		mc.getInterna().setBitAt(3, 2);
		System.out.println("Clear Wreg");
	}
}
