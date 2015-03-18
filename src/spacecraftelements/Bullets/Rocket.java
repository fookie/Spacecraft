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
		super.ImageID = "Images//bullet//basicbullet2.png";
		super.ID = 2;
		super.angle = 0;
		super.imagesizex = 10;
		super.imagesizey = 10;
		super.faction = f;
	}
	public boolean update() {
//		if(Math.abs(ax) < Math.abs(fax)){
//			if(fax <0)
//			{
//				ax--;
//			}else if (fax>0){
//				ax++;
//			}
//		}
//		if(Math.abs(ay) < Math.abs(fay)){
//			if(fay <0)
//			{
//				ay--;
//			}else if (fay>0){
//				ay++;
//			}
//		}
		x += vx;
		y += vy;
		vx += ax;
		if((vx + ax) * vx <= 0){
			vx = 0;
			ax = fax;
		}
		if((vy + ay)*vy <= 0){
			vy = 0;
			ay = fay;
		}
		vy += ay;
		return true;
	}

}
