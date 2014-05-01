import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LeftRight2 extends JFrame {

	private JPanel contentPane;
	private JLabel lblClickEitherLeft;
	private JButton btnLeft;
	private JButton btnRight;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeftRight2 frame = new LeftRight2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LeftRight2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		
		lblClickEitherLeft = new JLabel("Click a Button");
		panel.add(lblClickEitherLeft);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		
		btnLeft = new JButton("Left");
		
		panel_1.add(btnLeft);
		
		btnRight = new JButton("Right");
		
		panel_1.add(btnRight);
		
		buttonListener Ear = new buttonListener();
		btnLeft.addActionListener(Ear);
		btnRight.addActionListener(Ear);
		
		contentPane.setPreferredSize(new Dimension(200, 80));
		panel.setPreferredSize(new Dimension(200, 25));
		pack();
		setResizable(false);
	}
	
	private class buttonListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == btnLeft)
				lblClickEitherLeft.setText("Left");
			else
				lblClickEitherLeft.setText("Right");
		}
	}

}
