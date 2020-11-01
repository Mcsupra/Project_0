package MoneyAppMain;

import java.util.Scanner;

import MoneyAppPojos.User;
import MoneyAppServices.UserSignInServiceImpl;

public class MoneyAppDriver {
	
	private static Scanner scan = new Scanner(System.in);
	private static UserSignInServiceImpl user;
	
	public static void main(String args[]) {
		//Menu Creation
		
		
		System.out.println("What is your full name?");
		String name = scan.nextLine();
		System.out.println("What do you want your username to be?");
		String username = scan.nextLine();
		System.out.println("What do you want your password to be?");
		String password = scan.nextLine();
		System.out.println("What is your email?");
		String email = scan.nextLine();
		System.out.println("What is your phone number?");
		String phoneNumber = scan.nextLine();
		
		User userTest = user.createUser(name, username, password, email, phoneNumber);
		
		
		System.out.println(userTest);
	}
}
