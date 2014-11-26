package spacecraftelements;
/**
 * Objects such as Spaceship,bullet...must implement this interface.
 * If a class implement this class,it can be update by the BattleFieldManager
 * 
 */
public interface Updatable {
	/**
	 * @return if it is update successfully
	 */
	public boolean update();
}
