package spacecraftelements.Enemy.Evasion;

import spacecraftcore.MainGame;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.SpecialEffect.BigBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;
/**
 * 
 * @author Pimba
 * Mothership Core 
 * The core of rotation object
 */
public class Kamikaze extends Enemy{
    public double angle,tarx,tary;
    public int mapsizex,mapsizey;
	public long starttime;
    //public static int centerx,centery;
	public Kamikaze(int x, int y,int mapsizex,int mapsizey) {
	    super.x = x;
		super.y = y;
		super.damage = 2;
		super.health = 200;
		super.v = 4;
		super.volume = 100;
		super.imageID = "Images//enemy//star.png";
		super.imagesize = 50;
		super.getscore=100;
		tarx= (Math.random()*mapsizex*0.75)*((-1)^(int)x);
		tary= (Math.random()*mapsizey*0.75)*((-1)^(int)y);
		starttime=MainGame.gametime;
		super.radius = 200;

	}

	public boolean update() {

		if (Math.abs(x - tarx)<20 && Math.abs(y - tary)<20) {
			tarx= (Math.random()*mapsizex*0.75)*((-1)^(int)x);
			tary= (Math.random()*mapsizey*0.75)*((-1)^(int)y);
			
		}
		if(hit==true){this.imageID = "Images//enemy//star1.png";hit=false;}
		else {this.imageID = "Images//enemy//star.png";}//hint when hit
		double x1, y1;
		double ratiox, ratioy, third;
		x1 = MainGame.bm.getShip().x - x;
		y1 = MainGame.bm.getShip().y - y;
		third = Math.sqrt((double) x1 * x1 + y1 * y1);
		ratiox = ((double) x1) / third;
		ratioy = ((double) y1) / third;
		vx =  (((double) v) * ratiox);
		vy = (((double) v) * ratioy);

		x = x + vx;
		y = y + vy;	
		this.centerx = x;
		this.centery = y;
		
		if ((MainGame.gametime-starttime) % 15==0&&(MainGame.gametime-starttime)<135){
	        MainGame.bm.add(new RotatingSlime(x+radius,y,this,radius));
	        System.out.println(MainGame.gametime-starttime);
		}
		if((MainGame.gametime-starttime)>150){
			this.radius++;
		}

		return true;
	}

	public SpecialEffect deathwhisper() {
		
		return new BigBlast(x,y);
	}

}
