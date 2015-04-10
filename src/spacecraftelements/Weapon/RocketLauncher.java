package spacecraftelements.Weapon;

import spacecraftcore.SoundController;
import spacecraftelements.Bullets.Bullet;
import spacecraftelements.Bullets.Rocket;

/**
 * WeaponID: 3
 * 
 * @author Paulay
 *
 */
public class RocketLauncher extends Weapon {
	int fa;

	public RocketLauncher() {
		super.weaponID = 3;
		super.defaultbullet = 0;
		super.clip = 10;
		super.iv = 10;
		super.ia = -3;
		fa = 1;
		super.reload = 1;
		super.cd = 19;
		super.ImageLoc = "Images//Item//rocketlauncher.png";

	}

	public Bullet[] shoot(int x, int y, int visx, int visy, int cx, int cy,
			int f) {
		double a, b, c;
		a = cx - visx;
		b = cy - visy;
		c = Math.sqrt(a * a + b * b);
		double sin = b / c;
		double cos = a / c;
		double vx = iv * cos;
		double vy = iv * sin;
		double ax = ia * cos;
		double ay = ia * sin;
		double fax = fa * cos;
		double fay = fa * sin;									//some calculation for rockets movement
		Bullet[] rocket = new Rocket[1];
		Thread t = new Thread(new SoundController("Sounds//RocketLauncher.wav"));
		t.start();
		rocket[0] = new Rocket(x, y, vx, vy, ax, ay, f, fax, fay);
		return rocket;
	}
}
