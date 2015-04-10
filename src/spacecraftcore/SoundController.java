package spacecraftcore;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class SoundController implements Runnable{
	private String loc;
	public SoundController(String path){
		this.loc = path;
	}
	
	public void run() {
		try {
			URL cbUrl;
			File fi = new File(loc);
			cbUrl = fi.toURI().toURL();
			AudioClip ac;
			ac = Applet.newAudioClip(cbUrl);
			ac.play();
			Thread.sleep(10000);
			ac.stop();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
