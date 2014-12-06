package spacecraftelements.Bullets;

public class EnhancedBullet extends Bullet{
	public EnhancedBullet(int x, int y, int vx, int vy)
	{
		super.x = x;
		super.y = y;
		super.vx = vx;
		super.vy = vy;
		super.damage = 20;
		
	}

	public boolean update() {
		
		return false;
	}
}
