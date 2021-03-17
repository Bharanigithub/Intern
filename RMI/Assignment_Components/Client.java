package Assignment_Components;

import java.io.*;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 8000);
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream out = new PrintStream(socket.getOutputStream());
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String message;

		while (true) {
			System.out.println("Client : ");
			message = input.readLine();
			out.println(message);
			if (message.equalsIgnoreCase("exit")) {
				System.out.println("Exit!!!");
				break;
			}
			message = in.readLine();
			System.out.println("Server says, " + message);
			System.out.println();
		}

		socket.close();
		in.close();
		out.close();
		input.close();
	}
}