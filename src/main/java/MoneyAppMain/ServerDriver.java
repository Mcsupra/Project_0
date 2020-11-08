package MoneyAppMain;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import MoneyAppDoa.UserDao;
import MoneyAppDoa.UserDaoPostgres;
import MoneyAppPojos.Customer;
import MoneyAppServices.UserSignIn;
import MoneyAppServices.UserSignInDB;
import io.javalin.Javalin;

public interface ServerDriver {
	
	public static UserSignIn userController = new UserSignInDB();
	public static UserDao userDao = new UserDaoPostgres();
	public static Logger log = Logger.getLogger("Driver");
	
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(9090); //sets up and starts our server
		app.get("/Welcome", ctx -> ctx.html("Welcome to Money App"));
		log.info("Server has started");
		log.info("Program has started");
		
		//userController.createUser("gobbleking","Notmydrumstick","giblets@turkeytownnet.com","9018675309","Turkey","McDurkey");
		Customer user = new Customer("gobbleking","Notmydrumstick","giblets@turkeytownnet.com","9018675309","Turkey","McDurkey");
		try {
			userDao.createCustomer(user);
		} catch (SQLException e) {
			// TODO Add Log
			e.printStackTrace();
		}
		
		log.info("Program has ended");
	}

}
