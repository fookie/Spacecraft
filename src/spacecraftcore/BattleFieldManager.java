package spacecraftcore;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import spacecraftelements.Bullets.Bullet;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.SpaceShip.SpaceShip;

/**
 * BattleFieldManager负责更新战场以及地图，并把信息传递给DisplayManager
 * 
 * @method 添加元素：add();更新战场数据及逻辑 update();
 * 
 * @author Hale
 *
 */
public class BattleFieldManager {
	private List<Bullet> BulletList = new LinkedList<Bullet>();
	private List<Enemy> EnemyList = new LinkedList<Enemy>();
	private SpaceShip Ship = null;
	private int map[][], mapblocksize;
	public int mapx, mapy;
	private String bgloc;
	private DataInputStream mapin;

	public boolean loadmap(String mapaddress) {
		try {
			mapin = new DataInputStream(new BufferedInputStream(
					new FileInputStream(mapaddress)));
		} catch (FileNotFoundException e) {
			System.out.println(mapaddress + " 不存在，故无法加载地图");
			e.printStackTrace();// 会出现红字
			return false;
		}
		int ax = 0, ay = 0;
		try {
			bgloc = mapin.readUTF();
			ax = mapin.readInt();
			ay = mapin.readInt();
			mapx = mapin.readInt();
			mapy = mapin.readInt();
			mapblocksize = mapin.readInt();
			System.out.println("正在处理" + mapaddress + "\n背景地址：" + bgloc + " 区块:"
					+ ax + "x" + ay + "(共" + ax * ay + "个),地图实际大小：" + mapx
					+ "x" + mapy + "(区块大小：" + mapblocksize + ")");
		} catch (IOException e1) {
			System.out.println("在读取地图:" + mapaddress + "时,无法获取基本信息，故无法加载地图");
			e1.printStackTrace();
			return false;
		}
		map = new int[ax][ay];
		for (int column = 0; column < ay; column++) {
			for (int row = 0; row < ax; row++) {
				try {
					map[row][column] = mapin.readInt();
					// System.out.println(" row : " + row + " column: " + column
					// + " :" + map[row][column]);
				} catch (IOException e) {
					System.out.println("处理地图时，到第" + row + "行" + "第" + column
							+ "列，无法被处理，故无法加载地图\n堆栈轨迹：");
					e.printStackTrace();
					return false;
				}
			}
		}
		try {
			mapin.close();
		} catch (IOException e) {
			System.out.println("在读取地图:" + mapaddress + "时,无法关闭流，读取失败。");
			e.printStackTrace();
		}
		System.out.println("读取完成");
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

	public boolean update() {
		if (bgloc == null) {
			System.out.println("没有加载地图，故无法更新战场数据");
			return false;
		}
		// 子弹
		for (int i = 0;i<BulletList.size(); i++) {
			BulletList.get(i).update();
			//计算部分
			//超出边界
			if(BulletList.get(i).x>(mapx/2)||BulletList.get(i).x<-(mapx/2))
			{
				System.out.println(BulletList.get(i).toString()+"removing:out of range");
				BulletList.remove(i);
				i=i-1;
			}
			
			//传递部分
			MainGame.test.repainter.add(name, x, y, degree, layer);
		}
		return true;
	}
}
