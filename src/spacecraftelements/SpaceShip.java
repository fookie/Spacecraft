package spacecraftelements;

/**
 * 
 *
 */
public abstract class SpaceShip implements Updatable{
	/**
	 * ��Ϸ�ڽ�����
	 */
	Double x,y;
	/**
	 * �ɴ����ٶȣ��Ȳ�����
	 */
	Double ax,ay;
	/**
	 * ���ƣ�ÿ�θ���ʱ��
	 */
	Double tx,ty;
	/**
	 * ��ͼ��ַ���Ժ�Ҫ���б�Ҫ���Ըĳ�ImageID[];
	 */
	String ImageID;
	/**
	 * ��������;w1������װ��������
	 */
	Weapon w1,w2;
	/**
	 * constructor ��Paulayд�ɣ�����о���Ҫ��ElementManager��
	 */
	public SpaceShip()
	{
		
	}
	public abstract boolean update();
}
