package spacecraftevent;

import spacecraftcore.MainGame;

public class DeathHanabi extends SpaceEvent {
	  private int breaktime=19;
	  public int i=1;
	  public String boomstatus="Images//hp//"+i+".png";
	  public int imagesize=202;
	  public int x,y;
	public boolean execute() {
//        //MainGame.bm.add(new Hanabi(x,y));
//		System.out.println(1);
//		/*while(i<=15){
//		boomstatus = "Images//hp//" + i +  ".png";
//		MainGame.test.repainter.add(boomstatus,100,0,0,0,2);
//		i++;
//		//System.out.println(boomstatus);
//		}*/
//		super.over=true;
//		return true;
		if(i>=13)
		{
			super.over=true;
		}
		MainGame.test.repainter.add(boomstatus, imagesize, x, y, 0, 0);
		System.out.println(i);
		i++;
		return true;
	}

	public boolean executenow() {
		return false;
	}
	public DeathHanabi(int a,int b){
		x = a;
		y = b;
		i=1;
		super.over = false;
	}


}