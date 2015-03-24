package spacecraftelements.Bullets;

public class EnhancedBullet extends Bullet{
	public EnhancedBullet(int x, int y, int vx, int vy)
	{
		super.x = x;
		super.y = y;
		super.vx = vx;
		super.vy = vy;
		super.damage = 15;
		super.volume = 20;
		super.ImageID = "Images//bullet//basicbullet2.png";
		super.ID = 3;
		super.angle = 0;
		super.Imagesize = 10;
	}

	public boolean update() {
		
		return false;
	}
}
