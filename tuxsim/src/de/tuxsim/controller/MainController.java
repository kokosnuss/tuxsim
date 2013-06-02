package de.tuxsim.controller;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

/**
 * Represents the CPU of the PIC, all Actions are performed or called here
 * @author tuxpad
 *
 */
public class MainController implements Runnable {
	private Decoder decoder;
	private Mainview gui;
	private OpenFile of;
	private Instructions instructions;
	private Interna interna;
	private Interpreter interpreter;
	
	private Thread t2;
	
	private int curInstruction;
	/**
	 * Boolean which is Stop-Condition for Start Thread
	 */
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

	/**
	 * Run Method for Init Thread
	 */
	@Override
	public void run() {
		this.initGui();
		this.addListener();
	}

	/**
	 * Enable Gui 
	 */
	public void initGui() {
		gui.setVisible(true);
		this.updateGui();
	}
	
	/**
	 * Init the Run Thread for Running the Programm automatically
	 */
	public void initRunThread() {
		stop = false;
		t2 = new Thread(new StartListener());
	}
	/**
	 * Updates the GUI-Elements  
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
	 * Initialize  Listener of gui - no programm is loaded
	 */
	public void addListener() {
		this.gui.setOpenListener(new OpenListener());
		this.gui.setHelpListener(new HelpListener());
		this.gui.setAboutTuxSimListener(new AboutTuxSimListener());
		this.gui.getPortA().addMouseListener(new MouseAdapter() { //PortA
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = gui.getPortA().rowAtPoint(e.getPoint());
				int column = gui.getPortA().columnAtPoint(e.getPoint());
				if(row==0 && column>2 && (interna.getBitAt(0x85,7-column) ==1)) { //tris aktiviert?
					portAClicked(column);
				}
			}
		});
		this.gui.getPortB().addMouseListener(new MouseAdapter() { //PortB
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = gui.getPortB().rowAtPoint(e.getPoint());
				int column = gui.getPortB().columnAtPoint(e.getPoint());
				if(row==0 && (interna.getBitAt(0x86,7-column) ==1)) { //tris aktiviert?
					portBClicked(column);
				}
			}
		});
		this.gui.getIntcon().addMouseListener(new MouseAdapter() {
			@Override
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
		this.gui.setComListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
				} else {
				}
			}
		});
		
	}
	

	/**
	 * Highlight the line in Source Code which is executed
	 */
	public void updateSelectedLine() {
		int index = decoder.getLineNrToAddress(getPC());
		gui.getCodeList().setSelectedIndex(index);
		gui.getCodeList().ensureIndexIsVisible(gui.getCodeList().getSelectedIndex());
		
	}
	/**
	 * Check if Interrupt occurs, if yes, push PC to Stack & go to 0x4
	 */
	public void checkInterrupt() {
		if (interna.getInterrupt() && !isInterrupted) {
			isInterrupted = true;
			this.getInterna().getPcstack().push(this.getPC());
			this.setPC(0x4-1);
		}
	}
	/**
	 * A Bit of Port B is Clicked
	 * Checks Interrupt Bits and impulse edge
	 * @param column Bit of Port B
	 */
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
	/**
	 * Bit of Port A is Clicked
	 * Checks TMR0 Source Select Bit & impulse edge
	 * @param column Bit of Port A
	 */
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

	
	/**Returns the current Instruction Code
	 * @return the curInstruction
	 */
	public int getCurInstruction() {
		return curInstruction;
	}

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
	 * Opens new File and parses it
	 * @author tuxpad
	 *
	 */
	class OpenListener implements ActionListener {
		@Override
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
		@Override
		public void actionPerformed(ActionEvent e)
		{
			try {
				Desktop.getDesktop().open(new File("doku/TuxSim_Doku.pdf"));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	class AboutTuxSimListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			About a = new About();
			a.setVisible(true);
		}
	}
	/**
	 * Starts running through programm until Stop is clicked 
	 * @author tuxpad
	 *
	 */
	class StartListener implements ActionListener,Runnable
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			
			//if (t2 == null || !running) {
			 initRunThread();
			 gui.getControllButtons("start").setEnabled(false);
			 gui.getControllButtons("step").setEnabled(false);
			 t2.start();
			//} else return; 
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
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	/**
	 * Stops the running programm
	 * @author tuxpad
	 *
	 */
	class StopListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			stop=true;
			 gui.getControllButtons("start").setEnabled(true);
			 gui.getControllButtons("step").setEnabled(true);
		}
	}
	/**
	 * Execute the next Instruction
	 * @author tuxpad
	 *
	 */
	class StepListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			checkInterrupt();
			interpreter.execInstruction(decoder.getInstruction(getPC()));
			updateSelectedLine();
		}

	
	}
	/**
	 * Reset the Programm 
	 * PC = 0; Register = default
	 * @author tuxpad
	 *
	 */
	class ResetListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			reset(false);
			updateSelectedLine();
		}
	}
	


			
		
}



