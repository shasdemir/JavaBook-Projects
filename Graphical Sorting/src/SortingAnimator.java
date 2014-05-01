// A class to to test the rest and also animate a sorting operation.
// This code may work, but it still needs to be rewritten because it is ugly

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SortingAnimator extends JFrame {
    private ArrayDisplay theDisplay;
    private int[] toBeSorted;

    int sortingType; // 0 is insertionSort, 1 is selectionSort

    // general sort variables:
    private Timer clock;
    private int k; // these 2 will be used as index variables in the sorting_
    private int j; // double loop. We do this to make them timer controllable
    private int[] indicesToSwitch;
    private int switchState;
    private boolean sortingNow;

    // selection sort variables:
    int smallestIndex;

    public SortingAnimator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Insertion Sort Animation");

        toBeSorted = new int[12];

        theDisplay = new ArrayDisplay(toBeSorted);

        sortingType = 0;
        resetRestart();

        addMouseListener(new resetListener());
        getContentPane().add(theDisplay);
        pack();
    }


    private void resetRestart() {
        for (int h = 0; h < toBeSorted.length; h++) {
            toBeSorted[h] = (int) (Math.random()*21); // for-each loop won't
            // work before initialization
        }

        theDisplay.setData(toBeSorted);

        if (sortingType == 0)
            animatedInsertionSort(toBeSorted, 200);
        else
            animatedSelectionSort(toBeSorted, 200);
    }


    private class resetListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if (!sortingNow) {
//                sortingType = 1 - sortingType; // selection sort doesnt work
                // cba, doing that one from scratch
                resetRestart();
            }
        }
    }


    public static void main(String[] args) {
        SortingAnimator Anime = new SortingAnimator();
        Anime.setVisible(true);
    }


    private void initiateSortingIndices() {
        switch (sortingType) {
            case 0:
                k = 1;
                j = 1;
                break;
            case 1:
                k = 0;
                j = 0;
                break;
            default: System.out.println("initiateSortingIndices error!");
        }
    }


    private boolean incrementSortingIndices(int inputLength) {
        boolean result = true;
        // returns sortingNow
        switch (sortingType) {
            case 0:
                j++;
                if (!(j <= k)) {
                    j = 1;

                    k++;
                    if (!(k < inputLength)) {
                        clock.stop();
                        result = false;
                    }
                }

                break;
            case 1:
                j++;
                if (j >= inputLength) {
                    k++;
                    j = k;
                    smallestIndex = k;

                    if (k >= inputLength) {
                        clock.stop();
                        result = false;
                    }
                }

                break;
            default:
                System.out.println("Indices incrementing error!");
                result = false;
                break;
        }

        return result;
    }

    private void animatedInsertionSort(int[] input, int delay) {
        sortingType = 0;
        startSorting(input, delay);

//        insertion sort:
//        int temp;
//        if (input.length > 1) {
//            for (int k = 1; k < input.length; k++) {
//                for (int j = 1; j <= k; j++) {
//                    if (input[k - j] > input[k - j + 1]) {
//                        temp = input[k - j + 1];
//                        input[k - j + 1] = input[k - j];
//                        input[k - j] = temp;
//                    }
//                }
//            }
//        }
    }


    private void animatedSelectionSort(int[] input, int delay) {
        sortingType = 1;
        startSorting(input, delay);
    }


    private void startSorting(int[] input, int delay) {
        theDisplay.setFinished(false);
        for (int index = 0; index < input.length; index++)
            theDisplay.setHighlight(index, false);
        switch (sortingType) {
            case 0: theDisplay.setDisplayText("Insertion sort in progress.");
            case 1: theDisplay.setDisplayText("Selection sort in progress.");
        }

        initiateSortingIndices();
        indicesToSwitch = new int[2];
        switchState = 3; // 0: initial highlight
                         // 1: switch, and highlight new position
                         // 2: stop highlighting
                         // 3: continue looping k & j
        clock = new Timer(delay, new TimerListener());
        clock.start();
        sortingNow = true;
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            switch (switchState) { // see animatedInsertionSort for explanation
                case 0:
                    for (int index : indicesToSwitch)
                        theDisplay.setHighlight(index, true);

                    switchState++;
                    break;
                case 1:
                    int temp;
                    temp = toBeSorted[indicesToSwitch[0]]; // k - j + 1 = 0
                    toBeSorted[indicesToSwitch[0]] =
                            toBeSorted[indicesToSwitch[1]];
                    toBeSorted[indicesToSwitch[1]] = temp;

                    theDisplay.repaint();

                    switchState++;
                    break;
                case 2:
                    for (int index : indicesToSwitch)
                        theDisplay.setHighlight(index, false);

                    switchState++;
                    break;
                case 3:
                    switch (sortingType) {
                        case 0:
                            while ((sortingNow) && // check sortingNow first
                                    !(toBeSorted[k - j] >
                                            toBeSorted[k - j + 1])) {
                                sortingNow = incrementSortingIndices(toBeSorted
                                        .length);
                                if (!sortingNow) {
                                    theDisplay.setFinished(true);
                                    clock.stop();
                                }
                            }

                            if (sortingNow) {
                                indicesToSwitch[0] = k - j + 1;
                                indicesToSwitch[1] = k - j;
                                switchState = 0;
                                actionPerformed(e);
                            }

                            break;
                        case 1:
                            while((sortingNow) && j <= toBeSorted.length){
                                sortingNow = incrementSortingIndices
                                        (toBeSorted.length);
                                if (toBeSorted[j] < toBeSorted[smallestIndex])
                                    smallestIndex = j;

                                if (!sortingNow) {
                                    theDisplay.setFinished(true);
                                    clock.stop();
                                }
                            }

                            if (sortingNow) {
                                indicesToSwitch[0] = smallestIndex;
                                indicesToSwitch[1] = k;
                                actionPerformed(e);
                            }

                            break;
                        default:
                            System.out.println("sortingType error!");
                            break;
                    }
                    break;
                default:
                    System.out.println("switchState Error!");
                    break;
            }

            theDisplay.setData(toBeSorted);
        }
    }
}
