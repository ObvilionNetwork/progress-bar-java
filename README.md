# Progress Bar Java
### lightweight library (~75 kb) for setting the percentage download status for the tray icon on Windows OS
![](https://media.discordapp.net/attachments/657881800110243881/1115032531180470442/GIF_04.06.2023_18-31-38.gif)

# Using the library
For the library to work, you need to copy one of the necessary compiled native files `.dll` to any location on your computer. You can compile them yourself, or take ready-made ones from `/src/main/cpp/out`. 

After that, load the library `ProgressBar.loadLib(File file)` and specify JavaFX/JFrame/LWJGL/LibGDX and other window name: `ProgressBar.setWindowName(String name)`.

## Setting Progress value
Используйте метод `ProgressBar.setProgressValue(int value)` для установки текущего значения загрузки. Вы можете установить значение от 0 до 100 включительно.

## Setting Progress state
Используйте метод `ProgressBar.setProgressState(ProgressState state)` для установки состояния загрузки. Для настройки используется `enum ProgressState`.

### Вот его виды:
- `NO_PROGRESS` - Отключает загрузку.
- `NORMAL` - Включает стандартную загрузку через проценты.
- `PAUSE` - Меняет цвет статуса трея на желтный, обозначает паузу.
- `STOP_ERROR` - Меняет цвет статуса трея на красный, обозначает ошибку.
- `INDETERMINATE` - Отключает показ процентного значения загрузки, обозначает загрузку с неизвестным процентом загрузки.
