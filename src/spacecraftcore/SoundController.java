package spacecraftcore;

/**
 * Play sound effects for the game
 * @author Paulay
 *
 */
public class SoundController implements Runnable{
	private String loc;
	public SoundController(String path){
		this.loc = path;
	}
	
	public void run() {
		SoundFXPlayer.play(loc);
	}

}
