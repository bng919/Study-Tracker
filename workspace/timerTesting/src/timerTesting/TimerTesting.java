package timerTesting;

/*
 * This file is for testing and developing methods related to timing 
 * Package also includes Proj.java with Proj class
 * 
 * 
 */


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerTesting implements ActionListener{

	//Initialize global variables
	private JFrame frame;
	private JButton button;
	private boolean active = false;
	private long startTime;
	private long elapsedTime;
	private Proj task = new Proj("Study");
	
	public TimerTesting() {
		frame = new JFrame();
		
		button = new JButton("Start");
		button.addActionListener(this);

		
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Study Tracker");
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TimerTesting();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(!active) {
			startTime = System.currentTimeMillis();
			active = true;
			button.setText("Stop");
		} else {
			elapsedTime = System.currentTimeMillis() - startTime;
			active = false;
			task.updateTime(elapsedTime);
			System.out.println(task.getTime());
			button.setText("Start");
		}
		
	}

}
