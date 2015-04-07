package spacecraftcore;

public class BattleFieldLoader {
	int time=0;
	public static void loadBattleField()
	{
		
		for(int i=0;i<69;i++){
		MainGame.test.repainter.add_nooffset_element("Images//UI//mouse//hud ("
				+ i + ").png", -400+i*6,
				0, 0, 2);
		}
		
		for(int i=1;i<13;i++){
			MainGame.test.repainter.add_nooffset_element("Images//SpecialEffects//SmallBlast//"+i+".png", 0,
					i, 0, 2);
			}
		for(int i=1;i<13;i++){
			MainGame.test.repainter.add_nooffset_element("Images//SpecialEffects//BigBlast//"+i+".png", 0,
					i, 0, 2);
			}
		MainGame.test.repainter.add_nooffset_element("Images//bullets//bluebullet.png", 0,
			8, 0, 2);
		MainGame.test.repainter.add_nooffset_element("Images//bullets//purple.png", 0,
				8, 0, 2);
		MainGame.test.repainter.add_nooffset_element("Images//bullets//blue.png", 0,
				8, 0, 2);
		MainGame.test.repainter.repaint();
		MainGame.gamestatus=1;
	}
}
