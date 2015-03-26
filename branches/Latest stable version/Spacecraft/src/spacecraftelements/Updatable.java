package spacecraftelements;
/**
 * 这个主要是保证其他元件有update()；<br/>
 * This is to ensure other elements have update()
 */
public interface Updatable {
	/**
	 * @return 是否成功更新//update succfully
	 */
	public abstract boolean update();
}
