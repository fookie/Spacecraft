package spacecraftelements.Weapon;

import javax.imageio.plugins.bmp.BMPImageWriteParam;

import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Bullets.Bullet;

public class EnhancedWeapon extends Weapon {
	public EnhancedWeapon() {
		super.defaultbullet = 0;
		super.clip = 30;
		super.iv = 20;
		super.reload = 2;
		super.ID = 0;
		super.cd = 8;
		super.count = 3;
	}

	public Bullet[] shoot(int x, int y, int visx, int visy, int cx, int cy) {
		double a, b, c;
		a = cx - visx;
		b = cy - visy;
		c = Math.sqrt(a * a + b * b);
		double sin = b / c;
		double cos = a / c;
		int vx = (int) (((double) iv) * cos);
		int vy = (int) (((double) iv) * sin);
		Bullet[] bullet = new Bullet[3];
		bullet[0] = new BasicBullet(x, y + 25, vx, vy);
		bullet[1] = new BasicBullet(x, y - 25, vx, vy);
		bullet[2] = new BasicBullet(x, y, vx, vy);
		return bullet;
	}
}
