package spacecraftelements.Enemy;

import spacecraftcore.MainGame;
import spacecraftelements.SpecialEffect.SmallBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class Basickamikaze extends Enemy{
	public double angle;

	public Basickamikaze(int x,int y,double initialangle){
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.health = 50;
		super.v = 8;
		super.volume = 40;
		super.imageID = "Images//bullet//blue.png";
		super.imagesize = 20;
		super.getscore = 0;
		this.angle = initialangle;
	}

	public boolean update() {
		if (x == MainGame.bm.getShip().x && y == MainGame.bm.getShip().y) {
			return false;
		}

		double ratiox, ratioy;
		//ratiox = Math.cos(angle*Math.PI/180);
		//ratioy = Math.sin(angle*Math.PI/180);
		if(angle==180){
			ratiox = -1.0;
			ratioy = 0;
		}
		else{
		ratiox = Math.cos(angle*Math.PI/180);
	    ratioy = Math.sin(angle*Math.PI/180);
		}
		vx = (int) (((double) v) * ratiox);
		vy = (int) (((double) v) * ratioy);
		x = x + vx;
		y = y + vy;
		return true;
	}

	@Override
	public SpecialEffect deathwhisper() {
		return new SmallBlast(x, y);
	}

}
