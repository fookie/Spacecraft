package spacecraftelements.Enemy;

import spacecraftcore.MainGame;
import spacecraftelements.SpecialEffect.BigBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class Stigis extends Enemy{
    public int tarx,tary,mapsizex,mapsizey;
    public int centerx;
	public int centery;
	public long starttime;
	public double targetangle= Math.random()%360;
	public Stigis(int x,int y,int mapsizex,int mapsizey){
	    super.x = x;
		super.y = y;
		super.damage = 2;
		super.health = 200;
		super.v = 4;
		super.volume = 40;
		super.imageID = "Images//enemy//star.png";
		super.imagesize = 50;
		super.getscore=100;
		tarx=(int) (Math.random()*mapsizex*0.75)*(-1)^x;
		tary=(int) (Math.random()*mapsizey*0.75)*(-1)^y;
		starttime=MainGame.gametime;
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
		x1 = tarx - x;
		y1 = tary - y;
		third = Math.sqrt((double) x1 * x1 + y1 * y1);
		ratiox = ((double) x1) / third;
		ratioy = ((double) y1) / third;
		vx = (int) (((double) v) * ratiox);
		vy = (int) (((double) v) * ratioy);
		
		if ((MainGame.gametime-starttime) % 5==0){
	        MainGame.bm.add(new Basickamikaze(x,y,targetangle));
	       // MainGame.bm.add(new Basickamikaze(x,y,targetangle+180));
	        //System.out.println(MainGame.gametime-starttime);&&(MainGame.gametime-starttime)<135
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
