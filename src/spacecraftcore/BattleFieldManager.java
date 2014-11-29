package spacecraftcore;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import spacecraftelements.*;

/**
 * BattleFieldManager�������ս���Լ���ͼ��������Ϣ���ݸ�DisplayManager
 * @method
 * ���Ԫ�أ�add();
 * 
 * @author Hale
 *
 */
public class BattleFieldManager {
	private List<Bullet> BulletList = new LinkedList<Bullet>();
	private List<Enemy> EnemyList = new LinkedList<Enemy>();
	private SpaceShip Ship = null;
	private int map[][],mapblocksize;
	private String bgloc;
	private DataInputStream mapin;

	public boolean loadmap(String mapaddress) {
		try {
			mapin = new DataInputStream(new BufferedInputStream(
					new FileInputStream(mapaddress)));
		} catch (FileNotFoundException e) {
			System.out.println(mapaddress + " �����ڣ����޷����ص�ͼ");
			e.printStackTrace();// ����ֺ���
			return false;
		}
		int ax = 0, ay = 0,x=0,y=0;
		try {
			bgloc = mapin.readUTF();
			ax = mapin.readInt();
			ay = mapin.readInt();
			x = mapin.readInt();
			y = mapin.readInt();
			mapblocksize=mapin.readInt();
			System.out.println("���ڴ���"+mapaddress+"\n������ַ��"+bgloc+" ����:"+ax+"x"+ay+"(��"+ax*ay+"��),��ͼʵ�ʴ�С��"+x+"x"+y+"(�����С��"+mapblocksize+")");
		} catch (IOException e1) {
			System.out.println("�ڶ�ȡ��ͼ:" + mapaddress + "ʱ,�޷���ȡ������Ϣ�����޷����ص�ͼ");
			e1.printStackTrace();
			return false;
		}
		map = new int[ax][ay];
		for (int column = 0; column < ay; column++) {
			for (int row = 0; row < ax; row++) {
				try {
					map[row][column] = mapin.readInt();
//					System.out.println(" row : " + row + " column: " + column
//							+ " :" + map[row][column]);
				} catch (IOException e) {
					System.out.println("�����ͼʱ������" + row
							+ "��" + "��" + column + "�У��޷����������޷����ص�ͼ\n��ջ�켣��");
					e.printStackTrace();
					return false;
				}
			}
		}
		try {
			mapin.close();
		} catch (IOException e) {
			System.out.println("�ڶ�ȡ��ͼ:" + mapaddress + "ʱ,�޷��ر�������ȡʧ�ܡ�");
			e.printStackTrace();
		}
		System.out.println("��ȡ���");
		return true;
	}

	/**
	 * ����ӵ�
	 * 
	 * @param Bullet
	 * @return �Ƿ�ɹ����
	 */
	public boolean add(Bullet b) {
		return BulletList.add(b);
	}

	/**
	 * ���SpaceShip��ֻ�����һ��
	 * 
	 * @param SpaceShip
	 * @return �Ƿ�ɹ����
	 */
	public boolean add(SpaceShip s) {
		if (Ship == null) {
			Ship = s;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * ��ӵ���
	 * 
	 * @param Bullet
	 * @return �Ƿ�ɹ����
	 */
	public boolean add(Enemy e) {
		return EnemyList.add(e);
	}
	public boolean update()
	{
		if(bgloc==null)
		{
			System.out.println("û�м��ص�ͼ�����޷�����ս������");
			return false;
		}
		//�ӵ�
		
		return true;
	}
}
