package de.tuxsim.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;

/**
 * About Frame of GUI
 * @author tuxpad
 *
 */
public class About extends JFrame {

	public About() {
		setResizable(false);
		setTitle("About");
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtPnTuxSim = new JTextPane();
		txtPnTuxSim.setText("TuxSim v1.0\n\nA lightweight Java-Simulator for the PIC16F84 Processor.\n\n\n\n© 2013 by Karolin Edigkaufer, Lukas Essig");
		
		txtPnTuxSim.setBackground(UIManager.getColor("Button.background"));
		txtPnTuxSim.setEditable(false);
		txtPnTuxSim.setBounds(12, 12, 370, 143);
		contentPane.add(txtPnTuxSim);
	}
}
