package Assignment_Components;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.*;

public class Server {
	int port;
	ServerSocket server = null;
	Socket client = null;
	ExecutorService pool = null;
	int noOfClient = 0;

	public static void main(String[] args) throws Exception {
		Server serverObject = new Server();
		serverObject.startServer();
	}

	public Server() {
		pool = Executors.newFixedThreadPool(5);
	}

	public void startServer() throws Exception {
		server = new ServerSocket(8000);
		System.out.println("Server Started!!");
		while (true) {
			client = server.accept();
			noOfClient++;
			ServerThread run = new ServerThread(client, noOfClient, this);
			pool.execute(run);
		}
	}

	private static class ServerThread implements Runnable {
		Server server = null;
		Socket client = null;
		BufferedReader in;
		PrintStream out;
		int id;
		String message;
		Scanner sc = new Scanner(System.in);

		public ServerThread(Socket client, int noOfClient, Server server) throws Exception {
			this.client = client;
			this.server = server;
			this.id = noOfClient;

			System.out.println("client "+id+" Conneceted!!" );
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintStream(client.getOutputStream());
		}

		@Override
		public void run() {
			boolean status = true;
			try {
				while (true) {
					message = in.readLine();
					System.out.println("From Client " + id + ":" + message);
					System.out.println();
					message = sc.nextLine();
					if (message.equalsIgnoreCase("exit")) {
						out.println("exited....");
						status = false;
						break;
					}
					out.println(message);
				}
				in.close();
				out.close();
				client.close();
				if (status==false) {
					System.exit(0);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
