package spacecraftelements.Bullets;


public class BlueBullet extends Bullet{
	public BlueBullet(int x,int y,int vx,int vy, int f){
		//设定该子弹属性
		super.x=x;
		super.y=y;
		super.vx=vx;
		super.vy=vy;
		super.damage=32;
		super.volume = 10;
		super.ImageID="Images//bullet//bluebullet.png";
		super.ID = 1;
		super.angle=0;
		super.Imagesize=10;
		super.faction = f;
	}

	@Override
	public boolean update() {
		x=x+vx;
		y=y+vy;
		return true;
	}

}
