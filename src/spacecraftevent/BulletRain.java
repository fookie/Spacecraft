package spacecraftevent;

import spacecraftcore.MainGame;
import spacecraftcore.SoundController2;
import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Bullets.BlueBullet;

public class BulletRain extends SpaceEvent {
	int x = 0;
	int f=0;
	@Override
	public boolean execute() {
		if (MainGame.gametime % 70 == 0) {
			if(f!=1){
			for (int i = 0; i < 28; i=i+2) {
				MainGame.bm.add(new BasicBullet(-600 + i * 50, 600, 3 - x, -12
						- x, f));
			}
			}
			for (int i = 1; i < 28; i=i+2) {
				MainGame.bm.add(new BlueBullet(-600 + i * 50, 600, 3 - x, -12
						- x, f));
			}
			x++;
			Thread t = new Thread(new SoundController2("Sounds//heart.wav"));
			t.start();
			if (x > 2) {
				super.over = true;
				MainGame.nowdiff--;
			}
		}
		return true;
	}

	@Override
	public boolean executenow() {
		// TODO Auto-generated method stub
		return false;
	}

	public BulletRain(int f) {
		super.over = false;
		this.f=f;
		MainGame.nowdiff++;
	}
	public BulletRain() {
		super.over = false;
	}

}
