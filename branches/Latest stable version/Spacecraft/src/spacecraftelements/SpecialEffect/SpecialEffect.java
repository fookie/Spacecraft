package spacecraftelements.SpecialEffect;

import spacecraftelements.Updatable;
/**
 *		��Ч���
 */
public abstract class SpecialEffect implements Updatable{
	/**
	 * 		��Ч����
	 */
	public int x, y;
	/**
	 * 		��Ч��ͼ
	 */
	public String imageID;
	public int imagesizex,imagesizey;
	/**
	 * ��Ч�Ƿ����
	 */
	public boolean over;
	public abstract String getImage();
	}

