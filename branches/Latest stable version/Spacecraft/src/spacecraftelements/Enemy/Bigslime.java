package spacecraftelements.Enemy;

import spacecraftcore.MainGame;
import spacecraftelements.Bullets.BlueBullet;
import spacecraftelements.Items.S_repair;
import spacecraftelements.SpecialEffect.BigBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class Bigslime extends Enemy{
	int tarx,tary,mapsizex,mapsizey;
	public Bigslime(int x, int y,int mapsizex,int mapsizey) {
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.health = 500;
		super.v = 3;
		super.volume = 110;
		super.imageID = "Images//enemy//bigslime.png";
		super.imagesizex = 50;
		super.imagesizey = 50;
		this.mapsizex=mapsizex;
		this.mapsizey=mapsizey;
		tarx=(int) (Math.random()*mapsizex*0.75)*(-1)^x;
		tary=(int) (Math.random()*mapsizey*0.75)*(-1)^y;
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
		
		if (Math.abs(x - tarx)<20 && Math.abs(y - tary)<20) {
			tarx=(int) (Math.random()*mapsizex*0.75)*(-1)^x;
			tary=(int) (Math.random()*mapsizey*0.75)*(-1)^y;
			return false;
		}
		if(hit==true){this.imageID = "Images//enemy//bigslime1.png";hit=false;}
		else {this.imageID = "Images//enemy//bigslime.png";}//hint when hit
		int x1, y1;
		double ratiox, ratioy, third;
		x1 = tarx - x;
		y1 = tary - y;
		third = Math.sqrt((double) x1 * x1 + y1 * y1);
		ratiox = ((double) x1) / third;
		ratioy = ((double) y1) / third;
		vx = (int) (((double) v) * ratiox);
		vy = (int) (((double) v) * ratioy);
		x = x + vx;
		y = y + vy;
		
		if (MainGame.gametime % 200 == 0) {
			MainGame.bm.add(new Slime(x+55,y+55));
			MainGame.bm.add(new Slime(x+55,y-55));
			MainGame.bm.add(new Slime(x-55,y+55));
			MainGame.bm.add(new Slime(x-55,y-55));
		}
		return true;
	}

	
}
