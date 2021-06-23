package TCP;

import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TienTrinhGhi implements Runnable {
	private Socket socket;
	private String name;

	public TienTrinhGhi(Socket socket,String name) {
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		try {
            //System.out.println("Server started ");
			DataOutputStream DOS = new DataOutputStream(socket.getOutputStream());
			while(true) {
				String sms = sc.nextLine();
				DOS.writeUTF(name + ":" + sms);
				//DOS.flush();
				if(sms.equals("exit")) {
					break;
				}
			}
			DOS.close();
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		sc.close();
		
	}

}
