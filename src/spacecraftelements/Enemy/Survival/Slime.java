package spacecraftelements.Enemy.Survival;

import spacecraftcore.MainGame;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.Items.H_bulletblast;
import spacecraftelements.Items.H_bulletrain;
import spacecraftelements.Items.S_repair;
import spacecraftelements.Items.S_speedup;
import spacecraftelements.Items.W_BasicWeapon;
import spacecraftelements.Items.W_Shotgun;
import spacecraftelements.Items.W_StarWeapon;
import spacecraftelements.SpecialEffect.SmallBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class Slime extends Enemy {
	public Slime(double x, double y) {
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.health = 50;
		super.v = 4;
		super.volume = 40;
		super.imageID = "Images//enemy//slime.png";
		super.imagesize = 20;
		super.getscore = 9;
	}

	public boolean update() {
		if (x == MainGame.bm.getShip().x && y == MainGame.bm.getShip().y) {
			return false;
		}
		if (hit == true) {
			this.imageID = "Images//enemy//slime1.png";
			hit = false;
		} else {
			this.imageID = "Images//enemy//slime.png";
		}// hint when hit
		double x1, y1;
		double ratiox, ratioy, third;
		x1 =  (MainGame.bm.getShip().x - x);
		y1 = (MainGame.bm.getShip().y - y);
		third = Math.sqrt( x1 * x1 + y1 * y1);
		ratiox = (x1) / third;
		ratioy = (y1) / third;
		vx = ( v * ratiox);
		vy =  ( v * ratioy);
		x = x + vx;
		y = y + vy;
		return true;
	}

	@Override
	public SpecialEffect deathwhisper() {
		double r = Math.random();
		if (r < 0.05) {
			MainGame.bm.add(new W_StarWeapon(x, y));
		} else if (r > 0.15 && r < 0.2) {
			MainGame.bm.add(new H_bulletrain(x, y));
		} else if (r > 0.2 && r < 0.25) {
			MainGame.bm.add(new S_speedup(x, y));
		} else if (r > 0.3 && r < 0.4) {
			MainGame.bm.add(new S_repair(x, y));
		} else if (r > 0.4 && r < 0.5) {
			MainGame.bm.add(new H_bulletblast(x, y));
		} else if (r > 0.55 && r < 0.6) {
			MainGame.bm.add(new W_Shotgun(x, y));
		} else if (r > 0.6 && r < 0.61) {
			MainGame.bm.add(new W_BasicWeapon(x, y));
		}
		return new SmallBlast(x, y);
	}
}