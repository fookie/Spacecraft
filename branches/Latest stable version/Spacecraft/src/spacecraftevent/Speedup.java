package spacecraftevent;

import spacecraftcore.MainGame;

public class Speedup extends SpaceEvent {
	long time;

	@Override
	public boolean execute() {
		if (MainGame.gametime - time > 400) {
			MainGame.bm.ship.maxv = MainGame.bm.ship.maxv - 6;
			over=true;
		}
		return true;
	}

	@Override
	public boolean executenow() {
		// TODO Auto-generated method stub
		return false;
	}

	public Speedup(long starttime) {
		time = starttime;
		super.over=false;
	}
}
