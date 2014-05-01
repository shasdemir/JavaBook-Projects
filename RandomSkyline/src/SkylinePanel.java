// This is the panel that contains the buildings
// that make up the skyline.

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class SkylinePanel extends JPanel {
	private ArrayList<Building> TOKI;
	
	private int nextWidth, nextHeight, xPosition;
	
	public SkylinePanel() {
		setPreferredSize(new Dimension(400, 350));
		
		setBackground(new Color(25, 25, 112));
		
		nextWidth = 0;
		xPosition = 0;
		
		TOKI = new ArrayList<Building>();
		
		for (int i = 0; i < 6; i++) {
			randomizeWH();
			TOKI.add(new Building(nextWidth, nextHeight, xPosition , 350 - nextHeight));
		}
	}
	
	private void randomizeWH() {
		xPosition += nextWidth;
		
		nextWidth = 50 + (int)(Math.random()*51);
		nextHeight = 100 + (int)(Math.random()*101);
	}
	
	public void paintComponent(Graphics page) {
		super.paintComponent(page);
		
		for (int i = 0; i < 6; i++) {
			TOKI.get(i).draw(page);
		}
	}
}