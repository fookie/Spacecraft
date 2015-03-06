package spacecraftelements.Micellaneous;

import spacecraftcore.MainGame;
import spacecraftevent.DeathHanabi;

public class Hanabi extends BasicElement implements Runnable{
	public int i=1;
	public String name="Images//hp//"+ i +".png";

	public Hanabi(int x,int y){
	super.imageID=name;
	super.imagesize=5;
	super.x=x;
	super.y=y;
	}
	public boolean getitem() {
		//MainGame.bm.add(new DeathHanabi(x,y));
		return false;
	}
	@Override
	public void run() {
	  while(i<=13){
		try 
		{
			
			Thread.sleep(19);
            i = i + i;
			
			
		} catch (InterruptedException e) 
		{
			e.printStackTrace();
		}			
	   }
	}
  
}