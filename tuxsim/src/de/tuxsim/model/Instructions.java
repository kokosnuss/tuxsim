package de.tuxsim.model;

import de.tuxsim.controller.MainController;

public class Instructions {
	private MainController mc;
	
	public Instructions(MainController mc) {
		this.mc = mc;
	}
	
	public void iGoto(int instruction) {
		int newAddress =  instruction & 2047;
		mc.execInstruction(newAddress);
	}
	
	public void movlw(int instruction) {
		int literal = instruction & 1023;
		mc.getInterna().setRegW(literal); 
		
	}

}
