package AnimatedSelectionSort;// A panel that represents an array of Integers as a bar chart.

import javax.swing.*;
import java.awt.*;

public class ArrayDisplay extends  JPanel {
    private int[] data;
    private boolean[] highlighted;
    private double[] heightFractions;
    private String displayText;

    private final int INIT_HEIGHT = 400;
    private final int INIT_WIDTH = 800;

    private final Color BACKGROUND = Color.white;
    private final Color FOREGROUND = Color.black;
    private final Color HIGHLIGHT = Color.red;

    private final int SEPARATION = 10;
    private int barWidth;
    private int largestData;

    private boolean finished;

    public ArrayDisplay(int[] data) {
        setPreferredSize(new Dimension(INIT_WIDTH, INIT_HEIGHT));
        setBackground(BACKGROUND);

        setData(data);
        highlighted = new boolean[this.data.length];
    }


    public void paintComponent(Graphics context) {
        super.paintComponent(context);

        barWidth = (getWidth() - (SEPARATION * (data.length - 1))) /data.length;

        for (int k = 0; k < data.length; k++) {
            context.setColor(highlighted[k] ? HIGHLIGHT : FOREGROUND);

            context.fillRect(k * (barWidth + SEPARATION),
                   (int) (getHeight() * (1 - heightFractions[k])),
                    barWidth,
                   (int) (getHeight() * heightFractions[k]));
        }

        if (finished) {
            context.setColor(FOREGROUND);
            context.drawString("Sorting done! Click to randomize and start " +
                    "over.", 10, 20);
        }

        if (!(displayText == null) && !finished) {
            context.setColor(FOREGROUND);
            context.drawString(displayText, 10, 20);
        }
    }


    public void setData(int[] data) {
        this.data = data;

        largestData = data[0];
        for (int number : data)
            if (number > largestData) largestData = number;

        heightFractions = new double[this.data.length];
        for (int k = 0; k < data.length; k++)
            heightFractions[k] = ((double) data[k]) / ((double) largestData);

        repaint();
    }


    public void setHighlight(int index, boolean isHighlighted) {
        highlighted[index] = isHighlighted;
        repaint();
    }


    public void setFinished(boolean isFinished) {
        this.finished = isFinished;
        repaint();
    }


    public void setDisplayText(String text) {
        displayText = text;
    }
}



