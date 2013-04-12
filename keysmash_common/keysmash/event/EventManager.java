package keysmash.event;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.ControllerListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import keysmash.core.KeySmash;
import keysmash.core.TitleScreen;
import keysmash.gui.GraphicEventManager;
import keysmash.gui.GraphicVariables;
import keysmash.gui.button.ButtonList;
import keysmash.loaders.ImageLoader;
import keysmash.loaders.SoundLoader;
import keysmash.sound.SoundPlayer;
import keysmash.sound.SoundVariables;

public class EventManager {
	
		public static void gameFinishedCleanup(int par1GamemodeID) {
			if(par1GamemodeID == 0) {
				EventVariables.gameHasFinished = true;
				EventVariables.currentTimeTaken = 0;
				EventVariables.finishTime = KeySmash.app.getTime();
				EventVariables.totalTimeTaken = EventVariables.finishTime - EventVariables.startTime;
				EventVariables.timeToDisplay = EventVariables.totalTimeTaken;
				GraphicVariables.restartButtonShouldBeDisplayed = true;
			}
			else if(par1GamemodeID == 1) {
				EventVariables.gameHasFinished = true;
				EventVariables.currentTimeTaken = 0;
				EventVariables.timeLeft = 0;
				if(EventVariables.timeToDisplay < 0) {
					EventVariables.timeToDisplay = 0;
				}
				GraphicVariables.restartButtonShouldBeDisplayed = true;
			}
			else {
				System.out.println("Invalid Gamemode! Nothing happening!");
			}
		}
		
		public static void restartGame() {
			if(EventVariables.gameHasFinished) {
				  GraphicVariables.restartButtonShouldBeDisplayed = false;
				  GraphicVariables.buttonPanelShouldBeDisplayed = true;
				  GraphicVariables.gameModeButtonShouldBeDisplayed = true;
				  EventVariables.gameHasStarted = false;
				  GraphicVariables.stopwatchShouldBeDisplayed = false;
				  GraphicVariables.scoreShouldBeDisplayed = false;
				  GraphicVariables.timeShouldBeDisplayed = false;
				  GraphicVariables.startButtonShouldBeDisplayed = false;
				  EventVariables.score = 0;
				  EventVariables.timeToDisplay = 0;
			  }
		}
		
		public static void incrementScore() {
			EventVariables.score++;
			  EventVariables.bangPlayCount++;
			  if(EventVariables.bangPlayCount >= 10) {
				  if(EventVariables.soundEnabled == 0) {
					  SoundVariables.bang.play();
				  }
				  EventVariables.bangPlayCount = 0;
			  }
		}
		
		public static void updateTimeVariables(int par1GamemodeID) {
			if(par1GamemodeID == 0) {
			 EventVariables.currentTimeTaken = KeySmash.app.getTime() - EventVariables.startTime;
			 EventVariables.timeToDisplay = EventVariables.currentTimeTaken;
			}
			if(par1GamemodeID == 1) {
			 EventVariables.currentTimeTaken = KeySmash.app.getTime() - EventVariables.startTime;
			 EventVariables.timeLeft = EventVariables.objectiveTime - EventVariables.currentTimeTaken;
			 EventVariables.timeToDisplay = EventVariables.timeLeft;
			}
		}
		
