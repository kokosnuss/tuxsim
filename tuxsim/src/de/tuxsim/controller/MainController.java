package de.tuxsim.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.SwingUtilities;

import de.tuxsim.model.Decoder;
import de.tuxsim.model.Instructions;
import de.tuxsim.model.Interna;
import de.tuxsim.view.About;
import de.tuxsim.view.Mainview;
import de.tuxsim.view.OpenFile;


public class MainController implements Runnable {
	private Decoder decoder;
	private Mainview gui;
	private OpenFile of;
	private Instructions instructions;
	private Interna interna;
	private Interpreter interpreter;
	
	private Thread t2;
	
	private int curInstruction;
	private boolean stop = false;
	public boolean isInterrupted = false;

	
	public MainController() {
		this.decoder = new Decoder();
		this.gui = new Mainview();
		this.instructions = new Instructions(this);
		this.interna = new Interna();
		this.of = new OpenFile();
		this.interpreter = new Interpreter(instructions, this);
		
	}

	
	public void run() {
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
	
	public void initRunThread() {
		stop = false;
		t2 = new Thread(new StartListener());
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
		//PortA
		for (int i=0;i<gui.getPortA().getColumnCount();i++) {
			gui.getPortA().setValueAt(Integer.valueOf(interna.getBitAtNoBank(0x5, i)), 0, 7-i);
			gui.getPortA().setValueAt(interna.getTris(0x85, i), 1, 7-i);
		}
		//PortB
		for (int i=0;i<gui.getPortB().getColumnCount();i++) {
			gui.getPortB().setValueAt(Integer.valueOf(interna.getBitAtNoBank(0x6, i)), 0, 7-i);
			gui.getPortB().setValueAt(interna.getTris(0x86, i), 1, 7-i);
		}
		//INTCON
		for (int i=0;i<gui.getIntcon().getColumnCount();i++) {
			gui.getIntcon().setValueAt(Integer.valueOf(interna.getBitAt(0x0B, i)), 0, 7-i);
		}
		
		//Register
		int rowReg=0x0;
		for (int i=0;i<gui.getRegister().getRowCount();i++) {
			for (int j=0;j<=7;j++) {
				gui.getRegister().setValueAt(Integer.toHexString(interna.getValueAtNoBank(rowReg+j)), i, j+1);
			}
			rowReg +=0x8;
		}
	}
	
	/**reset Register, Stack, etc
	 * if newProg==true, old Code&Hashmaps deleted
	 * @param newProg boolean true if new Prog is loaded
	 */
	public void reset(boolean newProg) {
		if (newProg==true) {
			gui.getListModel().clear();
			decoder.clearHashMaps();
		}
		setPC(0);
		curInstruction=0;
		interna.setRegW(0);
		interna.initRegister();
		interna.initStack();
		updateGui();
	}
	/**
	 * Initialize  Listener of gui - no programm
	 */
	public void addListener() {
		this.gui.setOpenListener(new OpenListener());
		this.gui.setHelpListener(new HelpListener());
		this.gui.setAboutTuxSimListener(new AboutTuxSimListener());
		this.gui.getPortA().addMouseListener(new MouseAdapter() { //PortA
			public void mouseClicked(MouseEvent e) {
				int row = gui.getPortA().rowAtPoint(e.getPoint());
				int column = gui.getPortA().columnAtPoint(e.getPoint());
				if(row==0 && column>2 && (interna.getBitAt(0x85,7-column) ==1)) { //tris aktiviert?
					portAClicked(column);
				}
			}
		});
		this.gui.getPortB().addMouseListener(new MouseAdapter() { //PortB
			public void mouseClicked(MouseEvent e) {
				int row = gui.getPortB().rowAtPoint(e.getPoint());
				int column = gui.getPortB().columnAtPoint(e.getPoint());
				if(row==0 && (interna.getBitAt(0x86,7-column) ==1)) { //tris aktiviert?
					portBClicked(column);
				}
			}
		});
		this.gui.getIntcon().addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int column = gui.getIntcon().columnAtPoint(e.getPoint());
				int bit = interna.getBitAtNoBank(0x0B,7-column);
				if (bit==0) interna.setBitAt(0x0B, 7-column);
				else interna.clearBitAt(0x0B, 7-column);
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
	 * 
	 */
	public void updateSelectedLine() {
		int index = decoder.getLineNrToAddress(getPC());
		gui.getCodeList().setSelectedIndex(index);
		gui.getCodeList().ensureIndexIsVisible(gui.getCodeList().getSelectedIndex());
		
	}
	
	public void checkInterrupt() {
		if (interna.getInterrupt() && !isInterrupted) {
			isInterrupted = true;
			this.getInterna().getPcstack().push(this.getPC());
			this.setPC(0x3);
		}
	}
	
	private void portBClicked(int column) {
		int bit = interna.getBitAtNoBank(0x6,7-column); //toggle bits
		if (bit==0) interna.setBitAt(0x6, 7-column);
		else interna.clearBitAt(0x6, 7-column);
		
		boolean oldB = (bit != 0);
		boolean newB = (interna.getBitAtNoBank(0x6, 4) != 0);
		if (interna.getBitAt(0xB, 7)==1) { 									//GIE Enabled
			if (interna.getBitAt(0xB, 3)==1 && column <=3) {				//rb port changed
				 interna.setBitAt(0xB, 0);
			} else if (interna.getBitAt(0xB, 4)==1 && column==7) {			//rb0 interrupt
				if (interna.getBitAt(0x81, 6) ==1) {						//check interrupt-edge
					if (newB && !oldB) {
						interna.setBitAt(0xB, 1);
					}
				} else {
					if (!newB && oldB) {
						interna.setBitAt(0xB, 1);
					}
				}
			}
		}
		updateGui();
	}

	private void portAClicked(int column) {
		int bit = interna.getBitAtNoBank(0x5,7-column);					//toggle bits
		if (bit==0)  interna.setBitAt(0x5, 7-column);
		else interna.clearBitAt(0x5, 7-column);
		boolean oldV = (bit != 0);
		boolean newV = (interna.getBitAtNoBank(0x5, 4) != 0);
		if (column==3 && interna.getBitAt(0x81, 5)==1) {				//TMR0 Clock Source Select Bit
			if (interna.getBitAt(0x81, 4) == 1) {						//inc high-to-low
				if (!newV && oldV) {
						interna.incTMR0();
				}
			} else {													//inc low-to-high
				if (newV && !oldV) {
						interna.incTMR0();
				}
			}
		}
		updateGui();
	}

	
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
			reset(true); //Reset all, when new Programm is loaded
			File file = of.openFile(gui.getParent());
			if (file != null) {
				try {
					decoder.readLst(gui,file);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			addProgrammListener();
			gui.getCodeList().setSelectedIndex(decoder.getLineNrToAddress(getPC()));
			gui.setVisible(true); //Make sure buttons are focusable
			}
			else return;	
		}
		
	}
	
	class HelpListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			try {
				Desktop.getDesktop().open(new File("Datenblatt.pdf"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class AboutTuxSimListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			About a = new About();
			a.setVisible(true);
		}
	}
	
	class StartListener implements ActionListener,Runnable
	{
		public void actionPerformed(ActionEvent e)
		{
			initRunThread();	 
			 t2.start();
		}

		@Override
		public void run() {
			while(!stop) {
				checkInterrupt();
				interpreter.execInstruction(decoder.getInstruction(getPC()));
				SwingUtilities.invokeLater(new Runnable() {
					
					@Override
					public void run() {
						updateSelectedLine();
					}
				});
				try {
					t2.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	class StopListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			stop=true;
		}
	}
	
	class StepListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			checkInterrupt();
			interpreter.execInstruction(decoder.getInstruction(getPC()));
			updateSelectedLine();
		}

	
	}
	
	class ResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			reset(false);
			updateSelectedLine();
		}
	}
	


			
		
}



