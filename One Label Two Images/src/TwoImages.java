// trying to fit two images in each panel
import java.awt.*;
import javax.swing.*;

public class TwoImages {
	public static void main(String[] args) {
		
		// creating objects
		JFrame myFrame = new JFrame("Two Panels Four Images");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pnlPic1 = new JPanel();
		JPanel pnlPic2 = new JPanel();
		JPanel pnlPrimary = new JPanel();
		JLabel lblPic1, lblPic2, lblPic3, lblPic4;
		
		// setting the objects up
		ImageIcon icon1 = new ImageIcon("clips.jpg");
		ImageIcon icon2 = new ImageIcon("pencils.jpg");
		ImageIcon icon3 = new ImageIcon("paint-splatters.jpg");
		ImageIcon icon4 = new ImageIcon("color.jpg");
		
		lblPic1 = new JLabel(null, icon1, SwingConstants.CENTER);
		lblPic2 = new JLabel(null, icon2, SwingConstants.CENTER);
		lblPic3 = new JLabel(null, icon3, SwingConstants.CENTER);
		lblPic4 = new JLabel(null, icon4, SwingConstants.CENTER);
		
		pnlPic1.setPreferredSize(new Dimension(500, 200));
		
		// adding it up together
		pnlPic1.add(lblPic1);
		pnlPic1.add(lblPic2);
		pnlPic2.add(lblPic3);
		pnlPic2.add(lblPic4);
		
		pnlPrimary.add(pnlPic1);
		pnlPrimary.add(pnlPic2);
		myFrame.getContentPane().add(pnlPrimary);
		
		myFrame.pack();
		myFrame.setVisible(true);
	}
}
