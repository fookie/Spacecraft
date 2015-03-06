package spacecraftelements.Ornament;

import spacecraftelements.Updatable;
/**
 *		特效相关
 */
public abstract class Ornament implements Updatable{
	/**
	 * 		特效坐标
	 */
	public int x, y;
	/**
	 * 		特效贴图
	 */
	public String imageID;
	public int imagesize;
	/**
	 * 特效是否结束
	 */
	public boolean over;
	public abstract String getImage();
	}

