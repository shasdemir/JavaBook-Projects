// Border demo. What a useful comment.

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class BorderDemo extends JFrame {
	public BorderDemo() {
		setTitle("Border Demo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		getContentPane().setBackground(Color.white);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(0, 2, 5, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		panel.setBackground(Color.white);
		
		JPanel p1 = new JPanel();
		p1.setBorder(BorderFactory.createLineBorder(Color.red, 3));
		p1.add(new JLabel("Line Border"));
		p1.setBackground(Color.white);
		panel.add(p1);
		
		JPanel p2 = new JPanel();
		Border pd1 = BorderFactory.createEtchedBorder();
		Border pde = BorderFactory.createTitledBorder(pd1, "Title");
		p2.setBorder(pde);
		p2.add(new JLabel("Etched Titled Border"));
		p2.setBackground(Color.white);
		panel.add(p2);
		
		JPanel p3 = new JPanel();
		p3.setBorder(BorderFactory.createRaisedBevelBorder());
		p3.add(new JLabel("Raised Bevel Border"));
		p3.setBackground(Color.white);
		panel.add(p3);
		
		JPanel p4 = new JPanel();
		p4.setBorder(BorderFactory.createLoweredBevelBorder());
		p4.add(new JLabel("Lowered Bevel Border"));
		p4.setBackground(Color.white);
		panel.add(p4);
		
		JPanel p5 = new JPanel();
		p5.setBorder(BorderFactory.createTitledBorder("Title"));
		p5.add(new JLabel("Titled Border"));
		p5.setBackground(Color.white);
		panel.add(p5);
		
		JPanel p6 = new JPanel();
		TitledBorder tb = BorderFactory.createTitledBorder("Title");
		tb.setTitleJustification(TitledBorder.RIGHT);
		p6.setBorder(tb);
		p6.add(new JLabel("Titled Border (right)"));
		p6.setBackground(Color.white);
		panel.add(p6);
		
		JPanel p7 = new JPanel();
		Border b1 = BorderFactory.createLineBorder(Color.blue, 2);
		Border b2 = BorderFactory.createEtchedBorder();
		p7.setBorder(BorderFactory.createCompoundBorder(b1, b2));
		p7.add(new JLabel("Compound Border"));
		p7.setBackground(Color.white);
		panel.add(p7);
		
		JPanel p8 = new JPanel();
		Border mb = BorderFactory.createMatteBorder(1, 5, 1, 1, Color.red);
		p8.setBorder(mb);
		p8.add(new JLabel("Matte Border"));
		p8.setBackground(Color.white);
		panel.add(p8);
		
		getContentPane().add(panel);
		pack();
	}
	
	
	public static void main(String[] args) {
		BorderDemo BD = new BorderDemo();
		BD.setVisible(true);
	}
}
