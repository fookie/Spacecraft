package spacecraftelements.Ornament;

import spacecraftelements.Updatable;
/**
 *		ʵ����� 
 *		ʵ��Ϊ�̶��ڵ�ͼ�ϵģ���Ѫ�����Ƶģ��ɷ������幦�ܵ��ϰ���
 */
public class Ornament implements Updatable{
	/**
	 * 		ʵ������
	 */
	public int x, y;
	/**
	 * 		ʵ��Ѫ��
	 */
	public int health;
	/**
	 * 		ʵ�����
	 */
	public int volume;
	/**
	 * 		ʵ��ID
	 */
	public int ID;
	/**
	 * 		ʵ����ͼ
	 */
	public String imageID;
	public boolean update() {
		return false;
	}

}
