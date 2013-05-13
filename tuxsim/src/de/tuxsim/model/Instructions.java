package de.tuxsim.model;

import de.tuxsim.controller.MainController;

public class Instructions {
	private MainController mc;
	
	public Instructions(MainController mc) {
		this.mc = mc;
	}
	
	public void addlw(int k) {
		int help = mc.getInterna().getRegW() + k;
		if (help>255) {
			help = help % 256;
			mc.getInterna().setBitAt(0x3, 0); //Carry 
		} else {
			mc.getInterna().clearBitAt(0x3, 0);
		}
		if (help == 0) {
			mc.getInterna().setBitAt(0x3, 2); //Zero
		} else {
			mc.getInterna().clearBitAt(0x3, 2);
		}
		mc.getInterna().setRegW(help);
		System.out.println("addlw "+k+" help="+help);
	}
	/**
	 * add content of w with f; C,Z affected
	 * @param instruction
	 */
	public void addwf(int f, int d) {
		int help = mc.getInterna().getRegW() + mc.getInterna().getValueAt(f);
		if (help > 255) {
			help = help % 256;
			mc.getInterna().setBitAt(0x3, 0); //Carry set
		} else {
			mc.getInterna().clearBitAt(0x3, 0); //Carry clear
		}
		if (help == 0) {
			mc.getInterna().setBitAt(0x3, 2); //Zero set
		} else {
			mc.getInterna().clearBitAt(0x3, 2); // Zero clear
		}
		if (d == 0) {
			mc.getInterna().setRegW(help); //in W
		} else {
			mc.getInterna().setValueAt(help, f);//in f
		}
		System.out.println("addwf "+Integer.toHexString(f)+" help="+help);
	}
	/**
	 * Clear bit b at register reg
	 * @param instruction
	 */
	public void bcf(int f, int b) {
		mc.getInterna().clearBitAt(f, b);
		System.out.println("bcf "+b+" at "+Integer.toHexString(f));
	}
	/**
	 * Set bit b at register reg
	 * @param instruction
	 */
	public void bsf(int f, int b) {
		mc.getInterna().setBitAt(f, b);
		System.out.println("bsf "+b+" at "+Integer.toHexString(f));
	}
	/**
	 * Call Subroutine, PCL+1 is pushed to Stack
	 * @param instruction
	 */
	public void call(int k) {
		mc.getInterna().getPcstack().push(mc.getPC()+1);
		mc.setPC(k-1);
		System.out.println("Call "+Integer.toHexString(k));
	}
	/**
	 * Clear W-Register, Zero flag affected
	 * @param instruction
	 */
	public void clrw() {
		mc.getInterna().setRegW(0);
		mc.getInterna().setBitAt(3, 2); //Zero Bit
		System.out.println("Clear Wreg");
	}
	/**
	 * content of register f are complemented
	 * @param instruction
	 */
	public void comf(int f, int d) {
		int help = ~(mc.getInterna().getValueAt(f));
		help &= 255;
		if (help ==0) {
			mc.getInterna().setBitAt(0x3, 2);
		}else {
			mc.getInterna().clearBitAt(0x3, 2);
		}
		if (d==0) {
			mc.getInterna().setRegW(help);
		}else {
			mc.getInterna().setValueAt(help, f);
		}
		System.out.println("comf "+Integer.toHexString(f)+" help="+help);
	}
	/**
	 * Decf, if reg=0, zero is set, d=destination
	 * @param instruction
	 */
	public void decf(int f, int d) {
		int help = mc.getInterna().getValueAt(f) -1;
		
		if (help==0) {
			mc.getInterna().setBitAt(0x3, 2); //ZeroBit
		} else {
			mc.getInterna().clearBitAt(0x3, 2);
		}
		if (d == 0) {//Destination
			mc.getInterna().setRegW(help);
		} else {
			mc.getInterna().setValueAt(help, f);
		}
		System.out.println("decf "+Integer.toHexString(f)+" help="+help);
	}
	/**skip if result of decf = 0
	 * @see Instructions#decf(int)
	 * @param instruction
	 */
	public void decfsz(int f, int d) {
		decf( f,  d);
		if(mc.getInterna().getValueAt(f) != 0) {
			return;
		}else {
			mc.setPC(mc.getPC()+1);
		}
		System.out.println("decfsz "+Integer.toHexString(f)+" result="+mc.getInterna().getValueAt(f));
	}
	/**
	 * Pic - Goto address
	 * @param instruction
	 */
	public void iGoto(int k) {
		mc.setPC(k-1);
		System.out.println("GOTO "+Integer.toHexString(k)+"-1");
	}
	/**
	 * Increment content of Register f, Zero Bit Set
	 * @param instruction
	 */
	public void incf(int f, int d) {
		int help = mc.getInterna().getValueAt(f) +1;
		
		if (help > 255) {
			help = help % 256;
		}
		if (help == 0) { //Zero-Bit
			mc.getInterna().setBitAt(0x3, 2);
		} else {
			mc.getInterna().clearBitAt(0x3, 2);
		}
		if (d == 0) {//Destination
			mc.getInterna().setRegW(help);
		} else {
			mc.getInterna().setValueAt(help, f);
		}
		System.out.println("incf "+Integer.toHexString(f)+" d="+d);
	}
	/**
	 * Move literal to W-Register
	 * @param instruction
	 */
	public void movlw(int k) {
		mc.getInterna().setRegW(k);
		System.out.println("movlw "+k);
	}
	/**
	 * Move content of W-Register to Register f
	 * @param instruction
	 */
	public void movwf(int f, int d) {
		int w = mc.getInterna().getRegW();
		mc.getInterna().setValueAt(w, f);
		System.out.println("move "+w+" to "+Integer.toHexString(f));
	}
	/**
	 * Return with literal
	 * @param instruction
	 */
	public void retlw(int k) {
		mc.getInterna().setRegW(k);
		mc.setPC(mc.getInterna().getPcstack().pop()-1);
		System.out.println("retlw "+k+" pc="+mc.getPC());
	}
	/**
	 * Subtract W register from register f
	 * @param instruction
	 */
	public void subwf(int f, int d) {
		int help = mc.getInterna().getValueAt(f) - mc.getInterna().getRegW();
		if (help < 0) {
			help = help + 256;
			mc.getInterna().clearBitAt(0x3, 0); //Carry clear
		} else {
			mc.getInterna().setBitAt(0x3, 0); //Carry Set
		}
		if (help == 0) {
			mc.getInterna().setBitAt(0x3, 2); //Zero set
		} else {
			mc.getInterna().clearBitAt(0x3, 2); //Zero clear
		}
		if (d == 0) {
			mc.getInterna().setRegW(help); // d = wReg
		} else {
			mc.getInterna().setValueAt(help, f); //d = fReg
		}
		System.out.println("subwf "+Integer.toHexString(f)+" help="+help);
	}
	/**
	 * bit test f, skip if clear
	 * @param instruction
	 */
	public void btfsc(int f, int b) {
		
		if (mc.getInterna().getBitAt(f, b) == 0) {
			mc.setPC(mc.getPC()+1);
		}
		System.out.println("btfsc "+Integer.toHexString(f)+","+b+" result="+mc.getInterna().getBitAt(f, b));
	}
	/**
	 * bit test f, skip if set
	 * @param instruction
	 */
	public void btfss(int f, int b) {
		
		if (mc.getInterna().getBitAt(f, b) != 0) {
			mc.setPC(mc.getPC()+1);
		}
		System.out.println("btfss "+Integer.toHexString(f)+","+b+" result="+mc.getInterna().getBitAt(f, b));
	}
	/**
	 * 
	 * @param f
	 * @param d
	 */
	public void andwf(int f,int d) {
		int help = mc.getInterna().getRegW() & mc.getInterna().getValueAt(f);
		if (help == 0) {
			mc.getInterna().setBitAt(0x3, 2); //Zero set
		} else {
			mc.getInterna().clearBitAt(0x3, 2); //Zero clear
		}
		if (d == 0) {
			mc.getInterna().setRegW(help); // d = wReg
		} else {
			mc.getInterna().setValueAt(help, f); //d = fReg
		}
		System.out.println("andwf "+ mc.getInterna().getRegW()+" "+  mc.getInterna().getValueAt(f));
	}
	
