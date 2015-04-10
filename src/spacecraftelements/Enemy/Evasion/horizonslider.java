package spacecraftelements.Enemy.Evasion;

import spacecraftcore.MainGame;
import spacecraftelements.Bullets.BlueBullet;
import spacecraftelements.Bullets.EnemyBullet;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.Items.S_repair;
import spacecraftelements.SpecialEffect.BigBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class horizonslider extends Enemy{
	int mapsizex,mapsizey;
	double tarx,tary;
	public horizonslider(double x, double y,int mapsizex,int mapsizey) {
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.health = 500;
		super.v = 4;
		super.volume = 110;
		super.imageID = "Images//enemy//slider.png";
		super.imagesize = 50;
		this.mapsizex=mapsizex;
		this.mapsizey=mapsizey;
		tarx=(int) (Math.random()*mapsizex*0.75)*((-1)^(int)x);
		tary=y;
		super.getscore=125;
	}
	@Override
	public SpecialEffect deathwhisper() {
		MainGame.bm.add(new S_repair(x+10, y+10));
		for(int i=-5;i<6;i++)
		{
			MainGame.bm.add(new BlueBullet(x, y, i,(int) Math.sqrt(20-i*i), 1));
			MainGame.bm.add(new BlueBullet(x, y, i,-(int) Math.sqrt(20-i*i), 1));
		}
		return new BigBlast(x,y);
	}
	@Override
	public boolean update() {
		
		if (Math.abs(x - tarx)<20 && Math.abs(y - tary)<20||MainGame.gametime%200==0) {
			tarx= (Math.random()*mapsizex*0.75)*((-1)^(int)x);
			tary=y;
			
		}
		if(hit==true){this.imageID = "Images//enemy//slider1.png";hit=false;}
		else {this.imageID = "Images//enemy//star.png";}//hint when hit
		double x1;
		double y1;
		double ratiox, ratioy, third;
		x1 = tarx - x;
		y1 = tary - y;
		third = Math.sqrt((double) x1 * x1 + y1 * y1);
		ratiox = ((double) x1) / third;
		ratioy = ((double) y1) / third;
		vx =  (((double) v) * ratiox);
		vy = (((double) v) * ratioy);
		x = x + vx;
		y = y + vy;
		
		if (MainGame.gametime % 20 == 0) {
	        MainGame.bm.add(new EnemyBullet(x,y,-90));
		}
		return true;
	}
}
