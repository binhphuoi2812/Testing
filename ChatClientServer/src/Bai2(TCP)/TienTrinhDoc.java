package TCP;

import java.io.DataInputStream;
import java.net.Socket;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class TienTrinhDoc extends Thread {
	private Socket socket;

	public TienTrinhDoc(Socket socket) {

		this.socket = socket;

	}

	@Override
	public void run() {
		try {
            //System.out.println("Client started ");
			DataInputStream DIS = new DataInputStream(socket.getInputStream());
			while (true) {
				String sms = DIS.readUTF();
				System.out.println(sms);
				if (sms.equals("exit")) {
					break;

				}

			}
			socket.close();
			DIS.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
