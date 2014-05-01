// Showing images

import java.awt.*;
import javax.swing.*;

public class EvilThanDevil {
	public static void main(String[] args) {
		JFrame myFrame = new JFrame("Label Demo");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create labels
		ImageIcon icon = new ImageIcon("skullbg.gif");
		
		JLabel label1, label2, label3;
		
		label1 = new JLabel("Skull Left", icon, SwingConstants.CENTER);
		
		label2 = new JLabel("Skull Right", icon, SwingConstants.CENTER);
		label2.setHorizontalTextPosition(SwingConstants.LEFT);
		label2.setVerticalTextPosition(SwingConstants.BOTTOM);
		
		label3 = new JLabel("Skull Above", icon, SwingConstants.CENTER);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM); //
		
		label1.setForeground(Color.red);
		label2.setForeground(Color.red);
		label3.setForeground(Color.red);
		
		Font myFont = new Font("Chiller",Font.PLAIN, 20 );
		label1.setFont(myFont);
		label2.setFont(myFont);
		label3.setFont(myFont);
		
		//create panels and add to the frame
		JPanel myPanel = new JPanel();
		myPanel.setBackground(Color.black);
		myPanel.setPreferredSize(new Dimension(200, 430));
		myPanel.add(label1);
		myPanel.add(label2);
		myPanel.add(label3); //
		myFrame.getContentPane().add(myPanel);
		myFrame.pack();
		myFrame.setVisible(true);
	}
}
