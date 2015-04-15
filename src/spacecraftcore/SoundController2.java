package spacecraftcore;

/**
 * Play sound effects for the game
 * @author Paulay
 *
 */
public class SoundController2 implements Runnable{
	private String loc;
	public SoundController2(String path){
		this.loc = path;
	}
	
	public void run() {
		SoundFXPlayer.play(loc);
	}

}
