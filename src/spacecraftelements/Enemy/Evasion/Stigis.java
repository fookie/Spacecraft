package spacecraftelements.Enemy.Evasion;

import spacecraftcore.MainGame;
import spacecraftelements.Bullets.EnemyBullet;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.SpecialEffect.BigBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class Stigis extends Enemy{
    public int mapsizex,mapsizey;
    public double tarx,tary;
    public int centerx;
	public int centery;
	public long starttime;
	public double targetangle= Math.random()%360;
	public Stigis(double x,double y,int mapsizex,int mapsizey){
	    super.x = x;
		super.y = y;
		super.damage = 2;
		super.health = 200;
		super.v = 4;
		super.volume = 80;
		super.imageID = "Images//enemy//star.png";
		super.imagesize = 50;
		super.getscore=100;
		tarx= (Math.random()*mapsizex*0.75)*((int)Math.pow(-1,(int)x));
		tary= (Math.random()*mapsizey*0.75)*((int)Math.pow(-1,(int)y));
		starttime=MainGame.gametime;
	}

	public boolean update() {
		if (Math.abs(x - tarx)<20 && Math.abs(y - tary)<20) {
			tarx= (Math.random()*mapsizex*0.75)*((int)Math.pow(-1,(int)x));
			tary=(Math.random()*mapsizey*0.75)*((int)Math.pow(-1,(int)y));
			return false;
		}
		if(hit==true){this.imageID = "Images//enemy//star1.png";hit=false;}
		else {this.imageID = "Images//enemy//star.png";}//hint when hit
		double x1, y1;
		double ratiox, ratioy, third;
		x1 = tarx - x;
		y1 = tary - y;
		third = Math.sqrt((double) x1 * x1 + y1 * y1);
		ratiox = ((double) x1) / third;
		ratioy = ((double) y1) / third;
		vx =  (((double) v) * ratiox);
		vy = (((double) v) * ratioy);
		
		if ((MainGame.gametime-starttime) % 5==0&&(MainGame.gametime-starttime)<200){
	        MainGame.bm.add(new EnemyBullet(x,y,targetangle));
	        MainGame.bm.add(new EnemyBullet(x,y,targetangle+180));
		}
		targetangle = targetangle + 5;

		x = x + vx;
		y = y + vy;	
		
		return true;
	}

	public SpecialEffect deathwhisper() {
		return new BigBlast(x,y);
	}

}
