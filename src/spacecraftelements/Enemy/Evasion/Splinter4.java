package spacecraftelements.Enemy.Evasion;

import spacecraftcore.MainGame;
import spacecraftelements.SpecialEffect.SmallBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class Splinter4 extends Basickamikaze{
	long starttime;
	long lifetime = 0;

	public Splinter4(double x, double y, double initialangle) {
		super(x, y, initialangle);
		this.starttime =MainGame.gametime;
	}

	public boolean update() {
		if (x == MainGame.bm.getShip().x && y == MainGame.bm.getShip().y) {
			return false;
		}

		double ratiox, ratioy;
		if(angle==180){
			ratiox = -1.0;
			ratioy = 0;
		}
		else{
		ratiox = Math.cos(angle*Math.PI/180);
	    ratioy = Math.sin(angle*Math.PI/180);
		}
		vx =  (((double) v) * ratiox);
		vy =  (((double) v) * ratioy);
		
		if (this.lifetime==40){
			this.health=-1;
		}
		x = x + vx;
		y = y + vy;
		this.lifetime++;
		return true;
	}

	public SpecialEffect deathwhisper() {
		return new SmallBlast(x, y);
	}

}