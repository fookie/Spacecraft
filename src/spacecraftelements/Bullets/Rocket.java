package spacecraftelements.Bullets;

public class Rocket extends Bullet {
	double fax, fay;
	public Rocket(double x, double y, double vx, double vy, double ax, double ay, int f, double fax, double fay) {
		super.x = x;
		super.y = y;
		super.vx = vx;
		super.vy = vy;
		super.ax = ax;
		super.ay = ay;
		this.fax = fax;
		this.fay = fay;
		super.damage = 50;
		super.volume = 20;
		super.ImageID = "Images//bullet//Rocket.png";
		super.ID = 2;
		super.angle = 0;
		super.imagesizex = 10;
		super.imagesizey = 10;
		super.faction = f;
	}
	public boolean update() {
		x += vx;
		y += vy;
		if((vx + ax) * vx <= 0){
			vx = 0;
			ax = fax;
			ImageID = "Images//bullet//Rocketac.png";
		}
		if((vy + ay)*vy <= 0){
			vy = 0;
			ay = fay;
			ImageID = "Images//bullet//Rocketac.png";
		}
		vx += ax;
		vy += ay;
		return true;
	}

}
