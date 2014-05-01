// lets do everything in a single class for a change

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class DynamicPolylineFrame extends JFrame {
	private JPanel pnlContainer;
	private PolyLineDrawPanel pnlDraw;
	private JButton btnClear;
	
	public DynamicPolylineFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Draw a Poly-Line");
		
		pnlContainer = new JPanel();
		pnlDraw = new PolyLineDrawPanel();
		btnClear = new JButton("Clear Canvas");
		btnClear.addActionListener(new resetListener());
		
		pnlContainer.add(pnlDraw);
		pnlContainer.add(btnClear);
		getContentPane().add(pnlContainer);
		
		setSize(new Dimension(630, 680));
	}
	
	
	private class resetListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			pnlDraw.clearCanvas();
		}
	}
	
	
	public static void main(String[] args) {
		DynamicPolylineFrame myWindow = new DynamicPolylineFrame();
		myWindow.setVisible(true);
	}
}
