package spacecraftelements.SpaceShip;

import spacecraftelements.Weapon.Weapon;

/**
 * 
 *
 */
public abstract class SpaceShip {
	public double angle;
	/**
	 * 游戏内建坐标
	 */
	public int x, y;
	/**
	 * 屏幕上的坐标
	 */
	public int visx,visy;
	/**
	 * 飞船加速度,质量(只与移动有关)
	 */
	public int a,m;
	/**
	 * 最大速度
	 */
	public int maxv;
	/**
	 * 现在速度
	 * 在计算镜头时有用
	 */
	public int nowv;
	/**
	 * 速度(趋势)，每次更新时用
	 */
	public int vx, vy;
	/*改成ImageID[];
	 */
	public String ImageID;
	/**
	 * 贴图的大小，正方形图片边长的一半。单位：像素
	 */
	public int Imagesize;
	/**
	 * 两个武器;w1是现在装备的武器
	 */
	public Weapon w1, w2;
	/**
	 * 飞船耐久度
	 */
	public int health;
	/**
	 * 飞船体积
	 */
	public int volume;
	/**
	 * 切换武器
	 */
	public abstract void switchweapon();
	/**
	 * 拾取武器
	 */
	public abstract void updateweapon(Weapon nw);
}
