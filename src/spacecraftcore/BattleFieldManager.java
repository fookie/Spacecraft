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
	private int map[][], mapblocksize;
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
		int ax = 0, ay = 0;
		try {
			bgloc = mapin.readUTF();
			ax = mapin.readInt();
			ay = mapin.readInt();
			mapx = mapin.readInt();
			mapy = mapin.readInt();
			mapblocksize = mapin.readInt();
			System.out.println("���ڴ���" + mapaddress + "\n������ַ��" + bgloc + " ����:"
					+ ax + "x" + ay + "(��" + ax * ay + "��),��ͼʵ�ʴ�С��" + mapx
					+ "x" + mapy + "(�����С��" + mapblocksize + ")");
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
				} catch (IOException e) {
					System.out.println("�����ͼʱ������" + row + "��" + "��" + column
							+ "�У��޷����������޷����ص�ͼ\n��ջ�켣��");
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
		//����
		updateEnemy();
		// ���ݵ�����

		// ���
		MainGame.test.repainter.le = new LinkedList<Element>();
		MainGame.test.repainter.computeOffset(ship);
		// ���ݷɴ�
//		if (ship != null)
//			MainGame.test.repainter.add(ship.ImageID, ship.x, ship.y,
//					ship.angle, 2);
		for (int i = 0; i < BulletList.size(); i++) {
			MainGame.test.repainter.add(BulletList.get(i).ImageID,
					BulletList.get(i).x, BulletList.get(i).y,
					getangle(BulletList.get(i).vx, BulletList.get(i).vy), 2);
		}
		for (int i = 0; i < EnemyList.size(); i++) {
			MainGame.test.repainter.add(EnemyList.get(i).imageID,
					EnemyList.get(i).x, EnemyList.get(i).y,
					0, 2);
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
		ship.visx=ship.visx+ship.vx;
		ship.y = ship.y + ship.vy;
		ship.visy=ship.visy+ship.vy;
		ship.angle = currentangle;

	}

	public int getangle(int x, int y) {
		int ans;
		if (y > 0) {
			if (x == 0) {
				return 90;
			}
			if (x > 0) {
				ans = (int) (Math.atan(y / x) * (180 / Math.PI));
				return ans;
			}
			if (x < 0) {
				ans = 180 - (int) (Math.atan(y / -x) * (180 / Math.PI));
				return ans;
			}
		}
		if (y < 0) {
			if (x == 0)
				return 270;
			if (x > 0) {
				ans = 360 - (int) (Math.atan(-y / x) * (180 / Math.PI));
				return ans;
			}
			if (x < 0) {
				ans = 180 + (int) (Math.atan(-y / -x) * (180 / Math.PI));
				return ans;
			}
		}
		if (y == 0) {
			if (x >= 0) {
				return 0;
			} else {
				return 180;
			}

		}
		/*
		 * if (x == 0) { if (y > 0) return 90; if (y < 0) return 270; if (y ==
		 * 0) return 0; } else if (y == 0) { if (x > 0) return 90; if (x < 0)
		 * return 270; } else if (y > 0) { ans = (int) (Math.atan(100 * y / 100
		 * * x) * (180 / Math.PI));
		 * //System.out.println("x:"+x+" y:"+y+" ans="+ans); return ans; } else
		 * if (y < 0) { ans = (int) (Math.atan(100 * y / 100 * x) * (180 /
		 * Math.PI)) + 180; return ans; } return 0;
		 */
		return 0;
	}

	private boolean kw = false;
	private boolean ka = false;
	private boolean ks = false;
	private boolean kd = false;
	private int currentangle;

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
		int t1 = MainGame.test.ml.mx - ship.x - 45;
		int t2 = MainGame.test.ml.my - ship.y - 45;
		currentangle = getangle(t1, t2);
	}

	public void Mouseprocessor(int x, int y) {
		int t1 = x - ship.x - 45;
		int t2 = y - ship.y - 45;
		currentangle = getangle(t1, t2);

		// System.out.println(t1+" "+t2+" "+currentangle);
	}
}