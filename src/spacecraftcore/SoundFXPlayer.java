package spacecraftcore;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Core class for sound FXs playing by SourceDataLine. <br/>
 * 
 * Referenced from https://www3.ntu.edu.sg/home/ehchua/programming/java/J8c_PlayingSound.html
 * 
 */
public class SoundFXPlayer {

	public SoundFXPlayer() {
	}

	/**
	 * Write relevant data to the mixer via sound data line.
	 * @param add
	 */
	public static void play(String add) {
		int BUFFER_SIZE = 128 * 1024; // 128 KB
		SourceDataLine soundLine = null;
		// Set up an audio input stream piped from the sound file.
		try {
			File soundFile = new File(add);
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(soundFile);
			AudioFormat audioFormat = audioInputStream.getFormat();
			DataLine.Info info = new DataLine.Info(SourceDataLine.class,
					audioFormat);
			soundLine = (SourceDataLine) AudioSystem.getLine(info);
			soundLine.open(audioFormat);
			soundLine.start();
			int nBytesRead = 0;
			byte[] sampledData = new byte[BUFFER_SIZE];
			while (nBytesRead != -1) {
				nBytesRead = audioInputStream.read(sampledData, 0,
						sampledData.length);
				if (nBytesRead >= 0) {
					// Writes audio data to the mixer via this source data line.
					soundLine.write(sampledData, 0, nBytesRead);
				}
			}
		} catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
		} finally {
			soundLine.drain();
			soundLine.close();
		}
	}

}
