package spacecraftelements.Enemy;

import spacecraftcore.MainGame;

public class Slime extends Enemy {
	public Slime(int x, int y) {
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.health = 50;
		super.v = 10;
		super.volume = 20;
		super.imageID = "Images//enemy//slime.png";
	}

	public boolean update() {
		int x1, y1, vx, vy;
		double angle;
		x1 = MainGame.bm.getShip().x - x;
		y1 = MainGame.bm.getShip().y - y;
		angle = MainGame.bm.getangle(x1, y1);
		vx = (int) (Math.cos(angle) * v);
		vy = (int) (Math.sin(angle) * v);
		x = x + vx;
		y = y + vy;
		return true;
	}
}
