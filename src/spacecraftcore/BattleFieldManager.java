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
 * 
 * @author Hale
 *
 */
public class BattleFieldManager {
	private List<Bullet> BulletList = new LinkedList<Bullet>();
	private List<Enemy> EnemyList = new LinkedList<Enemy>();
	private SpaceShip Ship = null;
	private int map[][];
	private DataInputStream mapin;
	public boolean loadmap(String mapaddress, int x, int y) {
		try {
			mapin = new DataInputStream(
					new BufferedInputStream(new FileInputStream(mapaddress)));
		} catch (FileNotFoundException e) {
			System.out.println(mapaddress + " �����ڣ����޷����ص�ͼ");
			e.printStackTrace();// ����ֺ���
			return false;
		}
		map = new int[x][y];
		for (int column = 0; column < y; column++) {
			for (int row = 0; row < x; row++) {
				try {
					map[row][column]=mapin.readInt();
				} catch (IOException e) {
					System.out.println("�ڶ�ȡ��ͼ�� row: "+row+" colum: "+column+" �޷�������ȡ�����ݣ����޷����ص�ͼ");
					e.printStackTrace();
					return false;
				}	
			}
		}
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

}
