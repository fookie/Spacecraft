package spacecraftelements.SpaceShip;

import spacecraftelements.Weapon.Weapon;

/**
 * 
 *
 */
public abstract class SpaceShip {
	public double angle;
	/**
	 * ��Ϸ�ڽ�����
	 */
	public int x, y;
	/**
	 * ��Ļ�ϵ�����
	 */
	public int visx,visy;
	/**
	 * �ɴ����ٶ�,����(ֻ���ƶ��й�)
	 */
	public int a,m;
	/**
	 * ����ٶ�
	 */
	public int maxv;
	/**
	 * �����ٶ�
	 * �ڼ��㾵ͷʱ����
	 */
	public int nowv;
	/**
	 * �ٶ�(����)��ÿ�θ���ʱ��
	 */
	public int vx, vy;
	/*�ĳ�ImageID[];
	 */
	public String ImageID;
	/**
	 * ��ͼ�Ĵ�С��������ͼƬ�߳���һ�롣��λ������
	 */
	public int Imagesize;
	/**
	 * ��������;w1������װ��������
	 */
	public Weapon w1, w2;
	/**
	 * �ɴ��;ö�
	 */
	public int health;
	/**
	 * �ɴ����
	 */
	public int volume;
	/**
	 * �л�����
	 */
	public abstract void switchweapon();
	/**
	 * ʰȡ����
	 */
	public abstract void updateweapon(Weapon nw);
}
