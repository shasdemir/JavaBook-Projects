import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderPane extends JPanel {
    private final int PARAMMIN = -10;
    private final int PARAMAX = 10;
    private final int PARAMINT = 3;

    private int[] eqParams; // a, b ,c in y = ax^2 + bx + c
    private int[] xData, yData;

    private ArrayList<JSlider> SlidersList;
    private ArrayList<JLabel> LabelsList;

    PlotUpdater myUpdater;

    public SliderPane(PlotUpdater updater) {
        myUpdater = updater;

        setPreferredSize(new Dimension(1000, 60));

        eqParams = new int[3];
        for (int i : eqParams)
            i = PARAMINT;

        xData = new int[1000];
        yData = new int[1000];

        SlidersList = new ArrayList<JSlider>();
        LabelsList = new ArrayList<JLabel>();

        LabelsList.add(new JLabel("a:"));
        LabelsList.add(new JLabel("b:"));
        LabelsList.add(new JLabel("c:"));
        for (JLabel anyLabel : LabelsList)
            anyLabel.setFont(new Font("Sans Serif", Font.PLAIN, 25));

        for (int k = 0; k < 3; k++) {
            JSlider currentSlider = new JSlider(JSlider.HORIZONTAL,PARAMMIN,
                    PARAMAX, PARAMINT);
            currentSlider.setMajorTickSpacing(20);
            currentSlider.setMinorTickSpacing(10);
            currentSlider.setPaintTicks(true);
            currentSlider.setPaintLabels(true);
            currentSlider.setPreferredSize(new Dimension(300, 50));
            SlidersList.add(currentSlider);
            add(LabelsList.get(k));
            add(currentSlider);
            currentSlider.addChangeListener(new SliderListener());
        }
    }

    private class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            for (int j = 0; j < 3; j++)
                eqParams[j] = SlidersList.get(j).getValue();

            // calculate function
            for (int k = 0; k < 1000; k++) {
                xData[k] = -500 + k;
                yData[k] = eqParams[0]*xData[k]*xData[k] +
                        eqParams[1]*xData[k] + eqParams[2];
            }

            // send to plot
            myUpdater.updatePlot(xData, yData);
        }
    }
}
