package de.tuxsim.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import de.tuxsim.model.Decoder;
import de.tuxsim.view.Mainview;


public class MainController {
	private Decoder decoder;
	private Mainview gui;
	
	public MainController() {
		this.decoder = new Decoder();
		this.gui = new Mainview();
		gui.getTextPane("Wreg").setText("test");
		
	}
	
	public void initGui() {
		gui.setVisible(true);
	}
	
	public void readLst() {
		try {
			decoder.readLst(gui);
			decoder.parseInstructions();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


