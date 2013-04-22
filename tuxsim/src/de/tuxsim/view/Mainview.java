//This is dev-branch

package de.tuxsim.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Panel;
import javax.swing.JSpinner;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Mainview extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnFile = new JMenu("File");
	private JMenuItem mntmOpen = new JMenuItem("Open");
	private JMenu mnAbout = new JMenu("About");
	private JMenuItem mntmHelp = new JMenuItem("Help");
	private JMenuItem mntmAboutTuxsim = new JMenuItem("About TuxSim");
	private JButton btnStart = new JButton("Start");
	private JButton btnStop = new JButton("Stop");
	private JButton btnStep = new JButton("Step");
	private JButton btnReset = new JButton("Reset");
	public JTextArea textAreaSourceCode = new JTextArea();
	private JTextPane textPaneWreg = new JTextPane();
	private JTextPane textPaneFSRreg = new JTextPane();
	private JTextPane textPaneTMR0 = new JTextPane();
	private JTextPane textPanePCLreg = new JTextPane();
	private JTextPane textPaneRP0 = new JTextPane();
	private JTextPane textPaneTO = new JTextPane();
	private JTextPane textPanePD = new JTextPane();
	private JTextPane textPaneZ = new JTextPane();
	private JTextPane textPaneDC = new JTextPane();
	private JTextPane textPaneC = new JTextPane();
	private JTextPane textPaneRA5 = new JTextPane();
	private JTextPane textPaneRA4 = new JTextPane();
	private JTextPane textPaneRA3 = new JTextPane();
	private JTextPane textPaneRA2 = new JTextPane();
	private JTextPane textPaneRA1 = new JTextPane();
	private JTextPane textPaneRA0 = new JTextPane();
	private JTextPane textPaneRAt4 = new JTextPane();
	private JTextPane textPaneRAt3 = new JTextPane();
	private JTextPane textPaneRAt2 = new JTextPane();
	private JTextPane textPaneRAt1 = new JTextPane();
	private JTextPane textPaneRAt0 = new JTextPane();
	private JTextPane textPaneRB7 = new JTextPane();
	private JTextPane textPaneRB6 = new JTextPane();
	private JTextPane textPaneRB5 = new JTextPane();
	private JTextPane textPaneRB4 = new JTextPane();
	private JTextPane textPaneRB3 = new JTextPane();
	private JTextPane textPaneRB2 = new JTextPane();
	private JTextPane textPaneRB1 = new JTextPane();
	private JTextPane textPaneRB0 = new JTextPane();
	private JTextPane textPaneRBt7 = new JTextPane();
	private JTextPane textPaneRBt6 = new JTextPane();
	private JTextPane textPaneRBt5 = new JTextPane();
	private JTextPane textPaneRBt4 = new JTextPane();
	private JTextPane textPaneRBt3 = new JTextPane();
	private JTextPane textPaneRBt2 = new JTextPane();
	private JTextPane textPaneRBt1 = new JTextPane();
	private JTextPane textPaneRBt0 = new JTextPane();
	private JCheckBox chckbxHardwarecom = new JCheckBox("Hardware/COM");
	
	
	public Mainview() {

		setResizable(false);
		setTitle("TuxSim");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//Menu Bar
		menuBar.setBounds(0, 0, 994, 21);
		contentPane.add(menuBar);
		menuBar.add(mnFile);
		mnFile.add(mntmOpen);
		menuBar.add(mnAbout);
		mnAbout.add(mntmHelp);
		mnAbout.add(mntmAboutTuxsim);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 23, 500, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		//Start,Stop,Step, Reset Buttons
		btnStart.setBounds(0, 5, 70, 25);
		btnStart.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnStart);
		btnStop.setBounds(82, 5, 67, 25);
		panel.add(btnStop);
		btnStep.setBounds(161, 5, 67, 25);
		panel.add(btnStep);
		btnReset.setBounds(240, 5, 75, 25);
		panel.add(btnReset);
		
		//Source Code
		JLabel lblSourceCode = new JLabel("Source Code");
		lblSourceCode.setBounds(12, 64, 105, 15);
		contentPane.add(lblSourceCode);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 86, 500, 475);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(textAreaSourceCode);
		
		//Spezialfunktionsregister
		JLabel lblSpezialfunktionsregister = new JLabel("Spezialfunktionsregister");
		lblSpezialfunktionsregister.setBounds(524, 23, 189, 15);
		contentPane.add(lblSpezialfunktionsregister);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(UIManager.getColor("Button.disabledToolBarBorderBackground")));
		panel_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_1.setBounds(524, 43, 458, 33);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 4, 1, 1));
		
		JLabel lblW = new JLabel("W");
		lblW.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblW);
		
		JLabel lblFsr = new JLabel("FSR");
		lblFsr.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblFsr);
		
		JLabel lblTmr = new JLabel("TMR0");
		lblTmr.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblTmr);
		
		JLabel lblPcl = new JLabel("PCL");
		lblPcl.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblPcl);
		

		textPaneWreg.setBackground(UIManager.getColor("Button.background"));
		textPaneWreg.setEditable(false);
		panel_1.add(textPaneWreg);
		

		textPaneFSRreg.setBackground(UIManager.getColor("Button.background"));
		textPaneFSRreg.setEditable(false);
		panel_1.add(textPaneFSRreg);
		

		textPaneTMR0.setBackground(UIManager.getColor("Button.background"));
		textPaneTMR0.setEditable(false);
		panel_1.add(textPaneTMR0);
		

		textPanePCLreg.setBackground(UIManager.getColor("Button.background"));
		textPanePCLreg.setEditable(false);
		panel_1.add(textPanePCLreg);
		
		//Statusregister
		JLabel lblStatus = new JLabel("Statusregister");
		lblStatus.setBounds(524, 86, 189, 15);
		contentPane.add(lblStatus);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(UIManager.getColor("Button.disabledToolBarBorderBackground")));
		panel_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_2.setBounds(524, 102, 458, 33);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 6, 1, 1));
		
		JLabel lblRp = new JLabel("rp0");
		lblRp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblRp);
		
		JLabel lblNewLabel = new JLabel("TO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel);
		
		JLabel lblPd = new JLabel("PD");
		lblPd.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblPd);
		
		JLabel lblZ = new JLabel("Z");
		lblZ.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblZ);
		
		JLabel lblDc = new JLabel("DC");
		lblDc.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblDc);
		
		JLabel lblC = new JLabel("C");
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblC);
		

		textPaneRP0.setBackground(UIManager.getColor("Button.background"));
		textPaneRP0.setEditable(false);
		panel_2.add(textPaneRP0);
		

		textPaneTO.setBackground(UIManager.getColor("Button.background"));
		textPaneTO.setEditable(false);
		panel_2.add(textPaneTO);
		

		textPanePD.setBackground(UIManager.getColor("Button.background"));
		textPanePD.setEditable(false);
		panel_2.add(textPanePD);
		

		textPaneZ.setBackground(UIManager.getColor("Button.background"));
		textPaneZ.setEditable(false);
		panel_2.add(textPaneZ);
		

		textPaneDC.setBackground(UIManager.getColor("Button.background"));
		textPaneDC.setEditable(false);
		panel_2.add(textPaneDC);
		

		textPaneC.setBackground(UIManager.getColor("Button.background"));
		textPaneC.setEditable(false);
		panel_2.add(textPaneC);
		
		//Ports RA & RB
		JLabel lblRa = new JLabel("RA");
		lblRa.setBounds(528, 153, 43, 15);
		contentPane.add(lblRa);
		
		JLabel lblTris = new JLabel("Tris");
		lblTris.setBounds(552, 163, 33, 15);
		contentPane.add(lblTris);
		
		JLabel lblRb = new JLabel("RB");
		lblRb.setBounds(530, 196, 70, 15);
		contentPane.add(lblRb);
		
		JLabel lblTris_1 = new JLabel("Tris");
		lblTris_1.setBounds(552, 206, 33, 15);
		contentPane.add(lblTris_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(UIManager.getColor("Button.disabledToolBarBorderBackground")));
		panel_3.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_3.setBounds(582, 143, 402, 33);
		contentPane.add(panel_3);
		panel_3.setLayout(new GridLayout(2, 8, 1, 1));
		
		JTextPane textPane_5 = new JTextPane();
		textPane_5.setBackground(UIManager.getColor("Button.background"));
		textPane_5.setEditable(false);
		panel_3.add(textPane_5);
		
		JTextPane textPane_14 = new JTextPane();
		textPane_14.setBackground(UIManager.getColor("Button.background"));
		textPane_14.setEditable(false);
		panel_3.add(textPane_14);
		
		JTextPane textPane_12 = new JTextPane();
		textPane_12.setBackground(UIManager.getColor("Button.background"));
		textPane_12.setEditable(false);
		panel_3.add(textPane_12);
		
		panel_3.add(textPaneRA4);
		
		panel_3.add(textPaneRA3);
		
		
		panel_3.add(textPaneRA2);

		panel_3.add(textPaneRA1);
		

		panel_3.add(textPaneRA0);
		
		JTextPane txtpnI = new JTextPane();
		txtpnI.setBackground(UIManager.getColor("Button.background"));
		txtpnI.setEditable(false);
		panel_3.add(txtpnI);
		
		JTextPane txtpnI_1 = new JTextPane();
		txtpnI_1.setBackground(UIManager.getColor("Button.background"));
		txtpnI_1.setEditable(false);
		panel_3.add(txtpnI_1);
		
		JTextPane txtpnI_2 = new JTextPane();
		txtpnI_2.setBackground(UIManager.getColor("Button.background"));
		txtpnI_2.setEditable(false);
		panel_3.add(txtpnI_2);
		

		textPaneRAt4.setBackground(UIManager.getColor("Button.background"));
		textPaneRAt4.setText("i");
		textPaneRAt4.setEditable(false);
		panel_3.add(textPaneRAt4);

		textPaneRAt3.setBackground(UIManager.getColor("Button.background"));
		textPaneRAt3.setText("i");
		textPaneRAt3.setEditable(false);
		panel_3.add(textPaneRAt3);
		
		
		textPaneRAt2.setBackground(UIManager.getColor("Button.background"));
		textPaneRAt2.setText("i");
		textPaneRAt2.setEditable(false);
		panel_3.add(textPaneRAt2);
		

		textPaneRAt1.setBackground(UIManager.getColor("Button.background"));
		textPaneRAt1.setText("i");
		textPaneRAt1.setEditable(false);
		panel_3.add(textPaneRAt1);
		
		textPaneRAt0.setBackground(UIManager.getColor("Button.background"));
		textPaneRAt0.setText("i");
		textPaneRAt0.setEditable(false);
		panel_3.add(textPaneRAt0);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(UIManager.getColor("Button.disabledToolBarBorderBackground")));
		panel_4.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_4.setBounds(582, 190, 402, 33);
		contentPane.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 8, 1, 1));
		
		panel_4.add(textPaneRB7);
		panel_4.add(textPaneRB6);
		panel_4.add(textPaneRB5);
		panel_4.add(textPaneRB4);
		panel_4.add(textPaneRB3);
		panel_4.add(textPaneRB2);
		panel_4.add(textPaneRB1);
		panel_4.add(textPaneRB0);
		
		textPaneRBt7.setText("i");
		textPaneRBt7.setEditable(false);
		textPaneRBt7.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt7);
		

		
		textPaneRBt6.setText("i");
		textPaneRBt6.setEditable(false);
		textPaneRBt6.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt6);
		
		
		textPaneRBt5.setText("i");
		textPaneRBt5.setEditable(false);
		textPaneRBt5.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt5);
		
	
		textPaneRBt4.setText("i");
		textPaneRBt4.setEditable(false);
		textPaneRBt4.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt4);
		
		
		textPaneRBt3.setText("i");
		textPaneRBt3.setEditable(false);
		textPaneRBt3.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt3);
		

		textPaneRBt2.setText("i");
		textPaneRBt2.setEditable(false);
		textPaneRBt2.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt2);
		

		textPaneRBt1.setText("i");
		textPaneRBt1.setEditable(false);
		textPaneRBt1.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt1);
		

		textPaneRBt0.setText("i");
		textPaneRBt0.setEditable(false);
		textPaneRBt0.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt0);
		

		chckbxHardwarecom.setFont(new Font("Dialog", Font.BOLD, 12));
		chckbxHardwarecom.setBounds(836, 231, 146, 23);
		contentPane.add(chckbxHardwarecom);
		

		
	}
	public JTextPane getTextPane(String pane) {
	
		switch(pane)
		{
		case "Wreg": 	return this.textPaneWreg;
		case "FSRreg": 	return this.textPaneFSRreg; 
		case "TMR0": 	return this.textPaneTMR0; 	
		case "PCLreg": 	return this.textPanePCLreg; 
		case "RP0": 	return this.textPaneRP0; 	
		case "TO": 		return this.textPaneTO; 	
		case "PD": 		return this.textPanePD; 	
		case "Z": 		return this.textPaneZ; 		
		case "DC":		return this.textPaneDC;		
		case "C":		return this.textPaneC; 		
		case "RA4":		return this.textPaneRA4;	
		case "RA3":		return this.textPaneRA3;	
		case "RA2":		return this.textPaneRA2;	
		case "RA1":		return this.textPaneRA1;	
		case "RA0":		return this.textPaneRA0;	
		case "RAt4":	return this.textPaneRAt4;	
		case "RAt3":	return this.textPaneRAt3;	
		case "RAt2":	return this.textPaneRAt2;	
		case "RAt1":	return this.textPaneRAt1;	
		case "RAt0":	return this.textPaneRAt0;	
		case "RB7":		return this.textPaneRB7;	
		case "RB6":		return this.textPaneRB6;	
		case "RB5":		return this.textPaneRB5;	
		case "RB4":		return this.textPaneRB4;	
		case "RB3":		return this.textPaneRB3;	
		case "RB2":		return this.textPaneRB2;	
		case "RB1":		return this.textPaneRB1;	
		case "RB0":		return this.textPaneRB0;	
		case "RBt7":	return this.textPaneRBt7;	
		case "RBt6":	return this.textPaneRBt6;	
		case "RB5t":	return this.textPaneRBt5;	
		case "RBt4":	return this.textPaneRBt4;	
		case "RBt3":	return this.textPaneRBt3;	
		case "RBt2":	return this.textPaneRBt2;	
		case "RBt1":	return this.textPaneRBt1;	
		case "RBt0":	return this.textPaneRBt0;	
		}
		return this.textPaneRA5;
		}

	}
	


