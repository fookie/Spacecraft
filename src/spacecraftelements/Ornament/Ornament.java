package spacecraftelements.Ornament;

import spacecraftelements.Updatable;
/**
 *		װ������� 
 *		װ����Ϊ�̶��ڵ�ͼ�ϵģ���Ѫ�����Ƶģ��ɷ������幦�ܵ��ϰ���
 */
public class Ornament implements Updatable{
	/**
	 * 		װ��������
	 */
	public int x, y;
	/**
	 * 		װ����Ѫ��
	 */
	public int health;
	/**
	 * 		װ����ID
	 */
	public int ID;
	public boolean update() {
		return false;
	}

}
