package spacecraftelements.Bullets;


public class BasicBullet extends Bullet{
	public BasicBullet(int x,int y,int vx,int vy){
		//设定该子弹属性
		super.x=x;
		super.y=y;
		super.vx=vx;
		super.vy=vy;
		super.damage=15;
		super.volume = 10;
		super.ImageID="Images//bullet//basicbullet2.png";
		super.ID = 0;
		super.angle=0;
		super.Imagesize=20;
	}

	@Override
	public boolean update() {
		x=x+vx;
		y=y+vy;
		return true;
	}

}
