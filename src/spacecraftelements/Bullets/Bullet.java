package spacecraftelements.Bullets;
/**
 * �ӵ�������
 * @author Paulay
 *
 */
public abstract class Bullet {
	/**
	 * 		�ӵ���ͼ·��
	 */
	String ImageID;
	/**
	 * 		�ӵ��ٶ�
	 */
	Double vx,vy;
	/**
	 * 		�ӵ����ٶȣ���ѡ��
	 */
	Double ax, ay;
	/**
	 * 		�ӵ���ʼ����λ��
	 */
	Double x, y;
	/**
	 *		�ӵ�����Ƕ� 
	 */
	Double angle;
	/**
	 * 		�ӵ��˺�ֵ
	 */
	Double damage;
	/**
	 * 		�ӵ�������������������Ҫ��
	 * 		�����ӵ��жϵ���
	 */
	int faction;
}
