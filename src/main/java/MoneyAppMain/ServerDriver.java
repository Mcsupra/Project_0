package MoneyAppMain;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import MoneyAppDao.BankDao;
import MoneyAppDao.BankDaoPostgres;
import MoneyAppDao.UserDao;
import MoneyAppDao.UserDaoPostgres;
import MoneyAppPojos.Customer;
import MoneyAppServices.UserSignIn;
import MoneyAppWebServices.FrontWebImpl;
import io.javalin.Javalin;

public interface ServerDriver {
	
	public static UserSignIn userController = new FrontWebImpl();
	public static UserDao userDao = new UserDaoPostgres();
	public static BankDao bankDao = new BankDaoPostgres();
	public static FrontWebImpl test = new FrontWebImpl();
	public static Logger log = Logger.getLogger("Driver");
	
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(9090); //sets up and starts our server
		app.get("/Welcome", ctx -> ctx.html("Welcome to Money App"));
		log.info("Server has started");
		log.info("Program has started");
		
		
		Customer user = new Customer("gobbleking","Notmydrumstick","giblets@turkeytownnet.com","9018675309","Turkey","McDurkey");
		
		System.out.println(test.createUser("gobbleking","Notmydrumstick","giblets@turkeytownnet.com","9018675309","Turkey","McDurkey"));
		
		
		log.info("Program has ended");
	}

}
