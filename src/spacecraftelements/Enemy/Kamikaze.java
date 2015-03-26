package spacecraftelements.Enemy;

import spacecraftcore.MainGame;
import spacecraftelements.SpecialEffect.BigBlast;
import spacecraftelements.SpecialEffect.SmallBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;
/**
 * 
 * @author Pimba
 * Mothership Core 
 * The core of rotation object
 */
public class Kamikaze extends Enemy{
    public double angle;
    public int radius=100;
    public int tarx,tary,mapsizex,mapsizey;
    //public static int centerx,centery;
	public Kamikaze(int x, int y,int mapsizex,int mapsizey) {
	    super.x = x;
		super.y = y;
		super.damage = 2;
		super.health = 200;
		super.v = 4;
		super.volume = 40;
		super.imageID = "Images//enemy//slime.png";
		super.imagesize = 50;
		super.getscore=100;
		tarx=(int) (Math.random()*mapsizex*0.75)*(-1)^x;
		tary=(int) (Math.random()*mapsizey*0.75)*(-1)^y;

	}

	public boolean update() {

		if (Math.abs(x - tarx)<20 && Math.abs(y - tary)<20) {
			tarx=(int) (Math.random()*mapsizex*0.75)*(-1)^x;
			tary=(int) (Math.random()*mapsizey*0.75)*(-1)^y;
			return false;
		}
		if(hit==true){this.imageID = "Images//enemy//star.png";hit=false;}
		else {this.imageID = "Images//enemy//star.png";}//hint when hit
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
		this.centerx = x;
		this.centery = y;
		if (MainGame.gametime % 15==0&&MainGame.gametime<300){
	        MainGame.bm.add(new RotatingSlime(x+radius,y,this,radius));

		}


		


		return true;
	}

	public SpecialEffect deathwhisper() {
		
		return new BigBlast(x,y);
	}

}