	public void clrf(int f,int d) {
		mc.getInterna().setValueAt(0, f);
		mc.getInterna().setBitAt(0x3, 2);
		System.out.println("clrf "+f);
	}
	
	public void incfsz(int f, int d) {
		incf(f, d);
		if(mc.getInterna().getValueAt(f) != 0) {
			return;
		}else {
			mc.setPC(mc.getPC()+1);
		}
		System.out.println("incfsz "+Integer.toHexString(f)+" result="+mc.getInterna().getValueAt(f));
	}
	
	public void iorwf(int f, int d) {
		int help = mc.getInterna().getRegW() | mc.getInterna().getValueAt(f);
		if (help == 0) {
			mc.getInterna().setBitAt(0x3, 2); //Zero set
		} else {
			mc.getInterna().clearBitAt(0x3, 2); //Zero clear
		}
		if (d == 0) {
			mc.getInterna().setRegW(help); // d = wReg
		} else {
			mc.getInterna().setValueAt(help, f); //d = fReg
		}
	}
	
	public void movf(int f,int d) {
		int help = mc.getInterna().getValueAt(f);
		if (help == 0) {
			mc.getInterna().setBitAt(0x3, 2); //Zero set
		} else {
			mc.getInterna().clearBitAt(0x3, 2); //Zero clear
		}
		if (d == 0) {
			mc.getInterna().setRegW(help); // d = wReg
		} else {
			mc.getInterna().setValueAt(help, f); //d = fReg
		}
	}
}
