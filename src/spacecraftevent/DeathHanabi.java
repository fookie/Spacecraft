package spacecraftevent;

import java.awt.*;

import spacecraftcore.MainGame;
import spacecraftelements.Micellaneous.Hanabi;

public class DeathHanabi extends SpaceEvent {
	  private int breaktime=19;
	  public int i=1;
	  public String boomstatus="Images//hp//"+i+".png";
	  public int x,y;
	public boolean execute() {
        //MainGame.bm.add(new Hanabi(x,y));
		System.out.println(1);
		/*while(i<=15){
		boomstatus = "Images//hp//" + i +  ".png";
		MainGame.test.repainter.add(boomstatus,100,0,0,0,2);
		i++;
		//System.out.println(boomstatus);
		}*/
		super.over=true;
		return true;
	}

	public boolean executenow() {
		return false;
	}
	public DeathHanabi(int a,int b){
		x = a;
		y = b;
		super.over = false;
	}


}