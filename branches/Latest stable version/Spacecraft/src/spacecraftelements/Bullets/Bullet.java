package spacecraftelements.Bullets;

import spacecraftelements.Updatable;

/**
 * �ӵ�������
 * @author Paulay
 *
 */
public abstract class Bullet implements Updatable{
	/**
	 * 		�ӵ���ͼ·�� The image path in disk
	 */
	public String ImageID;
	/**
	 * ��ͼ�Ĵ�С��������ͼƬ�İ뾶����λ������ images' size,pix
	 */
	public int imagesizex,imagesizey;
	/**
	 * 		�ӵ��ٶ�  bullets' speed
	 */
	public double vx,vy;
	/**
	 * 		�ӵ����ٶȣ���ѡ�� bullets' acceleration
	 */
	public double ax, ay;
	/**
	 * 		�ӵ���ʼ����λ�� initial position
	 */
	public double x, y;
	/**
	 *		�ӵ�����Ƕ� 	bullets' heading direction
	 */
	public double angle;
	/**
	 * 		�ӵ��˺�ֵ  
	 */
	public int damage;
	/**
	 * 		�ӵ�������������������Ҫ��
	 * 		�����ӵ��жϵ���
	 */
	public int faction;
	/**
	 * 		�ӵ����
	 */
	public int volume;
	/**
	 * 		�ӵ����
	 */
	public int ID;
	public abstract boolean update();
}
