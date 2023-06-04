package ru.obvilion.progressbar;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class ProgressBarTest {
    static String appName = "Example title";

    public static void main(String[] args) {
        JFrame frame = new JFrame(appName);

        frame.setSize(300, 200);

        Button b1 = new Button("No progress");
        Button b2 = new Button("Normal");
        Button b3 = new Button("Stop error");
        Button b4 = new Button("Pause");
        Button b5 = new Button("Inderterminate");

        b1.addActionListener(e -> ProgressBar.setProgressState(ProgressState.NO_PROGRESS));
        b2.addActionListener(e -> ProgressBar.setProgressState(ProgressState.NORMAL));
        b3.addActionListener(e -> ProgressBar.setProgressState(ProgressState.STOP_ERROR));
        b4.addActionListener(e -> ProgressBar.setProgressState(ProgressState.PAUSE));
        b5.addActionListener(e -> ProgressBar.setProgressState(ProgressState.INDETERMINATE));

        JPanel root = new JPanel();
        BoxLayout boxLayout = new BoxLayout(root, BoxLayout.Y_AXIS);
        root.setLayout(boxLayout);

        root.add(b1);
        root.add(b2);
        root.add(b3);
        root.add(b4);
        root.add(b5);

        JSlider slider = new JSlider(JSlider.HORIZONTAL);
        slider.addChangeListener(e -> ProgressBar.setProgressValue(slider.getValue()));
        root.add(slider);

        frame.getContentPane().add(root, BorderLayout.SOUTH);

        ProgressBar.loadLib( new File("C:/path/to/progress-bar-x64.dll") );
        ProgressBar.setWindowName(appName);

        frame.setVisible(true);
    }
}
