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
 * BattleFieldManager�������ս���Լ���ͼ��������Ϣ���ݸ�DisplayManager
 * 
 * @method ���Ԫ�أ�add();����ս�����ݼ��߼� update();
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
			System.out.println(mapaddress + " �����ڣ����޷����ص�ͼ");
			e.printStackTrace();// ����ֺ���
			return false;
		}
		try {
			bgloc = mapin.readUTF();
			mapx = mapin.readInt();
			mapy = mapin.readInt();
			System.out.println("���ڴ���" + mapaddress + "\n������ַ��" + bgloc +"��ͼʵ�ʴ�С��" + mapx
					+ "x" + mapy );
		} catch (IOException e1) {
			System.out.println("�ڶ�ȡ��ͼ:" + mapaddress + "ʱ,�޷���ȡ������Ϣ�����޷����ص�ͼ");
			e1.printStackTrace();
			return false;
		}
		try {
			mapin.close();
		} catch (IOException e) {
			System.out.println("�ڶ�ȡ��ͼ:" + mapaddress + "ʱ,�޷��ر�������ȡʧ�ܡ�");
			e.printStackTrace();
		}
		System.out.println("��ȡ���");
		MainGame.test.setMapsize(mapx, mapy);
		MainGame.test.setTitle("Spacecraft - running:" + mapaddress);
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
		if (ship == null) {
			ship = s;
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

	public boolean update() {
		if (bgloc == null) {
			System.out.println("û�м��ص�ͼ�����޷�����ս������");
			return false;
		}
		// ��������
		// �ӵ�
		updatebullet();
		// �ɴ�
		updateship();
		// ����
		updateEnemy();
		// ���ݵ�����

		// ���
		MainGame.test.repainter.le = new LinkedList<Element>();
		// ���ݷɴ�������ƫ����
		MainGame.test.repainter.computeOffset(ship);
		// �����ӵ�
		for (int i = 0; i < BulletList.size(); i++) {
			MainGame.test.repainter.add(BulletList.get(i).ImageID,
					BulletList.get(i).Imagesize, BulletList.get(i).x,
					BulletList.get(i).y,
					-getangle(BulletList.get(i).vx, BulletList.get(i).vy), 2);
		}
		// ���ݵ���
		for (int i = 0; i < EnemyList.size(); i++) {
			MainGame.test.repainter.add(EnemyList.get(i).imageID,
					EnemyList.get(i).imagesize, EnemyList.get(i).x,
					EnemyList.get(i).y, 0, 2);
		}

		// ���»���
		MainGame.test.repainter.repaint();
		return true;
	}

	private void updateEnemy() {
		for (int i = 0; i < EnemyList.size(); i++) {
			EnemyList.get(i).update();
		}

	}

	/**
	 * �ƶ��ӵ������Զ��Ƴ������ӵ�
	 */
	private void updatebullet() {
		for (int i = 0; i < BulletList.size(); i++) {
			BulletList.get(i).update();
			// ���㲿��
			// �����߽�
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
		if (((kw && ks) || (ka && kd)) != true) {// ������¼��������Ҽ�����ͬʱ�����򲻲���
			if (kw && (ship.vy <= 0)) {// W����
				ship.vy = 10;
			} else if (kd && (ship.vx <= 0)) {// d����
				ship.vx = 10;
			} else if (ka && (ship.vx >= 0)) {// a����
				ship.vx = -10;
			} else if (ks && (ship.vy >= 0)) {// s����
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
		//������ͼ����
		int cx=mx-400;//400=1/2windowsizex
		int cy=300-my;
		System.out.println("shooting: visx:"+ship.visx+" visy:"+ship.visy+"cx:"+cx+"cy"+cy);
		add(this.ship.w1.shoot(ship.x,ship.y,ship.visx, ship.visy, cx, cy));
	}
}