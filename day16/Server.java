package day16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	ServerSocket ss;
	PrintWriter out;
	BufferedReader br,in;
	Socket s;
	public Server() {
		try {
			ExecutorService es=Executors.newFixedThreadPool(1);
			ss=new ServerSocket(2000);
			System.out.println("Server Starts...");
			synchronized (es) {
				es.execute(()->{
					try {
						while (true) {
							s = ss.accept();
							System.out.println(s);
							out = new PrintWriter(s.getOutputStream(), true);
							in = new BufferedReader(new InputStreamReader(System.in));
							System.out.println("Please Enter a message to Client..:");
							String msg = in.readLine();
							out.println(msg);
							br = new BufferedReader(new InputStreamReader(s.getInputStream()));
							String msgFromClient = br.readLine();
							System.out.println("Message From Client...:" + msgFromClient);
						} 
						
					}
					catch (Exception e) {
						// TODO: handle exception
					}
				});
				es.shutdown();

			}
						
		}
		catch(Exception e) { 
			e.printStackTrace(); 
			}
	}
	public static void main(String[] args) {
		new Server();
	}
}
