package spacecraftcore;

import java.awt.Rectangle;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import displayConsole.Element;
import displayConsole.Gamewindow;
import spacecraftelements.Bullets.Bullet;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.Items.H_bulletcircle;
import spacecraftelements.Items.SpaceItem;
import spacecraftelements.SpaceShip.SpaceShip;
import spacecraftevent.SpaceEvent;

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
	private List<SpaceEvent> EventList = new LinkedList<SpaceEvent>();
	private List<SpaceItem> ItemList = new LinkedList<SpaceItem>();
	public SpaceShip ship = null;
	public int mapx, mapy;// 地图实际大小
	private String bgloc;// 背景地址
	private DataInputStream mapin;
	public int autotarx, autotary;// 按住自动发炮的变量
	public int windowsizex, windowsizey;
	public boolean paused = false;

	public SpaceShip getShip() {
		return ship;
	}

	public void SetShip(SpaceShip ship) {
		this.ship = ship;
	}

	/**
	 * 在这里输入输入窗口大小
	 * 
	 * @param windowsizex
	 * @param windowsizey
	 */
	public BattleFieldManager(int windowsizex, int windowsizey) {
		this.windowsizex = windowsizex;
		this.windowsizey = windowsizey;
	}

	/**
	 * 
	 * 输入一个地图，输出一个窗口。地图有问题return null
	 * 
	 * @param mapaddress
	 * @return
	 */
	public Gamewindow loadmap(String mapaddress) {
		try {
			mapin = new DataInputStream(new BufferedInputStream(
					new FileInputStream(mapaddress)));
		} catch (FileNotFoundException e) {
			System.out.println(mapaddress + " 不存在，故无法加载地图");
			e.printStackTrace();// 会出现红字
			return null;
		}
		try {
			bgloc = mapin.readUTF();
			mapx = mapin.readInt();
			mapy = mapin.readInt();
			System.out.println("正在处理" + mapaddress + "\n背景地址：" + bgloc
					+ "地图实际大小：" + mapx + "x" + mapy);
		} catch (IOException e1) {
			System.out.println("在读取地图:" + mapaddress + "时,无法获取基本信息，故无法加载地图");
			e1.printStackTrace();
			return null;
		}
		try {
			mapin.close();
		} catch (IOException e) {
			System.out.println("在读取地图:" + mapaddress + "时,无法关闭流，读取失败。");
			e.printStackTrace();
		}
		System.out.println("读取完成");
		return new Gamewindow(bgloc, mapx, mapy, windowsizex, windowsizey);
	}

	public boolean add(SpaceEvent e) {
		return EventList.add(e);
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
	 * @param Enemy
	 * @return 是否成功添加
	 */
	public boolean add(Enemy e) {
		return EnemyList.add(e);
	}

	public boolean add(SpaceItem i) {
		return ItemList.add(i);
	}

	public boolean update() {
		if (bgloc == null) {
			System.out.println("没有加载地图，故无法更新战场数据");
			return false;
		}

		collisionupdate();
		// 基本计算
		autoshoot();// 自动射击
		updateevent();// 事件
		updatebullet();// 更新子弹
		updateship();// 更新飞船
		updateEnemy();// 更新敌人
		// 计算碰撞
		// 传递数据
		sendImage();
		return true;
	}

	private void updateevent() {
		for (int i = 0; i < EventList.size(); i++) {
			EventList.get(i).execute();
			if (EventList.get(i).over == true) {
				EventList.remove(i);
				i--;
			}
		}
	}

	private void sendImage() {
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
		// 传递物品
		if (ItemList.size() != 0) {
			for (int i = 0; i < ItemList.size(); i++) {
				MainGame.test.repainter.add(ItemList.get(i).imageID,
						ItemList.get(i).imagesize, ItemList.get(i).x,
						ItemList.get(i).y, 0, 2);
			}
		}
		// 传递敌人
		for (int i = 0; i < EnemyList.size(); i++) {
			MainGame.test.repainter.add(EnemyList.get(i).imageID,
					EnemyList.get(i).imagesize, EnemyList.get(i).x,
					EnemyList.get(i).y,
					-getangle(EnemyList.get(i).vx, EnemyList.get(i).vy), 2);
		}
		if(ship.health<=0)
		{
			MainGame.test.repainter.add_nooffset_element("Images//UI//gameover.png",-200,75, 0, 0);
		}
		if (ship.health == 5) {
			MainGame.test.repainter.add_nooffset_element("Images//hp//hp5.png",
					-800, 600, 0, 2);
		}
		if (ship.health == 4) {
			MainGame.test.repainter.add_nooffset_element("Images//hp//hp4.png",
					-700, 500, 0, 2);
		}
		if (ship.health == 3) {
			MainGame.test.repainter.add_nooffset_element("Images//hp//hp3.png",
					-600, 500, 0, 2);
		}
		if (ship.health == 2) {
			MainGame.test.repainter.add_nooffset_element("Images//hp//hp2.png",
					-500, 300, 0, 2);
		}
		if (ship.health == 1) {
			MainGame.test.repainter.add_nooffset_element("Images//hp//hp1.png",
					-400, 100, 0, 2);
		}

		// 重新绘制
		MainGame.test.repainter.repaint();
	}

	private void updateEnemy() {
		for (int i = 0; i < EnemyList.size(); i++) {
			if (EnemyList.get(i).health < 0) {
				EnemyList.get(i).giveitem();
				EnemyList.remove(i);
				i--;
			} else {
				EnemyList.get(i).update();
			}
		}
	}

	/**
	 * 计算碰撞
	 */

	private void collisionupdate() {
		for (int i = 0; i < EnemyList.size(); i++) {// 这个循环判断是子弹与敌人之间的碰撞
			EnemyList.get(i).update();
			Enemy tEnemy = EnemyList.get(i);
			Rectangle Enemyhitbox = new Rectangle(tEnemy.x - tEnemy.volume / 2,
					tEnemy.y - tEnemy.volume / 2, tEnemy.volume / 2,
					tEnemy.volume / 2);

			Rectangle Shiphitbox = new Rectangle(ship.x - ship.volume / 2,
					ship.y - ship.volume / 2, ship.volume / 2, ship.volume / 2);

			if (Enemyhitbox.intersects(Shiphitbox)) {
				ship.health--;
				EnemyList.remove(i);
				i--;
			}

			for (int j = 0; j < BulletList.size(); j++) {
				Bullet tBullet = BulletList.get(j);
				Rectangle Bullethitbox = new Rectangle(tBullet.x
						- tBullet.volume / 2, tBullet.y - tBullet.volume / 2,
						tBullet.volume / 2, tBullet.volume / 2);

				if (Enemyhitbox.intersects(Bullethitbox)) {
					tEnemy.health = tEnemy.health - tBullet.damage;
					BulletList.remove(j);
					j--;
				}
			}
		}
		for (int i = 0; i < ItemList.size(); i++) {
			SpaceItem tItem = ItemList.get(i);
			Rectangle Itemhitbox = new Rectangle(tItem.x - tItem.imagesize,
					tItem.y - tItem.imagesize, 50, 50);
			if (Itemhitbox.contains(ship.x, ship.y)) {
				tItem.getitem();
				ItemList.remove(i);
				i--;
			}
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
				BulletList.remove(i);
				i = i - 1;
			}
		}
	}

	private void updateship() {
		if(ship.health<=0)
		{
			ship.x=0;
			ship.y=0;
			ship.visx=0;
			ship.visy=0;
			if(MainGame.gametime % 200 == 0)
			{
				add(new H_bulletcircle(0,0));
			}
		}
		
		if (((kw && ks) || (ka && kd)||(ship.health<=0)) != true) {// 如果上下键或者左右键被被同时按下则不操作
			if (kw && (ship.vy <= 0)) {// W向上
				ship.vy = ship.maxv;
			} else if (kd && (ship.vx <= 0)) {// d向右
				ship.vx = ship.maxv;
			} else if (ka && (ship.vx >= 0)) {// a向左
				ship.vx = -ship.maxv;
			} else if (ks && (ship.vy >= 0)) {// s向下
				ship.vy = -ship.maxv;
			}
			if (!kd && !ka) {
				ship.vx = 0;
			}		
			if (!kw && !ks) {
				ship.vy = 0;
			}
		}
		
		
		
		if (((ship.x + ship.vx) > (mapx / 2) || (ship.x + ship.vx) < -(mapx / 2)) != true) {
			ship.x = ship.x + ship.vx;
			ship.visx = ship.visx + ship.vx;
		}
		if (((ship.y + ship.vy) > (mapy / 2) || (ship.y + ship.vy) < -(mapy / 2)) != true) {
			ship.y = ship.y + ship.vy;
			ship.visy = ship.visy + ship.vy;
		}
		ship.angle = currentangle;

	}

	private boolean kw = false;
	private boolean ka = false;
	private boolean ks = false;
	private boolean kd = false;
	private double currentangle;
	public boolean ml = false;
	public long pressedtime = 0;

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

	/**
	 * 这个是管理按键的，注意：无论是按下还是松开都会触发这个!
	 * 
	 * @param i
	 * @param key
	 */
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
		int t1 = (MainGame.test.ml.mx - windowsizex / 2 - 45) - (ship.visx);
		int t2 = (windowsizey / 2 - MainGame.test.ml.my + 45) - (ship.visy);
		currentangle = -getangle(t1, t2);
	}

	/**
	 * 这个负责船体旋转的视觉效果
	 * 
	 * @param x
	 * @param y
	 * @author EveLIN
	 */
	public void Mouseprocessor(int x, int y) {
		int t1 = (x - windowsizex / 2) - (ship.visx);
		int t2 = (windowsizey / 2 - y) - (ship.visy);
		currentangle = -getangle(t1, t2);

	}

	public void autoshoot() {

		if (ml && (MainGame.gametime - pressedtime) % ship.w1.cd == 0) {
			shootprocessor(autotarx, autotary);
		}

	}

	public void shootprocessor(int mx, int my) {
		// 计算大地图坐标
		if (!paused&&ship.health>=0) {
			int cx = mx - windowsizex / 2;
			int cy = windowsizey / 2 - my;
			Bullet[] tBullets = new Bullet[this.ship.w1.count()];
			tBullets = this.ship.w1.shoot(ship.x, ship.y, ship.visx, ship.visy,
					cx, cy, 0);
			for (int i = 0; i < this.ship.w1.count(); i++) {
				add(tBullets[i]);
			}
		}
	}
}