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
	public int vx,vy;
	/**
	 * 		�ӵ����ٶȣ���ѡ��
	 */
	public int ax, ay;
	/**
	 * 		�ӵ���ʼ����λ��
	 */
	public int x, y;
	/**
	 *		�ӵ�����Ƕ� 	
	 */
	public int angle;
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
