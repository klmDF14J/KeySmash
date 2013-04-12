package keysmash.sound;

import keysmash.core.KeySmash;

import org.newdawn.slick.Sound;

public class SoundLoop {
	
	/**
	 * Loops A Sound For A Short Period Of Time
	 * @see keysmash.sound.SoundLoop#loopSoundConsistentlyMedium(Sound, long, boolean)
	 * @see keysmash.sound.SoundLoop#loopSoundConsistentlyLong(Sound, long, boolean)
	 */
	public static void loopSoundConsistentlyShort(Sound par1Sound, long timeBetweenPlays, boolean soundShouldBeLooped) {
		int amountOfTimesPlayed = 0;
		long startTime = KeySmash.app.getTime();
		long currentTime = 0;
		long timePassed = currentTime - startTime;
		while(soundShouldBeLooped) {
			currentTime = KeySmash.app.getTime();
			timePassed = currentTime - startTime;
			if(timePassed >= timeBetweenPlays) {
			par1Sound.play();
			timePassed = 0;
			startTime = KeySmash.app.getTime();
			amountOfTimesPlayed++;
			}
			if(amountOfTimesPlayed >= 10) {
				break;
			}
		}
	}
	/**
	 * Loops A Sound For A Medium Period Of Time
	 * @see keysmash.sound.SoundLoop#loopSoundConsistentlyShort(Sound, long, boolean)
	 * @see keysmash.sound.SoundLoop#loopSoundConsistentlyLong(Sound, long, boolean)
	 */
	public static void loopSoundConsistentlyMedium(Sound par1Sound, long timeBetweenPlays, boolean soundShouldBeLooped) {
		int amountOfTimesPlayed = 0;
		long startTime = KeySmash.app.getTime();
		long currentTime = 0;
		long timePassed = currentTime - startTime;
		while(soundShouldBeLooped) {
			currentTime = KeySmash.app.getTime();
			timePassed = currentTime - startTime;
			if(timePassed >= timeBetweenPlays) {
			par1Sound.play();
			timePassed = 0;
			startTime = KeySmash.app.getTime();
			amountOfTimesPlayed++;
			}
			if(amountOfTimesPlayed >= 30) {
				break;
			}
		}
	}
	/**
	 * Loops A Sound For A Long Period Of Time
	 * @see keysmash.sound.SoundLoop#loopSoundConsistentlyMedium(Sound, long, boolean)
	 * @see keysmash.sound.SoundLoop#loopSoundConsistentlyShort(Sound, long, boolean)
	 */
	public static void loopSoundConsistentlyLong(Sound par1Sound, long timeBetweenPlays, boolean soundShouldBeLooped) {
		int amountOfTimesPlayed = 0;
		long startTime = KeySmash.app.getTime();
		long currentTime = 0;
		long timePassed = currentTime - startTime;
		while(soundShouldBeLooped) {
			currentTime = KeySmash.app.getTime();
			timePassed = currentTime - startTime;
			if(timePassed >= timeBetweenPlays) {
			par1Sound.play();
			timePassed = 0;
			startTime = KeySmash.app.getTime();
			amountOfTimesPlayed++;
			}
			if(amountOfTimesPlayed >= 50) {
				break;
			}
		}
	}
	public static void loopSoundAmountOfTimes(Sound par1Sound, int amountOfTimesToPlay, long timeBetweenPlays, boolean soundShouldBeLooped) {
		int amountOfTimesPlayed = 0;
		long startTime = KeySmash.app.getTime();
		long currentTime = 0;
		long timePassed = currentTime - startTime;
		while(soundShouldBeLooped) {
			currentTime = KeySmash.app.getTime();
			timePassed = currentTime - startTime;
			if(amountOfTimesPlayed < amountOfTimesToPlay && timePassed >= timeBetweenPlays) {
				par1Sound.play();
				amountOfTimesPlayed++;
				timePassed = 0;
				startTime = KeySmash.app.getTime();
			}
			if(amountOfTimesPlayed >= amountOfTimesToPlay) {
				break;
			}
 		}
	}
}
