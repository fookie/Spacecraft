package spacecraftelements.Enemy.Evasion;

import spacecraftcore.MainGame;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.SpecialEffect.BigBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;
/**
 * 
 * @author Pimba
 * Rotating Object
 *
 */
public class RotatingSlime extends Enemy{
	public int centerx,centery;
	public int radius;
	public double angle2center = 90;
	public Enemy mom;
	public double rotation = 3;
	public double starttime;
	public RotatingSlime(double x, double y,Enemy mother,int radius) {
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.health = 50;
		super.v = 12;
		super.volume = 40;
		super.imageID = "Images//enemy//circle.png";
		super.imagesize = 20;
		super.getscore=9;
        this.mom = mother;
		this.radius = mother.radius;
		this.starttime = MainGame.gametime;
	}
	public boolean update() {
		if (x == MainGame.bm.getShip().x && y == MainGame.bm.getShip().y) {
			return false;
		}
		if((MainGame.gametime-starttime)>200){
			this.health = -1;
		}
		if(hit==true){this.imageID = "Images//enemy//circle1.png";hit=false;}
		else {this.imageID = "Images//enemy//circle.png";}//hint when hit
		/*int x1, y1;
		double ratiox, ratioy, third;
		x1 = MainGame.bm.getShip().x - x;
		y1 = MainGame.bm.getShip().y - y;
		third = Math.sqrt((double) x1 * x1 + y1 * y1);
		ratiox = ((double) x1) / third;
		ratioy = ((double) y1) / third;
		vx = (int) (((double) v) * ratiox);
		vy = (int) (((double) v) * ratioy);
		x = x + vx;
		y = y + vy;*/
		@SuppressWarnings("unused")
		double x1,y1,x2,y2,leap;
		double ratiox, ratioy, third,cos,sin;

	    //x1 =  (x + radius*(1-Math.cos(angle2center*Math.PI/180)));
		//y1 =  (y - radius*Math.sin(angle2center*Math.PI/180));
		if(angle2center==180){
			cos = -1.0;
			sin = 0;
		}
		else{
		cos = Math.cos(angle2center*Math.PI/180);
	    sin = Math.sin(angle2center*Math.PI/180);
		}// gotta fix the accuracy here 

		x1 =  (radius*(cos) + mom.centerx) - x;
		y1 =  (radius*(sin) + mom.centery) - y;

		//System.out.println(angle2center + " "  + " " + cos + " " + sin + " " + " " + mom.centerx);
		third = Math.sqrt((double) x1 * x1 + y1 * y1);
		ratiox = ((double) x1) / third;
		ratioy = ((double) y1) / third;
		vx =  (((double) v) * ratiox);
		vy =  (((double) v) * ratioy);
		x = x + vx;
		y = y + vy;
		angle2center = (angle2center + rotation)%360;

		return true;

	}

	public SpecialEffect deathwhisper() {
		return new BigBlast(x,y);
	}

}
