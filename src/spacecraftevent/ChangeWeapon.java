package spacecraftevent;

import spacecraftcore.MainGame;
import spacecraftelements.Weapon.Weapon;

public class ChangeWeapon {
	public ChangeWeapon() {

	}
/**
 * 
 * @param id ����ID
 * @param name ��������
 * @return
 */
	public static boolean change(int id, Weapon name) {
		if (MainGame.bm.ship.w2 == null) {
			MainGame.bm.ship.w2 = name;
		} else {
			if (MainGame.bm.ship.w1.weaponID != id
					&& MainGame.bm.ship.w2.weaponID != id) {
				MainGame.bm.ship.w1 = name;
			}
		}
		return false;
	}
}
