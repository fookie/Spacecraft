package spacecraftTest;

import spacecraftcore.BattleFieldManager;
import spacecraftelements.Bullets.BasicBullet;

/**
 * 测试BattleFieldManager相关功能
 * @author Hale
 *
 */
public class BattleFieldTest {
	public static void main(String[] args)
	{
		BattleFieldManager bfm=new BattleFieldManager();
		bfm.loadmap("scmaps//ditu1.cmp");
		bfm.add(new BasicBullet(300.0, 300.0, 100.0, 0.0));
		bfm.add(new BasicBullet(100.0, 300.0, 100.0, 0.0));
	}

}
