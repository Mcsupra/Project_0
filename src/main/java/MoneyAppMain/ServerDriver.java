package MoneyAppMain;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import MoneyAppController.WebController;
import MoneyAppDao.BankDao;
import MoneyAppDao.BankDaoPostgres;
import MoneyAppDao.UserDao;
import MoneyAppDao.UserDaoPostgres;
import MoneyAppServices.UserSignIn;
import MoneyAppWebServices.FrontWebImpl;
import io.javalin.Javalin;

public interface ServerDriver {
	
	public static UserSignIn userController = new FrontWebImpl();
	public static UserDao userDao = new UserDaoPostgres();
	public static BankDao bankDao = new BankDaoPostgres();
	public static FrontWebImpl test = new FrontWebImpl();
	public static WebController web = new WebController();
	public static Logger log = Logger.getLogger("Driver");
	
	public static void main(String[] args) {
		Javalin app = Javalin.create().start(9090); //sets up and starts our server
		
		log.info("Server has started");
		log.info("Program has started");
		
		app.get("/Welcome", ctx -> ctx.html("Welcome to Money App"));
		app.get("/Signin", ctx -> web.callSignIn(ctx));
		app.post("/CreateUser", ctx -> web.callCreateUser(ctx));
		app.post("/CreateBank", ctx -> web.callCreateBank(ctx));
		app.post("/CreateCredit", ctx -> web.callCreateCredit(ctx));
		app.put("/Send", ctx -> web.callSendMoney(ctx));
		app.put("/AddFunds", ctx -> web.callAddFunds(ctx));
		app.put("/RemoveFunds", ctx -> ctx.html("Welcome to Money App"));
		app.get("/BankBalance", ctx -> ctx.html("Welcome to Money App"));
		app.get("/CreditBalance", ctx -> ctx.html("Welcome to Money App"));
		app.delete("/DeleteUser", ctx -> ctx.html("Welcome to Money App"));
		app.delete("/DeleteBank", ctx -> ctx.html("Welcome to Money App"));
		app.delete("/DeleteCredit", ctx -> ctx.html("Welcome to Money App"));
		
		
		
		
		log.info("Program has ended");
	}

}
