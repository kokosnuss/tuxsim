package de.tuxsim.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import de.tuxsim.view.Mainview;


//Class to decode the .lst-File and build the Data Structure 


public class Decoder {

	public void einlesen(Mainview frame) throws IOException{
		//Liest Datei mit Sonderzeichen
		File x = new File("BA_Test.LST");
		FileInputStream fis = new FileInputStream(x);
		InputStreamReader isr = new InputStreamReader(fis, Charset.forName("ISO-8859-1"));
		BufferedReader br = new BufferedReader(isr);
		String zeile = "";

		while ( (zeile = br.readLine()) != null ) {
		frame.textAreaSourceCode.append(zeile+"\n");
		System.out.println(zeile);
			
		}

		br.close();
	}
	
	
}
