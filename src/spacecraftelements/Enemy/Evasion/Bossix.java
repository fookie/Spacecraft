package spacecraftelements.Enemy.Evasion;

import spacecraftcore.BattleFieldManager;
import spacecraftcore.MainGame;
import spacecraftelements.Bullets.EnemyBullet;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.SpecialEffect.BigBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

/**
 * Boss The core of rotation object
 * 
 * @author Hale
 * 
 */
public class Bossix extends Enemy {
	public double angle, tarx, tary;
	public int mapsizex = 2000, mapsizey = 2000;
	public long starttime;
	private int skillid = 0;
	private int skillstatus = 0;
	private int skillstoptime;
	private double skillangle;
	private int movestatus = 0;// 0-跟随 1-随机

	public Bossix(int x, int y, int mapsizex, int mapsizey) {
		super.x = x;
		super.y = y;
		super.damage = 2;
		super.health = 2000;
		super.v = 2;
		super.volume = 200;
		super.imageID = "Images//enemy//Bossix.png";
		super.imagesize = 100;
		super.getscore = 100;
		tarx = (Math.random() * mapsizex * 0.4) * ((int) Math.pow(-1, (int) x));
		tary = (Math.random() * mapsizey * 0.4) * ((int) Math.pow(-1, (int) y));
		starttime = MainGame.gametime;

	}

	public boolean update() {
		// AI par1 move

		// 根据当前移动策略选择目标
		if (movestatus == 1) {
			if (Math.abs(x - tarx) < 20 && Math.abs(y - tary) < 20) {
				tarx = (Math.random() * mapsizex * 0.4)
						* ((int) Math.pow(-1, (int) x));
				tary = (Math.random() * mapsizey * 0.4)
						* ((int) Math.pow(-1, (int) y));

			}
		} else if (movestatus == 0) {
			tarx = MainGame.bm.ship.x;
			tary = MainGame.bm.ship.y;
		}

		// 向目标移动
		double x1, y1;
		double ratiox, ratioy, third;
		x1 = tarx - x;
		y1 = tary - y;
		third = Math.sqrt((double) x1 * x1 + y1 * y1);
		ratiox = ((double) x1) / third;
		ratioy = ((double) y1) / third;
		vx = (((double) v) * ratiox);
		vy = (((double) v) * ratioy);
		x = x + vx;
		y = y + vy;

		// AI part 2 using skills
		if (skillstatus >= skillstoptime) {
			skillstatus = 0;
			skillid = (int) ((Math.random() * 100) % 6);
		}
		if (skillid == 0) {
			bulletlaser(skillstatus);
		} else if (skillid == 1) {
			bulletring(skillstatus);
		} else if (skillid == 2) {
			summonpet(skillstatus);
		} else if (skillid == 3) {
			threelines(skillstatus);
		} else if (skillid == 4) {
			suddenshot(skillstatus);
		} else if (skillid == 5) {
			Slaser(skillstatus);
		}
		return true;

	}

	public SpecialEffect deathwhisper() {

		return new BigBlast(x, y);
	}

	// skillil=1;
	private void bulletlaser(int s) {
		if (s == 0) {
			skillstoptime = 90;
			movestatus = 0;
		}

		double angle = BattleFieldManager.getangle(vx, vy);
		if (s < 30) {
			if (s % 10 == 0) {
				MainGame.bm.add(new EnemyBullet(x, y, angle, 1, 13));
			}
		} else if (s < 60) {
			if (s % 10 == 0) {
				MainGame.bm.add(new EnemyBullet(x, y, angle, 2, 13));
			}
		} else if (s < 90) {
			if (s % 10 == 0) {
				MainGame.bm.add(new EnemyBullet(x, y, angle, 3, 13));
			}
		}
		skillstatus++;
	}

	// skill id =2
	private void bulletring(int s) {
		if (s == 0) {
			skillstoptime = 120;
			movestatus = 1;
		}
		if (s == 40) {
			for (int i = 0; i < 18; i++) {
				MainGame.bm.add(new EnemyBullet(x, y, i * 20, 2));
			}
		}
		if (s == 80) {
			for (int i = 0; i < 18; i++) {
				MainGame.bm.add(new EnemyBullet(x, y, i * 20 + 10, 3));
			}
		}
		if (s == 119) {
			for (int i = 0; i < 18; i++) {
				MainGame.bm.add(new EnemyBullet(x, y, i * 20, 4));
			}
		}
		skillstatus++;
	}

	// skillid=3
	private void summonpet(int s) {
		if (s == 0) {
			skillstoptime = 2;

		}
		if (Math.random() > 0.7) {
			MainGame.bm.add(new Kamikaze(400, -200,
					(int) (MainGame.bm.windowsizex * 0.7),
					(int) (MainGame.bm.windowsizey * 0.7)));
		}

		skillstatus++;
	}

	private void threelines(int s) {

		skillangle = BattleFieldManager.getangle(vx, vy);
		if (s == 0) {
			skillstoptime = 40;
			movestatus = 0;
		}
		if (s == 10) {
			MainGame.bm.add(new EnemyBullet(x, y, skillangle, 3));
			MainGame.bm.add(new EnemyBullet(x, y, skillangle - 10, 2, 12));
			MainGame.bm.add(new EnemyBullet(x, y, skillangle + 10, 5, 12));
		}
		if (s == 20) {
			MainGame.bm.add(new EnemyBullet(x, y, skillangle, 3));
			MainGame.bm.add(new EnemyBullet(x, y, skillangle - 10, 2, 12));
			MainGame.bm.add(new EnemyBullet(x, y, skillangle + 10, 5, 12));
		}
		if (s == 29) {
			MainGame.bm.add(new EnemyBullet(x, y, skillangle, 3));
			MainGame.bm.add(new EnemyBullet(x, y, skillangle - 10, 2, 12));
			MainGame.bm.add(new EnemyBullet(x, y, skillangle + 10, 5, 12));
		}
		skillstatus++;
	}

	private void suddenshot(int s) {
		if (s == 0) {
			skillstoptime = 80;
			movestatus = 0;
			v = 0.01;
		}

		skillangle = BattleFieldManager.getangle(vx, vy);
		if (s < 30) {
			if (s == 29) {
				skillangle = BattleFieldManager.getangle(vx, vy);
				movestatus = 1;
			}
		} else if (s < 80) {
			if (s == 79) {
				v = 2;
			}
			if (s % 3 == 0) {
				MainGame.bm.add(new EnemyBullet(x, y, skillangle, s % 6,
						15 + s % 5));

			}
			if (s % 3 == 1) {
				MainGame.bm.add(new EnemyBullet(x, y, skillangle - 10 - s % 8,
						s % 6, 15 + s % 5));
			}
			if (s % 3 == 2) {
				MainGame.bm.add(new EnemyBullet(x, y, skillangle + 10 + s % 8,
						s % 6, 15 + s % 5));
			}
		}
		skillstatus++;
	}

	private void Slaser(int s) {
		if (s == 0) {
			skillstoptime = 60;
			movestatus = 0;
			v = 5;
		} else {
			double angle = BattleFieldManager.getangle(vx, vy);
			
				if (s % 5 == 0) {
					MainGame.bm
							.add(new EnemyBullet(x, y, angle + s, s % 4, 13));
					MainGame.bm
					.add(new EnemyBullet(x, y, angle - s, s % 4, 13));
				}
			
		}

		if (s == 89) {
			v = 2;
		}
		skillstatus++;
	}
}
