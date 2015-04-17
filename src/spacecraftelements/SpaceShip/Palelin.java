package spacecraftelements.SpaceShip;

import spacecraftcore.SoundController;
import spacecraftelements.Weapon.BasicWeapon;
import spacecraftelements.Weapon.RocketLauncher;
import spacecraftelements.Weapon.Weapon;

public class Palelin extends SpaceShip {


	public Palelin(int x, int y, int visx, int visy) {
		super.x = x;
		super.y = y;
		super.visx = visx;
		super.visy = visy;
		super.maxv = 10;
		super.a = 3;
		super.m = 2;
		super.health = 5;
		super.volume = 50;
		super.w1 = new BasicWeapon();
		super.w2 = new RocketLauncher();
		super.ImageID = "Images//ship//palelin2.png";
		super.Imagesize = 45;
	}

	public void switchweapon() {
		Weapon tw;
		if (w2 == null) {
			Thread t = new Thread(new SoundController("Sounds//cantchange.wav"));
			t.start();
		} else {
			Thread t = new Thread(new SoundController(
					"Sounds//changeweapon.wav"));
			t.start();
			tw = w1;
			w1 = w2;
			w2 = tw;
		}
	}

	public void updateweapon(Weapon nw) {
		switchweapon();
		w1 = nw;
	}

}
