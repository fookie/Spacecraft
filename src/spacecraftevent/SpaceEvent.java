package spacecraftevent;
/**
 * �¼������࣬Ŀǰ�뵽�Ĺ���1����Ϸ��ʱʱ�� ����2���Ժ�����ı�ըʲô�����Ķ����������¼�����
 * 
 * 
 * @author Hale
 *
 */
public abstract class SpaceEvent {
	/**
	 * �¼������ж��Ƿ񴥷�
	 * 
	 * @return
	 */
	public abstract boolean execute();
	/**
	 * ����������ʱ�䣨�����¼��Դ���������
	 * @return
	 */
	public abstract boolean executenow();
}
