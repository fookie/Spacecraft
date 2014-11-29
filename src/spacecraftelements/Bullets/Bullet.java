package spacecraftelements.Bullets;

public abstract class Bullet {
	String ImageID;
	/**
	 * 		子弹贴图路径
	 */
	Double vx,vy;
	/**
	 * 		子弹速度
	 */
	Double ax, ay;
	/**
	 * 		子弹加速度（可选）
	 */
	Double x, y;
	/**
	 * 		子弹初始生成位置
	 */
	Double angle;
	/**
	 *		子弹朝向角度 
	 */
	Double damage;
	/**
	 * 		子弹伤害值
	 */
}
