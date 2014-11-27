package spacecraftcore;

import java.util.LinkedList;
import java.util.List;

import spacecraftelements.*;
/**
 * BattleFieldManager负责更新战场以及地图，并把信息传递给DisplayManager
 * @author Hale
 *
 */
public class BattleFieldManager {
	private List<Bullet> BulletList = new LinkedList<Bullet>();
	private List<Enemy> EnemyList = new LinkedList<Enemy>();
	private SpaceShip Ship = null;
	
	/**
	 * 添加子弹
	 * 
	 * @param Bullet
	 * @return 是否成功添加
	 */
	public boolean add(Bullet b) {
		return BulletList.add(b);
	}

	/**
	 * 添加SpaceShip，只能添加一次
	 * 
	 * @param SpaceShip
	 * @return 是否成功添加
	 */
	public boolean add(SpaceShip s) {
		if (Ship == null) {
			Ship = s;
			return true;
		} else {
			return false;
		}
	}
	/**
	 * 添加敌人
	 * 
	 * @param Bullet
	 * @return 是否成功添加
	 */
	public boolean add(Enemy e) {
		return EnemyList.add(e);
	}
	
}
