package spacecraftcore;

public class BattleFieldLoader {
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
	
		MainGame.test.repainter.repaint();
		MainGame.gamestatus=1;
	}
}
