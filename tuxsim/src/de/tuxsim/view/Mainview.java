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

public class Mainview extends JFrame {

	private JPanel contentPane;

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
		
		JTextPane txtpnSourcecode = new JTextPane();
		txtpnSourcecode.setEditable(false);
		txtpnSourcecode.setBounds(12, 86, 500, 475);
		contentPane.add(txtpnSourcecode);
		
		JLabel lblSourceCode = new JLabel("Source Code");
		lblSourceCode.setBounds(12, 64, 105, 15);
		contentPane.add(lblSourceCode);
		
		JLabel lblSpezialfunktionsregister = new JLabel("Spezialfunktionsregister");
		lblSpezialfunktionsregister.setBounds(524, 33, 189, 15);
		contentPane.add(lblSpezialfunktionsregister);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_1.setBounds(524, 53, 458, 45);
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
		lblStatus.setBounds(524, 103, 189, 15);
		contentPane.add(lblStatus);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_2.setBounds(524, 119, 458, 45);
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
		
		JLabel lblPorts = new JLabel("Ports");
		lblPorts.setBounds(524, 172, 70, 15);
		contentPane.add(lblPorts);
		
		JLabel lblRa = new JLabel("RA");
		lblRa.setBounds(530, 200, 70, 15);
		contentPane.add(lblRa);
		
		JLabel lblRb = new JLabel("RB");
		lblRb.setBounds(530, 253, 70, 15);
		contentPane.add(lblRb);
		
		JLabel lblTris = new JLabel("Tris");
		lblTris.setBounds(550, 215, 70, 15);
		contentPane.add(lblTris);
		
		}
}
