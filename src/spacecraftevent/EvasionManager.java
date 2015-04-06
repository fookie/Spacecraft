package spacecraftevent;

import spacecraftcore.MainGame;
/**
 * 躲避模式管理器
 * 
 * 设计为难度逐步上升 </br>
 * 
 * @author Hale
 *
 */
public class EvasionManager extends SpaceEvent{
	private final int tardiff=100;
	private int nowtardiff=2;//当前目标难度
	@Override
	public boolean execute() {
		if(MainGame.nowdiff<nowtardiff){
		//MainGame.bm.add(new BulletRain(1));
		
		
		
		}
		if(MainGame.gametime%1300==0)
		{
			if(nowtardiff>=tardiff)
			{
				nowtardiff=tardiff;
			}
			else
			{
				nowtardiff++;
			}
		}
		return false;
	}

	@Override
	public boolean executenow() {
		// TODO Auto-generated method stub
		return false;
	}

}
