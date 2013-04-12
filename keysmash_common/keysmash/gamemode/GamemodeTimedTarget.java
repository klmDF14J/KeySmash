package keysmash.gamemode;

import org.newdawn.slick.GameContainer;

import keysmash.event.EventManager;
import keysmash.event.EventVariables;

public class GamemodeTimedTarget {
	public static void update(GameContainer gc, int delta) {
		  if(EventVariables.gameShouldStart && EventVariables.startTimerHasFinished) {
			  EventVariables.startTimerHasFinished = false;
			  EventManager.setupGamemode(0);
		  }
	  
		  if(!EventVariables.gameHasFinished && EventVariables.gameHasStarted) {
			 EventManager.updateTimeVariables(0);
		  }
	  
		  if (EventManager.checkInputs(gc, EventVariables.scoreKey) && EventVariables.score < EventVariables.objectiveScore && EventVariables.gameHasStarted && !EventVariables.gameHasFinished) {
			  EventManager.incrementScore();
		  }
	  
		  if(EventVariables.score >= EventVariables.objectiveScore && !EventVariables.gameHasFinished && EventVariables.gameHasStarted) {
			  EventManager.gameFinishedCleanup(0);
		  }
	}
}
