package spacecraftcore;

public class SpaceTimmer implements Runnable {
	public int gamestatus=0;//0²Ëµ¥×´Ì¬£¬1ÓÎÏ·×´Ì¬
	private int sleeping_time=19;
	@Override
	public void run(){
		while (true) 
		{
			if(gamestatus==1)
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
			else if(gamestatus==0)
			{
				MainGame.mainmenu.update();
				try 
				{
					Thread.sleep(sleeping_time);
					
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}	
			}
		}
	}
}
