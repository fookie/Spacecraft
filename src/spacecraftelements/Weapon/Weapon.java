package spacecraftelements.Weapon;

import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Bullets.Bullet;

/**
 * 这个的话既可以是玩家飞船的武器也可以是敌人的武器
 */
public abstract class Weapon {
	/**
	 * 指定子弹ID
	 */
	public int defaultbullet;
	/**
	 * 弹夹大小
	 */
	public int clip;
	/**
	 * 装弹时间
	 */
	public int reload;
	/**
	 * 出膛速度
	 */
	public int iv;
	/**
	 * 武器ID
	 */
	public int ID;

	/**
	 * 开火method
	 * 
	 * @param
	 */
	public abstract Bullet shoot(int x,int y,int visx, int visy, int cx, int cy);
}
