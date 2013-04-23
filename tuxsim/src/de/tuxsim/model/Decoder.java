package de.tuxsim.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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
	
	HashMap<Integer, Integer> instructionMap = new HashMap<Integer, Integer>();
	
	
	public void readLst(Mainview frame) throws IOException{
		//Liest Datei mit Sonderzeichen
		File x = new File("BA_Test.LST");
		FileInputStream fis = new FileInputStream(x);
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("ISO-8859-1"));
		BufferedReader br = new BufferedReader(isr);
		String line = "";

		while ( (line = br.readLine()) != null ) {
		frame.textAreaSourceCode.append(line+"\n");	
		
		if (Character.isDigit(line.charAt(0))) {
			int memoryAdress = Integer.parseInt(line.substring(0,4), 16);
			int instruction = Integer.parseInt(line.substring(5,9), 16);
		
			instructionMap.put(memoryAdress, instruction);
			

			}
		}
		//Close Buffered Reader
		br.close();
		
	}
	
	public void parseInstructions() {
		int k = 5;
		
		for (int i = 0; i < instructionMap.size(); i++) {
			if ((i ^ k) == 0 ) {System.out.println("k="+k+"i="+i);}
//			int instruction = instructionMap.get(i);
//			
//			System.out.println(instruction);
			
			}
		}
}
