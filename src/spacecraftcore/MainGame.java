package spacecraftcore;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import displayConsole.Gamewindow;
import spacecraftelements.Enemy.Slime;
import spacecraftelements.SpaceShip.Palelin;
import spacecraftevent.RandomSlime;

/**
 * ����������������ϸ���Manager��ȫ�ֱ���
 * 
 */

public class MainGame {
	public static BattleFieldManager bm;
	public static Gamewindow test;
	public static long gametime;

	public static void main(String[] args) {
		Thread mt = new Thread(new SpaceTimmer());
		Dimension srcDim = Toolkit.getDefaultToolkit().getScreenSize();   //��ȡ��Ļ�ֱ���
		bm = new BattleFieldManager(srcDim.width,srcDim.height);
		test=bm.loadmap("Data//scmaps//bigmap1600x1200.smp");
		test.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	
		bm.add(new Palelin(0,0,0,0));
		bm.add(new Slime(300,200));
		bm.add(new Slime(300,0));
		bm.add(new Slime(30,200));
		bm.add(new Slime(500,200));
		bm.add(new RandomSlime(1600,1200));
		mt.start();
	}

}
