package spacecraftelements.Items;

public abstract class SpaceItem {
	public String imageID;//��ͼλ��
	public int imagesize;//��ͼ��С
	public int x;
	public int y;//λ��
	public int timeup=600;
	public abstract boolean getitem();
}
