package keysmash.core;

import keysmash.gui.GraphicVariables;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class TitleScreen {
	public static long timePassed;
	public static long startTime;
	public static void displayTitleScreen(GameContainer gc, Graphics g) {
		if(!GraphicVariables.titleScreenMethodCalled) {
		startTime = KeySmash.app.getTime();
		}
		long currentTime = 0;
		
			timePassed = currentTime - startTime;
			GraphicVariables.titleScreenMethodCalled = true;
			currentTime = KeySmash.app.getTime();
			timePassed = currentTime - startTime;
			if(timePassed >= 3000) {
			timePassed = 0;
			GraphicVariables.titleScreenHasBeenDisplayed = true;
			}
			
	}
}
