package spacecraftelements.Ornament;

import spacecraftelements.Updatable;
/**
 *		��Ч���
 */
public abstract class Ornament implements Updatable{
	/**
	 * 		��Ч����
	 */
	public int x, y;
	/**
	 * 		��Ч��ͼ
	 */
	public String imageID;
	public int imagesize;
	/**
	 * ��Ч�Ƿ����
	 */
	public boolean over;
	public abstract String getImage();
	}

