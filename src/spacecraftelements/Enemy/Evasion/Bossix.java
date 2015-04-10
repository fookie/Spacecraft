package spacecraftelements.Enemy.Evasion;

import spacecraftcore.BattleFieldManager;
import spacecraftcore.MainGame;
import spacecraftelements.Bullets.EnemyBullet;
import spacecraftelements.Enemy.Enemy;
import spacecraftelements.SpecialEffect.BigBlast;
import spacecraftelements.SpecialEffect.SpecialEffect;

/**
 * Boss The core of rotation object
 * @author Hale 
 * 
 */
public class Bossix extends Enemy {
	public double angle, tarx, tary;
	public int mapsizex, mapsizey;
	public long starttime;
	private int skillid = 0;
	private int skillstatus = 0;
	private int skillstoptime;
	private double skillangle;

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
		tarx = (Math.random() * mapsizex * 0.75) * ((-1) ^ (int) x);
		tary = (Math.random() * mapsizey * 0.75) * ((-1) ^ (int) y);
		starttime = MainGame.gametime;

	}

	public boolean update() {
		// AI par1 move
		if (Math.abs(x - tarx) < 20 && Math.abs(y - tary) < 20) {
			tarx = (Math.random() * mapsizex * 0.75) * ((-1) ^ (int) x);
			tary = (Math.random() * mapsizey * 0.75) * ((-1) ^ (int) y);

		} else {
			// if(hit==true){this.imageID =
			// "Images//enemy//star1.png";hit=false;}
			// else {this.imageID = "Images//enemy//star.png";}//hint when hit
			double x1, y1;
			double ratiox, ratioy, third;
			x1 = MainGame.bm.getShip().x - x;
			y1 = MainGame.bm.getShip().y - y;
			third = Math.sqrt((double) x1 * x1 + y1 * y1);
			ratiox = ((double) x1) / third;
			ratioy = ((double) y1) / third;
			vx = (((double) v) * ratiox);
			vy = (((double) v) * ratioy);
			x = x + vx;
			y = y + vy;
		}

		// AI part 2 using skills
		if (skillstatus >= skillstoptime) {
			skillstatus = 0;
			skillid= (int) ((Math.random()*100)%4);
		}
		if (skillid == 0) {
			bulletlaser(skillstatus);
		}
		else if (skillid == 1) {
			bulletring(skillstatus);
		}
		else if(skillid == 2)
		{
			summonpet(skillstatus);
		}
		else if(skillid == 3)
		{
			threelines(skillstatus);
		}
		return true;

	}

	public SpecialEffect deathwhisper() {

		return new BigBlast(x, y);
	}
	//skillil=1;
	private void bulletlaser(int s) {
		if (s == 0) {
			skillstoptime = 90;
		}

		double angle = BattleFieldManager.getangle(vx, vy);
		if (s < 30) {
			if (s % 10 == 0) {
				MainGame.bm.add(new EnemyBullet(x, y, angle, 1));
			}
		} else if (s < 60) {
			if (s % 10 == 0) {
				MainGame.bm.add(new EnemyBullet(x, y, angle, 2));
			}
		} else if (s < 90) {
			if (s % 10 == 0) {
				MainGame.bm.add(new EnemyBullet(x, y, angle, 3));
			}
		}
		skillstatus++;
	}
	//skill id =2
	private void bulletring(int s)
	{
		if (s == 0) {
			skillstoptime = 120;
		}
		if(s==40)
		{
			for(int i=0;i<18;i++)
			{
				MainGame.bm.add(new EnemyBullet(x, y, i*20, 2));
			}
		}
		if(s==80)
		{
			for(int i=0;i<18;i++)
			{
				MainGame.bm.add(new EnemyBullet(x, y, i*20+10, 3));
			}
		}
		if(s==119)
		{
			for(int i=0;i<18;i++)
			{
				MainGame.bm.add(new EnemyBullet(x, y, i*20, 4));
			}
		}
		skillstatus++;
	}
	//skillid=3
	private void summonpet(int s) {
		if (s == 0) {
			skillstoptime = 2;
		}
		if(Math.random()>0.7)
		{
			MainGame.bm.add(new Kamikaze(400, -200, (int) (MainGame.bm.windowsizex * 0.7),(int) (MainGame.bm.windowsizey * 0.7)));
		}
		
		skillstatus++;
	}
	private void threelines(int s)
	{
		skillangle = BattleFieldManager.getangle(vx, vy);
		if (s == 0) {
			skillstoptime = 40;
		}
		if(s==10)
		{
				MainGame.bm.add(new EnemyBullet(x, y, skillangle, 3));
				MainGame.bm.add(new EnemyBullet(x, y, skillangle-10, 2));
				MainGame.bm.add(new EnemyBullet(x, y, skillangle+10, 5));
		}
		if(s==20)
		{
			MainGame.bm.add(new EnemyBullet(x, y, skillangle, 3));
			MainGame.bm.add(new EnemyBullet(x, y, skillangle-10, 2));
			MainGame.bm.add(new EnemyBullet(x, y, skillangle+10, 5));
		}
		if(s==29)
		{
			MainGame.bm.add(new EnemyBullet(x, y, skillangle, 3));
			MainGame.bm.add(new EnemyBullet(x, y, skillangle-10, 2));
			MainGame.bm.add(new EnemyBullet(x, y, skillangle+10, 5));
		}
		skillstatus++;
	}
}
