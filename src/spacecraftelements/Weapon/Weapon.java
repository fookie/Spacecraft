package spacecraftelements.Weapon;

import spacecraftelements.Bullets.BasicBullet;
import spacecraftelements.Bullets.Bullet;

/**
 * ����Ļ��ȿ�������ҷɴ�������Ҳ�����ǵ��˵�����
 */
public abstract class Weapon {
	/**
	 * ָ���ӵ�ID
	 */
	public int defaultbullet;
	/**
	 * ���д�С
	 */
	public int clip;
	/**
	 * װ��ʱ��
	 */
	public int reload;
	/**
	 * �����ٶ�
	 */
	public int iv;
	/**
	 * ����ID
	 */
	public int ID;

	/**
	 * ����method
	 * 
	 * @param
	 */
	public abstract Bullet shoot(int x,int y,int visx, int visy, int cx, int cy);
}
