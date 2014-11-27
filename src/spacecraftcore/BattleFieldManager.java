package spacecraftcore;

import java.util.LinkedList;
import java.util.List;

import spacecraftelements.*;

public class BattleFieldManager {
	List<Bullet> BulletList = new LinkedList<Bullet>();
	SpaceShip Ship=null;
	public boolean add(Bullet b) {
		return BulletList.add(b);
	}
	public boolean add(SpaceShip s) {
		Ship=s;
		return true;
	}
	
}
