package de.tuxsim.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;

import de.tuxsim.view.Mainview;


 

/**
 * Decoder Class, decodes the .lst File, generates the HashMap with the Instructions
 * and parses them
 * @author tuxpad
 *
 */
public class Decoder {
	
	/**
	 * Hashmap which contains adrees + instructions of LST-File
	 */
	HashMap<Integer, Integer> instructionMap = new HashMap<Integer, Integer>();
	/**
	 * Hashmap which links the PC-Adress to the LineNumber in SourceCode
	 */
	HashMap<Integer,Integer> address_linenumber = new HashMap<Integer,Integer>();
	
	/**
	 * Read Lst-File and build HashMap
	 * @param frame
	 * @throws IOException
	 */
	public void readLst(Mainview frame, File f) throws IOException{
		//Liest Datei mit Sonderzeichen
		FileInputStream fis = new FileInputStream(f);
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("ISO-8859-1"));
		BufferedReader br = new BufferedReader(isr);
		String line = "";
		int lineNr = 1;
		while ( (line = br.readLine()) != null ) {

			frame.getListModel().addElement(line);
		
		if (Character.isDigit(line.charAt(0))) {
			int memoryAdress = Integer.parseInt(line.substring(0,4), 16);
			int instruction = Integer.parseInt(line.substring(5,9), 16);
		
			instructionMap.put(memoryAdress, instruction);
			address_linenumber.put(memoryAdress,lineNr);
			}
		lineNr++;	
		
		}
		//Close Buffered Reader
		br.close();
		
	}
	
	
	public int getInstruction(int address) {
			int instruction = this.instructionMap.get(address);
			return instruction;
			}
	
	public HashMap<Integer, Integer> getInstructionMap() {
		return this.instructionMap;
	}
	
	public int getLineNrToAddress(int address) {
		int lineNr = this.address_linenumber.get(address);
		return lineNr -1;
	}
	/**
	 * Clears Hashmaps, called if new Programm loaded
	 */
	public void clearHashMaps() {
		this.instructionMap.clear();
		this.address_linenumber.clear();
	}
}
	
