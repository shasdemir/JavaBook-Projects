// This represents a rectangular black building
// with a random number of yellow windows of random
// dimensions.
// Inputs are the dimensions of the building.

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;

public class Building{
	private int width, height, upperX, upperY;
	private int numberOfWindows; // between 1-5
	private int nWinWidth, nWinHeight, nWinX, nWinY;
	
	private ArrayList<YellowWindow> Windows;
		
	public Building(int width, int height, int x, int y) {
		this.width = width;
		this.height = height;
		upperX = x;
		upperY = y;
		
		Windows = new ArrayList<YellowWindow>();
		
		numberOfWindows = (int)(1 + Math.random()*4);
			
		for (int k = 0; k < numberOfWindows; k++) {
			rndWinParameters();
			Windows.add(new YellowWindow(nWinWidth, nWinHeight, nWinX, nWinY));
		}
	}
	
	private void rndWinParameters() {
		nWinWidth = (int)(20 + Math.random()*this.width/10);
		nWinHeight = (int)(20 + Math.random()*this.height/10);
		nWinX = upperX +(int)(1 + Math.random()*this.width*0.8);
		nWinY = upperY + (int)(1 + Math.random()*this.height*0.8);
	}
	
	public void draw(Graphics page) {
		page.setColor(Color.black);
		page.fillRect(upperX, upperY, width, height);
		
		for (int k = 0; k < numberOfWindows; k++) {
			Windows.get(k).draw(page);
		}
	}
}