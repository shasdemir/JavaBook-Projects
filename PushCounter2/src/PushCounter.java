// This is slightly different from the example in the book:
// Eeverything is defined in the JFrame class,
// instead of a separate class that inherits JPanel.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PushCounter extends JFrame {
	private int count; // number of pushes
	private JButton btnCount;
	private JPanel pnlContainer;
	private JLabel lblCount;
	
	public PushCounter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		count = 0;
	
		pnlContainer = new JPanel();
		btnCount = new JButton("Push Me!");
		lblCount = new JLabel("Pushes: " + count);
		
		pnlContainer.add(btnCount);
		pnlContainer.add(lblCount);
		add(pnlContainer);
		
		pnlContainer.setPreferredSize(new Dimension(300, 40));
		btnCount.setBounds(50, 60, 80, 30);
		
		btnCount.addActionListener(new btnCountListener());
		
		pack();
	}
	
	private class btnCountListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
				count++;
				lblCount.setText("Pushes: " + count);
		}
	}
	
	public static void main(String[] args) {
		PushCounter yoyo = new PushCounter();
		yoyo.setVisible(true);
	}
}