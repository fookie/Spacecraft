package spacecraftelements.SpecialEffect;

import spacecraftelements.Updatable;
/**
 *		特效相关
 */
public abstract class SpecialEffect implements Updatable{
	/**
	 * 		特效坐标
	 */
	public int x, y;
	/**
	 * 		特效贴图
	 */
	public String imageID;
	public int imagesizex,imagesizey;
	/**
	 * 特效是否结束
	 */
	public boolean over;
	public abstract String getImage();
	}

