package MoneyAppController;

import MoneyAppPojos.Credit;
import MoneyAppPojos.Customer;
import MoneyAppWebServices.FrontWebImpl;
import MoneyAppWebServices.TransferWebImpl;
import io.javalin.http.Context;

public class WebController {
	
	FrontWebImpl dummy = new FrontWebImpl();
	TransferWebImpl runner = new TransferWebImpl();
	public static int status;
	
	public void callCreateUser(Context ctx){
		
		 //User input for username
        String username = ctx.formParam("username");
        
        //User input for password
        String password = ctx.formParam("password");
        
        //User input for email
        String email = ctx.formParam("email");
        
     	//User input for phone number
        String phoneNum = ctx.formParam("phoneNum");
        
        //User input for first
        String firstName = ctx.formParam("firstName");
        
        //User input for last
        String lastName = ctx.formParam("lastName");
        
        
       if (dummy.createUser(username, password, email, phoneNum, firstName, lastName)) {
    	   ctx.html("User creation was successful");
       }
       else {
    	   ctx.html("User creation was unsuccessful - username already exists or information was missing");
       }
        
        
        
	}
	
	public void callSignIn(Context ctx){
		
		 //User input for username
        String username = ctx.formParam("username");
        
        //User input for password
        String password = ctx.formParam("password");
        
        status = dummy.signIn(username, password);
        
        switch (status) {
        case -1:
        	ctx.html("User does not exist in database - please create an account first");
        	break;
        case 0:
        	ctx.html("The password entered was not correct");
        	break;
        case 1:
        	ctx.html("You have successfully logged it!");
        	break;
        default:
        	ctx.html("You were not signed in. Please try again");
        	break;
        }
		
	}
	
	public void callCreateBank(Context ctx){
		
		 //User input for bank name
        String bankName = ctx.formParam("bankName");
        
        //User input for balance
        String currentBal = ctx.formParam("currentBalance");
        double currentBalance = Double.parseDouble(currentBal); 
        
        //User input for account #
        String accountNumber = ctx.formParam("accountNumber");
        
        //User input for routing #
        String routingNumber = ctx.formParam("routingNumber");
        
        //User input for username
        String username = ctx.formParam("username");
        
        //User input for password
        String password = ctx.formParam("password");
        
        //User input for email
        String email = ctx.formParam("email");
        
     	//User input for phone number
        String phoneNum = ctx.formParam("phoneNum");
        
        //User input for first
        String firstName = ctx.formParam("firstName");
        
        //User input for last
        String lastName = ctx.formParam("lastName");
        
        Customer currUser = new Customer(username, password, email, phoneNum, firstName, lastName);
       
		status = dummy.createBank(bankName, currentBalance, accountNumber, routingNumber, currUser);
		
		switch (status) {
        case 0:
        	ctx.html("Bank account already exists in the database");
        	break;
        case 1:
        	ctx.html("Bank successfully added");
        	break;
        default:
        	ctx.html("Error in bank creation - try again");
        	break;
        }
		
		
	}
	
	public void callCreateCredit(Context ctx){
		
		//User input for card number
        String cardNum = ctx.formParam("cardNum");
        
        //User input for card type
        String cardType = ctx.formParam("cardType");
        
     	//User input for exp date
        String expDate = ctx.formParam("expirationDate");
        int expirationDate = Integer.parseInt(expDate);
        
        //User input for CVV
        String CVV = ctx.formParam("cVV");
        int cVV = Integer.parseInt(CVV);
        
        //User input for balance
        String bal = ctx.formParam("balance");
        double balance = Double.parseDouble(bal);
        
        //User input for username
        String username = ctx.formParam("username");
        
        //User input for password
        String password = ctx.formParam("password");
        
        //User input for email
        String email = ctx.formParam("email");
        
     	//User input for phone number
        String phoneNum = ctx.formParam("phoneNum");
        
        //User input for first
        String firstName = ctx.formParam("firstName");
        
        //User input for last
        String lastName = ctx.formParam("lastName");
        
        Customer currUser = new Customer(username, password, email, phoneNum, firstName, lastName);
        
        status = dummy.createCredit(cardNum, cardType, expirationDate, cVV, balance, currUser);
        
        switch (status) {
        case 0:
        	ctx.html("Card already exists in the database");
        	break;
        case 1:
        	ctx.html("Card successfully added");
        	break;
        default:
        	ctx.html("Error in card creation - try again");
        	break;
        }
	}
	
	public void callSendMoney(Context ctx){
		       
        //User input for username
        String username = ctx.formParam("username");
       
        //User input for an amount
        String sendAmount = ctx.formParam("amount");
        double amount = Double.parseDouble(sendAmount);
        
        //User input for username to send to
        String toUsername = ctx.formParam("toUsername");
      
        
        if (runner.SendMoney(username, toUsername, amount)) {
        	ctx.html("You have successfully sent $"
        			+ amount 
        			+" to "
        			+ toUsername);
        }
        else {
        	ctx.html("Send money failed - check the username and/or your available funds");
        }
		
	}
	
	public void callAddFunds(Context ctx) {
		
		//User input for username
        String username = ctx.formParam("username");
       
        //User input for an amount
        String sendAmount = ctx.formParam("amount");
        double amount = Double.parseDouble(sendAmount);
        
        if (runner.AddFunds(username, amount)) {
        	ctx.html("You have successfully added $"
        			+ amount
        			+" to MoneyApp");
        }
        else {
        	ctx.html("There was an error adding funds. Check to make sure there are enough funds in your bank");
        }
	}
	
public void callRemoveFunds(Context ctx) {
		
		//User input for username
        String username = ctx.formParam("username");
       
        //User input for an amount
        String sendAmount = ctx.formParam("amount");
        double amount = Double.parseDouble(sendAmount);
        
        if (runner.Removefunds(username, amount)) {
        	ctx.html("You have successfully removed $"
        			+ amount
        			+" to your bank");
        }
        else {
        	ctx.html("There was an error removing funds. Check to make sure there are enough funds on your card");
        }
	}

}
