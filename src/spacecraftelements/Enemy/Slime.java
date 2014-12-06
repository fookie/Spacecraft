package spacecraftelements.Enemy;

import spacecraftcore.MainGame;

public class Slime extends Enemy {
	public Slime(int x, int y) {
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.health = 50;
		super.v = 2;
		super.volume = 20;
		super.imageID = "Images//enemy//slime.png";
//		super.imageID = "Images//ornament//basicentity.png";
		super.imagesize = 20;
	}

	public boolean update() {
		if (x == MainGame.bm.getShip().x && y == MainGame.bm.getShip().y) {
			return false;
		}
		int x1, y1;
		double ratiox, ratioy, third;
		x1 = MainGame.bm.getShip().x - x;
		y1 = MainGame.bm.getShip().y - y;
		third = Math.sqrt((double) x1 * x1 + y1 * y1);
		ratiox = ((double) x1) / third;
		ratioy = ((double) y1) / third;
		vx = (int) (((double) v) * ratiox);
		vy = (int) (((double) v) * ratioy);
		x = x + vx;
		y = y + vy;
		return true;
	}
}
