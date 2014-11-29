package spacecraftelements.Bullets;

import spacecraftelements.Updatable;

/**
 * 子弹虚拟类
 * @author Paulay
 *
 */
public abstract class Bullet implements Updatable{
	/**
	 * 		子弹贴图路径
	 */
	public String ImageID;
	/**
	 * 		子弹速度
	 */
	public int vx,vy;
	/**
	 * 		子弹加速度（可选）
	 */
	public int ax, ay;
	/**
	 * 		子弹初始生成位置
	 */
	public int x, y;
	/**
	 *		子弹朝向角度 	
	 */
	public int angle;
	/**
	 * 		子弹伤害值
	 */
	public int damage;
	/**
	 * 		子弹所属（跟踪类武器需要）
	 * 		用于子弹判断敌我
	 */
	public int faction;
	/**
	 * 		子弹体积
	 */
	public int volume;
	/**
	 * 		子弹编号
	 */
	public int ID;
	public abstract boolean update();
}
