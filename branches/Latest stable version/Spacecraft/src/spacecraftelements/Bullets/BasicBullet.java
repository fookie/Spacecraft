package spacecraftelements.Bullets;


public class BasicBullet extends Bullet{
	public BasicBullet(double x,double y,double vx,double vy, int f){
		//设定该子弹属性 //bulid the bullet
		super.x=x;
		super.y=y;
		super.vx=vx;
		super.vy=vy;
		super.damage=15;
		super.volume = 20;
		super.ImageID="Images//bullet//basicbullet2.png";
		super.ID = 0;
		super.angle=0;
		super.imagesizex=10;
		super.imagesizey=10;
		super.faction = f;}
	

	@Override
	public boolean update() {
		x=x+vx;
		y=y+vy;
		return true;
	}

}
