package de.tuxsim.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.charset.Charset;

import de.tuxsim.view.Mainview;


//Class to decode the .lst-File and build the Data Structure 


public class Decoder {
	
	
	
	
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
			int lineNumber = Integer.parseInt(line.substring(0,4), 16);
			int instruction = Integer.parseInt(line.substring(5,9), 16);
			System.out.print(lineNumber+" ");
			System.out.println(instruction);
			}
		}

		br.close();
	}
		
}
