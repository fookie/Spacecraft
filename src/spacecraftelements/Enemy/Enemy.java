package spacecraftelements.Enemy;

import spacecraftelements.Updatable;

public class Enemy implements Updatable{
	/**
	 *  ��������λ��
	 */
	public int x, y;
	/**
	 * 	���˹�����
	 */
	public int damage;
	/**
	 *  �����ƶ��ٶ�
	 */
	public int v;
	/**
	 * 	����Ѫ��
	 */
	public int health;
	/**
	 * 	�������
	 */
	public int volume;
	/**
	 * 	�����Ը���
	 */
	public boolean update() {
		return false;
	}
}
