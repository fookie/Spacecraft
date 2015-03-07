package spacecraftelements.Weapon;

import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Bullets.Bullet;
/**
 * WeaponID: 2
 * @author Paulay
 *
 */
public class StarWeapon extends Weapon {
	public StarWeapon() {
		super.weaponID = 2;
		super.defaultbullet = 0;
		super.clip = 30;
		super.iv = 20;
		super.reload = 2;
		super.ID = 0;
		super.cd = 10;
		super.count = 5;
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
		for (int i = -30; i <= 30; i = i + 15) {
			if (i != 0) {
				tvx = (int) (iv * Math.cos(angle + i));
				tvy = (int) (iv * Math.sin(angle + i));
				bullet[tj] = new BasicBullet(x, y, tvx, tvy, f);
				tj++;
			}
		}
		return bullet;
	}
}
