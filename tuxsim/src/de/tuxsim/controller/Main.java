/**Dev-Class to test file read **/


package de.tuxsim.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import de.tuxsim.view.Mainview;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		MainController maincontroller = new MainController();
		maincontroller.initGui();
		maincontroller.einlesen();
		

		
		


	}

}
