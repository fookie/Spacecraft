package displayConsole;
/**
 * ���ǰ�ť�����ֽ�������º�ϵͳ�Դ����ظ�
 * @author Hale
 */
public abstract class SButton {
	String Default[];//δ����ȥʱ��״̬
	String on[];//�������֮��
	String pressed[];//����ȥ��
	int status=0;//״̬,0δ����,1֮��,2����ȥ��
	int sizex,sizey;//��С
	int x,y;//λ��
	public abstract void setstaus(int s);
}
