package de.tuxsim.model;

import java.util.Stack;


/**
 * This class represents the PIC interna with the registers, memory ...
 * @author tuxpad
 *
 */
public class Interna {
	private short Register[];

	private int regW;
	private Stack<Integer> pcstack;
	

	public Interna() {
		this.initRegister();
		this.initStack();
	}
	
	/**
	 * Init array of bytes for every single Register
	 * Set default values
	 */
	public void initRegister() {
		Register = new short[0x100];
		for (int i = 0; i < this.Register.length; i++) {
			this.Register[i] = 0;
		}
		this.Register[0x3] = Short.parseShort("00011000", 2);
		this.Register[0x83] = Short.parseShort("00011000", 2);
		this.Register[0x81] = Short.parseShort("11111111", 2);
		this.Register[0x85] = Short.parseShort("00011111", 2);
		this.Register[0x86] = Short.parseShort("11111111", 2);
		
	}
	/**
	 * Init the Stack for PCL
	 */
	public void initStack() {
		pcstack = new Stack<Integer>();
		pcstack.clear();
	}
	/**
	 * Set bit at Register with verify bank
	 * @param index Register
	 * @param bit position to set
	 */
	public void setBitAt(int index, int bit) {
		short help = 1;
		help = (short) (help << bit);
		// Auf Bank überprüfen und ggf. Indexwert anpassen
		switch (index) {
		case 0x0:
			this.Register[0x0] = (short) (this.Register[index] | help);
			this.Register[0x80] = (short) (this.Register[index] | help);
			break;
		case 0x2:
			this.Register[0x2] = (short) (this.Register[index] | help);
			this.Register[0x82] = (short) (this.Register[index] | help);
			break;
		case 0x3:
			this.Register[0x3] = (short) (this.Register[index] | help);
			this.Register[0x83] = (short) (this.Register[index] | help);
			break;
		case 0x4:
			this.Register[0x4] = (short) (this.Register[index] | help);
			this.Register[0x84] = (short) (this.Register[index] | help);
			break;
		case 0xA:
			this.Register[0xA] = (short) (this.Register[index] | help);
			this.Register[0x8A] = (short) (this.Register[index] | help);
			break;
		case 0xB:
			this.Register[0xB] = (short) (this.Register[index] | help);
			this.Register[0x8B] = (short) (this.Register[index] | help);
			break;
		case 0x80:
			this.Register[0x0] = (short) (this.Register[index] | help);
			this.Register[0x80] = (short) (this.Register[index] | help);
			break;
		case 0x82:
			this.Register[0x2] = (short) (this.Register[index] | help);
			this.Register[0x82] = (short) (this.Register[index] | help);
			break;
		case 0x83:
			this.Register[0x3] = (short) (this.Register[index] | help);
			this.Register[0x83] = (short) (this.Register[index] | help);
			break;
		case 0x84:
			this.Register[0x4] = (short) (this.Register[index] | help);
			this.Register[0x84] = (short) (this.Register[index] | help);
			break;
		case 0x8A:
			this.Register[0xA] = (short) (this.Register[index] | help);
			this.Register[0x8A] = (short) (this.Register[index] | help);
			break;
		case 0x8B:
			this.Register[0xB] = (short) (this.Register[index] | help);
			this.Register[0x8B] = (short) (this.Register[index] | help);
			break;
		default:
			if ((checkBank() == 1) && (index < 0x80))
				index = index + 0x80;
			this.Register[index] = (short) (this.Register[index] | help);
			break;
		}
		return;
	}
	/**
	 * Clear bit at Register with verify bank
	 * @param index Register
	 * @param bit position to clear
	 */
	public void clearBitAt(int index, int bit) {
		short help = 1;
		help = (short) (help << bit);
		help = (short) ~help;
		// Auf Bank überprüfen und ggf. Indexwert anpassen
		switch (index) {
		case 0x0:
			this.Register[0x0] = (short) (this.Register[index] & help);
			this.Register[0x80] = (short) (this.Register[index] & help);
			break;
		case 0x2:
			this.Register[0x2] = (short) (this.Register[index] & help);
			this.Register[0x82] = (short) (this.Register[index] & help);
			break;
		case 0x3:
			this.Register[0x3] = (short) (this.Register[index] & help);
			this.Register[0x83] = (short) (this.Register[index] & help);
			break;
		case 0x4:
			this.Register[0x4] = (short) (this.Register[index] & help);
			this.Register[0x84] = (short) (this.Register[index] & help);
			break;
		case 0xA:
			this.Register[0xA] = (short) (this.Register[index] & help);
			this.Register[0x8A] = (short) (this.Register[index] & help);
			break;
		case 0xB:
			this.Register[0xB] = (short) (this.Register[index] & help);
			this.Register[0x8B] = (short) (this.Register[index] & help);
			break;
		case 0x80:
			this.Register[0x0] = (short) (this.Register[index] & help);
			this.Register[0x80] = (short) (this.Register[index] & help);
			break;
		case 0x82:
			this.Register[0x2] = (short) (this.Register[index] & help);
			this.Register[0x82] = (short) (this.Register[index] & help);
			break;
		case 0x83:
			this.Register[0x3] = (short) (this.Register[index] & help);
			this.Register[0x83] = (short) (this.Register[index] & help);
			break;
		case 0x84:
			this.Register[0x4] = (short) (this.Register[index] & help);
			this.Register[0x84] = (short) (this.Register[index] & help);
			break;
		case 0x8A:
			this.Register[0xA] = (short) (this.Register[index] & help);
			this.Register[0x8A] = (short) (this.Register[index] & help);
			break;
		case 0x8B:
			this.Register[0xB] = (short) (this.Register[index] & help);
			this.Register[0x8B] = (short) (this.Register[index] & help);
			break;
		default:
			if ((checkBank() == 1) && (index < 0x80))
				index = index + 0x80;
			this.Register[index] = (short) (this.Register[index] & help);
			break;
		}
		return;
	}
	public int getBitAt(int index, int bit) {
		short help = 1;
		help = (short) (help << bit);
		int val = 0;
		// Auf Bank �berpr�fen und ggf. Indexwert anpassen
		switch (index) {
		case 0x0:
			val = this.Register[0x0];
			val = this.Register[0x80];
		case 0x2:
			val = this.Register[0x2];
			val = this.Register[0x82];
			break;
		case 0x3:
			val = this.Register[0x3];
			val = this.Register[0x83];
			break;
		case 0x4:
			val = this.Register[0x4];
			val = this.Register[0x84];
			break;
		case 0xA:
			val = this.Register[0xA];
			val = this.Register[0x8A];
			break;
		case 0xB:
			val = this.Register[0xB];
			val = this.Register[0x8B];
			break;
		case 0x80:
			val = this.Register[0x0];
			val = this.Register[0x80];
		case 0x82:
			val = this.Register[0x2];
			val = this.Register[0x82];
			break;
		case 0x83:
			val = this.Register[0x3];
			val = this.Register[0x83];
			break;
		case 0x84:
			val = this.Register[0x4];
			val = this.Register[0x84];
			break;
		case 0x8A:
			val = this.Register[0xA];
			val = this.Register[0x8A];
			break;
		case 0x8B:
			val = this.Register[0xB];
			val = this.Register[0x8B];
			break;
		default:
			if ((checkBank() == 1) && (index < 0x80))
				index = index + 0x80;
			val = this.Register[index];
			break;
		}
		if ((short) (val & help) == 0) {
			return 0;
		} else {
			return 1;
		}
	}
	/**
	 * Returns bit without verify bank
	 * @param index
	 * @return bit
	 */
	public int getBitAtNoBank(int index, int bit) {
		short help = 1;
		int val = this.Register[index];
		help = (short) (help << bit);
		if ((short) (val & help) == 0) {
			return 0;
		} else {
			return 1;
		}
	}
	/**
	 * Set value at Register with verify bank
	 * @param val value to set
	 * @param index Register 
	 */
	public void setValueAt(int val, int index) {
		// Auf Bank überprüfen und ggf. Indexwert anpassen
		switch (index) {
		case 0x0:
			this.Register[0x0] = (short) val;
			this.Register[0x80] = (short) val;
			break;
		case 0x2:
			this.Register[0x2] = (short) val;
			this.Register[0x82] = (short) val;
			break;
		case 0x3:
			this.Register[0x3] = (short) val;
			this.Register[0x83] = (short) val;
			break;
		case 0x4:
			this.Register[0x4] = (short) val;
			this.Register[0x84] = (short) val;
			break;
		case 0xA:
			this.Register[0xA] = (short) val;
			this.Register[0x8A] = (short) val;
			break;
		case 0xB:
			this.Register[0xB] = (short) val;
			this.Register[0x8B] = (short) val;
			break;
		case 0x80:
			this.Register[0x0] = (short) val;
			this.Register[0x80] = (short) val;
			break;
		case 0x82:
			this.Register[0x2] = (short) val;
			this.Register[0x82] = (short) val;
			break;
		case 0x83:
			this.Register[0x3] = (short) val;
			this.Register[0x83] = (short) val;
			break;
		case 0x84:
			this.Register[0x4] = (short) val;
			this.Register[0x84] = (short) val;
			break;
		case 0x8A:
			this.Register[0xA] = (short) val;
			this.Register[0x8A] = (short) val;
			break;
		case 0x8B:
			this.Register[0xB] = (short) val;
			this.Register[0x8B] = (short) val;
			break;
		default:
			if ((checkBank() == 1) && (index < 0x80))
				index = index + 0x80;
			this.Register[index] = (short) val;
			break;
		}
		return;
	}
	/**
	 * Returns the value of Register
	 * @param index of Register
	 * @return value of Register
	 */
	public short getValueAt(int index) {
		// Auf Bank überprüfen und ggf. Indexwert anpassen	
		if ((checkBank() == 1) && (index < 0x80))
			index = index + 0x80;
		return this.Register[index];
	}
	
