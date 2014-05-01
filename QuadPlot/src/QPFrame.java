import javax.swing.*;

public class QPFrame extends JFrame implements PlotUpdater {
    private JPanel container;
    private SliderPane mySP;
    private PlotArea myPA;

    public QPFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Parabola Plotter: y = ax^2 + bx + c");

        container = new JPanel();
        mySP = new SliderPane(this);
        myPA = new PlotArea();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.add(mySP);
        container.add(myPA);

        getContentPane().add(container);

        setResizable(false);
        pack();
    }


    public void updatePlot(int[] xData, int[] yData) {
        myPA.setData(xData, yData);
    }


    public static void main(String[] args) {
        QPFrame theFrame = new QPFrame();
        theFrame.setVisible(true);
    }
}
