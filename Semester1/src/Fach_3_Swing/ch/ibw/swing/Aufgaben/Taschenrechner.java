package Fach_3_Swing.ch.ibw.swing.Aufgaben;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JTextField;

public class Taschenrechner extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private String rechnungAnzeige = "";
	
	private void operation(Operation o) {
		rechnungAnzeige = rechnungAnzeige + o;
		textField.setText(rechnungAnzeige);
	}

	private void zahl(int i) {
		rechnungAnzeige = rechnungAnzeige + i;
		textField.setText(rechnungAnzeige);
	}
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taschenrechner frame = new Taschenrechner();
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
	public Taschenrechner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		// generelles, grosses panel
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		// top/north panel
		JPanel PanelNorth = new JPanel();
		PanelNorth.setBackground(Color.YELLOW);
		panel.add(PanelNorth, BorderLayout.NORTH);
		
		textField = new JTextField();
		PanelNorth.add(textField);
		textField.setColumns(10);
		JButton cleanButton = new JButton("Clear");
		PanelNorth.add(cleanButton);

		// bottom/south panel
		JPanel PanelSouth = new JPanel();
		PanelSouth.setBackground(Color.BLUE);
		panel.add(PanelSouth, BorderLayout.SOUTH);
		JButton button2 = new JButton("New button");
		PanelSouth.add(button2);

		// left/east
		JPanel panelEast = new JPanel();
		panelEast.setBackground(Color.GREEN);
		panel.add(panelEast, BorderLayout.EAST);
		JButton buttonCalcPlus = new JButton("+");
		buttonCalcPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operation(Operation.PLUS);
			}
		});
		buttonCalcPlus.setAlignmentX(0.5f);
		JButton buttonCalcMinus = new JButton("-");
		JButton buttonCalcMal = new JButton("*");
		JButton buttonCalcDurch = new JButton("/");
		JButton buttonCalcRechne = new JButton("=");
		
		JLabel label_2 = new JLabel("");
		
		JLabel label_3 = new JLabel("");
		
		JLabel label_4 = new JLabel("");
		
		JLabel label_5 = new JLabel("");
		panelEast.setLayout(new BoxLayout(panelEast, BoxLayout.X_AXIS));
		panelEast.add(buttonCalcPlus);
		panelEast.add(label_2);
		panelEast.add(label_3);
		panelEast.add(label_4);
		panelEast.add(label_5);
		panelEast.add(buttonCalcMinus);
		panelEast.add(buttonCalcMal);
		panelEast.add(buttonCalcDurch);
		panelEast.add(buttonCalcRechne);
		
		// right/west
		JPanel panelWest = new JPanel();
		panelWest.setBackground(Color.GREEN);
		panel.add(panelWest, BorderLayout.WEST);
	
		// central panel
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.CYAN);
		panel.add(panelCenter, BorderLayout.CENTER);
		JButton buttonZahl1 = new JButton("1");
		buttonZahl1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zahl(1);
			}
		});
		JButton buttonZahl2 = new JButton("2");
		JButton buttonZahl3 = new JButton("3");
		JButton buttonZahl4 = new JButton("4");
		JButton buttonZahl5 = new JButton("5");
		JButton buttonZahl6 = new JButton("6");
		JButton buttonZahl7 = new JButton("7");
		JButton buttonZahl8 = new JButton("8");
		JButton buttonZahl9 = new JButton("9");
		JButton buttonZahl0 = new JButton("0");
		panelCenter.setLayout(new GridLayout(0, 3, 0, 0));
		
		panelCenter.add(buttonZahl1);
		panelCenter.add(buttonZahl2);
		panelCenter.add(buttonZahl3);
		panelCenter.add(buttonZahl4);
		panelCenter.add(buttonZahl5);
		panelCenter.add(buttonZahl6);
		panelCenter.add(buttonZahl7);
		panelCenter.add(buttonZahl8);
		panelCenter.add(buttonZahl9);
		
		JLabel label = new JLabel("");
		panelCenter.add(label);
		panelCenter.add(buttonZahl0);
		
		JLabel label_1 = new JLabel("");
		panelCenter.add(label_1);
		
	
	}

}
