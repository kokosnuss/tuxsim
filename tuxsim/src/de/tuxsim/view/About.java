package de.tuxsim.view;

import java.awt.Desktop;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;

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
		setBounds(100, 100, 400, 175);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JEditorPane url = new JEditorPane();
		url.setBackground(UIManager.getColor("Button.background"));
		url.setBounds(12, 69, 360, 32);
	    url.setContentType("text/html");
	    url.setEditable(false);
	    url.setText("<html><a href=\"http://kokosnuss.github.io/tuxsim/\">http://kokosnuss.github.io/tuxsim</a></html>");
	    url.addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
	            if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
	                try {
	                    Desktop.getDesktop().browse(e.getURL().toURI());
	                } catch (Exception e1) {
	                   e1.printStackTrace();
	                }
	            }
			}
		});
		contentPane.add(url);
		
		JTextPane txtPnTuxSim = new JTextPane();
		txtPnTuxSim.setText("TuxSim v1.0\n\n" +
				"A lightweight Java-Simulator for the PIC16F84 Processor.\n\n " +
				
				"\n\n© 2013 by Karolin Edigkaufer, Lukas Essig");
		
		txtPnTuxSim.setBackground(UIManager.getColor("Button.background"));
		txtPnTuxSim.setEditable(false);
		txtPnTuxSim.setBounds(12, 12, 370, 143);
		contentPane.add(txtPnTuxSim);
	}
}
