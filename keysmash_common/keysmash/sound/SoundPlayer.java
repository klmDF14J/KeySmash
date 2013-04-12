package keysmash.sound;

import keysmash.event.EventVariables;

import org.newdawn.slick.Sound;

public class SoundPlayer {
	public static void playSound(Sound par1Sound) {
		if(EventVariables.soundEnabled == 0) {
		par1Sound.play();
		}
	}
	
	public static void playSoundWithPitchAndVolume(Sound par1Sound, float par2Pitch, float par3Volume) { 
		if(EventVariables.soundEnabled == 0) {
			par1Sound.play(par2Pitch, par3Volume);
		}
	}
}
