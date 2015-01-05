package spacecraftelements.Bullets;

public class EnhancedBullet extends Bullet{
	public EnhancedBullet(int x, int y, int vx, int vy)
	{
		super.x = x;
		super.y = y;
		super.vx = vx;
		super.vy = vy;
		super.damage = 15;
		super.volume = 10;
		super.ImageID = "Images//bullet//basicbullet2.png";
		super.ID = 0;
		super.angle = 0;
		super.Imagesize = 20;
	}

	public boolean update() {
		
		return false;
	}
}
