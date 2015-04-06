package spacecraftelements.Weapon;

import spacecraftelements.Bullets.Bullet;

/**
 * 这个的话既可以是玩家飞船的武器也可以是敌人的武器
 */
public abstract class Weapon {
	/**
	 * 武器ID
	 */
	public int weaponID;
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
	public double iv;
	/**
	 * 出膛加速度
	 */
	public double ia = 0;
	/**
	 * 开火间隔
	 */
	public int cd;
	/**
	 * 散弹数量
	 */
	public int count = 1;
	/**
	 * 武器图标地址 
	 */
	public String ImageLoc;
	/**
	 * 武器图标大小
	 */
	public int ImageSize = 25;
	/**
	 * 开火method x， y为船体在内建坐标的位置 visx, visy为船体在屏幕坐标的位置 cx, cy为鼠标在屏幕上的坐标
	 * 
	 * @param
	 */
	public abstract Bullet[] shoot(int x, int y, int visx, int visy, int cx,
			int cy, int f);

	/**
	 * 返回散弹数
	 */
	public int count() {
		return count;
	}
}
