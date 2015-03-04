package spacecraftevent;

import spacecraftcore.MainGame;
import spacecraftelements.Bullets.BasicBullet;

public class BulletRain extends SpaceEvent {
	int x = 0;

	@Override
	public boolean execute() {
		if (MainGame.gametime % 50 == 0) {
			for (int i = 0; i < 30; i++) {
				MainGame.bm.add(new BasicBullet(-600 + i * 50, 600, 1 - x, -9
						- x, 0));
			}
			x++;
			if (x > 2) {
				super.over = true;
			}
		}
		return true;
	}

	@Override
	public boolean executenow() {
		// TODO Auto-generated method stub
		return false;
	}

	public BulletRain() {
		super.over = false;
	}

}