package spacecraftelements.Weapon;

/**
 * 这个的话既可以是玩家飞船的武器也可以是敌人的武器
 */
public abstract class Weapon {
	/**
	 * 指定子弹
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
}
