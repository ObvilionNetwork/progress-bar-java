package ru.obvilion.progressbar;

import java.io.File;

public class ProgressBar {
    public static final String VERSION = "1.0.1";

    public static void loadLib(File from) {
        System.load(from.getAbsolutePath());
    }

    public static void setProgressState(ProgressState state) {
        setProgressState(state.intValue());
    }

    private static native void setProgressState(int state);

    public static native void setProgressValue(int value);

    public static native void setWindowName(String name);
}
