package MoneyAppDao;

import java.sql.SQLException;
import java.util.List;

import MoneyAppPojos.Bank;
import MoneyAppPojos.Customer;

public interface BankDao {
	
	public void createBank (Bank newBank, Customer currentUser) throws SQLException;
	
	public List<Bank> readBank(Customer currentUser) throws SQLException;
	
	public void updateBank(Bank bankMod,Customer currentUser) throws SQLException;
	
	public void deleteBank(Customer currentUser)throws SQLException ;
}
