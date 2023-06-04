package ru.obvilion.progressbar;

public enum ProgressState {

    NO_PROGRESS  (0x00000000),
    INDETERMINATE(0x00000001),
    NORMAL       (0x00000002),
    STOP_ERROR   (0x00000004),
    PAUSE        (0x00000008);

    private final int value;

    private ProgressState(int i) {
        value = i;
    }

    int intValue() {
        return value;
    }
}
