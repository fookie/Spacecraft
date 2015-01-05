package spacecraftelements.Weapon;

import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Bullets.Bullet;

public class BasicWeapon extends Weapon {
	public BasicWeapon() {
		super.defaultbullet = 0;
		super.clip = 10;
		super.iv = 20;
		super.reload = 1;
		super.ID = 0;
		super.cd = 8;
	}

	public Bullet[] shoot(int x, int y, int visx, int visy, int cx, int cy, int f) {
		double a, b, c;
		a = cx - visx;
		b = cy - visy;
		c = Math.sqrt(a * a + b * b);
		double sin = b / c;
		double cos = a / c;
		int vx = (int) (((double) iv) * cos);
		int vy = (int) (((double) iv) * sin);
		Bullet[] bullet = new Bullet[1];
		bullet[0] = new BasicBullet(x, y, vx, vy, f);
		return bullet;
	}
}
