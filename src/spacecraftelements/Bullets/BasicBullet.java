package spacecraftelements.Bullets;

import spacecraftTest.BattleFieldTest;

public class BasicBullet extends Bullet{
	public BasicBullet(int x,int y,int vx,int vy){
		//�趨���ӵ�����
		super.x=x;
		super.y=y;
		super.vx=vx;
		super.vy=vy;
		super.damage=15;
		super.volume = 10;
		super.ImageID="Images//bullet//basicbullet.png";
		super.ID = 0;
		//�Ƕ���ʱ���趨
	}

	@Override
	public boolean update() {
		System.out.print(this.toString()+"\n x:"+x+"y:"+y);
		x=x+vx;
		y=y+vy;
		System.out.println("-> x:"+x+"y:"+y);
		if(x>((BattleFieldTest.bfm.mapx)))
		{//�����߽�
		return false;
		}
		return true;
	}

}
