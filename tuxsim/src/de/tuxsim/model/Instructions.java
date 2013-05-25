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
		
	}

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
		
	}
	
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
		
	}
	
	public void bcf(int f, int b) {
		mc.getInterna().clearBitAt(f, b);
		
	}
	public void bsf(int f, int b) {
		mc.getInterna().setBitAt(f, b);
		
	}
	public void btfsc(int f, int b) {
		
		if (mc.getInterna().getBitAt(f, b) == 0) {
			mc.setPC(mc.getPC()+1);
		}
		
	}
	public void btfss(int f, int b) {
		
		if (mc.getInterna().getBitAt(f, b) != 0) {
			mc.setPC(mc.getPC()+1);
		}
		
	}
	public void call(int k) {
		mc.getInterna().getPcstack().push(mc.getPC()+1);
		mc.setPC(k-1);
		
	}
	public void clrf(int f,int d) {
		mc.getInterna().setValueAt(0, f);
		mc.getInterna().setBitAt(0x3, 2);
		
	}
	public void clrw() {
		mc.getInterna().setRegW(0);
		mc.getInterna().setBitAt(3, 2); //Zero Bit
		
	}
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
		
	}
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
		
	}
	public void decfsz(int f, int d) {
		decf( f,  d);
		if(mc.getInterna().getValueAt(f) != 0) {
			return;
		}else {
			mc.setPC(mc.getPC()+1);
		}
		
	}
	public void iGoto(int k) {
		mc.setPC(k-1);
		
	}
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
		
	}
	public void incfsz(int f, int d) {
		incf(f, d);
		if(mc.getInterna().getValueAt(f) != 0) {
			return;
		}else {
			mc.setPC(mc.getPC()+1);
		}
		
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
	
	public void movlw(int k) {
		mc.getInterna().setRegW(k);
		
	}
	
	public void movwf(int f, int d) {
		int w = mc.getInterna().getRegW();
		mc.getInterna().setValueAt(w, f);
		
	}
	
	public void retlw(int k) {
		mc.getInterna().setRegW(k);
		mc.setPC(mc.getInterna().getPcstack().pop()-1);
		
	}
	
	public void rlf(int f, int d) {
		int help = mc.getInterna().getValueAt(f);
		help = help << 1;
		if (mc.getInterna().getBitAt(0x3, 0)==1) {
			help = help + 1;
			mc.getInterna().clearBitAt(0x3, 0);
		}
		if (help > 255) {
			help = help % 256;
			mc.getInterna().setBitAt(0x3, 0);
		}
		if (d == 0) {
			mc.getInterna().setRegW(help);
		} else {
			mc.getInterna().setValueAt(help, f);
		}
	}
	
	public void rrf(int f, int d) {
		int help = mc.getInterna().getValueAt(f);
		help = help >> 1;
		if (mc.getInterna().getBitAt(0x3, 0)==1) {
			help = help + 128;
		}
		if ((mc.getInterna().getValueAt(f) % 2) == 0) {
			mc.getInterna().clearBitAt(0x3, 0);
		} else {
			mc.getInterna().setBitAt(0x3, 0);
		}
		if (d == 0) {
			mc.getInterna().setRegW(help);
		} else {
			mc.getInterna().setValueAt(help, f);
		}
	}
	
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
	}
	
	public void swapf(int f, int d) {
		int help = mc.getInterna().getValueAt(f) << 4;
		help = help & (~(0xF << 8));
		help = help | (mc.getInterna().getValueAt(f) >> 4);
		if (d == 0) {
			mc.getInterna().setRegW(help);
		} else {
			mc.getInterna().setValueAt(help, f);
		}
	}
	
	public void xorwf(int f, int d) {
		int help = mc.getInterna().getValueAt(f) ^ mc.getInterna().getRegW();
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
	
	public void andlw(int k) {
		int help = mc.getInterna().getRegW() & k;
		mc.getInterna().setRegW(help);
		if (help == 0) {
			mc.getInterna().setBitAt(0x3, 2); //Zero set
		} else {
			mc.getInterna().clearBitAt(0x3, 2); //Zero clear
		}
	}
	
	public void iorlw(int k) {
		int help = mc.getInterna().getRegW() | k;
		mc.getInterna().setRegW(help);
		if (help == 0) {
			mc.getInterna().setBitAt(0x3, 2); //Zero set
		} else {
			mc.getInterna().clearBitAt(0x3, 2); //Zero clear
		}
	}
	
	public void retfie() {
		
		mc.setPC(mc.getInterna().getPcstack().pop()-1);
		int pc = mc.getPC();
		mc.getInterna().setBitAt(0xB, 7);
		mc.isInterrupted = false;
	}
	
	public void Return() {
		mc.setPC(mc.getInterna().getPcstack().pop()-1);
	}
	
	public void sublw(int k) {
		int help = k % 256;
		help = help - mc.getInterna().getRegW();
		if (help < 0) {
			help = help + 256;
			mc.getInterna().clearBitAt(0x3, 0); //Carry clear
		} else {
			mc.getInterna().setBitAt(0x3, 0);	//Carry Set
		}
		if (help == 0) {
			mc.getInterna().setBitAt(0x3, 2);	//Zero Set
		} else {
			mc.getInterna().clearBitAt(0x3, 2); //Zero Clear
		}
		mc.getInterna().setRegW(help);
	}
	
	public void xorlw(int k) {
		int help = mc.getInterna().getRegW() ^ k;
		if (help == 0) {
			mc.getInterna().setBitAt(0x3, 2);	//Zero Set
		} else {
			mc.getInterna().clearBitAt(0x3, 2); //Zero Clear
		}
		mc.getInterna().setRegW(help);
	}
}
