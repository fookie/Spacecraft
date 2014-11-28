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
 * BattleFieldManager负责更新战场以及地图，并把信息传递给DisplayManager
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
	public boolean loadmap(String mapaddress) {
		try {
			mapin = new DataInputStream(
					new BufferedInputStream(new FileInputStream(mapaddress)));
		} catch (FileNotFoundException e) {
			System.out.println(mapaddress + " 不存在，故无法加载地图");
			e.printStackTrace();// 会出现红字
			return false;
		}
		try {
			System.out.println(mapin.readUTF());
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		int x = 0;
		try {
			x = mapin.readInt();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		int y = 0;
		try {
			y = mapin.readInt();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		map = new int[x][y];
		for (int column = 0; column < y; column++) {
			for (int row = 0; row < x; row++) {
				try {
					map[row][column]=mapin.readInt();
					System.out.println(" row : "+row+" column: "+column+" :"+map[row][column]);
				} catch (IOException e) {
					System.out.println("在读取地图:"+mapaddress+"时"+"第"+row+"行"+"第"+column+ "列，无法被处理或读取，故无法加载地图\n堆栈轨迹：");
					e.printStackTrace();
					return false;
				}	
			}
		}
		return true;

	}

	/**
	 * 添加子弹
	 * 
	 * @param Bullet
	 * @return 是否成功添加
	 */
	public boolean add(Bullet b) {
		return BulletList.add(b);
	}

	/**
	 * 添加SpaceShip，只能添加一次
	 * 
	 * @param SpaceShip
	 * @return 是否成功添加
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
	 * 添加敌人
	 * 
	 * @param Bullet
	 * @return 是否成功添加
	 */
	public boolean add(Enemy e) {
		return EnemyList.add(e);
	}

}
