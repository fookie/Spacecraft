package spacecraftelements.Enemy.Evasion;

import spacecraftcore.MainGame;
import spacecraftelements.SpecialEffect.SmallBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class Splinter3 extends Basickamikaze{
	long starttime;
	long lifetime = 0;
	public Splinter3(double x, double y, double initialangle) {
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
		
		if (lifetime==40){
			//System.out.println("Why");
			MainGame.bm.add(new Splinter4(x,y,45));
			MainGame.bm.add(new Splinter4(x,y,135));
			MainGame.bm.add(new Splinter4(x,y,225));
			MainGame.bm.add(new Splinter4(x,y,315));
			//System.out.println("Here???");
			
			this.health=-1;
			
		}
		lifetime++;
		x = x + vx;
		y = y + vy;
		return true;
	}

	public SpecialEffect deathwhisper() {
		return new SmallBlast(x, y);
	}

}