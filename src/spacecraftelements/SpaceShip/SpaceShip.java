package spacecraftelements.SpaceShip;

import spacecraftelements.Updatable;
import spacecraftelements.Weapon.Weapon;

/**
 * 
 *
 */
public abstract class SpaceShip {
	public int angle;
	/**
	 * ��Ϸ�ڽ�����
	 */
	public int x, y;
	/**
	 * �ɴ����ٶȣ��Ȳ�����
	 */
	public int ax, ay;
	/**
	 * �ٶ�(����)��ÿ�θ���ʱ��
	 */
	public int vx, vy;
	/**
	 * ��ͼ��ַ���Ժ�Ҫ���б�Ҫ���Ըĳ�ImageID[];
	 */
	public String ImageID;
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