		public static void setupGamemode(int par1GamemodeID) {
			if(par1GamemodeID == 0) {
				GraphicVariables.buttonPanelShouldBeDisplayed = false;
				EventVariables.gameShouldStart = false;
				GraphicVariables.stopwatchShouldBeDisplayed = true;
				GraphicVariables.timeShouldBeDisplayed = true;
				GraphicVariables.scoreShouldBeDisplayed = true;
				EventVariables.gameHasStarted = true;
				EventVariables.gameHasFinished = false;
				EventVariables.currentTimeTaken = 0;
				EventVariables.timeToDisplay = EventVariables.currentTimeTaken;
				EventVariables.totalTimeTaken = 0;
				EventVariables.finishTime = 0;
				EventVariables.startTime = 0;
				EventVariables.score = 0;
				EventVariables.startTime = KeySmash.app.getTime();
			}
			if(par1GamemodeID == 1) {
				GraphicVariables.buttonPanelShouldBeDisplayed = false;
				EventVariables.gameShouldStart = false;
				GraphicVariables.stopwatchShouldBeDisplayed = true;
				GraphicVariables.timeShouldBeDisplayed = true;
				GraphicVariables.scoreShouldBeDisplayed = true;
				EventVariables.startTime = KeySmash.app.getTime();
				EventVariables.gameHasStarted = true;
				EventVariables.gameHasFinished = false;
				EventVariables.currentTimeTaken = 0;
				EventVariables.timeLeft = EventVariables.objectiveTime - EventVariables.currentTimeTaken;
				EventVariables.timeToDisplay = EventVariables.timeLeft;
			}
		}
		public static void soundToggleEvent(String par1State) throws SlickException {
			if(par1State == "on") {
				GraphicVariables.soundButtonImageOff = false;
				GraphicVariables.soundButtonImageOn = false;
				GraphicVariables.soundToggleButtonImage = new Image("/resources/images/SoundEnabled.png");
			}
			
			else if(par1State == "off") {
				GraphicVariables.soundButtonImageOff = false;
			    GraphicVariables.soundButtonImageOn = false;
				GraphicVariables.soundToggleButtonImage = new Image("/resources/images/SoundDisabled.png");
			}
			else {
				System.out.println("Invalid State! Nothing happening!");
			}
			
		}
public static void wait3Seconds() throws SlickException  {
			
			if(!EventVariables.timerMethodCalled) {
			EventVariables.startTimeForLoad = KeySmash.app.getTime();
			}
			long currentTime = 0;
				EventVariables.timePassedForLoad = currentTime - EventVariables.startTimeForLoad;
				EventVariables.timerMethodCalled = true;
				currentTime = KeySmash.app.getTime();
				EventVariables.timePassedForLoad = currentTime - EventVariables.startTimeForLoad;
				if(EventVariables.timePassedForLoad >= 0 && EventVariables.amountOfTimesRun == 0) {
					EventVariables.amountOfTimesRun++;
					GraphicVariables.progressBar = new Image("/resources/images/LoadBarEmpty.png");
					GraphicVariables.progressBarString = "Loading Game";
				}
				else if(EventVariables.timePassedForLoad >= 500 && EventVariables.amountOfTimesRun == 1) {
					EventVariables.amountOfTimesRun++;
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar1.png");
					GraphicVariables.progressBarString = "Loading Keybinds";
				}
				else if(EventVariables.timePassedForLoad >= 1000 && EventVariables.amountOfTimesRun == 2) {
					EventVariables.amountOfTimesRun++;
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar2.png");
					GraphicVariables.progressBarString = "Loading Images";
				}
				else if(EventVariables.timePassedForLoad >= 1500 && EventVariables.amountOfTimesRun == 3) {
					EventVariables.amountOfTimesRun++;
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar3.png");
					GraphicVariables.progressBarString = "Loading Sounds";
				}
				else if(EventVariables.timePassedForLoad >= 2000 && EventVariables.amountOfTimesRun == 4) {
					EventVariables.amountOfTimesRun++;
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar4.png");
					GraphicVariables.progressBarString = "Loading Buttons";
				}
				else if(EventVariables.timePassedForLoad >= 2500 && EventVariables.amountOfTimesRun == 5) {
					EventVariables.amountOfTimesRun++;
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar5.png");
					GraphicVariables.progressBarString = "Everything Loaded";
				}
				else if(EventVariables.timePassedForLoad >= 3000 && EventVariables.amountOfTimesRun == 6) {
					EventVariables.timePassedForLoad = 0;
					EventVariables.startTimeForLoad = 0;
					EventVariables.amountOfTimesRun = 0;
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar5.png");
					GraphicVariables.progressBarString = "Everything Loaded";
					EventVariables.timerMethodCalled = false;
				}
	}

		
		public static void keySmashSetup(String[] args) throws SlickException {
			String[] arguements = new String[5];
			if(args.length >= 1) {
				EventVariables.arguements[0] = args[0].toString();
			}
			if(args.length < 1) {
				EventVariables.arguements[0] = "Default Player";
			}
			System.out.println("Value Of Arguements[0]: " + EventVariables.arguements[0]);
			 KeySmash.app = new AppGameContainer(new KeySmash()); 
			 KeySmash.app.setDisplayMode(1366, 768, false);
			//KeySmash.app.setTargetFrameRate(100);
			 KeySmash.app.start();
		}
		
