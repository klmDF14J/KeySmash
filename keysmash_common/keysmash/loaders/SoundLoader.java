package keysmash.loaders;

import keysmash.sound.SoundVariables;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class SoundLoader {
	public static void loadSounds() throws SlickException {
		SoundVariables.buttonClick = new Sound("/resources/sounds/ButtonClick2.wav");
		SoundVariables.bang = new Sound("/resources/sounds/Bang.wav");
		SoundVariables.countdown = new Sound("/resources/sounds/Countdown.wav");
		SoundVariables.countdown2 = new Sound("/resources/sounds/Countdown2.wav");
	}
}
