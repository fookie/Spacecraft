package spacecraftelements.Weapon;

import spacecraftcore.SoundController2;
import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Bullets.Bullet;
/**
 * WeaponID: 1
 * @author Paulay
 *
 */
public class Shotgun extends Weapon {
	public Shotgun() {
		super.weaponID = 1;
		super.defaultbullet = 0;
		super.clip = 30;
		super.iv = 20;
		super.reload = 2;
		super.cd = 13;
		super.count = 5;
		super.ImageLoc = "Images//Item//shotgun.png";
	}

	public Bullet[] shoot(int x, int y, int visx, int visy, int cx, int cy,
			int f) {
		double a, b, c;
		a = cx - visx;
		b = cy - visy;
		c = Math.sqrt(a * a + b * b);
		double sin = b / c;
		double cos = a / c;
		double angle = Math.asin(sin);
		if (a < 0) {
			angle = -angle + Math.PI;
		}
		int vx = (int) (((double) iv) * cos);
		int vy = (int) (((double) iv) * sin);
		Bullet[] bullet = new Bullet[5];
		bullet[0] = new BasicBullet(x, y, vx, vy, f);
		int tvx, tvy = 0;
		int tj = 1;
		Thread t = new Thread(new SoundController2("Sounds//weapon2.wav"));
		t.start();
		for (int i = -30; i <= 30; i = i + 15) {
			if (i != 0) {
				double tangle = i * Math.PI / 180;
				tvx = (int) (iv * Math.cos(angle + tangle));
				tvy = (int) (iv * Math.sin(angle + tangle));
				bullet[tj] = new BasicBullet(x, y, tvx, tvy, f);
				tj++;
			}
		}
		return bullet;
	}
}
