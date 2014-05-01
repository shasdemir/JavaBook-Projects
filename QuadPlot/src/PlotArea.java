import javax.swing.*;
import java.awt.*;

public class PlotArea extends JPanel {
    private final Color BACKGROUND = Color.white;
    private final Color FOREGROUND = Color.black;
    private final int WIDTH = 1000;
    private final int HEIGHT = 500;
    private final int NUMLABELS = 20;

    private int cWidth;
    private int cHeight;

    private boolean hasGraph = false;
    private int[] yData;
    private int[] xData;

    public PlotArea() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(BACKGROUND);
    }


    public void setData(int[] X, int[] Y) {
        if (X.length == Y.length) {
            xData = X;
            yData = Y;
            hasGraph = true;
            repaint();
        } else
            System.out.println("Data length mismatch!");
    }


    public void paintComponent(Graphics context) {
        super.paintComponent(context);

        cWidth = this.getWidth();
        cHeight = this.getHeight();

        context.setColor(FOREGROUND);

        // draw axes
        context.drawLine(0, cHeight/2, cWidth, cHeight/2);
        context.drawLine(cWidth/2, 0, cWidth/2, cHeight);

        // draw axis labels
        for (int k = 0; k < NUMLABELS; k++) {
            int xPosition = k* cWidth /NUMLABELS;
            if (!(xPosition - cWidth/2 == 0))
            context.drawString(String.valueOf(xPosition - cWidth/2), xPosition,
                    cHeight/2 + 17);

            context.drawLine(xPosition, cHeight/2 -5, xPosition, cHeight/2 + 5);

            // x axis done above. now y:
            int yPosition = k* cHeight /NUMLABELS;
            context.drawString(String.valueOf(-yPosition + cHeight /2),
                    cWidth/2 + 10, yPosition + 5);
            context.drawLine(cWidth/2 - 5, yPosition, cWidth/2 + 5, yPosition);

            // plot the graph if it was set
            if (hasGraph) {
                for (int i = 0; i < xData.length; i++) {
                  context.fillOval(xData[i]+500, -yData[i] + cHeight/2, 10,
                          10);
                }
            }
        }
    }
}