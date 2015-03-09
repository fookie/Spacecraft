package spacecraftevent;

import spacecraftcore.MainGame;
import spacecraftelements.Enemy.Slime;

/**
 * 随机刷史莱姆的事件
 *
 */
public class RandomSlime extends SpaceEvent {
	int mapsizex;
	int mapsizey;
	
	@Override
	public boolean execute() {
		if (MainGame.gametime % 70 == 0) {
			MainGame.bm.add(new Slime((int) (Math.random() * 3000) % mapsizex,
					(int) (Math.random() * 3000) % mapsizey));
		}
		return true;
	}

	@Override
	public boolean executenow() {
		MainGame.bm.add(new Slime((int) (Math.random() * 3000) % mapsizex,
				(int) (Math.random() * 3000) % mapsizey));
		return true;
	}

	/**
	 * 需要地图的大小
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
