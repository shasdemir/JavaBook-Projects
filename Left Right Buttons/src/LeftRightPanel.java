// This is the panel that will hold the buttons
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class LeftRightPanel extends JPanel {
	private JButton btnLeft;
	private JButton btnRight;
	private JPanel pnlButtons;
	private JLabel lblIndie;
	private JPanel pnlLabel;
	
	public LeftRightPanel() {
		btnLeft = new JButton("Left");
		btnRight = new JButton("Right");
		pnlButtons = new JPanel();
		lblIndie = new JLabel();
		pnlLabel = new JPanel();
		
		lblIndie.setText("Press a button...");
		
		pnlButtons.add(btnLeft);
		pnlButtons.add(btnRight);
		
		pnlLabel.add(lblIndie);
		pnlLabel.setPreferredSize(new Dimension(200, 25));
		
		add(pnlLabel);
		add(pnlButtons);
		
		setPreferredSize(new Dimension(200, 75));
		
		btnLeft.addActionListener(new buttonsListener());
		btnRight.addActionListener(new buttonsListener());
	}
	
	private class buttonsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnLeft)
				lblIndie.setText("Left");
			else
				lblIndie.setText("Right");
		}
	}
}