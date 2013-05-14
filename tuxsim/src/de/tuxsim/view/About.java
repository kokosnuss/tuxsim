package de.tuxsim.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class About extends JFrame {

	public About() {
		setResizable(false);
		setTitle("About");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnTuxsimV = new JTextPane();
		txtpnTuxsimV.setText("TuxSim v1.0\n\nA lightweight Java-Simulator for the PIC16F84 Processor.\n\n© 2013 by Karolin Edigkaufer, Lukas Essig");
		txtpnTuxsimV.setBackground(UIManager.getColor("Button.background"));
		txtpnTuxsimV.setEditable(false);
		txtpnTuxsimV.setBounds(12, 12, 370, 143);
		contentPane.add(txtpnTuxsimV);
	}
}
