package spacecraftelements.Weapon;

import spacecraftelements.Bullets.Bullet;

/**
 * ����Ļ��ȿ�������ҷɴ�������Ҳ�����ǵ��˵�����
 */
public abstract class Weapon {
	/**
	 * ����ID
	 */
	public int weaponID;
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
	 * ������
	 */
	public int cd;
	/**
	 * ɢ������
	 */
	public int count = 1;

	/**
	 * ����method x�� yΪ�������ڽ������λ�� visx, visyΪ��������Ļ�����λ�� cx, cyΪ�������Ļ�ϵ�����
	 * 
	 * @param
	 */
	public abstract Bullet[] shoot(int x, int y, int visx, int visy, int cx,
			int cy, int f);

	/**
	 * ����ɢ����
	 */
	public int count() {
		return count;
	}
}
