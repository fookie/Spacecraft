package spacecraftcore;

import java.util.LinkedList;
import java.util.List;

import spacecraftelements.*;

public class BattleFieldManager {
	List<Bullet> BulletList = new LinkedList<Bullet>();
	List<SpaceShip> ShipList = new LinkedList<SpaceShip>();
	public boolean add(Bullet b) {
		return BulletList.add(b);
	}
	public boolean add(SpaceShip s) {
		return ShipList.add(s);
	}
}
