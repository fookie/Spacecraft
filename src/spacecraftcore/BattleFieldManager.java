package spacecraftcore;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import displayConsole.Element;
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
	public SpaceShip ship = null;
	private int map[][], mapblocksize;
	public int mapx, mapy;
	private String bgloc;
	private DataInputStream mapin;

	public SpaceShip getShip() {
		return ship;
	}

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
		if (ship == null) {
			ship = s;
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
		// 基本计算
		// 子弹
		updatebullet();
		// 飞船
		updateship();

		// 传递到画面

		// 清空
		MainGame.test.repainter.le = new LinkedList<Element>();
		// 传递飞船
		if (ship != null)
			MainGame.test.repainter.add(ship.ImageID, ship.x + 400,
					300 - ship.y, getangle(ship.x, ship.y), 2);
		for (int i = 0; i < BulletList.size(); i++) {
			MainGame.test.repainter.add(BulletList.get(i).ImageID,
					BulletList.get(i).x + 400, 300 - BulletList.get(i).y,
					getangle(BulletList.get(i).vx, BulletList.get(i).vy), 2);
		}
		// 重新绘制
		MainGame.test.repainter.repaint();
		return true;
	}

	/**
	 * 移动子弹并且自动移除出界子弹
	 */
	private void updatebullet() {
		for (int i = 0; i < BulletList.size(); i++) {
			BulletList.get(i).update();
			// 计算部分
			// 超出边界
			if (BulletList.get(i).x > (mapx / 2)
					|| BulletList.get(i).x < -(mapx / 2)
					|| BulletList.get(i).y > (mapy / 2)
					|| BulletList.get(i).y < -(mapy / 2)) {
				// System.out.println(BulletList.get(i).toString()+"remove:out of range");
				BulletList.remove(i);
				i = i - 1;
			}
		}
	}

	private void updateship() {
		if (((kw && ks) || (ka && kd)) != true) {// 如果上下键或者左右键被被同时按下则不操作
			if (kw && (ship.vy <= 0)) {// W向上
				ship.vy = 10;
			} else if (kd && (ship.vx <= 0)) {// d向右
				ship.vx = 10;
			} else if (ka && (ship.vx >= 0)) {// a向左
				ship.vx = -10;
			} else if (ks && (ship.vy >= 0)) {// s向下
				ship.vy = -10;
			}
			if (!kd && !ka) {
				ship.vx = 0;
			}
			if (!kw && !ks) {
				ship.vy = 0;
			}
		}
		ship.x = ship.x + ship.vx;
		ship.y = ship.y + ship.vy;
	}

	public int getangle(int x, int y) {
		int ans;
		if (x == 0) {
			if (y > 0)
				return 0;
			else
				return 180;
		} else if (y == 0) {
			if (x > 0)
				return 90;
			if (x < 0)
				return 270;
		} else if (y > 0) {
			ans = (int) (Math.atan(100 * y / 100 * x) * (180 / Math.PI));
			return ans;
		} else if (y < 0) {
			ans = (int) (Math.atan(100 * y / 100 * x) * (180 / Math.PI)) + 180;
			return ans;
		}
		return 0;
	}

	private boolean kw = false;
	private boolean ka = false;
	private boolean ks = false;
	private boolean kd = false;

	public void Keyprocesser(Boolean i, char key) {

		if (key == 'w') {
			kw = i;
		} else if (key == 'a') {
			ka = i;
		} else if (key == 's') {
			ks = i;
		} else if (key == 'd') {
			kd = i;

		}
	}
}