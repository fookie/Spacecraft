package spacecraftcore;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class SpaceTimmer implements Runnable {
	/**
	 * Game thread
	 */
	private static final int sleeping_time = 19;
	
	
	// static int threadnum;
	// public static int threadcount;
	@Override
	public void run() {
		while (true) {
			
			
			if (MainGame.gamestatus == 1) {
				if (MainGame.bm.paused != true) {
					MainGame.bm.update();
				}
				try {
					Thread.sleep(sleeping_time);
					MainGame.gametime = MainGame.gametime + 1;

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (MainGame.gamestatus == 0) {
				MainGame.mainmenu.update();
				try {
					Thread.sleep(sleeping_time);
					MainGame.gametime = MainGame.gametime + 1;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else if (MainGame.gamestatus == 2) {
				BattleFieldLoader.loadBattleField();
				try {
					Thread.sleep(sleeping_time);
					MainGame.gametime = MainGame.gametime + 1;

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// if(MainGame.gametime % 200 == 0){
			// threadcount = (Thread.getAllStackTraces()).size() - threadnum;}
		}
	}
	
	
}
