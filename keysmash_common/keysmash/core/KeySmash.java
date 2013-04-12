package keysmash.core;

import keysmash.event.EventManager;
import keysmash.gamemode.GeneralUpdateChecks;
import keysmash.gui.GraphicEventManager;
import keysmash.gui.button.ButtonEventManager;
import org.newdawn.slick.*;
public class KeySmash extends BasicGame implements MouseListener
{
 public static AppGameContainer app;
  /**
   * @author Kyle Mandell
   */
  public KeySmash() { super("Key Smash"); }
  @Override
  public void init(GameContainer gc) throws SlickException {  EventManager.loadGame(); }
  @Override
  public void mouseClicked(int button, int x, int y, int clickCount) { ButtonEventManager.checkForClickedButton(x, y); }
  @Override
  public void update(GameContainer gc, int delta) throws SlickException { GeneralUpdateChecks.gameUpdate(gc, delta); }
  @Override
  public void render(GameContainer gc, Graphics g) throws SlickException { GraphicEventManager.renderGraphicElements(gc, g); }
  public static void main(String[] args) throws SlickException { EventManager.keySmashSetup(args); }
  public void keyPressed(int key, char c) { EventManager.checkForKeyInteractions(key, c); }
  public void mousePressed(int button, int x, int y) { EventManager.checkForMouseInteractions(button, x, y); }
  public void controllerButtonPressed(int controller, int button) { 
	  EventManager.checkForControllerInteractions(controller, button); 
	  EventManager.controllerScoreEvent(controller, button);
  }
 }