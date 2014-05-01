import java.awt.*;
import javax.swing.*;

public class KochPanel extends JPanel {
    private final int PANEL_WIDTH = 800;
    private final int PANEL_HEIGHT = 800;

    private final double SQ = Math.sqrt(3.0) / 6;

    private final int TOPX = 400, TOPY = 40;
    private final int LEFTX = 120, LEFTY = 600;
    private final int RIGHTX = 680, RIGHTY = 600;

    private int currentOrder;

    public KochPanel(int currentOrder) {
        this.currentOrder = currentOrder;
        setBackground(Color.black);
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }


    public void drawFractal(int order, int x1, int y1, int x5, int y5,
                            Graphics page) {
        // Draws A SINGLE EDGE of the fractal: If order == 1, then it is just a
        // line (-> triangle). Otherwise divides the range between points 1
        // and 5 into three, draws each as a fractal of one less degree.
        int deltaX, deltaY, x2, y2, x3, y3, x4, y4;

        if (order == 1)
            page.drawLine(x1, y1, x5, y5);
        else {
            deltaX = x5 - x1; // coordinate diffs from start to stop
            deltaY = y5 - y1;

            x2 = x1 + deltaX / 3;
            y2 = y1 + deltaY / 3;

            x3 = (int) ((x1+x5)/2 + SQ * (y1-y5));
            y3 = (int) ((y1+y5)/2 + SQ * (x5-x1));

            x4 = x1 + deltaX * 2/3;
            y4 = y1 + deltaY * 2/3;

            drawFractal(order-1, x1, y1, x2, y2, page);
            drawFractal(order-1, x2, y2, x3, y3, page);
            drawFractal(order-1, x3, y3, x4, y4, page);
            drawFractal(order-1, x4, y4, x5, y5, page);
        }
    }


    public void paintComponent(Graphics page) {
        super.paintComponent(page);

        page.setColor(Color.white);

        drawFractal(currentOrder, TOPX, TOPY, LEFTX, LEFTY, page);
        drawFractal(currentOrder, LEFTX, LEFTY, RIGHTX, RIGHTY, page);
        drawFractal(currentOrder, RIGHTX, RIGHTY, TOPX, TOPY, page);
    }


    public void setOrder(int order) {
        currentOrder = order;
    }


    public int getOrder() {
        return currentOrder;
    }
}
