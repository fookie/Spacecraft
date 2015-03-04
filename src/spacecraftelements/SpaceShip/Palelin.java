package spacecraftelements.SpaceShip;

import spacecraftelements.Weapon.BasicWeapon;
import spacecraftelements.Weapon.EnhancedWeapon;
import spacecraftelements.Weapon.Weapon;

public class Palelin extends SpaceShip {

	public Palelin(int x, int y, int visx, int visy) {
		super.x = x;
		super.y = y;
		super.visx = visx;
		super.visy = visy;
		super.maxv=10;
		super.a=1;
		super.health = 5;
		super.volume = 50;
		super.w2 = new BasicWeapon();
		super.w1 = new EnhancedWeapon();
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
