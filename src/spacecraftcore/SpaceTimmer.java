package spacecraftcore;

public class SpaceTimmer implements Runnable {
	
	private int sleeping_time=19;
	@Override
	public void run(){
		while (true) 
		{
			if(MainGame.gamestatus==1)
			{
				if (MainGame.bm.paused != true) {
					MainGame.bm.update();
				}
				try 
				{
					Thread.sleep(sleeping_time);
					MainGame.gametime = MainGame.gametime + 1;
					
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}				
			}
			else if(MainGame.gamestatus==0)
			{
				MainGame.mainmenu.update();
				try 
				{
					Thread.sleep(sleeping_time);
					MainGame.gametime = MainGame.gametime + 1;
					
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}	
			}
		}
	}
}
