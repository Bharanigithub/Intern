package day16;

import java.net.InetAddress;

public class InetDemo {
	public static void main(String[] args) throws Exception {
		InetAddress inet=InetAddress.getByName("www.google.com");
		System.out.println(inet.getHostAddress());
		InetAddress[] inetAddress=InetAddress.getAllByName("www.irctc.co.in");
		for(InetAddress add:inetAddress) {
			System.out.println(add.getHostAddress());
		}
		InetAddress myAddress=InetAddress.getByName("localhost");
		System.out.println(myAddress.getHostAddress());
		System.out.println("Host Name:");
		InetAddress a=InetAddress.getByAddress(new byte[] {103,10,10,18});
		System.out.println(a.getHostName());
	}
}
