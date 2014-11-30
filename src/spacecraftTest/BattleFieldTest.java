package spacecraftTest;

import spacecraftcore.BattleFieldManager;
import spacecraftelements.Bullets.BasicBullet;

/**
 * ����BattleFieldManager��ع���
 * @author Hale
 *
 */
public class BattleFieldTest {
	public static BattleFieldManager bfm;
	public static void main(String[] args)
	{
		BattleFieldManager bfm=new BattleFieldManager();
		bfm.loadmap("ditu1.cmp");
		for(int j=0;j<300;j++){
		bfm.add(new BasicBullet( (int) (Math.random() * 100) % 10,(int) (Math.random() * 100) % 10,(int) (Math.random() * 100) % 10,(int) (Math.random() * 100) % 10));
		}
		bfm.add(new BasicBullet(300,0,50,2));
		bfm.add(new BasicBullet(300,0,10,2));
		for(int i=0;i<20;i++)
		{
			bfm.update();
		}
	}

}
