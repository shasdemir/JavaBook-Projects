// Shows sliders as color choosers

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class SlideColorPanel extends JPanel {
    private JPanel pnlControls, pnlDisplay;
    private JSlider rSlider, gSlider, bSlider;
    private JLabel rLabel, gLabel, bLabel;

    // set up sliders and their labels, align left with a box layout
    public SlideColorPanel() {
        rSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        rSlider.setMajorTickSpacing(50);
        rSlider.setMinorTickSpacing(10);
        rSlider.setPaintTicks(true);
        rSlider.setPaintLabels(true);
        rSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        gSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        gSlider.setMajorTickSpacing(50);
        gSlider.setMinorTickSpacing(10);
        gSlider.setPaintTicks(true);
        gSlider.setPaintLabels(true);
        gSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        bSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        bSlider.setMajorTickSpacing(50);
        bSlider.setMinorTickSpacing(10);
        bSlider.setPaintTicks(true);
        bSlider.setPaintLabels(true);
        bSlider.setAlignmentX(Component.LEFT_ALIGNMENT);

        SliderListener listener = new SliderListener();
        rSlider.addChangeListener(listener);
        gSlider.addChangeListener(listener);
        bSlider.addChangeListener(listener);

        rLabel = new JLabel("Red: 0");
        gLabel = new JLabel("Green: 0");
        bLabel = new JLabel("Blue: 0");
        rLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        gLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        bLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        pnlControls = new JPanel();
        BoxLayout layout = new BoxLayout(pnlControls, BoxLayout.Y_AXIS);
        pnlControls.setLayout(layout);
        pnlControls.add(rLabel);
        pnlControls.add(rSlider);
        pnlControls.add(Box.createRigidArea(new Dimension(0, 20)));
        pnlControls.add(gLabel);
        pnlControls.add(gSlider);
        pnlControls.add(Box.createRigidArea(new Dimension(2, 20)));
        pnlControls.add(bLabel);
        pnlControls.add(bSlider);

        pnlDisplay = new JPanel();
        pnlDisplay.setPreferredSize(new Dimension(100, 100));
        pnlDisplay.setBackground(new Color(0, 0, 0));

        add(pnlControls);
        add(pnlDisplay);
    }


        private class SliderListener implements ChangeListener {
            private int red, green, blue;

            public void stateChanged(ChangeEvent event) {
                red = rSlider.getValue();
                green = gSlider.getValue();
                blue = bSlider.getValue();

                rLabel.setText("Red: " + red);
                gLabel.setText("Green: " + green);
                bLabel.setText("Blue: " + blue);

                pnlDisplay.setBackground(new Color(red, green, blue));
        }
    }
}
