// E-mail program prototype

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ProtoMail extends JFrame {
	private JTextArea txtBody;
	
	private JTextField txtTo;
	private JTextField txtCc;
	private JTextField txtBcc;
	private JTextField txtSub;
	private JButton btnSend;
	
	private final JLabel lblTo = new JLabel("To:");
	private final JLabel lblCc = new JLabel("Cc:");
	private final JLabel lblBcc = new JLabel("Bcc:");
	private final JLabel lblSub = new JLabel("Subject:");
	
	private JPanel pnlContainer;
	
	public ProtoMail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ProtoMail");
		setResizable(false);
		
		txtBody = new JTextArea();
		//txtBody.setText("Enter your message here.");
		txtBody.setPreferredSize(new Dimension(580, 305));
		txtBody.setLineWrap(true);
		txtBody.setWrapStyleWord(true);
		
		txtTo = new JTextField(45);
		txtCc = new JTextField(51);
		txtBcc = new JTextField(50);
		txtSub = new JTextField(48);
		btnSend = new JButton("Send");
		pnlContainer = new JPanel();
		
		pnlContainer.add(btnSend);
		
		pnlContainer.add(lblTo);
		pnlContainer.add(txtTo);
		
		pnlContainer.add(lblCc);
		pnlContainer.add(txtCc);
		
		pnlContainer.add(lblBcc);
		pnlContainer.add(txtBcc);
		
		pnlContainer.add(lblSub);
		pnlContainer.add(txtSub);
		
		pnlContainer.add(txtBody);
		pnlContainer.setPreferredSize(new Dimension(600, 400));
		
		getContentPane().add(pnlContainer);
		
		pack();
		
		btnSend.addActionListener(new SendListener());
	}
	
	public static void main(String[] args) {
		ProtoMail pm1 = new ProtoMail();
		pm1.setVisible(true);
	}
	
	public class SendListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("To: " + txtTo.getText());
			System.out.println("Cc: " + txtCc.getText());
			System.out.println("Bcc: " + txtBcc.getText());
			System.out.println("Subject: " + txtSub.getText());
			System.out.println("Message contents:\n" + txtBody.getText());
		}
	}
}