//incomplete

package AnimatedSelectionSort;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.*;

public class SelectionSortAnimator extends JFrame {
    private ArrayDisplay theDisplay;
    private int[] toBeSorted;

    private boolean sortingNow;
    private int animationState;
    private Timer clock;
    private boolean sleeping;

    public SelectionSortAnimator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Selection Sort Animation");

        toBeSorted = new int[12];
        theDisplay = new ArrayDisplay(toBeSorted);

        // incomplete
    }


    public static void main(String[] args) {
        SelectionSortAnimator myAnime = new SelectionSortAnimator();
        myAnime.setVisible(true);
    }


    private void resetRestart() {
        for (int h = 0; h < toBeSorted.length; h++) {
            toBeSorted[h] = (int) (Math.random()*21);
        }

        theDisplay.setData(toBeSorted);

        // sort command here
    }


    private class resetListender extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (!sortingNow)
                resetRestart();
        }
    }
}
