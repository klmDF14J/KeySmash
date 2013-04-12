package keysmash.gui.button;

import keysmash.gui.GraphicVariables;
	
public class ButtonList {
	public static Button gamemodeButtonTimed;
	public static Button gamemodeButtonPoints;
	public static Button startButton;
	public static Button soundToggleButton;
	public static Button optionsButton;
	public static Button backToMenuButton;
	public static Button infoButton;
	public static Button exitButton;
	public static Button restartButton;
	public static Button restartKey;
	public static Button scoreKey;
	
	public static void loadButtons() {
	gamemodeButtonTimed = new Button(100, 100, (256 * GraphicVariables.buttonScaleSize), 64 * GraphicVariables.buttonScaleSize);
	gamemodeButtonPoints = new Button(100, 300, (256 * GraphicVariables.buttonScaleSize), 64 * GraphicVariables.buttonScaleSize);
	startButton = new Button(100, 100, (256 * GraphicVariables.buttonScaleSize), 64 * GraphicVariables.buttonScaleSize);
	soundToggleButton = new Button(1250, 650, (64 * GraphicVariables.soundButtonScaleSize), 64 * GraphicVariables.soundButtonScaleSize);
	optionsButton = new Button(625, 650, (256 * GraphicVariables.soundButtonScaleSize), 64 * GraphicVariables.soundButtonScaleSize);
	backToMenuButton = new Button(625, 650, (256 * GraphicVariables.soundButtonScaleSize), 64 * GraphicVariables.soundButtonScaleSize);
	infoButton = new Button(305, 650, (256 * GraphicVariables.soundButtonScaleSize), 64 * GraphicVariables.soundButtonScaleSize);
	exitButton = new Button(930, 650, (256 * GraphicVariables.soundButtonScaleSize), 64 * GraphicVariables.soundButtonScaleSize);
	restartButton = new Button(305, 650, (256 * GraphicVariables.soundButtonScaleSize), 64 * GraphicVariables.soundButtonScaleSize);
	restartKey = new Button(100, 300, (256 * GraphicVariables.buttonScaleSize), 64 * GraphicVariables.buttonScaleSize);
	scoreKey = new Button(100, 100, (256 * GraphicVariables.buttonScaleSize), 64 * GraphicVariables.buttonScaleSize);
	}
}

