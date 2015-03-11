package spacecraftelements.Bullets;

import spacecraftelements.Updatable;

/**
 * 子弹虚拟类
 * @author Paulay
 *
 */
public abstract class Bullet implements Updatable{
	/**
	 * 		子弹贴图路径 The image path in disk
	 */
	public String ImageID;
	/**
	 * 贴图的大小，正方形图片的半径。单位：像素 images' size,pix
	 */
	public int Imagesize;
	/**
	 * 		子弹速度  bullets' speed
	 */
	public int vx,vy;
	/**
	 * 		子弹加速度（可选） bullets' acceleration
	 */
	public int ax, ay;
	/**
	 * 		子弹初始生成位置 initial position when borned
	 */
	public int x, y;
	/**
	 *		子弹朝向角度 	bullets' heading direction
	 */
	public double angle;
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
