package spacecraftelements.Enemy.Evasion;

import spacecraftcore.MainGame;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.SpecialEffect.SmallBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class Basickamikaze extends Enemy{
	public double angle;

	public Basickamikaze(double x,double y,double initialangle){
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.health = 50;
		super.v = 10;
		super.volume = 40;
		super.imageID = "Images//bullet//blue.png";
		super.imagesize = 20;
		super.getscore = 0;
		this.angle = initialangle %360;
	}

	public boolean update() {
		if (x == MainGame.bm.getShip().x && y == MainGame.bm.getShip().y) {
			this.health=-1;
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
		vx = (v * ratiox);
		vy =  (v * ratioy);
		x = x + vx;
		y = y + vy;

		return true;
	}

	@Override
	public SpecialEffect deathwhisper() {
		return new SmallBlast(x, y);
	}

}
