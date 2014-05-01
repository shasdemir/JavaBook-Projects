import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.*;
import javax.swing.*;

public class DisplayFile {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Display File");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea ta = new JTextArea(20, 30);
        final JFileChooser chooser = new JFileChooser();

        int status = chooser.showOpenDialog(null);

        if (status != JFileChooser.APPROVE_OPTION)
            ta.setText("No File Choosen");
        else {
            File file = chooser.getSelectedFile();
            Scanner scan = new Scanner(file);

            String info = "";
            while (scan.hasNext())
                info += scan.nextLine() + "\n";

            ta.setText(info);
        }

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    FileWriter myFW = new FileWriter(chooser.getSelectedFile());
                    BufferedWriter myBW = new BufferedWriter(myFW);
                    PrintWriter myPrint = new PrintWriter(myBW);

                    Scanner wScan = new Scanner(ta.getText());
                    while (wScan.hasNext()) {
                        myPrint.println(wScan.nextLine());
                    }
                    myPrint.close();
                } catch (IOException exc) {
                    System.out.println("Please open a file first!");
                }
            }
        });

        JPanel thePanel = new JPanel();
        thePanel.add(saveButton);
        thePanel.add(ta);
        frame.getContentPane().add(thePanel);
        frame.pack();
        frame.setVisible(true);
    }
}
