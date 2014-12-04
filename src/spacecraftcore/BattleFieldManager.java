package spacecraftcore;

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
	public int mapx, mapy;
	private String bgloc;
	private DataInputStream mapin;

	public SpaceShip getShip() {
		return ship;
	}

	public void SetShip(SpaceShip ship) {
		this.ship = ship;
	}

	public boolean loadmap(String mapaddress) {
		MainGame.test.setTitle("Spacecraft - loding:" + mapaddress);
		try {
			mapin = new DataInputStream(new BufferedInputStream(
					new FileInputStream(mapaddress)));
		} catch (FileNotFoundException e) {
			System.out.println(mapaddress + " 不存在，故无法加载地图");
			e.printStackTrace();// 会出现红字
			return false;
		}
		try {
			bgloc = mapin.readUTF();
			mapx = mapin.readInt();
			mapy = mapin.readInt();
			System.out.println("正在处理" + mapaddress + "\n背景地址：" + bgloc +"地图实际大小：" + mapx
					+ "x" + mapy );
		} catch (IOException e1) {
			System.out.println("在读取地图:" + mapaddress + "时,无法获取基本信息，故无法加载地图");
			e1.printStackTrace();
			return false;
		}
		try {
			mapin.close();
		} catch (IOException e) {
			System.out.println("在读取地图:" + mapaddress + "时,无法关闭流，读取失败。");
			e.printStackTrace();
		}
		System.out.println("读取完成");
		MainGame.test.setMapsize(mapx, mapy);
		MainGame.test.setTitle("Spacecraft - running:" + mapaddress);
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
		// 敌人
		updateEnemy();
		// 传递到画面

		// 清空
		MainGame.test.repainter.le = new LinkedList<Element>();
		// 传递飞船并计算偏移量
		MainGame.test.repainter.computeOffset(ship);
		// 传递子弹
		for (int i = 0; i < BulletList.size(); i++) {
			MainGame.test.repainter.add(BulletList.get(i).ImageID,
					BulletList.get(i).Imagesize, BulletList.get(i).x,
					BulletList.get(i).y,
					-getangle(BulletList.get(i).vx, BulletList.get(i).vy), 2);
		}
		// 传递敌人
		for (int i = 0; i < EnemyList.size(); i++) {
			MainGame.test.repainter.add(EnemyList.get(i).imageID,
					EnemyList.get(i).imagesize, EnemyList.get(i).x,
					EnemyList.get(i).y, 0, 2);
		}

		// 重新绘制
		MainGame.test.repainter.repaint();
		return true;
	}

	private void updateEnemy() {
		for (int i = 0; i < EnemyList.size(); i++) {
			EnemyList.get(i).update();
		}

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
		ship.visx = ship.visx + ship.vx;
		ship.y = ship.y + ship.vy;
		ship.visy = ship.visy + ship.vy;
		ship.angle = currentangle;

	}

	private boolean kw = false;
	private boolean ka = false;
	private boolean ks = false;
	private boolean kd = false;
	private double currentangle;

	/**
	 * 
	 * @param x
	 * @param y
	 * @return
	 * @author EveLIN
	 */
	public double getangle(int x, int y) {
		double ans;
		double temp = (double) y / x;
		if (y > 0) {
			if (x == 0) {
				return 90.00;
			}
			if (x > 0) {
				ans = (Math.atan(temp) * (180 / Math.PI));
				return ans;
			}
			if (x < 0) {
				ans = 180.00 - (Math.atan(-temp) * (180 / Math.PI));
				return ans;
			}
		}
		if (y < 0) {
			if (x == 0)
				return 270.00;
			if (x > 0) {
				ans = 360.00 - (Math.atan(-temp) * (180 / Math.PI));
				return ans;
			}
			if (x < 0) {
				ans = 180.00 + (Math.atan(temp) * (180 / Math.PI));
				return ans;
			}
		}
		if (y == 0) {
			if (x >= 0) {
				return 0.00;
			} else {
				return 180.00;
			}

		}
		return 0;
	}

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
		int t1 = (MainGame.test.ml.mx - 400 - 45) - (ship.visx);
		int t2 = (300 - MainGame.test.ml.my + 45) - (ship.visy);
		currentangle = -getangle(t1, t2);
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @author EveLIN
	 */
	public void Mouseprocessor(int x, int y) {
		int t1 = (x - 400) - (ship.visx);
		int t2 = (300 - y) - (ship.visy);
		currentangle = -getangle(t1, t2);
//		 System.out.println("x:"+x+"  y:"+y+"    x2:"+(x-400-45)+"  y2  "+(300-y+45));
//		 System.out.println("t1:"+t1+"  t2:  "+t2+"a:"+currentangle);
//		 System.out.println("visx:"+ship.visx+"  vixy:  "+ship.visy+"\n");
//		System.out.println("x:"+ship.x+"  y:  "+ship.y);
	}
	public void shootprocessor(int mx,int my)
	{	
		//计算大地图坐标
		int cx=mx-400;//400=1/2windowsizex
		int cy=300-my;
		System.out.println("shooting: visx:"+ship.visx+" visy:"+ship.visy+"cx:"+cx+"cy"+cy);
		add(this.ship.w1.shoot(ship.x,ship.y,ship.visx, ship.visy, cx, cy));
	}
}