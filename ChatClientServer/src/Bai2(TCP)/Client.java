package TCP;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private InetAddress host;
	private int port;
	public Client(InetAddress host, int port) {
		super();
		this.host = host;
		this.port = port;
	}
	private void execute() throws IOException {
        System.out.println("Client started ");

		Socket Client = new Socket(host,port);
		
		TienTrinhDoc read = new TienTrinhDoc(Client);
		read.start();
		TienTrinhGhi write = new TienTrinhGhi(Client, "CLIENT");
		Thread thread = new Thread(write);
		thread.start();
		
	}
	public static void main(String[] args) throws IOException {
		Client client = new Client(InetAddress.getLocalHost(), 1999);
		client.execute();
	}
}
