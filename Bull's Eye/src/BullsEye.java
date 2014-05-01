// displays the bullseye
// dunno where the previous one went...

import javax.swing.JFrame;

public class BullsEye extends JFrame {
	private BullsEyePanel BEP;
	
	public BullsEye() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Bullseye");
		
		BEP = new BullsEyePanel();
		getContentPane().add(BEP);
		pack();
	}
	
	
	public static void main(String[] args) {
		BullsEye myBE = new BullsEye();
		myBE.setVisible(true);
	}
}