		public static void loadKeybinds() {
			EventVariables.scoreKey = Input.KEY_ENTER;
			EventVariables.restartKey = Input.KEY_R;
	}
		public static void loadGame() throws SlickException {
			loadPart();
		}
		
		public static void loadingBar(String par1PartLoaded) {
			if(par1PartLoaded == "keybinds") {
				GraphicVariables.progressBarString = "Loading Keybinds";
				EventVariables.keybindsLoaded = true;
				try {
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar1.png");
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(par1PartLoaded == "images") {
				GraphicVariables.progressBarString = "Loading Images";
				EventVariables.imagesLoaded = true;
				try {
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar2.png");
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(par1PartLoaded == "sounds") {
				GraphicVariables.progressBarString = "Loading Sounds";
				EventVariables.soundsLoaded = true;
				try {
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar3.png");
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(par1PartLoaded == "buttons") {
				GraphicVariables.progressBarString = "Loading Buttons";
				EventVariables.buttonsLoaded = true;
				try {
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar4.png");
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(par1PartLoaded == "all") {
				GraphicVariables.progressBarString = "Everything Loaded";
				EventVariables.allLoaded = true;
				try {
					GraphicVariables.progressBar = new Image("/resources/images/LoadBar5.png");
				} catch (SlickException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public static void loadPart() throws SlickException {
				EventManager.loadKeybinds();
				EventManager.loadingBar("keybinds");
				ImageLoader.loadImages();
				EventManager.loadingBar("images");
				SoundLoader.loadSounds();
			 	EventManager.loadingBar("sounds");
			 	ButtonList.loadButtons();
			 	EventManager.loadingBar("buttons");
			 	EventManager.loadingBar("all");
			
		}
		public static void checkForKeyInteractions(int key, char c) {
			if(GraphicVariables.optionsMenuShouldBeDisplayed) {
				  if(EventVariables.currentKeyBindBeingChanged == "restartKey" && EventVariables.listeningForMouse) {
					  EventVariables.restartKey = key;
					  EventVariables.currentInputType = "key";
					  System.out.println(key);
					  System.out.println(EventVariables.currentInputType);
					  System.out.println(EventVariables.restartKey);
					  EventVariables.listeningForMouse = false;
				  }
				  else if(EventVariables.currentKeyBindBeingChanged == "scoreKey" && EventVariables.listeningForMouse) {
					  EventVariables.scoreKey = key;
					  EventVariables.currentInputType = "key";
					  System.out.println(key);
					  System.out.println(EventVariables.currentInputType);
					  System.out.println(EventVariables.scoreKey);
					  EventVariables.listeningForMouse = false;
				  }
			  }
		}
		
		public static void checkForMouseInteractions(int button, int x, int y) {
			if(GraphicVariables.optionsMenuShouldBeDisplayed) {
				  if(EventVariables.currentKeyBindBeingChanged == "restartKey" && EventVariables.listeningForMouse) {
					  EventVariables.restartKey = button;
					  EventVariables.currentInputType = "mouse";
					  System.out.println(button);
					  System.out.println(EventVariables.currentInputType);
					  System.out.println(EventVariables.restartKey);
					  EventVariables.listeningForMouse = false;
				  }
				  else if(EventVariables.currentKeyBindBeingChanged == "scoreKey" && EventVariables.listeningForMouse) {
					  EventVariables.scoreKey = button;
					  EventVariables.currentInputType = "mouse";
					  System.out.println(button);
					  System.out.println(EventVariables.currentInputType);
					  System.out.println(EventVariables.scoreKey);
					  EventVariables.listeningForMouse = false;
				  }
			  }
		}
		
		public static void checkForControllerInteractions(int controller, int button) {
			if(GraphicVariables.optionsMenuShouldBeDisplayed) {
				  if(EventVariables.currentKeyBindBeingChanged == "restartKey" && EventVariables.listeningForMouse) {
					  EventVariables.restartKey = button;
					  EventVariables.currentInputType = "controller";
					  System.out.println(button);
					  System.out.println(EventVariables.currentInputType);
					  System.out.println(EventVariables.restartKey);
					  EventVariables.listeningForMouse = false;
				  }
				  else if(EventVariables.currentKeyBindBeingChanged == "scoreKey" && EventVariables.listeningForMouse) {
					  EventVariables.controllerInUse = controller;
					  EventVariables.scoreKey = button;
					  EventVariables.currentInputType = "controller";
					  System.out.println(button);
					  System.out.println(EventVariables.currentInputType);
					  System.out.println(EventVariables.scoreKey);
					  EventVariables.listeningForMouse = false;
				  }
			  }
		}

		public static void countdownToGameStart() throws SlickException  {
			
			if(!EventVariables.timerMethodCalled) {
			EventVariables.startTimeForCountdown = KeySmash.app.getTime();
			}
			long currentTime = 0;
			
				EventVariables.timePassedForCountdown = currentTime - EventVariables.startTimeForCountdown;
				EventVariables.timerMethodCalled = true;
				currentTime = KeySmash.app.getTime();
				EventVariables.timePassedForCountdown = currentTime - EventVariables.startTimeForCountdown;
				if(EventVariables.timePassedForCountdown == 0 && EventVariables.amountOfTimesRunForCountdown == 0) {
					EventVariables.amountOfTimesRunForCountdown++;
					SoundPlayer.playSound(SoundVariables.countdown);
				}
				else if(EventVariables.timePassedForCountdown >= 1000 && EventVariables.amountOfTimesRunForCountdown == 1) {
					EventVariables.amountOfTimesRunForCountdown++;
					SoundPlayer.playSound(SoundVariables.countdown);
				}
				else if(EventVariables.timePassedForCountdown >= 2000 && EventVariables.amountOfTimesRunForCountdown == 2) {
					EventVariables.amountOfTimesRunForCountdown++;
					SoundPlayer.playSound(SoundVariables.countdown);
				}
				else if(EventVariables.timePassedForCountdown >= 3000 && EventVariables.amountOfTimesRunForCountdown == 3) {
					EventVariables.timePassedForCountdown = 0;
					EventVariables.startTimeForCountdown = 0;
					EventVariables.amountOfTimesRunForCountdown = 0;
					EventVariables.startTimerHasFinished = true;
					EventVariables.timerMethodCalled = false;
					SoundPlayer.playSound(SoundVariables.countdown2);
				}
	}
		
		public static String getAuthorName() {
			return "Kyle Mandell";
		}
		
		public static boolean checkInputs(GameContainer gc, int input) {
			if(EventVariables.currentInputType == "key") {
				if(gc.getInput().isKeyPressed(input)) {
					return true;
				}
			}
			else if(EventVariables.currentInputType == "mouse") {
				if(gc.getInput().isMousePressed(input)) {
					return true;
				}
			}
			else if(EventVariables.currentInputType == "controller") {
				if(gc.getInput().isControlPressed(3)) {
					System.out.println("controller button 3 pressed");
					return true;
				}
			}
			return false;
			
		}

		public static void controllerScoreEvent(int controller, int button) {
			if(EventVariables.gameHasStarted && EventVariables.scoreKey == button && !EventVariables.gameHasFinished) {
				EventManager.incrementScore();
			}
			
		}

		
}