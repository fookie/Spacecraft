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
	public int Imagesize;
	/**
	 * 		�ӵ��ٶ�  bullets' speed
	 */
	public int vx,vy;
	/**
	 * 		�ӵ����ٶȣ���ѡ�� bullets' acceleration
	 */
	public int ax, ay;
	/**
	 * 		�ӵ���ʼ����λ�� initial position when borned
	 */
	public int x, y;
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
