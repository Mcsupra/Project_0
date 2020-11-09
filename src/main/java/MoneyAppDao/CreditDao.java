package MoneyAppDao;

import java.sql.SQLException;
import java.util.List;

import MoneyAppPojos.Credit;
import MoneyAppPojos.Customer;

public interface CreditDao {
	
	public void createCredit(Credit newCard, Customer currentUser) throws SQLException;

	public List<Credit> readCredit(Customer currentUser) throws SQLException;

	public void updateCredit(Credit cardMod,Customer currentUser) throws SQLException;

	public void deleteCredit(Customer currentUser) throws SQLException;

}
