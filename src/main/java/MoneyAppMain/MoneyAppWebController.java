package MoneyAppMain;

import org.apache.log4j.Logger;
import java.util.InputMismatchException;
import MoneyAppController.MoneyAppControllerImpl;
import io.javalin.http.Context;

public class MoneyAppWebController {
	private static Logger log = Logger.getLogger("UserSignInService");
	private static MoneyAppControllerImpl action = new MoneyAppControllerImpl();
	
	public static boolean UserSignInMenu(Context ctx){
		
		int decision = 0;
		
		//Menu Creation		
		do {
			//Initialize the user and signing in
			//Maintain loop state
			decision = -2;
			try {	
				//ctx.html("What would you like to do?");
				System.out.println("[1] Create an account");
				System.out.println("[2] Sign in");
				System.out.println("[0] Exit");
				String choice = ctx.formParam("Decision");
				decision = Integer.parseInt(choice);
				
			}catch(InputMismatchException e){
				log.error("Invalid input");
			}
			
			//Notifies user of various successes and failure of the service
				switch(decision) {
					case 1:
						if(action.callUserSignIn(decision)) {
							log.info("Successful User obj creation");
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
						decision = -1;
						break;
					default:
						System.out.println("Invalid choice");
						break;
					
				}
		} while (decision != -1 && decision != 0);
		

		return (decision == 0);	
	}
	
	public static boolean MoneyTransferMenu(Context ctx){
			
			int decision;
			
			do {
				//Maintain loop state
				decision = -1;
				//Next decision tree handles manipulation of money objects in cached memory
				try {
					System.out.println("What would you like to do?");
					System.out.println("[1] Add a bank");
					System.out.println("[2] Add a credit card");
					System.out.println("[3] Send money to another user TODO");
					System.out.println("[4] Send money to card");
					System.out.println("[5] Send money to bank from card");
					System.out.println("[6] Get current balance of card");
					System.out.println("[7] Get current balance of bank");
					System.out.println("[0] Exit");
					String choice = ctx.formParam("Decision");
					decision = Integer.parseInt(choice);
				
				}catch(InputMismatchException e){
					log.error("Invalid input");
			
				}
				
				//Notifies user of various successes and failure of the service
					switch(decision) {
						case 1:
							if(action.callMoneyTransferService(decision)) {
								log.info("Successful bank obj creation");
								System.out.println("Bank creation successful");
							}
							else {
								System.out.println("Bank creation unsuccessful");
							}
							break;
						case 2:
							if(action.callMoneyTransferService(decision)) {
								log.info("Successful credit obj creation");
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
						case 6:
							if(!action.callMoneyTransferService(decision)) {
								System.out.println("Balance could not be retrieved");
							}
						break;
						case 7:
							if(!action.callMoneyTransferService(decision)) {
								System.out.println("Balance could not be retrieved");
							}
						break;
						case 0:
							break;
						default:
							System.out.println("Invalid input");
							break;
					}
				
			}while (decision != 0);
			
			return true;
		}
}


