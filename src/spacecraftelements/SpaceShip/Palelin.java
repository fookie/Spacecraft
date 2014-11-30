package spacecraftelements.SpaceShip;

public class Palelin extends SpaceShip{
	
	public Palelin(int x, int y, int vx, int vy){
		super.x = x;
		super.y = y;
		super.vx = vx;
		super.vy = vy;
		super.health = 100;
		super.volume = 50;
		super.w1 = null;
		super.w2 = null;
	}
	
	public boolean update() {
		return false;
	}

}
