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
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 794, 21);
		contentPane.add(menuBar);
		
		JMenuItem mntmFile = new JMenuItem("File");
		mntmFile.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mntmFile);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.setHorizontalAlignment(SwingConstants.TRAILING);
		menuBar.add(mntmHelp);
	}
}
