package Bai1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URL;
import java.util.Scanner;

public class bai2 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			String name = sc.nextLine();
			URL url = new URL(name);
			System.out.println("URL : " + url.toString());
			System.out.println("protocol : " + url.getProtocol());
			System.out.println("host : " + url.getHost());
			System.out.println("port : " + url.getPort());
			//InetAddress add = InetAddress.getByName(name);
			//System.out.println("ip :" + add.getHostAddress());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}