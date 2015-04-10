package spacecraftelements.Enemy.Evasion;

import spacecraftcore.MainGame;

import spacecraftelements.SpecialEffect.SmallBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class Splinter extends Basickamikaze{
	long starttime;
	long lifetime=0;

	public Splinter(double x, double y, double initialangle) {
		super(x, y, initialangle);
		super.v = 8;
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
		
		if (this.lifetime==60){
			System.out.println(MainGame.gametime-starttime);
			MainGame.bm.add(new Splinter2(x,y,45));
			MainGame.bm.add(new Splinter2(x,y,135));
			MainGame.bm.add(new Splinter2(x,y,225));
			MainGame.bm.add(new Splinter2(x,y,315));
			this.health=-1;
		}
		x = x + vx;
		y = y + vy;
		this.lifetime = lifetime + 1;
		return true;
	}

	public SpecialEffect deathwhisper() {
		return new SmallBlast(x, y);
	}

}
