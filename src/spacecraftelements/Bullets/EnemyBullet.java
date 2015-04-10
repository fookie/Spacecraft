package spacecraftelements.Bullets;

import spacecraftcore.MainGame;

public class EnemyBullet extends Bullet{
	public double angle;
	public int v;

	public EnemyBullet(double x,double y,double initialangle){
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.volume = 50;
		super.ImageID = "Images//bullet//blue.png";
		super.Imagesize = 50;
		super.faction = 1;
		this.angle = initialangle %360;
		this.v = 10;
	}

	public boolean update() {
		if (x == MainGame.bm.getShip().x && y == MainGame.bm.getShip().y) {
			return false;
		}

		double ratiox, ratioy;
		//ratiox = Math.cos(angle*Math.PI/180);
		//ratioy = Math.sin(angle*Math.PI/180);
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
		x = x + vx;
		y = y + vy;

		return true;
	}
	public EnemyBullet(double x,double y,double initialangle,int color){
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.volume = 50;
		if(color==1){
		super.ImageID = "Images//bullet//blue.png";
		}
		else if(color==2)
		{
			super.ImageID = "Images//bullet//green.png";	
		}
		else if(color==3)
		{
			super.ImageID = "Images//bullet//orange.png";	
		}
		else if(color==4)
		{
			super.ImageID = "Images//bullet//purple.png";	
		}
		else if(color==5)
		{
			super.ImageID = "Images//bullet//yellow.png";	
		}
		else
		{
			super.ImageID = "Images//bullet//blue.png";
		}
		super.Imagesize = 50;
		super.faction = 1;
		this.angle = initialangle %360;
		this.v = 10;
	}

}
