package spacecraftcore;

public class SpaceTimmer implements Runnable{

	@Override
	public void run() {
		while(true){
		MainGame.bm.update();
		try {
			Thread.sleep(19);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}

}
