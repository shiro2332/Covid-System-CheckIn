package application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler{
	
	public ArrayList<history> readRecordFile(String fileName) throws IOException{ //Complete
		File file = new File(fileName);
		ArrayList<history> readRecordFile = new ArrayList<history>();
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			readRecordFile.add(new history(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
		}
		sc.close();
		return readRecordFile;
	}
	
	public ArrayList<Customer> readCustomerFile(String fileName) throws IOException{ //Complete
		File file = new File(fileName);
		ArrayList<Customer> readCustomerFile = new ArrayList<Customer>();
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			readCustomerFile.add(new Customer(sc.nextLine(), sc.nextLine(), sc.nextLine()));
		}
		sc.close();
		return readCustomerFile;
	}
	
	public ArrayList<User> readUserFile(String fileName) throws IOException{ //Complete
		File file = new File(fileName);
		ArrayList<User> readUserFile = new ArrayList<User>();
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			readUserFile.add(new User(sc.nextLine(), sc.nextLine()));
		}
		sc.close();
		return readUserFile;
	}
	
	public ArrayList<Shop> readShopFile(String fileName) throws IOException{ //Complete
		File file = new File(fileName);
		ArrayList<Shop> readShopFile = new ArrayList<Shop>();
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			readShopFile.add(new Shop(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine()));
		}
		sc.close();
		return readShopFile;
	}
	
	//Args is varags(Variadic), works similarly to array
	public void writeUserFile(String fileName, String... args) throws Exception { //Complete
		if (args.length != 2) throw new Exception("Argument not match!");
		FileWriter writer = new FileWriter(fileName, true);
		for (int i = 0; i < 2; i++) {
			writer.write(args[i] + "\n");
		}
		writer.close();
	}
	
	public void writeCustomerFile(String fileName, String... args) throws Exception { //Complete
		if (args.length != 3) throw new Exception("Argument not match!");
		FileWriter writer = new FileWriter(fileName, true);
		for (int i = 0; i < 3; i++) {
			writer.write(args[i] + "\n");
		}
		writer.close();
	}
	
	public void writeRecordFile(String fileName, String... args) throws Exception{		
		if (args.length != 4) throw new Exception("Argument not match!");
		FileWriter writer = new FileWriter(fileName, true);
		for (int i = 0; i < 4; i++) {
			writer.write(args[i] + "\n");
		}
		writer.close();
	}
}