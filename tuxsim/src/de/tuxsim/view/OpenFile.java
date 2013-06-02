package de.tuxsim.view;

import javax.swing.JFileChooser;

import java.awt.Container;
import java.io.File; 
/**
 * Open File Dialog
 * @author tuxpad
 *
 */
public class OpenFile 
{
	
	public File openFile(Container parent) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new LSTFileFilter());
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(parent);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = fileChooser.getSelectedFile();
		    return selectedFile;
		}
		return null;
	}
	
	/**
	 * Intern Class for File Filter, only allows .lst Files
	 * @author tuxpad
	 *
	 */
	public class LSTFileFilter extends javax.swing.filechooser.FileFilter {

	    @Override
	    public boolean accept(File file) {
	        return file.isDirectory() || file.getAbsolutePath().toLowerCase().endsWith(".lst");
	    }

	    @Override
	    public String getDescription() {
	        return "LST Dateien (*.lst)";
	    }
	}
}
