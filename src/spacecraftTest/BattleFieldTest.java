package spacecraftTest;

import spacecraftcore.BattleFieldManager;

/**
 * ����BattleFieldManager��ع���
 * @author Hale
 *
 */
public class BattleFieldTest {
	public static void main(String[] args)
	{
		BattleFieldManager bfm=new BattleFieldManager();
		bfm.loadmap("scmaps//ceshiditu.cmp",10, 10);
	}

}
