package spacecraftTest;

import spacecraftcore.BattleFieldManager;
import spacecraftelements.Bullets.BasicBullet;

/**
 * 测试BattleFieldManager相关功能
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
		for(int i=0;i<1;i++)
		{
			bfm.update();
		}
	}

}
