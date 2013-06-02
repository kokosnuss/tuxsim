

package de.tuxsim.view;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.JMenu;
import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JCheckBox;
import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.JList;
/**
 * GUI-Class, separated from Controller & Model
 * @author tuxpad
 *
 */
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
	private JTextPane textPaneRBIF = new JTextPane();
	private JCheckBox chckbxHardwarecom = new JCheckBox("Hardware/COM");
	private JTable table;
	private JList Sourcecodelist;
	private DefaultListModel lm;
	private JTable PortB;
	private final JTable PortA = new JTable();
	private JTable intcon;
	
	
	public Mainview() {

		setResizable(false);
		setTitle("TuxSim");
		setIconImage(Toolkit.getDefaultToolkit().getImage("./tux.jpg"));
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
		btnStart.setFocusable(true);
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
		
		lm = new DefaultListModel();
		
		Sourcecodelist = new JList(lm);
		scrollPane.setViewportView(Sourcecodelist);
		
		
		//Spezialfunktionsregister
		JLabel lblSpezialfunktionsregister = new JLabel("Spezialfunktionsregister");
		lblSpezialfunktionsregister.setBounds(809, 88, 189, 15);
		contentPane.add(lblSpezialfunktionsregister);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(UIManager.getColor("Button.disabledToolBarBorderBackground")));
		panel_1.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_1.setBounds(809, 113, 175, 40);
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
		lblStatus.setBounds(522, 88, 189, 15);
		contentPane.add(lblStatus);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(UIManager.getColor("Button.disabledToolBarBorderBackground")));
		panel_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		panel_2.setBounds(534, 113, 262, 40);
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(2, 6, 1, 1));
		
		JLabel lblRp = new JLabel("rp0");
		lblRp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblRp);
		
		JLabel lblT0 = new JLabel("TO");
		lblT0.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblT0);
		
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
		lblRa.setBounds(522, 164, 43, 15);
		contentPane.add(lblRa);
		
		JLabel lblTris = new JLabel("Tris");
		lblTris.setBounds(552, 180, 33, 15);
		contentPane.add(lblTris);
		
		JLabel lblRb = new JLabel("RB");
		lblRb.setBounds(522, 206, 70, 15);
		contentPane.add(lblRb);
		
		JLabel lblTris_1 = new JLabel("Tris");
		lblTris_1.setBounds(552, 222, 33, 15);
		contentPane.add(lblTris_1);
		
		

		chckbxHardwarecom.setFont(new Font("Dialog", Font.BOLD, 12));
		chckbxHardwarecom.setBounds(842, 42, 146, 23);
		contentPane.add(chckbxHardwarecom);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(522, 261, 322, 300);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.setBackground(Color.WHITE);
		
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"00", null, null, null, null, null, null, null, null},
				{"08", null, null, null, null, null, null, null, null},
				{"10", null, null, null, null, null, null, null, null},
				{"18", null, null, null, null, null, null, null, null},
				{"20", null, null, null, null, null, null, null, null},
				{"28", null, null, null, null, null, null, null, null},
				{"30", null, null, null, null, null, null, null, null},
				{"38", null, null, null, null, null, null, null, null},
				{"40", null, null, null, null, null, null, null, null},
				{"48", null, null, null, null, null, null, null, null},
				{"50", null, null, null, null, null, null, null, null},
				{"58", null, null, null, null, null, null, null, null},
				{"60", null, null, null, null, null, null, null, null},
				{"68", null, null, null, null, null, null, null, null},
				{"70", null, null, null, null, null, null, null, null},
				{"78", null, null, null, null, null, null, null, null},
				{"80", null, null, null, null, null, null, null, null},
				{"88", null, null, null, null, null, null, null, null},
				{"90", null, null, null, null, null, null, null, null},
				{"98", null, null, null, null, null, null, null, null},
				{"A0", null, null, null, null, null, null, null, null},
				{"A8", null, null, null, null, null, null, null, null},
				{"B0", null, null, null, null, null, null, null, null},
				{"B8", null, null, null, null, null, null, null, null},
				{"C0", null, null, null, null, null, null, null, null},
				{"C8", null, null, null, null, null, null, null, null},
				{"D0", null, null, null, null, null, null, null, null},
				{"D8", null, null, null, null, null, null, null, null},
				{"E0", null, null, null, null, null, null, null, null},
				{"E8", null, null, null, null, null, null, null, null},
				{"F0", null, null, null, null, null, null, null, null},
				{"F8", null, null, null, null, null, null, null, null},
			},
			new String[] {
				"", "00", "01", "02", "03", "04", "05", "06", "07"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(6).setResizable(false);
		table.getColumnModel().getColumn(7).setResizable(false);
		table.getColumnModel().getColumn(8).setResizable(false);
		
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			
			
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            
            int rowM = table.convertRowIndexToModel(row);
            int columnM = table.convertColumnIndexToModel(column);
            if (columnM == 0 ) {
                c.setBackground(UIManager.getColor("Button.background"));
                
            }
            else {
            	c.setBackground(Color.white);
            }
            return c;
        }
        
       
				
        });
		
		
		PortB = new JTable();
		PortB.setShowVerticalLines(false);
		PortB.setBackground(UIManager.getColor("Button.background"));
		PortB.setRowSelectionAllowed(false);
		PortB.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}) {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			});
	
		PortB.setBounds(582, 206, 262, 31);
		contentPane.add(PortB);

		PortA.setRowSelectionAllowed(false);
		PortA.setShowVerticalLines(false);
		PortA.setBackground(UIManager.getColor("Button.background"));
		
		PortA.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		PortA.setBounds(582, 164, 262, 31);
		
		contentPane.add(PortA);
		
		JLabel lblIntcon = new JLabel("INTCON");
		lblIntcon.setBounds(522, 23, 63, 14);
		contentPane.add(lblIntcon);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(524, 40, 272, 38);
		contentPane.add(scrollPane_2);
		scrollPane_2.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		
		intcon = new JTable();
		intcon.setBackground(UIManager.getColor("Button.background"));
		scrollPane_2.setViewportView(intcon);
		intcon.setRowSelectionAllowed(false);
		intcon.getTableHeader().setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		intcon.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"GIE", "EEIE", "T0IE", "INTE", "RBIE", "T0IF", "INTF", "RBIF"
			}) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		intcon.getColumnModel().getColumn(0).setResizable(false);
		intcon.getColumnModel().getColumn(1).setResizable(false);
		intcon.getColumnModel().getColumn(2).setResizable(false);
		intcon.getColumnModel().getColumn(3).setResizable(false);
		intcon.getColumnModel().getColumn(4).setResizable(false);
		intcon.getColumnModel().getColumn(5).setResizable(false);
		intcon.getColumnModel().getColumn(6).setResizable(false);
		intcon.getColumnModel().getColumn(7).setResizable(false);
		
		
	}
	
	public void setOpenListener(ActionListener l) {
		this.mntmOpen.addActionListener(l);
	}
	
	public void setHelpListener(ActionListener l)
	{
		this.mntmHelp.addActionListener(l);
	}
	
	public void setAboutTuxSimListener(ActionListener l)
	{
		this.mntmAboutTuxsim.addActionListener(l);
	}
	
	public void setStartListener(ActionListener l) 
	{
		this.btnStart.addActionListener(l);
	}
	
	public void setStopListener(ActionListener l)
	{
		this.btnStop.addActionListener(l);
	}
	
	public void setStepListener(ActionListener l)
	{
		this.btnStep.addActionListener(l);
	}
	
	public void setResetListener(ActionListener l)
	{
		this.btnReset.addActionListener(l);
	}
	
	public void setComListener(ItemListener l) {
		this.chckbxHardwarecom.addItemListener(l);
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
		}
		return this.textPaneRA5;
		}
 
	public DefaultListModel getListModel() 
	{
		return this.lm;
	}
	public JList getCodeList() {
		return this.Sourcecodelist;
	}
	
	public JCheckBox getCheckbox()
	{
		return this.chckbxHardwarecom;
	}
	public JTable getRegister() {
		return table;
	}
	public JTable getPortA() {
		return PortA;
	}
	public JTable getPortB() {
		return PortB;
	}
	public JTable getIntcon() {
		return intcon;
	}

}


