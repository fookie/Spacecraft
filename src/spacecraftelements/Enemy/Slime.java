package spacecraftelements.Enemy;

import spacecraftcore.MainGame;
import spacecraftelements.Items.H_bulletblast;
import spacecraftelements.Items.H_bulletrain;
import spacecraftelements.Items.S_repair;
import spacecraftelements.Items.S_speedup;
import spacecraftelements.Items.W_Shotgun;
import spacecraftelements.Items.W_StarWeapon;

public class Slime extends Enemy {
	public Slime(int x, int y) {
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.health = 50;
		super.v = 2;
		super.volume = 40;
		super.imageID = "Images//enemy//slime.png";
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

	@Override
	public boolean giveitem() {
		double r=Math.random();
		if (r < 0.1) {
			MainGame.bm.add(new W_StarWeapon(x, y));
			return true;
		} else if(r>0.1&&r<0.2){
			MainGame.bm.add(new H_bulletrain(x, y));
			return true;
		}
		else if(r>0.2&&r<0.25){
			MainGame.bm.add(new S_speedup(x, y));
			return true;
		}
		else if(r>0.3&&r<0.4){
			MainGame.bm.add(new S_repair(x, y));
			return true;
		}
		else if(r>0.4&&r<0.5){
			MainGame.bm.add(new H_bulletblast(x, y));
			return true;
		}else if (r > 0.5 && r < 0.6) {
			MainGame.bm.add(new W_Shotgun(x, y));
			return true;
		}
		else
		{
			return false;
		}
	}
}
