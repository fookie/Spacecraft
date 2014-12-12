package spacecraftelements.Weapon;

import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Bullets.Bullet;

public class EnhancedWeapon extends Weapon {
	public EnhancedWeapon() {
		super.defaultbullet = 0;
		super.clip = 30;
		super.iv = 20;
		super.reload = 2;
		super.ID = 0;
		super.cd = 13;
		super.count = 5;
	}

	public Bullet[] shoot(int x, int y, int visx, int visy, int cx, int cy) {
		double a, b, c;
		a = cx - visx;
		b = cy - visy;
		c = Math.sqrt(a * a + b * b);
		double sin = b / c;
		double cos = a / c;
		 double angle = Math.asin(sin);
		int vx = (int) (((double) iv) * cos);
		int vy = (int) (((double) iv) * sin);
		Bullet[] bullet = new Bullet[5];
		bullet[0] = new BasicBullet(x, y, vx, vy);
		// bullet[1] = new BasicBullet(x, y+15, vx, vy);
		// bullet[2] = new BasicBullet(x, y-15, vx, vy);
		 int tvx, tvy;
		 for (int i = -60; i <= 60; i = i + 30) {
		 if (i == 0) {
		 continue;
		 }
		 tvx = (int) (iv * Math.cos(angle + i));
		 tvy = (int) (iv * Math.sin(angle + i));
		 bullet[i / 30 + 2] = new BasicBullet(x, y, tvx, tvy);
		 }
//		bullet[1] = new BasicBullet(x, y - 25, vx, vy);
//		bullet[2] = new BasicBullet(x, y - 50, vx, vy);
//		bullet[3] = new BasicBullet(x, y + 25, vx, vy);
//		bullet[4] = new BasicBullet(x, y + 50, vx, vy);
		return bullet;
	}
}
