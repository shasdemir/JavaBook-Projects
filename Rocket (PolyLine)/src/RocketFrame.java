// the frame with a rocket

import javax.swing.*;

public class RocketFrame extends JFrame {
	private RocketPanel myRocket;
	
	public RocketFrame() {
		myRocket = new RocketPanel();
		
		setTitle("Rocket");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(myRocket);
		pack();
	}
	
	
	public static void main(String[] args) {
		RocketFrame myFrame = new RocketFrame();
		myFrame.setVisible(true);
	}
}
