// the executable frame class that uses PCounterPanel

import java.awt.*;
import javax.swing.*;

public class PCounterFrame extends JFrame {
	public PCounterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PCounterPanel yoyo = new PCounterPanel();
		PCounterPanel mommy = new PCounterPanel();
		PCounterPanel zulu = new PCounterPanel();
		
		JPanel pnlContainer = new JPanel();
		
		pnlContainer.add(yoyo);
		pnlContainer.add(mommy);
		pnlContainer.add(zulu);
		
		getContentPane().add(pnlContainer);
		
		setSize(200, 175);
	}
	
	public static void main(String[] args) {
		PCounterFrame ma = new PCounterFrame();
		ma.setVisible(true);
	}

}
