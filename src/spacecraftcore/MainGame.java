package spacecraftcore;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import displayConsole.Test;
import spacecraftelements.Bullets.BasicBullet;

/**
 * ����������������ϸ���Manager��ȫ�ֱ���
 * 
 */

public class MainGame {
	public static BattleFieldManager bm;
	public static Test test;
	public static void main(String[] args) {
		Thread mt=new Thread(new SpaceTimmer());
		BattleFieldManager bfm=new BattleFieldManager();
		bfm.loadmap("ditu1.cmp");
		bfm.add(new BasicBullet(300,0,50,2));
		test = new Test();
		   test.addWindowListener(new WindowAdapter(){
			   public void windowClosing(WindowEvent e){
				   System.exit(0);
			   }
		   });
	}
	
}
