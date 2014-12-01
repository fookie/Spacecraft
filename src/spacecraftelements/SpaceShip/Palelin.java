package spacecraftelements.SpaceShip;

import spacecraftelements.Weapon.BasicWeapon;
import spacecraftelements.Weapon.Weapon;

public class Palelin extends SpaceShip {

	public Palelin(int x, int y, int visx, int visy) {
		super.x = x;
		super.y = y;
		super.visx = visx;
		super.visy = visy;
		super.health = 100;
		super.volume = 50;
		super.w1 = new BasicWeapon();
		super.w2 = null;
		super.ImageID = "Images//ship//palelin.png";
	}

	public void switchweapon() {
		Weapon tw;
		tw = w1;
		w1 = w2;
		w2 = tw;
	}

	public void updateweapon(Weapon nw) {
		switchweapon();
		w1 = nw;
	}

}
