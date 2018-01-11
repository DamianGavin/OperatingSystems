package Server;

import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
	public static void main(String[] args) throws Exception {
		ServerSocket s = new ServerSocket(44444, 10);
		int id = 0;

		while (true) {
			System.out.println("Server started");
			Socket socket = s.accept();
			ClientServerThread cst = new ClientServerThread(socket, id++);
			cst.start();
			// s.close();
		} // while

	}// main

}// Server

class ClientServerThread extends Thread {
	Socket socket;
	String message;
	int clientID = -1;
	boolean running = true;
	ObjectOutputStream objOut;
	ObjectInputStream objIn;
	ArrayList<User> list = new ArrayList<User>();

	ClientServerThread(Socket s, int id) {
		socket = s;
		clientID = id;
	}// Constructor

	void sendMessage(String msg) {
		try {

			objOut.writeObject(msg);
			objOut.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}// sendMessage

	public void run() {
		System.out.println(
				"Accepted Client : ID - " + clientID + " : Address - " + socket.getInetAddress().getHostName());
		try {
			objOut = new ObjectOutputStream(socket.getOutputStream());
			objOut.flush();
			objIn = new ObjectInputStream(socket.getInputStream());
			System.out.println(
					"Accepted Client : ID - " + clientID + " : Address - " + socket.getInetAddress().getHostName());

			do {
				try { // Sends menu options back to local device
					sendMessage(
							"Enter 1 to add new user:  \nEnter 2 to view record: \nEnter 3 to show all details: \nEnter 4 to exit:");
					message = (String) objIn.readObject();

					if (message.compareToIgnoreCase("1") == 0) {
						addUser();
					}

					else if (message.compareToIgnoreCase("2") == 0) {
						showRecord();
					} else if (message.compareToIgnoreCase("3") == 0) {
						details();
					}

				} catch (ClassNotFoundException e) {
					System.err.println("Data received in unknown format");
				}

			} while (!message.equals("4"));

			System.out.println(
					"Ending Client : ID - " + clientID + " : Address - " + socket.getInetAddress().getHostName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// run

	//Will write the users details to a file called users.txt
	private void addUser() throws ClassNotFoundException, IOException {
		// Creates a text file for output
		FileWriter fw = new FileWriter("users.txt", true);
		PrintWriter out = new PrintWriter(fw);

		// User inputs

		sendMessage("Please enter Name");
		message = (String) objIn.readObject();
		String name = message;

		sendMessage("Please enter Address");
		message = (String) objIn.readObject();
		String address = message;

		sendMessage("Please enter a password");
		message = (String) objIn.readObject();
		String password = message;

		sendMessage("Please enter Age");
		message = (String) objIn.readObject();
		String age = message;

		sendMessage("Please enter weight(kg)");
		message = (String) objIn.readObject();
		String weight = message;

		sendMessage("Please enter height(meters)");
		message = (String) objIn.readObject();
		String height = message;

		sendMessage("Please enter fitness mode");
		message = (String) objIn.readObject();
		String fitRec = message;

		sendMessage("How long was this activity(mins)");
		message = (String) objIn.readObject();
		String duration = message;

		sendMessage("Please enter food record");
		message = (String) objIn.readObject();
		String foodRec = message;
		// File headings and outputs
		list.add(new User(name, address, password, age, weight, height, fitRec, duration, foodRec));
		out.println("====== User Details ======");
		out.println("Name: " + name);
		out.println("Address: " + address);
		out.println("Password: " + password);
		out.println("Age: " + age);
		out.println("Weight(kg): " + weight);
		out.println("Height(meters): " + height);
		out.println("Recent Activity: " + fitRec);
		out.println("Duration(mins): " + duration);
		out.println("Meal Record: " + foodRec);
		out.println("***************************");
		// out.println("===== Next User =====");
		out.println("***************************");

		out.close();
	}// addUser

	public void details() throws ClassNotFoundException, IOException {

		sendMessage("Please enter your Password");
		message = (String) objIn.readObject();
		System.out.println(message);

		for (User a : list) {
			if (a.getPassword().equals(message)) {
				String arg1 = a.getName();
				String arg2 = a.getAddress();
				String arg3 = a.getAge();
				String arg4 = a.getWeight();
				String arg5 = a.getHeight();
				System.out.println(arg1);
				System.out.println(arg2);
				System.out.println(arg3);
				System.out.println(arg4);
				System.out.println(arg5);
				sendMessage("Name : " + arg1 + "\nAddress : " + arg2 + "\nAge : " + arg3 + "\nWeight(kg) : " + arg4
						+ "\nHeight(meters) : " + arg5);
				break;
			} else if (a.getPassword() != (message)) {
				System.out.println("Please try again No Password saved");

				break;
			}

		}
	}// details

	public void showRecord() throws ClassNotFoundException, IOException {

		sendMessage("Please enter your Password");
		message = (String) objIn.readObject();
		System.out.println(message);

		for (User a : list) {
			if (a.getPassword().equals(message)) {
				String tempString = a.getName();
				String tempString2 = a.getActivity();
				String tempString3 = a.getMinutes();
				String tempString4 = a.getMeal();

				System.out.println(tempString);
				System.out.println(tempString2);
				System.out.println(tempString3);
				System.out.println(tempString4);
				sendMessage("Name : " + tempString + "\nLast Activity :" + tempString2 + "\nDuration(mins) : "
						+ tempString3 + "\nLast Meal : " + tempString4);
				break;
			} else if (a.getPassword() != (message)) {
				System.out.println("Try again No Password saved");

				break;
			}

		}
	}// showRecord

}// ClientServiceThread
