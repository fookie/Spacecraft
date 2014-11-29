package spacecraftelements.Bullets;
/**
 * 子弹虚拟类
 * @author Paulay
 *
 */
public abstract class Bullet {
	/**
	 * 		子弹贴图路径
	 */
	public String ImageID;
	/**
	 * 		子弹速度
	 */
	public Double vx,vy;
	/**
	 * 		子弹加速度（可选）
	 */
	public Double ax, ay;
	/**
	 * 		子弹初始生成位置
	 */
	public Double x, y;
	/**
	 *		子弹朝向角度 
	 */
	public Double angle;
	/**
	 * 		子弹伤害值
	 */
	public Double damage;
	/**
	 * 		子弹所属（跟踪类武器需要）
	 * 		用于子弹判断敌我
	 */
	public int faction;
}
