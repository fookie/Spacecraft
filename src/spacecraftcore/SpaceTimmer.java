package spacecraftcore;

public class SpaceTimmer implements Runnable{

	@Override
	public void run() {
		MainGame.bm.update();
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