	public short getValueAtNoBank(int index) {
		return this.Register[index];
	}
	
	public void setValueAtNoBank(int index, int val) {
		this.Register[index] = (short) val;
	}
	
	/**
	 * Check which Bank is selected
	 * @return int 0|1
	 */
	private int checkBank() {
		int help = 1;
		help = help << 5;
		if ((this.Register[0x3] & help) == 0) {
			return 0;
		} else {
			return 1; 
		}
	}
	/**
	 * @return the register
	 */
	public short[] getRegister() {
		return Register;
	}
	/**
	 * Returns content von Register W
	 * @return Register W
	 */
	public int getRegW() {
		return this.regW;
	}
	/**
	 * Set Wreg to literal
	 * @param literal to set
	 */
	public void setRegW(int literal) {
		this.regW = literal;
	}
	/**
	 * Returns the PCLStack
	 * @return PCLStack
	 */
	public Stack<Integer> getPcstack() {
		return pcstack;
	}
	
	public String getTris(int index, int bit) {
		int tris = getBitAt(index, bit);
		if (tris==1) return "i";
		else return "o";
	}
	
	public void incTMR0() {
		int newVal = getValueAtNoBank(0x1) + 1;
		if (newVal > 255) { //Überlauf Tmr0?
			newVal = newVal % 256;
		}
		if (newVal == 0) { //tmr0 overflow interrupt bit
			setBitAt(0xB, 2);
		}
		setValueAtNoBank(0x1,newVal);
	}
	
	public boolean getInterrupt() {
		boolean result = false;
		if(this.getBitAt(0xB, 7) == 1) { //Global Interrupt
			if (this.getBitAt(0xB, 5)==1 && this.getBitAt(0xB, 2)==1 ) {
				result=true;
				System.err.println("TMR0 Interrupt!");
			}
			if (this.getBitAt(0xB, 4)==1 && this.getBitAt(0xB, 1)==1) {
				result=true;
				System.err.println("RB0 Interrupt");
			}
			if (this.getBitAt(0xB, 3)==1 && this.getBitAt(0xB, 0)==1) {
				result=true;
				System.err.println("RB Port Changed Interrupt!");
			}
		}
		return result;
}

	
	
	
	
}
