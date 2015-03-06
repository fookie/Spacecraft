package spacecraftelements.SpaceShip;

import spacecraftelements.Weapon.BasicWeapon;
import spacecraftelements.Weapon.Shotgun;
import spacecraftelements.Weapon.Weapon;

public class Palelin extends SpaceShip {

	public Palelin(int x, int y, int visx, int visy) {
		super.x = x;
		super.y = y;
		super.visx = visx;
		super.visy = visy;
		super.maxv=10;
		super.a=100;
		super.health = 5;
		super.volume = 50;
		super.w1 = new BasicWeapon();
		super.w2 = new Shotgun();
		super.ImageID = "Images//ship//palelin.png";
		super.Imagesize=45;
	}

	public void switchweapon() {
		Weapon tw;
		if(w2==null){}
		else
		{
			tw=w1;
			w1=w2;
			w2=tw;
		}
	}

	public void updateweapon(Weapon nw) {
		switchweapon();
		w1 = nw;
	}

}
