package spacecraftelements.Enemy;

import spacecraftelements.Updatable;
import spacecraftelements.SpecialEffect.SpecialEffect;

public abstract class Enemy implements Updatable{
	/**
	 * ������ͼ image path
	 */
	public String imageID;
	/**
	 * ������ͼ��С image size
	 */
	public int imagesize;
	/**
	 *  ��������λ�� initial position
	 */
	public int x, y;
	/**
	 * 	���˹����� damage
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
	public double rotation;
	public int getscore;
	public abstract boolean update();
	public boolean hit=false;
    public static int centerx,centery;
	
	public abstract SpecialEffect deathwhisper();

}
