package de.tuxsim.controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import de.tuxsim.model.Decoder;
import de.tuxsim.model.Instructions;
import de.tuxsim.model.Interna;
import de.tuxsim.view.Mainview;
import de.tuxsim.view.OpenFile;


public class MainController {
	private Decoder decoder;
	private Mainview gui;
	private OpenFile of;
	private Instructions instructions;
	private Interna interna;
	private Interpreter interpreter;
	
	private int curInstruction;

	
	public MainController() {
		this.decoder = new Decoder();
		this.gui = new Mainview();
		this.instructions = new Instructions(this);
		this.interna = new Interna();
		this.of = new OpenFile();
		this.interpreter = new Interpreter(instructions, this);
	}

	
	public void temp() {
		this.initGui();
		this.addListener();
		
	}

	/**
	 * Enable Gui & Reset View 
	 */
	public void initGui() {
		gui.setVisible(true);
		this.updateGui();
	}
	/**
	 * update/reset the Register(Model & View) to default, 
	 */
	public void updateGui() {
		gui.getTextPane("Wreg").setText(Integer.toHexString(interna.getRegW()));
		gui.getTextPane("FSRreg").setText(Integer.toHexString(interna.getValueAt(0x4)));
		gui.getTextPane("TMR0").setText(Integer.toHexString(interna.getValueAtNoBank(0x1)));
		gui.getTextPane("PCLreg").setText(Integer.toHexString(interna.getValueAt(0x2)));
		
		gui.getTextPane("RP0").setText(String.valueOf(interna.getBitAt(0x3, 5)));
		gui.getTextPane("TO").setText(String.valueOf(interna.getBitAt(0x3,4)));
		gui.getTextPane("PD").setText(String.valueOf(interna.getBitAt(0x3,3)));
		gui.getTextPane("Z").setText(String.valueOf(interna.getBitAt(0x3,2)));
		gui.getTextPane("DC").setText(String.valueOf(interna.getBitAt(0x3,1)));
		gui.getTextPane("C").setText(String.valueOf(interna.getBitAt(0x3,0)));
		
		gui.getTextPane("RA4").setText(String.valueOf(interna.getBitAtNoBank(0x5,4)));
		gui.getTextPane("RA3").setText(String.valueOf(interna.getBitAtNoBank(0x5,3)));
		gui.getTextPane("RA2").setText(String.valueOf(interna.getBitAtNoBank(0x5,2)));
		gui.getTextPane("RA1").setText(String.valueOf(interna.getBitAtNoBank(0x5,1)));
		gui.getTextPane("RA0").setText(String.valueOf(interna.getBitAtNoBank(0x5,0)));
		gui.getTextPane("RAt4").setText(interna.getTris(0x85, 4));
		gui.getTextPane("RAt3").setText(interna.getTris(0x85, 3));
		gui.getTextPane("RAt2").setText(interna.getTris(0x85, 2));
		gui.getTextPane("RAt1").setText(interna.getTris(0x85, 1));
		gui.getTextPane("RAt0").setText(interna.getTris(0x85, 0));
		
		gui.getTextPane("RB7").setText(String.valueOf(interna.getBitAtNoBank(0x6,7)));
		gui.getTextPane("RB6").setText(String.valueOf(interna.getBitAtNoBank(0x6,6)));
		gui.getTextPane("RB5").setText(String.valueOf(interna.getBitAtNoBank(0x6,5)));
		gui.getTextPane("RB4").setText(String.valueOf(interna.getBitAtNoBank(0x6,4)));
		gui.getTextPane("RB3").setText(String.valueOf(interna.getBitAtNoBank(0x6,3)));
		gui.getTextPane("RB2").setText(String.valueOf(interna.getBitAtNoBank(0x6,2)));
		gui.getTextPane("RB1").setText(String.valueOf(interna.getBitAtNoBank(0x6,1)));
		gui.getTextPane("RB0").setText(String.valueOf(interna.getBitAtNoBank(0x6,0)));
		gui.getTextPane("RBt7").setText(interna.getTris(0x86, 7));
		gui.getTextPane("RBt6").setText(interna.getTris(0x86, 6));
		gui.getTextPane("RBt5").setText(interna.getTris(0x86, 5));
		gui.getTextPane("RBt4").setText(interna.getTris(0x86, 4));
		gui.getTextPane("RBt3").setText(interna.getTris(0x86, 3));
		gui.getTextPane("RBt2").setText(interna.getTris(0x86, 2));
		gui.getTextPane("RBt1").setText(interna.getTris(0x86, 1));
		gui.getTextPane("RBt0").setText(interna.getTris(0x86, 0));
		
		
		int rowReg=0x0;
		for (int i=0;i<gui.getRegister().getRowCount();i++) {
			for (int j=0;j<=7;j++) {
				gui.getRegister().setValueAt(Integer.toHexString(interna.getValueAtNoBank(rowReg+j)), i, j+1);
			}
			rowReg +=0x8;
		}
	}
	
	/**
	 * Initialize  Listener of gui - no programm
	 */
	public void addListener() {
		this.gui.setOpenListener(new OpenListener());
		this.gui.setHelpListener(new HelpListener());
		this.gui.setAboutTuxSimListener(new AboutTuxSimListener());
		this.gui.getTextPane("RB0").addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int bit = interna.getBitAt(0x6, 0);
				if (bit==0) {
					interna.setBitAt(0x6, 0);
				}else interna.clearBitAt(0x6, 0);
				updateGui();
			}
		});
	}
	
	/**
	 * Initialize Listener when programm is loaded
	 */
	public void addProgrammListener() {
		this.gui.setStartListener(new StartListener());
		this.gui.setStopListener(new StopListener());
		this.gui.setStepListener(new StepListener());
		this.gui.setResetListener(new ResetListener());
		
	}
	
	
	
	
	/**
	 * Executes the instruction of current Adress
	 * 
	 */

	
	/**
	 * @return the curInstruction
	 */
	public int getCurInstruction() {
		return curInstruction;
	}

	/**
	 * @return the curAdress
	 */
	public int getPC() {
		return interna.getValueAt(0x2);
	}
	
	public void setPC(int a) {
		interna.setValueAt(a, 0x2);
	}
	
	/**
	 * @return the interna
	 */
	public Interna getInterna() {
		return interna;
	}
	/**
	 * Intern class for OpenBtnListener
	 * @author tuxpad
	 *
	 */
	class OpenListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			File file = of.openFile(gui.getParent());
			if (file != null) {
				try {
					decoder.readLst(gui,file);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			addProgrammListener();
			}
			else return;	
		}
		
	}
	
	class HelpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class AboutTuxSimListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class StartListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class StopListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
	
	class StepListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
			interpreter.execInstruction(decoder.getInstruction(getPC()));
		}
	}
	
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			setPC(0);
			curInstruction=0;
			interna.setRegW(0);
			interna.initRegister();
			interna.initStack();
			updateGui();
		}
	}


			
		
}



