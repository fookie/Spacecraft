package spacecraftcore;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver implements Runnable {
	public static final int port = 4356;
	DatagramPacket dp = null;
	DatagramSocket ds = null;
	byte[] buf = new byte[1024];
	String received = null;

	@Override
	public void run() {
		receive_packet();
		MainGame.bm.lan_buffer=received;
		MainGame.bm.lan_new=true;
	}

	private void receive_packet() {
		try {
			System.out.print("1");
			ds.receive(dp);
			received = new String(dp.getData(), 0, dp.getLength());
			System.out.print("2");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Receiver() {
		dp = new DatagramPacket(buf, buf.length);
		try {
			ds = new DatagramSocket(port);
		//	ds.setSoTimeout(3000);
		} catch (SocketException e) {

			e.printStackTrace();
		}
	}
}
