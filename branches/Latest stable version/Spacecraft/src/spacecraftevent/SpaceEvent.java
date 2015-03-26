package spacecraftevent;
/**
 * �¼������࣬Ŀǰ�뵽�Ĺ���1����Ϸ��ʱʱ�� ����2���Ժ�����ı�ըʲô�����Ķ����������¼�����
 * 
 * 
 * @author Hale
 *
 */
public abstract class SpaceEvent {
	public boolean over;
	/**
	 * �¼������ж��Ƿ񴥷� the event will check whether it should happen by itself
	 * 
	 * @return
	 */
	public abstract boolean execute();
	/**
	 * ����������ʱ�䣨�����¼��Դ��������� execute it now ignoring its checking
	 * @return
	 */
	public abstract boolean executenow();
}
