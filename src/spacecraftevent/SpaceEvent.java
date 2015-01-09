package spacecraftevent;
/**
 * 事件虚拟类，目前想到的功能1：游戏定时时间 功能2：以后物件的爆炸什么动画的都可以做成事件处理。
 * 
 * 
 * @author Hale
 *
 */
public abstract class SpaceEvent {
	/**
	 * 事件自行判断是否触发
	 * 
	 * @return
	 */
	public abstract boolean execute();
	/**
	 * 立即触发该时间（无视事件自带的条件）
	 * @return
	 */
	public abstract boolean executenow();
}
