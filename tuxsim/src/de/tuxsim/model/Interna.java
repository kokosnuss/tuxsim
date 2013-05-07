package de.tuxsim.model;


/**
 * This class represents the PIC interna with the registers, memory ...
 * @author tuxpad
 *
 */
public class Interna {
	private short Register[];
	private int regW;
	
	public Interna() {
		this.initRegister();
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
	

	
	
	
	
}
