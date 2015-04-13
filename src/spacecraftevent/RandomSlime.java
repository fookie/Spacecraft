package spacecraftevent;

import spacecraftcore.MainGame;
import spacecraftelements.Enemy.Evasion.Kamikaze;
import spacecraftelements.Enemy.Survival.Bigslime;
import spacecraftelements.Enemy.Survival.RunningShooter;

/**
 * ���ˢʷ��ķ���¼�
 *
 */
public class RandomSlime extends SpaceEvent {
	int mapsizex;
	int mapsizey;
	int cd;
	@Override
	public boolean execute() {
		cd=(10000-MainGame.bm.score)/200+70;
		int type=(int) ((Math.random()*100)%5);
		if(MainGame.gametime%cd==2)
		{
			double x=Math.random()*mapsizex*((int)Math.pow(-1,(int)cd));
			double y=Math.random()*mapsizey*((int)Math.pow(-1,(int)MainGame.bm.score));
			if(type==0)
			{
				MainGame.bm.add(new Kamikaze(x,y,mapsizex,mapsizey));
			}
			else if(type==1)
			{
				MainGame.bm.add(new RunningShooter(x,y,mapsizex,mapsizey));
			}
			else if(type==2)
			{
				MainGame.bm.add(new Bigslime(x,y,mapsizex,mapsizey));
			}
			
		}
		return true;
	}

	@Override
	public boolean executenow() {
		return true;
	}

	/**
	 * ��Ҫ��ͼ�Ĵ�С
	 * 
	 * @param mapsizex
	 * @param mapsizey
	 */
	public RandomSlime(int mapsizex, int mapsizey) {
		this.mapsizex = mapsizex;
		this.mapsizey = mapsizey;
		super.over=false;
	}

}
