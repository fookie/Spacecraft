package spacecraftelements.Enemy.Evasion;

import spacecraftcore.MainGame;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.SpecialEffect.BigBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

public class KochiyaSanae extends Enemy{

	  public double angle;
	    public int radius=100;
	    public double tarx,tary;
	    public int mapsizex,mapsizey;
	    public double centerx;
		public double centery;
		public long starttime;
	    //public static int centerx,centery;
		public KochiyaSanae(int x, int y,int mapsizex,int mapsizey) {
		    super.x = x;
			super.y = y;
			super.damage = 2;
			super.health = 2000;
			super.v = 4;
			super.volume = 200;
			super.imageID = "Images//enemy//star.png";
			super.imagesize = 50;
			super.getscore=100;
			this.mapsizex = mapsizex;
			this.mapsizey = mapsizey;
			starttime=MainGame.gametime;

		}

		public boolean update() {

			if (Math.abs(x - tarx)<20 && Math.abs(y - tary)<20) {
				tarx= (Math.random()*mapsizex*0.75)*((-1)^(int)x);
				tary= (Math.random()*mapsizey*0.75)*((-1)^(int)y);
				return false;
			}
			if(hit==true){this.imageID = "Images//enemy//boss1.png";hit=false;}
			else {this.imageID = "Images//enemy//boss.png";}//hint when hit
			double x1, y1;
			double ratiox, ratioy, third;
			x1 = tarx - x;
			y1 = tary - y;
			third = Math.sqrt((double) x1 * x1 + y1 * y1);
			ratiox = ((double) x1) / third;
			ratioy = ((double) y1) / third;
			vx =  (((double) v) * ratiox);
			vy =  (((double) v) * ratioy);

			x = x + vx;
			y = y + vy;	
			this.centerx = x;
			this.centery = y;


			if((MainGame.gametime-starttime)==1){
	            MainGame.bm.add(new Stigis(x, y, (int) (MainGame.bm.windowsizex * 0.7),(int) (MainGame.bm.windowsizey * 0.7)));
			}
			if((MainGame.gametime-starttime)%250==0){
				 MainGame.bm.add(new Stigis(x, y, (int) (MainGame.bm.windowsizex * 0.7),(int) (MainGame.bm.windowsizey * 0.7)));
			}
			
			if ((MainGame.gametime-starttime) % 220==0){
	           
	            //MainGame.bm.add(new Kamikaze(x, y,  (MainGame.bm.windowsizex * 0.7),(MainGame.bm.windowsizey * 0.7)));
				tarx=(int) (Math.random()*mapsizex*0.50)*((-1)^(int)x);
				tary=(int) (Math.random()*mapsizey*0.50)*((-1)^(int)y);
			}
			if((MainGame.gametime-starttime) % 50==0&&(MainGame.gametime-starttime)<151){
	            MainGame.bm.add(new horizonslider(x,y,(int) (MainGame.bm.windowsizex * 0.7),(int) (MainGame.bm.windowsizey * 0.7)));
			}
			if((MainGame.gametime-starttime)%300==0){
				MainGame.bm.add(new Splinter(x,y,90));
			}

			return true;
		}

		public SpecialEffect deathwhisper() {
			
			return new BigBlast(x,y);
		}

}
