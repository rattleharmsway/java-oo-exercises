//package exercises;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RobotWindowTest {

	private JFrame frame;
	//private final JList list = new JList();
	private JList list;
	private DefaultListModel<Robot> listModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotWindowTest window = new RobotWindowTest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RobotWindowTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 226);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		
		JButton btnMakeARobot = new JButton("Make A Robot");
		btnMakeARobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				String name = (String)JOptionPane.showInputDialog(frame, "What is your robot's name? ", "Name Dialog", JOptionPane.PLAIN_MESSAGE, null, null, "");
				int speed = (int)getPositiveValue("What is your robot's Speed? ", "Speed dialog");
				int orientation = (int)getPositiveValue("What is your robot's Orientation? ", "Orientation dialog");
				int x = (int)getPositiveValue("What is your robot's X cord? ", "X dialog");				
				int y = (int)getPositiveValue("What is your robot's Y cord? ", "Y dialog");	
				
				Robot r = new Robot(name, speed, orientation, x, y);
				listModel.add(listModel.size(), r);
				//listModel.addElement(r);
			}
		});
		btnMakeARobot.setBounds(10, 8, 184, 23);
		frame.getContentPane().add(btnMakeARobot);
		
		
		JButton btnMoveRobot = new JButton("Move Robot");
		btnMoveRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				int move = (int)getPositiveValue("How much are you moving? ", "Move dialog");
				listModel.get(selected).move(move);
				
			}
		});
		btnMoveRobot.setBounds(10, 42, 184, 23);
		frame.getContentPane().add(btnMoveRobot);
		
		
		JButton btnDistanceBetweenTwo = new JButton("Distance Between Two Robots");
		btnDistanceBetweenTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] selected2 = list.getSelectedIndices();
				double distance;
				if (selected2.length < 2){
				    Object selected = JOptionPane.showInputDialog(null, "Choose Another Robot", "Input",JOptionPane.INFORMATION_MESSAGE, null,listModel.toArray(),listModel.toArray());
				    System.out.println(selected);
				    distance = (double)listModel.get(selected2[0]).Distance((Robot)selected);
			    }
				else{
					distance = (double)listModel.get(selected2[0]).Distance(listModel.get(selected2[1]));
				}
				JOptionPane.showMessageDialog(null, "the distance is: " + distance, "distance", JOptionPane.PLAIN_MESSAGE);

			}
		});
		btnDistanceBetweenTwo.setBounds(10, 76, 184, 23);
		frame.getContentPane().add(btnDistanceBetweenTwo);
		
		
		JButton btnRotateARobot = new JButton("Rotate A Robot");
		btnRotateARobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selected = list.getSelectedIndex();
				String rot = (String)JOptionPane.showInputDialog(frame, "What direction do you want to rotate ( l or r )? ", "Rotate Dialog", JOptionPane.PLAIN_MESSAGE, null, null, "");
				listModel.get(selected).rotate(rot);
			}
		});
		btnRotateARobot.setBounds(10, 110, 184, 23);
		frame.getContentPane().add(btnRotateARobot);
		
		
		listModel = new DefaultListModel<Robot>();
		list = new JList(listModel);
		list.setBounds(204, 11, 370, 165);
		frame.getContentPane().add(list);
	}
	
	private double getPositiveValue(String prompt, String title){
		String s = (String)JOptionPane.showInputDialog(frame, prompt, title, JOptionPane.PLAIN_MESSAGE, null, null, "");
		double sint = Double.parseDouble(s);
		while(sint < 0){
			s= (String)JOptionPane.showInputDialog(frame, prompt + "(PLEASE ENTER A POSITIVE VALUE)", title, JOptionPane.PLAIN_MESSAGE, null, null, "");
			sint = Double.parseDouble(s);
		}
		return sint;
	}

}
