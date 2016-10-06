import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.JFrame;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

public class RobotWindow {

	private JFrame frmRobotLove;
	private DefaultListModel<Robot> listModel;
	private final JList list_1 = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotWindow window = new RobotWindow();
					window.frmRobotLove.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RobotWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRobotLove = new JFrame();
		frmRobotLove.setFont(new Font("Adobe Arabic", Font.BOLD, 12));
		frmRobotLove.setTitle("ROBOT LOVE");
		frmRobotLove.setBounds(100, 100, 610, 300);
		frmRobotLove.getContentPane().setLayout(null);
		frmRobotLove.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		list_1.setBounds(271, 11, 313, 239);
		frmRobotLove.getContentPane().add(list_1);
		
//		JList list = new JList();
//		list.setModel(new AbstractListModel() {
//			String[] values = new String[] {};
//			public int getSize() {
//				return values.length;
//			}
//			public Object getElementAt(int index) {
//				return values[index];
//			}
//		});
//		list.setBounds(560, 274, -306, -266);
//		frmRobotLove.getContentPane().add(list);
		
		JTextPane txtpnWelcomeToThe = new JTextPane();
		txtpnWelcomeToThe.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnWelcomeToThe.setContentType("text/plain/");
		txtpnWelcomeToThe.setText("Welcome to the ROBOT menu");
		txtpnWelcomeToThe.setBounds(10, 11, 233, 20);
		frmRobotLove.getContentPane().add(txtpnWelcomeToThe);
		
		JButton btnCreateNewRobot = new JButton("Create New ROBOT");
		btnCreateNewRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selected = list_1.getSelectedIndex();
				String name = (String)JOptionPane.showInputDialog(frmRobotLove, "What is your robot's name? ", "Name Dialog", JOptionPane.PLAIN_MESSAGE, null, null, "");
				int speed = (int)getPositiveValue("What is your robot's Speed? ", "Speed dialog");
				int orientation = (int)getPositiveValue("What is your robot's Orientation? ", "Orientation dialog");
				int x = (int)getPositiveValue("What is your robot's X cord? ", "X dialog");				
				int y = (int)getPositiveValue("What is your robot's Y cord? ", "Y dialog");	
				
				Robot r = new Robot(name, speed, orientation, x, y);
				listModel.add(listModel.size(), r);	
			}
		});
		btnCreateNewRobot.setBounds(20, 42, 211, 23);
		frmRobotLove.getContentPane().add(btnCreateNewRobot);
		
		JButton btnMoveARobot = new JButton("Move a ROBOT");
		btnMoveARobot.setBounds(20, 76, 211, 23);
		frmRobotLove.getContentPane().add(btnMoveARobot);
		
		JButton btnNewButton = new JButton("rotate a ROBOT");
		btnNewButton.setBounds(20, 110, 211, 23);
		frmRobotLove.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("distance between two ROBOTS ");
		btnNewButton_1.setBounds(20, 144, 211, 23);
		frmRobotLove.getContentPane().add(btnNewButton_1);
		
		listModel = new DefaultListModel<Robot>();
	}
	
	private double getPositiveValue(String prompt, String title){
		String s = (String)JOptionPane.showInputDialog(frmRobotLove, prompt, title, JOptionPane.PLAIN_MESSAGE, null, null, "");
		double sint = Double.parseDouble(s);
		while(sint < 0){
			s= (String)JOptionPane.showInputDialog(frmRobotLove, prompt + "(PLEASE ENTER A POSITIVE VALUE)", title, JOptionPane.PLAIN_MESSAGE, null, null, "");
			sint = Double.parseDouble(s);
		}
		return sint;
	}
}
