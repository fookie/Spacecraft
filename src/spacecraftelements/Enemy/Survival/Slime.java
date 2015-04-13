package spacecraftelements.Enemy.Survival;

import spacecraftcore.BattleFieldManager;
import spacecraftcore.MainGame;
import spacecraftelements.Enemy.Enemy;
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
		BattleFieldManager.createitem(x, y, 2);
		return new SmallBlast(x, y);
	}
}
