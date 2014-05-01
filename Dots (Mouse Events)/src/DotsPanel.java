import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DotsPanel extends JPanel {
	private final int SIZE = 6; // radius of the dots
	private ArrayList<Point> pointList;
	
	public DotsPanel() {
		pointList = new ArrayList<Point>();
		
		addMouseListener(new MouseListener() {
			public void mousePressed(MouseEvent event) {
				pointList.add(event.getPoint());
				repaint();
			}
			
			public void mouseClicked(MouseEvent event) {}
			public void mouseReleased(MouseEvent event) {}
			public void mouseEntered(MouseEvent event) {}
			public void mouseExited(MouseEvent event) {}
		});	
		
		setBackground(Color.black);
		setPreferredSize(new Dimension(300, 200));
	}
	
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		page.setColor(Color.green);
		
		for(Point spot : pointList)
			page.fillOval(spot.x - SIZE, spot.y - SIZE, SIZE * 2, SIZE * 2);
	}
}
