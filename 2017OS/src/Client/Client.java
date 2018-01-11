package Client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
	Socket socket;
	ObjectOutputStream objOut;
	ObjectInputStream objIn;
	String message = "";
	String ip;
	Scanner stdin;

	Client() {
	}

	void run() {
		stdin = new Scanner(System.in);
		try {
			// 1. create socket to connect to the server
			System.out.println("Please Enter your IP Address, if on a local machine type 127.0.0.1");
			ip = stdin.next();
			socket = new Socket(ip, 44444);
			System.out.println("Connected to " + ip + " on port number 44444");

			// 2. Input and Output streams
			objOut = new ObjectOutputStream(socket.getOutputStream());
			objOut.flush();
			objIn = new ObjectInputStream(socket.getInputStream());
			System.out.println("Welcome to my fitness app. Please chose from the following menu:");

			// 3: Communicating with the server
			do {
				try {
					message = (String) objIn.readObject();
					System.out.println(message);
					message = stdin.next();
					sendMessage(message);

					if (message.compareToIgnoreCase("1") == 0) { // 1st option, makes a new user.
						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

					} else if (message.compareToIgnoreCase("2") == 0) { // option 2, Displays user details
						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

					} else if (message.compareToIgnoreCase("3") == 0) {
						message = (String) objIn.readObject();
						System.out.println(message);
						message = stdin.next();
						sendMessage(message);

					}

				} // try
				catch (ClassNotFoundException e) {
					System.err.println("data received in unknown format");
				} // catch

			} while (!message.equals("4"));
		} catch (UnknownHostException e) {
			System.err.println("You are trying to connect to an unknown host!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4: Closing connection
			try {
				System.out.println("Session terminated");
				objIn.close();
				objOut.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	void sendMessage(String msg) {
		try {
			objOut.writeObject(msg);
			objOut.flush();
			System.out.println("Please type here: " + msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Client client = new Client();
		client.run();
	}
}
