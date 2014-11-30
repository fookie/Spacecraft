package spacecraftelements.Ornament;

import spacecraftelements.Updatable;
/**
 *		装饰物相关 
 *		装饰物为固定于地图上的，有血量限制的，可发挥掩体功能的障碍物
 */
public class Ornament implements Updatable{
	/**
	 * 		装饰物坐标
	 */
	public int x, y;
	/**
	 * 		装饰物血量
	 */
	public int health;
	/**
	 * 		装饰物ID
	 */
	public int ID;
	public boolean update() {
		return false;
	}

}
