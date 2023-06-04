package ru.obvilion.progressbar;

public class ProgressBar {
    public static final String VERSION = "1.0.0";


    public static void loadLib(String path) {
        System.load(path);
    }


    public static void setProgressState(ProgressState state) {
        setProgressState(state.intValue());
    }

    private static native void setProgressState(int state);

    public static native void setProgressValue(int value);

    public static native void setWindowName(String name);
}
