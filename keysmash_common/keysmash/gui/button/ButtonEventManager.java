package keysmash.gui.button;

import org.lwjgl.Sys;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

import keysmash.core.KeySmash;
import keysmash.event.*;
import keysmash.gui.GraphicVariables;
import keysmash.sound.*;

public class ButtonEventManager {
	public static void buttonClick(String par1ButtonID) {
		if(GraphicVariables.titleScreenHasBeenDisplayed) {
		if(par1ButtonID == "gamemodeTimed") { 
			SoundPlayer.playSound(SoundVariables.buttonClick);
			EventVariables.selectedGamemode = 0;
			GraphicVariables.gameModeButtonShouldBeDisplayed = false;
			GraphicVariables.timeShouldBeDisplayed = true;
			GraphicVariables.scoreShouldBeDisplayed = true;
			GraphicVariables.stopwatchShouldBeDisplayed = true;
			GraphicVariables.startButtonShouldBeDisplayed = true;
		}
		else if(par1ButtonID == "gamemodePoints") { 
			SoundPlayer.playSound(SoundVariables.buttonClick);
			EventVariables.selectedGamemode = 1;
			GraphicVariables.gameModeButtonShouldBeDisplayed = false;
			GraphicVariables.timeShouldBeDisplayed = true;
		    GraphicVariables.scoreShouldBeDisplayed = true;
			GraphicVariables.stopwatchShouldBeDisplayed = true;
			GraphicVariables.startButtonShouldBeDisplayed = true;
		}
		else if(par1ButtonID == "start") {
			EventVariables.gameShouldStart = true;
			GraphicVariables.startButtonShouldBeDisplayed = false;
		}
		else if(par1ButtonID == "soundOff") {
			EventVariables.soundEnabled = 1;
			GraphicVariables.soundButtonImageOff = true;
			GraphicVariables.soundButtonImageOn = false;
		}
		else if(par1ButtonID == "soundOn") {
			EventVariables.soundEnabled = 0;
			SoundPlayer.playSound(SoundVariables.buttonClick);
			GraphicVariables.soundButtonImageOn = true;
			GraphicVariables.soundButtonImageOff = false;
		}
		else if(par1ButtonID == "options") {
			SoundPlayer.playSound(SoundVariables.buttonClick);
			GraphicVariables.optionsMenuShouldBeDisplayed = true;
			GraphicVariables.startButtonShouldBeDisplayed = false;
			GraphicVariables.backToMenuButtonShouldBeDisplayed = true;
			GraphicVariables.gameModeButtonShouldBeDisplayed = false;
			GraphicVariables.stopwatchShouldBeDisplayed = false;
			GraphicVariables.scoreShouldBeDisplayed = false;
			GraphicVariables.timeShouldBeDisplayed = false;
		}
		else if(par1ButtonID == "backToMenu") {
			SoundPlayer.playSound(SoundVariables.buttonClick);
			GraphicVariables.optionsMenuShouldBeDisplayed = false;
			GraphicVariables.startButtonShouldBeDisplayed = false;
			GraphicVariables.backToMenuButtonShouldBeDisplayed = false;
			GraphicVariables.gameModeButtonShouldBeDisplayed = true;
			EventVariables.currentKeyBindBeingChanged = "";
		}
		else if(par1ButtonID == "info") {
			SoundPlayer.playSound(SoundVariables.buttonClick);
			Sys.openURL("https://sites.google.com/a/mandell.org/key-smash2/");
		}
		else if(par1ButtonID == "exit") {
			KeySmash.app.exit();
		}
		else if(par1ButtonID == "restart") {
			SoundPlayer.playSound(SoundVariables.buttonClick);
			EventManager.restartGame();
		}
		else if(par1ButtonID == "scoreKeyBinder") {
			SoundPlayer.playSound(SoundVariables.buttonClick);
			EventVariables.currentKeyBindBeingChanged = "scoreKey";
			EventVariables.listeningForMouse = true;
		}
		}
	}
	
	public static void checkForClickedButton(int x, int y) {
		  GraphicVariables.cursor = new Rectangle(x, y, 10, 10);
		  if(GraphicVariables.cursor.intersects(ButtonList.gamemodeButtonTimed.getBounds()) && GraphicVariables.gameModeButtonShouldBeDisplayed) {
			 ButtonEventManager.buttonClick("gamemodeTimed");
		  }
		  else if(GraphicVariables.cursor.intersects(ButtonList.gamemodeButtonPoints.getBounds()) && GraphicVariables.gameModeButtonShouldBeDisplayed) {
			 ButtonEventManager.buttonClick("gamemodePoints");
		  }
		  else if(GraphicVariables.cursor.intersects(ButtonList.startButton.getBounds()) && !EventVariables.gameHasStarted && GraphicVariables.startButtonShouldBeDisplayed) {
			 ButtonEventManager.buttonClick("start");
		  }
		  else if(GraphicVariables.cursor.intersects(ButtonList.soundToggleButton.getBounds()) && EventVariables.soundEnabled == 0) {
			 ButtonEventManager.buttonClick("soundOff");
		  }
		  else if(GraphicVariables.cursor.intersects(ButtonList.soundToggleButton.getBounds()) && EventVariables.soundEnabled == 1) {
			 ButtonEventManager.buttonClick("soundOn");
		  }
		  else if(GraphicVariables.cursor.intersects(ButtonList.optionsButton.getBounds()) && !EventVariables.gameHasStarted && !GraphicVariables.optionsMenuShouldBeDisplayed && !EventVariables.gameShouldStart) {
			 ButtonEventManager.buttonClick("options");
		  } 
		  else if(GraphicVariables.cursor.intersects(ButtonList.backToMenuButton.getBounds()) && GraphicVariables.optionsMenuShouldBeDisplayed) {
			 ButtonEventManager.buttonClick("backToMenu");
		  }
		  else if(GraphicVariables.cursor.intersects(ButtonList.infoButton.getBounds()) && GraphicVariables.optionsMenuShouldBeDisplayed) {
			 ButtonEventManager.buttonClick("info");
		  }
		  else if(GraphicVariables.cursor.intersects(ButtonList.exitButton.getBounds())) {
			  ButtonEventManager.buttonClick("exit");
		  }
		  else if(GraphicVariables.cursor.intersects(ButtonList.restartButton.getBounds()) && GraphicVariables.restartButtonShouldBeDisplayed) {
			  ButtonEventManager.buttonClick("restart");
		  }
		  else if(GraphicVariables.cursor.intersects(ButtonList.scoreKey.getBounds()) && GraphicVariables.optionsMenuShouldBeDisplayed) {
			  ButtonEventManager.buttonClick("scoreKeyBinder");
		  }
 	}
}
