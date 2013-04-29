package de.tuxsim.view;

import javax.swing.JFileChooser;
import java.io.File; 

public class OpenFile 
{
	
	public void openFile(Mainview view) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(view);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		}
	}
}
