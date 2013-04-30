package de.tuxsim.view;

import javax.swing.JFileChooser;

import java.awt.Container;
import java.io.File; 

public class OpenFile 
{
	
	public File openFile(Container parent) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(parent);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    return selectedFile;
		}
		return null;
	}
}
