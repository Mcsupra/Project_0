package MoneyAppMain;

import java.util.Scanner;

import MoneyAppFlowLogic.MoneyAppControllerImpl;

public class MoneyAppDriver {
	
	private static Scanner scan = new Scanner(System.in);
	private static MoneyAppControllerImpl action = new MoneyAppControllerImpl();
	
	public static void main(String args[]) {
		
		int decision = 0;
		//Menu Creation		
		do {
			
			System.out.println("What would you like to do?");
			System.out.println("[1] Create an account");
			System.out.println("[2] Sign in");
			System.out.println("[0] Exit");
			decision = scan.nextInt();
			
			switch(decision) {
				case 1:
					if(action.callUserSignIn(decision)) {
						System.out.println("User creation successful");
					}
					else {
						System.out.println("User creation unsuccessful");
					}
					break;
				case 2:
					if(action.callUserSignIn(decision)) {
						System.out.println("Sign in successful");
						decision = 0;
					}
					else {
						System.out.println("Sign in unsuccessful");
					}
					break;
				case 0:
					System.out.println("Exit");
					break;
				default:
					System.out.println("Invalid choice");
					break;
				
			}
		
		} while (decision != 0);
		
		do {
			
			System.out.println("What would you like to do?");
			System.out.println("[1] Add a bank");
			System.out.println("[2] Add a credit card");
			System.out.println("[3] Send money to another user");
			System.out.println("[4] Send money to card");
			System.out.println("[5] Send money to bank from card");
			System.out.println("[6] Get current balance");
			System.out.println("[0] Exit");
			decision = scan.nextInt();
			
			switch(decision) {
				case 1:
					if(action.callMoneyTransferService(decision)) {
						System.out.println("Bank creation successful");
					}
					else {
						System.out.println("Bank creation unsuccessful");
					}
					break;
				
				case 2:
					if(action.callMoneyTransferService(decision)) {
						System.out.println("Credit creation successful");
					}
					else {
						System.out.println("Credit creation unsuccessful");
					}
					break;
				case 3:
					if(action.callMoneyTransferService(decision)) {
						System.out.println("Money was sent successfully");
					}
					else {
						System.out.println("Money was sent unsuccessfully");
					}
					break;
				case 4:
					if(action.callMoneyTransferService(decision)) {
						System.out.println("Funds successfully added");
					}
					else {
						System.out.println("Funds unsuccessfully added");
					}
					break;
				case 5:
					if(action.callMoneyTransferService(decision)) {
						System.out.println("Funds successfully withdrawn");
					}
					else {
						System.out.println("Funds unsuccessfully withdrawn");
					}
					break;	
			}
		}while (decision != 0);
	}
}
