# Progress Bar Java
### lightweight library (~75 kb) for setting the percentage download status for the tray icon on Windows OS
![](https://media.discordapp.net/attachments/657881800110243881/1115032531180470442/GIF_04.06.2023_18-31-38.gif)

# Using the library
For the library to work, you need to copy one of the necessary compiled native files `.dll` to any location on your computer. You can compile them yourself, or take ready-made ones from `/src/main/cpp/out`. 

After that, load the library `ProgressBar.loadLib(File file)` and specify JavaFX/JFrame/LWJGL/LibGDX and other window name: `ProgressBar.setWindowName(String name)`.

## Setting Progress value
Use the `ProgressBar.setProgressValue(int value)` method to set the current load value. You can set the value from 0 to 100 inclusive.

## Setting Progress state
Use the `ProgressBar.setProgressState(ProgressState state)` method to set the boot state. The `enum ProgressState` is used for configuration.

### Вот его виды:
- `NO_PROGRESS` - Disables the download.
- `NORMAL` - Enables standard loading via percentages.
- `PAUSE` - Changes the color of the tray status to yellow, indicates a pause.
- `STOP_ERROR` - Changes the color of the tray status to red, indicates an error.
- `INDETERMINATE` - Disables the display of the download percentage value, denotes a download with an unknown download percentage.
