package spacecraftevent;

import spacecraftcore.MainGame;
/**
 * ���ģʽ������
 * 
 * ���Ϊ�Ѷ������� </br>
 * 
 * @author Hale
 *
 */
public class EvasionManager extends SpaceEvent{
	private final int tardiff=100;
	private int nowtardiff=2;//��ǰĿ���Ѷ�
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
