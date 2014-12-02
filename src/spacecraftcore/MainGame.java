package spacecraftcore;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import displayConsole.Test;
import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Enemy.Slime;
import spacecraftelements.SpaceShip.Palelin;

/**
 * 考虑在主程序里加上各个Manager的全局变量
 * 
 */

public class MainGame {
	public static BattleFieldManager bm;
	public static Test test;

	public static void main(String[] args) {
		test = new Test();
		test.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Thread mt = new Thread(new SpaceTimmer());
		bm = new BattleFieldManager();
		bm.loadmap("ditu1.cmp");
//		bm.add(new BasicBullet(0, 0, 0, 0));
//		bm.add(new BasicBullet(0, 0, 1, 1));
		bm.add(new Palelin(0, 0, 100,100));
		//bm.add(new Slime(300,200));
		// mt.start();

		for (int j = 0; j < 20; j++) {
			bm.add(new BasicBullet((int) (Math.random() * 100) % 10,
					(int) (Math.random() * 100) % 10,
				(int) (Math.random() * 100) % 5,
					(int) (Math.random() * 100) % 5));
		}
		for (int j = 0; j < 20; j++) {
			bm.add(new BasicBullet((int) (Math.random() * 100) % 10,
					(int) (Math.random() * 100) % 10,
					-(int) (Math.random() * 100) % 5,
					(int) (Math.random() * 100) % 5));
		}
		for (int j = 0; j < 20; j++) {
			bm.add(new BasicBullet((int) (Math.random() * 100) % 10,
					(int) (Math.random() * 100) % 10,
					-(int) (Math.random() * 100) % 5,
					-(int) (Math.random() * 100) % 5));
	}
		for (int j = 0; j < 20; j++) {
			bm.add(new BasicBullet((int) (Math.random() * 100) % 10,
					(int) (Math.random() * 100) % 10,
					(int) (Math.random() * 100) % 5,
					-(int) (Math.random() * 100) % 5));
		}
		mt.start();
	}

}
