package spacecraftelements.Bullets;

import spacecraftelements.Updatable;

/**
 * �ӵ�������
 * @author Paulay
 *
 */
public abstract class Bullet implements Updatable{
	/**
	 * 		�ӵ���ͼ·��
	 */
	public String ImageID;
	/**
	 * 		�ӵ��ٶ�
	 */
	public Double vx,vy;
	/**
	 * 		�ӵ����ٶȣ���ѡ��
	 */
	public Double ax, ay;
	/**
	 * 		�ӵ���ʼ����λ��
	 */
	public Double x, y;
	/**
	 *		�ӵ�����Ƕ� 
	 */
	public Double angle;
	/**
	 * 		�ӵ��˺�ֵ
	 */
	public Double damage;
	/**
	 * 		�ӵ�������������������Ҫ��
	 * 		�����ӵ��жϵ���
	 */
	public int faction;
	public abstract boolean update();
}
