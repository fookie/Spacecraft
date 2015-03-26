package spacecraftevent;

import spacecraftcore.MainGame;
import spacecraftcore.SoundController;
import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Bullets.BlueBullet;

public class BulletRain extends SpaceEvent {
	int x = 0;

	@Override
	public boolean execute() {
		if (MainGame.gametime % 70 == 0) {
			for (int i = 0; i < 28; i=i+2) {
				MainGame.bm.add(new BasicBullet(-600 + i * 50, 600, 3 - x, -12
						- x, 0));
			}
			for (int i = 1; i < 28; i=i+2) {
				MainGame.bm.add(new BlueBullet(-600 + i * 50, 600, 3 - x, -12
						- x, 0));
			}
			x++;
			Thread t = new Thread(new SoundController("Sounds//heart.wav"));
			t.start();
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
