package spacecraftelements.Ornament;

import spacecraftelements.Updatable;
/**
 *		实体相关 
 *		实体为固定于地图上的，有血量限制的，可发挥掩体功能的障碍物
 */
public class Ornament implements Updatable{
	/**
	 * 		实体坐标
	 */
	public int x, y;
	/**
	 * 		实体血量
	 */
	public int health;
	/**
	 * 		实体体积
	 */
	public int volume;
	/**
	 * 		实体ID
	 */
	public int ID;
	/**
	 * 		实体贴图
	 */
	public String imageID;
	public boolean update() {
		return false;
	}

}
