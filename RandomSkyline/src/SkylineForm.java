// Thid is the main executable of the project.
// It presents some buildings with random number of
// windows with random sizes.

import java.awt.*;
import javax.swing.*;

public class SkylineForm extends JFrame {
	private SkylinePanel sky1;
	
	public SkylineForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Night Skyline");
		
		sky1 = new SkylinePanel();
		getContentPane().add(sky1);
		
		pack();
	}

	public static void main(String[] args) {
		SkylineForm SF1 = new SkylineForm();
		SF1.setVisible(true);
	}
}