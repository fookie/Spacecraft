package spacecraftelements.Enemy;

import spacecraftelements.Updatable;

public class Enemy implements Updatable{
	/**
	 *  敌人生成位置
	 */
	public int x, y;
	/**
	 * 	敌人攻击力
	 */
	public int damage;
	/**
	 *  敌人移动速度
	 */
	public int v;
	/**
	 * 	敌人血量
	 */
	public int health;
	/**
	 * 	敌人体积
	 */
	public int volume;
	/**
	 * 	敌人自更新
	 */
	public boolean update() {
		return false;
	}
}
