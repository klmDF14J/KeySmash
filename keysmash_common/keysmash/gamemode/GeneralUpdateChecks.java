package keysmash.gamemode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.SlickException;

import keysmash.core.KeySmash;
import keysmash.core.TitleScreen;
import keysmash.event.EventManager;
import keysmash.event.EventVariables;
import keysmash.gui.GraphicVariables;

public class GeneralUpdateChecks {
	public static void update(GameContainer gc, int delta) throws SlickException {	
  
	  if(GraphicVariables.soundButtonImageOn && !GraphicVariables.soundButtonImageOff) {
		  EventManager.soundToggleEvent("on");
	  }
	  else if(GraphicVariables.soundButtonImageOff && !GraphicVariables.soundButtonImageOn) {
		  EventManager.soundToggleEvent("off");
	  }
	  if(GraphicVariables.titleScreenHasBeenDisplayed) {
		  
	  }
	  if(!GraphicVariables.titleScreenHasBeenDisplayed) {
		  if(TitleScreen.timePassed < 3000) {
			  TitleScreen.displayTitleScreen(gc, (new Graphics()));
			  
		  }
		  if(EventVariables.timePassedForLoad < 3000) {
			  EventManager.wait3Seconds();
		  }
		  }
	  if(EventVariables.timePassedForCountdown < 3000 && GraphicVariables.titleScreenHasBeenDisplayed && EventVariables.gameShouldStart) {
		  EventManager.countdownToGameStart();
	  }
	 
	}
	
	
	public static void gameUpdate(GameContainer gc, int delta) throws SlickException {
		GeneralUpdateChecks.update(gc, delta);
		  if(EventVariables.selectedGamemode == 0) {
			  GamemodeTimedTarget.update(gc, delta);
		  }
		  
		  if(EventVariables.selectedGamemode == 1) {
			  GamemodePointsMania.update(gc, delta);
		  }
	}
}
