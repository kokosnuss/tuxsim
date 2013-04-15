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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainview frame = new Mainview();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mainview() {
		setResizable(false);
		setTitle("TuxSim");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 994, 21);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnAbout.add(mntmHelp);
		
		JMenuItem mntmAboutTuxsim = new JMenuItem("About TuxSim");
		mnAbout.add(mntmAboutTuxsim);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 23, 500, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(0, 5, 70, 25);
		btnStart.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(82, 5, 67, 25);
		panel.add(btnStop);
		
		JButton btnStep = new JButton("Step");
		btnStep.setBounds(161, 5, 67, 25);
		panel.add(btnStep);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(240, 5, 75, 25);
		panel.add(btnReset);
		
		
		JLabel lblSourceCode = new JLabel("Source Code");
		lblSourceCode.setBounds(12, 64, 105, 15);
		contentPane.add(lblSourceCode);
		
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
		
		JTextPane textPaneWreg = new JTextPane();
		textPaneWreg.setBackground(UIManager.getColor("Button.background"));
		textPaneWreg.setEditable(false);
		panel_1.add(textPaneWreg);
		
		JTextPane textPaneFSRreg = new JTextPane();
		textPaneFSRreg.setBackground(UIManager.getColor("Button.background"));
		textPaneFSRreg.setEditable(false);
		panel_1.add(textPaneFSRreg);
		
		JTextPane textPaneTMR0 = new JTextPane();
		textPaneTMR0.setBackground(UIManager.getColor("Button.background"));
		textPaneTMR0.setEditable(false);
		panel_1.add(textPaneTMR0);
		
		JTextPane textPanePCLreg = new JTextPane();
		textPanePCLreg.setBackground(UIManager.getColor("Button.background"));
		textPanePCLreg.setEditable(false);
		panel_1.add(textPanePCLreg);
		
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
		
		JTextPane textPaneRP0 = new JTextPane();
		textPaneRP0.setBackground(UIManager.getColor("Button.background"));
		textPaneRP0.setEditable(false);
		panel_2.add(textPaneRP0);
		
		JTextPane textPaneTO = new JTextPane();
		textPaneTO.setBackground(UIManager.getColor("Button.background"));
		textPaneTO.setEditable(false);
		panel_2.add(textPaneTO);
		
		JTextPane textPanePD = new JTextPane();
		textPanePD.setBackground(UIManager.getColor("Button.background"));
		textPanePD.setEditable(false);
		panel_2.add(textPanePD);
		
		JTextPane textPaneZ = new JTextPane();
		textPaneZ.setBackground(UIManager.getColor("Button.background"));
		textPaneZ.setEditable(false);
		panel_2.add(textPaneZ);
		
		JTextPane textPaneDC = new JTextPane();
		textPaneDC.setBackground(UIManager.getColor("Button.background"));
		textPaneDC.setEditable(false);
		panel_2.add(textPaneDC);
		
		JTextPane textPaneC = new JTextPane();
		textPaneC.setBackground(UIManager.getColor("Button.background"));
		textPaneC.setEditable(false);
		panel_2.add(textPaneC);
		
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
		
		JTextPane textPaneRA4 = new JTextPane();
		panel_3.add(textPaneRA4);
		
		JTextPane textPaneRA3 = new JTextPane();
		panel_3.add(textPaneRA3);
		
		JTextPane textPaneRA2 = new JTextPane();
		panel_3.add(textPaneRA2);
		
		JTextPane textPaneRA1 = new JTextPane();
		panel_3.add(textPaneRA1);
		
		JTextPane textPaneRA0 = new JTextPane();
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
		
		JTextPane textPaneRAt4 = new JTextPane();
		textPaneRAt4.setBackground(UIManager.getColor("Button.background"));
		textPaneRAt4.setText("i");
		textPaneRAt4.setEditable(false);
		panel_3.add(textPaneRAt4);
		
		JTextPane textPaneRAt3 = new JTextPane();
		textPaneRAt3.setBackground(UIManager.getColor("Button.background"));
		textPaneRAt3.setText("i");
		textPaneRAt3.setEditable(false);
		panel_3.add(textPaneRAt3);
		
		JTextPane textPaneRAt2 = new JTextPane();
		textPaneRAt2.setBackground(UIManager.getColor("Button.background"));
		textPaneRAt2.setText("i");
		textPaneRAt2.setEditable(false);
		panel_3.add(textPaneRAt2);
		
		JTextPane textPaneRAt1 = new JTextPane();
		textPaneRAt1.setBackground(UIManager.getColor("Button.background"));
		textPaneRAt1.setText("i");
		textPaneRAt1.setEditable(false);
		panel_3.add(textPaneRAt1);
		
		JTextPane textPaneRAt0 = new JTextPane();
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
		
		JTextPane textPaneRB7 = new JTextPane();
		panel_4.add(textPaneRB7);
		
		JTextPane textPaneRB6 = new JTextPane();
		panel_4.add(textPaneRB6);
		
		JTextPane textPaneRB5 = new JTextPane();
		panel_4.add(textPaneRB5);
		
		JTextPane textPaneRB4 = new JTextPane();
		panel_4.add(textPaneRB4);
		
		JTextPane textPaneRB3 = new JTextPane();
		panel_4.add(textPaneRB3);
		
		JTextPane textPaneRB2 = new JTextPane();
		panel_4.add(textPaneRB2);
		
		JTextPane textPaneRB1 = new JTextPane();
		panel_4.add(textPaneRB1);
		
		JTextPane textPaneRB0 = new JTextPane();
		panel_4.add(textPaneRB0);
		
		JTextPane textPaneRBt7 = new JTextPane();
		textPaneRBt7.setText("i");
		textPaneRBt7.setEditable(false);
		textPaneRBt7.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt7);
		
		JTextPane textPaneRBt6 = new JTextPane();
		textPaneRBt6.setText("i");
		textPaneRBt6.setEditable(false);
		textPaneRBt6.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt6);
		
		JTextPane textPaneRBt5 = new JTextPane();
		textPaneRBt5.setText("i");
		textPaneRBt5.setEditable(false);
		textPaneRBt5.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt5);
		
		JTextPane textPaneRBt4 = new JTextPane();
		textPaneRBt4.setText("i");
		textPaneRBt4.setEditable(false);
		textPaneRBt4.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt4);
		
		JTextPane textPaneRBt3 = new JTextPane();
		textPaneRBt3.setText("i");
		textPaneRBt3.setEditable(false);
		textPaneRBt3.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt3);
		
		JTextPane textPaneRBt2 = new JTextPane();
		textPaneRBt2.setText("i");
		textPaneRBt2.setEditable(false);
		textPaneRBt2.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt2);
		
		JTextPane textPaneRBt1 = new JTextPane();
		textPaneRBt1.setText("i");
		textPaneRBt1.setEditable(false);
		textPaneRBt1.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt1);
		
		JTextPane textPaneRBt0 = new JTextPane();
		textPaneRBt0.setText("i");
		textPaneRBt0.setEditable(false);
		textPaneRBt0.setBackground(UIManager.getColor("Button.background"));
		panel_4.add(textPaneRBt0);
		
		JCheckBox chckbxHardwarecom = new JCheckBox("Hardware/COM");
		chckbxHardwarecom.setFont(new Font("Dialog", Font.BOLD, 12));
		chckbxHardwarecom.setBounds(836, 231, 146, 23);
		contentPane.add(chckbxHardwarecom);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 86, 500, 475);
		contentPane.add(scrollPane);
		
		JTextArea textAreaSourceCode = new JTextArea();
		scrollPane.setViewportView(textAreaSourceCode);
		textAreaSourceCode.setLineWrap(true);
		
		
		
		}
}
