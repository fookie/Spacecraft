package spacecraftelements;

/**
 * 
 *
 */
public abstract class SpaceShip implements Updatable{
	/**
	 * 游戏内建坐标
	 */
	Double x,y;
	/**
	 * 飞船加速度，先不考虑
	 */
	Double ax,ay;
	/**
	 * 速度(趋势)，每次更新时用
	 */
	Double vx,vy;
	/**
	 * 贴图地址，以后要是有必要可以改成ImageID[];
	 */
	String ImageID;
	/**
	 * 两个武器;w1是现在装备的武器
	 */
	Weapon w1,w2;
	/**
	 * constructor 给Paulay写吧，这个感觉主要是ElementManager用
	 */
	public SpaceShip()
	{
		
	}
	public abstract boolean update();
}
