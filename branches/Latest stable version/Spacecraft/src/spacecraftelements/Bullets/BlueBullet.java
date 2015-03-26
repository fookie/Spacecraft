package spacecraftelements.Bullets;


public class BlueBullet extends Bullet{
	public BlueBullet(double x,double y,double vx,double vy, int f){
		super.x=x;
		super.y=y;
		super.vx=vx;
		super.vy=vy;
		super.damage=32;
		super.volume = 10;
		super.ImageID="Images//bullet//bluebullet.png";
		super.ID = 1;
		super.angle=0;
		super.imagesizex=10;
		super.imagesizey=10;
		super.faction = f;
	}

	@Override
	public boolean update() {
		x=x+vx;
		y=y+vy;
		return true;
	}

}
