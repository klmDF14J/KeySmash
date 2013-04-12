package keysmash.loaders;

import keysmash.gui.GraphicVariables;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ImageLoader {
	public static void loadImages() throws SlickException {
		
			GraphicVariables.background = new Image("/resources/images/Background.png");
			GraphicVariables.stopwatch = new Image("/resources/images/Stopwatch.png");
			GraphicVariables.gamemodeButtonImageTimed = new Image("/resources/images/GamemodeButtonTimed.png");
			GraphicVariables.gamemodeButtonImagePoints = new Image("/resources/images/GamemodeButtonPoints.png");
			GraphicVariables.startButtonImage = new Image("/resources/images/StartButton.png");
			GraphicVariables.soundToggleButtonImage = new Image("/resources/images/SoundEnabled.png");
			GraphicVariables.optionsButtonImage = new Image("/resources/images/OptionsButton.png");
			GraphicVariables.backToMenuButtonImage = new Image("/resources/images/MenuButton.png");
			GraphicVariables.infoButtonImage = new Image("/resources/images/Button.png");
			GraphicVariables.exitButtonImage = new Image("/resources/images/ExitButton.png");
			GraphicVariables.restartButtonImage = new Image("/resources/images/RestartButton.png");
			GraphicVariables.logoImage = new Image("/resources/images/Logo.png");
			GraphicVariables.progressBar = new Image("/resources/images/LoadBarEmpty.png");
			GraphicVariables.loadBackground = new Image("/resources/images/LoadBackground.png");
			GraphicVariables.restartKeyButtonImage = new Image("/resources/images/RestartKeyButton.png");
			GraphicVariables.scoreKeyButtonImage = new Image("/resources/images/ScoreKeyButton.png");
	}
}
