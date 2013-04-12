package keysmash.gamemode;

import keysmash.event.EventManager;
import keysmash.event.EventVariables;

import org.newdawn.slick.GameContainer;

public class GamemodePointsMania {
	public static void update(GameContainer gc, int delta) {
		System.out.println(EventVariables.scoreKey);
		  if(EventVariables.gameShouldStart  && EventVariables.startTimerHasFinished) {
			  EventVariables.startTimerHasFinished = false;
			  EventManager.setupGamemode(1);
		  }
		  if(!EventVariables.gameHasFinished && EventVariables.gameHasStarted) {
			 EventManager.updateTimeVariables(1);
		  }
		  
		  if(EventManager.checkInputs(gc, EventVariables.scoreKey) && EventVariables.timeLeft > 0 && EventVariables.gameHasStarted && !EventVariables.gameHasFinished) {
			  EventManager.incrementScore();
		  }
		  
		  if(EventVariables.timeLeft <= 0 && EventVariables.gameHasStarted && !EventVariables.gameHasFinished) {
			  EventManager.gameFinishedCleanup(1);
		  }
		  
	}
}
