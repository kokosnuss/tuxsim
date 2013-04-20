/**Dev-Class to test file read **/


package de.tuxsim.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import de.tuxsim.view.Mainview;

public class Encoder {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		Mainview frame = new Mainview();
		frame.setVisible(true);
		
		FileReader fr = new FileReader("BA_Test.LST");
		BufferedReader br = new BufferedReader(fr);
		String zeile = "";
		
		while ( (zeile = br.readLine()) != null ) {
		frame.textAreaSourceCode.append(zeile+"\n");
			
		}
		
		br.close();
		
		


	}

}
