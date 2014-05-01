// Demos the use of the layout managers.

import javax.swing.*;

public class LayoutDemo extends JFrame {
	public LayoutDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Layout Manager Demo");
		
		JTabbedPane tp = new JTabbedPane();
		tp.addTab("Intro", new IntroPanel());
		tp.addTab("Flow", new FlowPanel());
		tp.addTab("Border", new BorderPanel());
		tp.addTab("Grid", new GridPanel());
		tp.addTab("Box", new BoxPanel());
		
		getContentPane().add(tp);
		pack();
	}
	
	
	public static void main(String[] args) {
		LayoutDemo LD = new LayoutDemo();
		LD.setVisible(true);
	}

}
