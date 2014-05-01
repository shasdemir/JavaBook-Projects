import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KochWindow extends JFrame {
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;

    private final int MIN = 1, MAX = 10;

    private JButton btnIncrease, btnDecrease;
    private JLabel titleLabel, orderLabel;
    private KochPanel drawing;
    private JPanel windowPanel, tools;


    public static void main(String[] args) {
        KochWindow myWin = new KochWindow();
        myWin.setVisible(true);
    }


    public KochWindow() {
        tools = new JPanel();
        tools.setLayout(new BoxLayout(tools, BoxLayout.X_AXIS));
        tools.setBackground(Color.white);
        tools.setOpaque(true);

        titleLabel = new JLabel("The Koch Snowflake");
        titleLabel.setForeground(Color.black);

        btnIncrease = new JButton("Increase!");
        btnIncrease.setMargin(new Insets(0, 0, 0, 0));
        btnIncrease.addActionListener(new ButtonListener());

        btnDecrease = new JButton("Decrease!");
        btnDecrease.setMargin(new Insets(0, 0, 0, 0));
        btnDecrease.addActionListener(new ButtonListener());

        orderLabel = new JLabel("Order: 1");
        orderLabel.setForeground(Color.black);

        tools.add(titleLabel);
        tools.add(Box.createHorizontalStrut(20));
        tools.add(btnDecrease);
        tools.add(btnIncrease);
        tools.add(Box.createHorizontalStrut(20));
        tools.add(orderLabel);

        drawing = new KochPanel(1);

        windowPanel = new JPanel();
        windowPanel.add(tools);
        windowPanel.add(drawing);
        windowPanel.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        getContentPane().add(windowPanel);
        pack();
        setTitle("The Koch Snowflake Fractal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            int order =drawing.getOrder();

            if (event.getSource() == btnIncrease)
                order++;
            else
                order--;

            if (order >= MIN && order <= MAX) {
                orderLabel.setText("Order: " + order);
                drawing.setOrder(order);
                repaint();
            }
        }
    }
}
