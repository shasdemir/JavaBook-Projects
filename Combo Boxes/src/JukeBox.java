import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.AudioClip;
import java.net.URL;

public class JukeBox extends JFrame {
    private JPanel controlsPanel;

    private JComboBox musicCombo;
    private JButton stopButton, playButton;
    private AudioClip[] musicArray;
    private AudioClip currentMusic;

    public static void main(String[] args) {
        JukeBox myBox = new JukeBox();
        myBox.setVisible(true);
    }


    public JukeBox() {
        URL url1, url2, url3, url4, url5, url6, url7, url8, url9;
        url1 = url2 = url3 = url4 = url5 = url6 = url7 = url8 = url9 = null;

        try {
            url1 = new URL("file", "localhost", "applause.wav");
            url2 = new URL("file", "localhost", "beam.wav");
            url3 = new URL("file", "localhost", "drama.wav");
            url4 = new URL("file", "localhost", "explos.wav");
            url5 = new URL("file", "localhost", "falling.wav");
            url6 = new URL("file", "localhost", "glasses.wav");
            url7 = new URL("file", "localhost", "gong.wav");
            url8 = new URL("file", "localhost", "laser.wav");
            url9 = new URL("file", "localhost", "train.wav");
        } catch (Exception exc) {}

        musicArray = new AudioClip[10];
        musicArray[0] = null;  // "make a selection..."
        musicArray[1] = JApplet.newAudioClip(url1);
        musicArray[2] = JApplet.newAudioClip(url2);
        musicArray[3] = JApplet.newAudioClip(url3);
        musicArray[4] = JApplet.newAudioClip(url4);
        musicArray[5] = JApplet.newAudioClip(url5);
        musicArray[6] = JApplet.newAudioClip(url6);
        musicArray[7] = JApplet.newAudioClip(url7);
        musicArray[8] = JApplet.newAudioClip(url8);
        musicArray[9] = JApplet.newAudioClip(url9);

        JLabel titleLabel = new JLabel("Şükrü's Java Juke Box");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // String for ComboBox options...
        String[] musicNames = {"Make a Selection...", "Applause", "Beam",
                "Drama", "Explosion", "Falling", "Glasses", "Gong", "Laser",
                "Train"};

        musicCombo = new JComboBox(musicNames);
        musicCombo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // buttons setup
        playButton = new JButton("Play", new ImageIcon("play.gif"));
        stopButton = new JButton("Stop", new ImageIcon("stop.gif"));
        playButton.setBackground(Color.white);
        stopButton.setBackground(Color.white);
        playButton.setMnemonic('p');
        stopButton.setMnemonic('s');

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
        buttonsPanel.add(playButton);
        buttonsPanel.add(Box.createRigidArea(new Dimension(5, 0)));
        buttonsPanel.add(stopButton);
        buttonsPanel.setBackground(Color.white);

        // set up the container panel: controlsPanel
        controlsPanel = new JPanel();
        controlsPanel.setPreferredSize(new Dimension(300, 100));
        controlsPanel.setBackground(Color.white);
        controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS));
        controlsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        controlsPanel.add(titleLabel);
        controlsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        controlsPanel.add(musicCombo);
        controlsPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        controlsPanel.add(buttonsPanel);
        controlsPanel.add(Box.createRigidArea(new Dimension(0, 5)));

        musicCombo.addActionListener(new ComboListener());
        stopButton.addActionListener(new ButtonListener());
        playButton.addActionListener(new ButtonListener()); // wtf?

        currentMusic = null;

        // frame setup
        setTitle("Java JukeBox");
        getContentPane().add(controlsPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pack();
    }


    private class ComboListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (currentMusic != null)
                currentMusic.stop();

            currentMusic = musicArray[musicCombo.getSelectedIndex()];
        }
    }


    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (currentMusic != null)
                currentMusic.stop();

            if (e.getSource() == playButton)
                if (currentMusic != null)
                    currentMusic.play();
        }
    }
}
