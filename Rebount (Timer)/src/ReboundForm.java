// contains a ReboundPanel

import java.awt.*;
import javax.swing.*;

public class ReboundForm extends JFrame {
	private ReboundPanel myPanel;
	
	public ReboundForm() {
		setTitle("Rebound");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myPanel = new ReboundPanel();
		getContentPane().add(myPanel);
		
		pack();
	}
	
	
	public static void main(String[] args) {
		ReboundForm theForm = new ReboundForm();
		theForm.setVisible(true);
	}
}
