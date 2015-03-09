package spacecraftelements.Enemy;

import spacecraftelements.Updatable;
import spacecraftelements.SpecialEffect.SpecialEffect;

public abstract class Enemy implements Updatable{
	/**
	 * ������ͼ
	 */
	public String imageID;
	/**
	 * ������ͼ��С
	 */
	public int imagesize;
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
	public int vx,vy;
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
	public int getscore;
	public abstract boolean update();
	
	public abstract SpecialEffect deathwhisper();

}
