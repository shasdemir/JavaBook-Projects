import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class TransitMap  extends JFrame {
    private boolean mouseDown = false;
    private Point dragStartPoint, currentPosition;
    private double initialScrollX, initialScrollY;
    private double  shiftX, shiftY;

    private JScrollPane mapScrollPane;
    private ImageIcon map;
    private JLabel imageLabel;

    public static void main(String[] args) {
        TransitMap myMap = new TransitMap();
        myMap.setVisible(true);
    }


    public TransitMap() {
        setTitle("İstanbul Transit Map");
        map = new ImageIcon("ist-rails.png");
        imageLabel = new JLabel(map);

        mapScrollPane = new JScrollPane(imageLabel);
        mapScrollPane.setPreferredSize(new Dimension(300, 400));

        mapScrollPane.getVerticalScrollBar().setUnitIncrement(35);
        mapScrollPane.getHorizontalScrollBar().setUnitIncrement(35);

        mapScrollPane.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}

            public void mousePressed(MouseEvent e) {
                mouseDown = true;
                dragStartPoint = e.getPoint();

                initialScrollX = mapScrollPane.getHorizontalScrollBar()
                        .getValue();
                initialScrollY = mapScrollPane.getVerticalScrollBar()
                        .getValue();
            }

            public void mouseReleased(MouseEvent e) {
                mouseDown = false;
            }

            public void mouseEntered(MouseEvent e) {}
            public void mouseExited(MouseEvent e) {}
        });

        mapScrollPane.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                currentPosition = e.getPoint();
                shiftX = currentPosition.getX() - dragStartPoint.getX();
                shiftY = currentPosition.getY() - dragStartPoint.getY();

                mapScrollPane.getHorizontalScrollBar().setValue((int)
                        (initialScrollX - shiftX));
                mapScrollPane.getVerticalScrollBar().setValue((int)
                        (initialScrollY - shiftY));
            }

            @Override
            public void mouseMoved(MouseEvent e) {}
        });

        getContentPane().add(mapScrollPane);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
