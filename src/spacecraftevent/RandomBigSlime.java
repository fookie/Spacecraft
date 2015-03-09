package spacecraftevent;

import spacecraftcore.MainGame;
import spacecraftelements.Enemy.Bigslime;
import spacecraftelements.Enemy.Slime;

/**
 * ���ˢʷ��ķ���¼�
 *
 */
public class RandomBigSlime extends SpaceEvent {
	int mapsizex;
	int mapsizey;

	@Override
	public boolean execute() {
		if (5000 - MainGame.bm.score > 1000) {
			if (MainGame.gametime % (5000 - MainGame.bm.score) == 0) {
				MainGame.bm.add(new Bigslime((int) (Math.random() * 3000)
						% mapsizex, (int) (Math.random() * 3000) % mapsizey,
						mapsizex, mapsizey));
			}
		}
		else
		{
			if (MainGame.gametime % 1000== 0) {
				MainGame.bm.add(new Bigslime((int) (Math.random() * 3000)
						% mapsizex, (int) (Math.random() * 3000) % mapsizey,
						mapsizex, mapsizey));
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
	public RandomBigSlime(int mapsizex, int mapsizey) {
		this.mapsizex = mapsizex;
		this.mapsizey = mapsizey;
		super.over = false;
	}

}
