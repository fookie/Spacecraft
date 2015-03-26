package spacecraftevent;

import spacecraftcore.MainGame;

public class Speedup extends SpaceEvent {
	long time;

	@Override
	public boolean execute() {
		if (MainGame.gametime - time > 400) {
			MainGame.bm.ship.maxv = MainGame.bm.ship.maxv - 4;
			over=true;
		}
		return true;
	}

	@Override
	public boolean executenow() {
		return false;
	}

	public Speedup(long starttime) {
		time = starttime;
		super.over=false;
	}
}
