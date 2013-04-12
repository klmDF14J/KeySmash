package keysmash.event;

public class EventVariables {
	public static boolean gameHasFinished = false;
	public static boolean gameHasStarted = false;
	public static boolean gameShouldStart = false;

	public boolean restartNeeded = false;
	public static boolean keybindsLoaded;
	public static boolean imagesLoaded;
	public static boolean soundsLoaded;
	public static boolean buttonsLoaded;
	public static boolean allLoaded;
	
	public static long currentTimeTaken;
	public static long finishTime;
	public static long totalTimeTaken;
	public static long startTime;
	public static long timeToDisplay;
	public static long timeLeft;
	public static long objectiveTime = 12000;
	
	public static int scoreKey;
	public static int restartKey;
	public static int selectedGamemode = 0;
	public static int score;
	public static int objectiveScore = 20;
	public static int soundEnabled = 0;
	public static int bangPlayCount;
	
	
	 public static String buttonString = "Score: ";
	 public static String[] arguements = new String[5];
	public static long amountOfTimesRun;
	public static long timePassedForLoad = 0;
	public static boolean timerMethodCalled;
	public static long startTimeForLoad;
	public static String currentKeyBindBeingChanged;
	public static boolean startTimerHasFinished = false;
	public static long startTimeForCountdown;
	public static long timePassedForCountdown;
	public static int amountOfTimesRunForCountdown;
	public static String currentInputType = "key";
	public static boolean listeningForMouse = false;
	public static int controllerInUse = 0;
	
}
