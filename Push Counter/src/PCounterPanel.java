// this time, a separate panel object is added to the frame

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PCounterPanel extends JPanel {
	private int count; // number of pushes
	private JLabel lblCount;
	private JButton btnCount;
	
	public PCounterPanel() {
		count = 0;
		
		btnCount = new JButton("Push me!");
		lblCount = new JLabel("Pushes: " + count);
		
		btnCount.setToolTipText("Click here to increment.");
		lblCount.setToolTipText("The number of clicks.");
		
		add(btnCount);
		add(lblCount);
		
		setPreferredSize(new Dimension(300, 40));
		btnCount.setBounds(50, 60, 80, 30);
		
		btnCount.addActionListener(new btnCountListener());
	}
	
	private class btnCountListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				count++;
				lblCount.setText("Pushes: " + count);
				//lblCount.setText(lblCount.getText() + count);	
			}
	}
}

