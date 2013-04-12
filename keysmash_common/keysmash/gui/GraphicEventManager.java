
package keysmash.gui;

import keysmash.core.KeySmash;
import keysmash.core.TitleScreen;
import keysmash.event.EventVariables;
import keysmash.gui.button.ButtonList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class GraphicEventManager {
	public static void renderGraphicElements(GameContainer gc, Graphics g) {
		  // Screen Width = 1366
		  // Screen Height = 768  
		  KeySmash.app.setClearEachFrame(true);
		 
		  int xOffset = 50;
		  int yOffset = 50;
		  if(!GraphicVariables.titleScreenHasBeenDisplayed) {
			  GraphicVariables.loadBackground.draw(0,0);
			  GraphicVariables.progressBar.draw(427,520, 5F);
			  GraphicVariables.logoImage.draw(555, 256);
			  g.drawString(GraphicVariables.progressBarString, 600, 560);
		  }
		  if(GraphicVariables.titleScreenHasBeenDisplayed && EventVariables.allLoaded) {
			  GraphicVariables.background.draw(0,0);
			  GraphicVariables.soundToggleButtonImage.draw(ButtonList.soundToggleButton.getStartX(),ButtonList.soundToggleButton.getStartY(), GraphicVariables.soundButtonScaleSize);
		  if(!GraphicVariables.optionsMenuShouldBeDisplayed) {
			  GraphicVariables.optionsButtonImage.draw(ButtonList.optionsButton.getStartX(),ButtonList.optionsButton.getStartY(), GraphicVariables.soundButtonScaleSize);
		  }
		  if(GraphicVariables.gameModeButtonShouldBeDisplayed) {
			  g.drawString("Choose A Mode: ", 850, 400);
			  GraphicVariables.gamemodeButtonImageTimed.draw(ButtonList.gamemodeButtonTimed.getStartX(), ButtonList.gamemodeButtonTimed.getStartY(), GraphicVariables.buttonScaleSize);  
			  GraphicVariables.gamemodeButtonImagePoints.draw(ButtonList.gamemodeButtonPoints.getStartX(), ButtonList.gamemodeButtonPoints.getStartY(), GraphicVariables.buttonScaleSize); 
		  }
		  
		  if(GraphicVariables.stopwatchShouldBeDisplayed) {
			  GraphicVariables.stopwatch.draw(25,25, 2F);
		  }
		  if(GraphicVariables.startButtonShouldBeDisplayed) {
			  GraphicVariables.startButtonImage.draw(ButtonList.startButton.getStartX(), ButtonList.startButton.getStartY(), GraphicVariables.buttonScaleSize);
		  }
		 g.setColor(Color.white);
		 if(GraphicVariables.scoreShouldBeDisplayed) {
	     g.drawString(EventVariables.buttonString + EventVariables.score, KeySmash.app.getWidth() / 2 - xOffset, KeySmash.app.getHeight() / 2 - yOffset);
		 }
	     g.setColor(Color.black);
	     if(GraphicVariables.timeShouldBeDisplayed) {
	     g.drawString("Time: " + EventVariables.timeToDisplay, 70, 80);
	     }
	     if(GraphicVariables.optionsMenuShouldBeDisplayed) {
	    	 GraphicVariables.backToMenuButtonImage.draw(ButtonList.backToMenuButton.getStartX(), ButtonList.backToMenuButton.getStartY(), GraphicVariables.soundButtonScaleSize);
	    	 GraphicVariables.infoButtonImage.draw(ButtonList.infoButton.getStartX(), ButtonList.infoButton.getStartY(), GraphicVariables.soundButtonScaleSize);
	    	 GraphicVariables.scoreKeyButtonImage.draw(ButtonList.scoreKey.getStartX(), ButtonList.scoreKey.getStartY(), GraphicVariables.buttonScaleSize);
	    	 
	     }
	     GraphicVariables.exitButtonImage.draw(ButtonList.exitButton.getStartX(), ButtonList.exitButton.getStartY(), GraphicVariables.soundButtonScaleSize);
	     if(EventVariables.gameHasFinished && GraphicVariables.restartButtonShouldBeDisplayed) {
	    	 GraphicVariables.restartButtonImage.draw(ButtonList.restartButton.getStartX(), ButtonList.restartButton.getStartY(), GraphicVariables.soundButtonScaleSize);
	     }
		  }
	}
}
