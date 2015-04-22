package spacecraftelements.Bullets;

import spacecraftcore.MainGame;

public class EnemyBullet extends Bullet {
	public double angle;
	public int v = 10;
	private int nowimage = 1;
	String color;

	public EnemyBullet(double x, double y, double initialangle) {
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.volume = 50;
		super.ImageID = "Images//bullet//blue.png";
		super.Imagesize = 50;
		super.faction = 1;
		this.angle = initialangle % 360;
		this.v = 10;
	}

	public boolean update() {
		this.ImageID = "Images//bullet//rounds//" + color + "rounds//round ("
				+ nowimage + ").png";
	//	System.out.println(ImageID);
		if(MainGame.gametime%5==0){
		if (nowimage > 4) {
			nowimage = 1;
		} else {
			nowimage++;
		}}
		if (x == MainGame.bm.getShip().x && y == MainGame.bm.getShip().y) {
			return false;
		}

		double ratiox, ratioy;
		// ratiox = Math.cos(angle*Math.PI/180);
		// ratioy = Math.sin(angle*Math.PI/180);
		if (angle == 180) {
			ratiox = -1.0;
			ratioy = 0;
		} else {
			ratiox = Math.cos(angle * Math.PI / 180);
			ratioy = Math.sin(angle * Math.PI / 180);
		}
		vx = (((double) v) * ratiox);
		vy = (((double) v) * ratioy);
		x = x + vx;
		y = y + vy;

		return true;
	}

	public EnemyBullet(double x, double y, double initialangle, int color) {
		super.x = x;
		super.y = y;
		super.damage = 1;
		super.volume = 50;
		// if(color==1){
		// super.ImageID = "Images//bullet//blue.png";
		// }
		// else if(color==2)
		// {
		// super.ImageID = "Images//bullet//green.png";
		// }
		// else if(color==3)
		// {
		// super.ImageID = "Images//bullet//orange.png";
		// }
		// else if(color==4)
		// {
		// super.ImageID = "Images//bullet//purple.png";
		// }
		// else if(color==5)
		// {
		// super.ImageID = "Images//bullet//yellow.png";
		// }
		// else
		// {
		// super.ImageID = "Images//bullet//blue.png";
		// }

		if (color == 1) {
			this.color = "blue";
		} else if (color == 2) {
			this.color = "cyan";
		} else if (color == 3) {
			this.color = "green";
		} else if (color == 4) {
			this.color = "orange";
		} else if (color == 5) {
			this.color = "purple";
		} else if (color == 6) {
			this.color = "red";
		} else if (color == 7) {
			this.color = "white";
		} else {
			this.color = "yellow";
		}
		super.Imagesize = 50;
		super.faction = 1;
		this.angle = initialangle % 360;
	}

	public EnemyBullet(double x, double y, double initialangle, int color, int v) {
		this(x, y, initialangle, color);
		this.v = v;
	}

}
