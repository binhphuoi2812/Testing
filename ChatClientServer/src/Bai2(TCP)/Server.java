package TCP;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

	private int port;

	public Server(int port) {
		this.port = port;

	}

	private void execute() throws IOException {
		ServerSocket server = new ServerSocket(port);
		Socket socket = server.accept();
        System.out.println("Server started ");


		TienTrinhDoc read = new TienTrinhDoc(socket);
		read.start();
		TienTrinhGhi write = new TienTrinhGhi(socket,"SERVER");
		Thread thread = new Thread(write);
		thread.start();

	}
	public static void main(String[] args) throws IOException {
		Server server = new Server(1999);
		server.execute();
	 
		
	}

}
