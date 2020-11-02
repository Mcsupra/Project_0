package MoneyAppFlowLogic;

import java.util.Scanner;

import MoneyAppPojos.Bank;
import MoneyAppPojos.Credit;
import MoneyAppPojos.User;
import MoneyAppServices.CreateMoneyImpl;
import MoneyAppServices.MoneyTransferServiceImpl;
import MoneyAppServices.UserSignInServiceImpl;

public class MoneyAppControllerImpl implements MoneyAppController  {
	
	UserSignInServiceImpl userSignInChoice = new UserSignInServiceImpl();
	CreateMoneyImpl bankChoice = new CreateMoneyImpl();
	CreateMoneyImpl creditChoice = new CreateMoneyImpl();
	MoneyTransferServiceImpl betweenUsers = new MoneyTransferServiceImpl();
	MoneyTransferServiceImpl addFunds = new MoneyTransferServiceImpl();
	MoneyTransferServiceImpl remFunds = new MoneyTransferServiceImpl();
	User currentUser = new User();
	Bank currentBank = new Bank();
	CreateMoneyImpl sentBank = new CreateMoneyImpl();
	Credit currentCredit = new Credit();
	CreateMoneyImpl sentCredit = new CreateMoneyImpl();
	String cardNum;
	String acctNum;
	
	private static Scanner scan = new Scanner(System.in);
	
	@Override
	public boolean callUserSignIn(int decision) {
		switch(decision) {
		
			case 1:
			//User wants to create a new user
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
				
				return(userSignInChoice.createUser(name, username, password, email, phoneNumber)!=null);
				
			case 2:
				System.out.println("What is your username?");
				String currentUsername = scan.nextLine();
				System.out.println("What is you password?");
				String currentPassword = scan.nextLine();
				return (userSignInChoice.signIn(currentUsername, currentPassword));
				
			default:
				return false;
		}
	}

	@Override
	public boolean callMoneyTransferService(int decision) {
		
		switch(decision) {
			case 1:
				System.out.println("What is the name of your bank?");
				String bankName = scan.nextLine();
				System.out.println("Please enter a bank account number:");
				acctNum = scan.nextLine();
				System.out.println("Please enter a routing number:");
				String routeNum = scan.nextLine();
				System.out.println("Set your current balance:");
				double balance = scan.nextDouble();
				scan.nextLine();
				
				currentBank= bankChoice.createBank(bankName, balance, acctNum, routeNum);
				return (currentBank != null);
			
			case 2:
				System.out.println("What type of card is this?");
				String cardType = scan.nextLine();
				System.out.println("Please enter your card number:");
				cardNum = scan.nextLine();
				System.out.println("Please enter the expiration date:");
				int expDate = scan.nextInt();
				scan.nextLine();
				System.out.println("Please enter the CVV:");
				int cVV = scan.nextInt();
				scan.nextLine();
				System.out.println("Set your current balance:");
				double cardBalance = scan.nextDouble();
				scan.nextLine();
				
				currentCredit = creditChoice.createCredit(cardNum, cardType, expDate, cVV,cardBalance);
				return (currentCredit != null);
			
			case 3:	
				System.out.println("Who is sending the money?");
				String sendMoneyFrom = scan.nextLine();
				
				System.out.println("Who is receiving the money?");
				String sendMoneyTo = scan.nextLine();
				
				System.out.println("How much would you like to send?");
				double amountToSend = scan.nextInt();
				scan.nextLine();
				
				try{
					System.out.println(sentCredit.getCreditCache().retrieveItemFromCache(sendMoneyFrom));
					return(betweenUsers.SendMoney(sentCredit.getCreditCache().retrieveItemFromCache(sendMoneyFrom), 
						   sentCredit.getCreditCache().retrieveItemFromCache(sendMoneyTo), amountToSend));
				}catch (NullPointerException e) {
					return false;
				}
				
			default:
				return false;
		}
	}
}
