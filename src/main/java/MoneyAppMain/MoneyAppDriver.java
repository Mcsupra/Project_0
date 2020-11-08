package MoneyAppMain;

import org.apache.log4j.Logger;
import io.javalin.Javalin;



public class MoneyAppDriver {
	
	
	
	
	public static void main(String args[]) {
		
		
		Javalin app = Javalin.create().start(9090); //sets up and starts our server
	
	}
}
