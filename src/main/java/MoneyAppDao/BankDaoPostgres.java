package MoneyAppDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectionUtil.ConnectionUtil;
import MoneyAppPojos.Bank;
import MoneyAppPojos.Customer;


public class BankDaoPostgres implements BankDao {
	
	private PreparedStatement statement;
	
	public ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	
	@Override
	public void createBank(Bank newBank, Customer currentUser) throws SQLException {
		String sql = "insert into bank (bank_name,current_balance,account_number,routing_number,username) "
				+ "values(?,?,?,?,?);";
		
		try {
			statement = connUtil.createConnection().prepareStatement(sql);
			statement.setString(1,newBank.getBankName());
			statement.setDouble(2,newBank.getCurrentBalance());
			statement.setString(3, newBank.getAccountNumber());
			statement.setString(4,newBank.getRoutingNumber());
			statement.setString(5,currentUser.getUsername());
			
			statement.executeUpdate();
			
	} catch (SQLException e) {
				// TODO Add log
				e.printStackTrace();
	}
		
	}

	@Override
	public List<Bank> readBank(Customer currentUser ) throws SQLException {
		List<Bank> allBanks = new ArrayList<>();
		String sql = "select * from bank where username = ?";

		try {
				statement = connUtil.createConnection().prepareStatement(sql);
				statement.setString(1, currentUser.getUsername());
				ResultSet rs = statement.executeQuery();
				while(rs.next()) {
				Bank returnedBank = new Bank(rs.getString(1),
											 rs.getDouble(2),
											 rs.getString(3),
											 rs.getString(4));
				allBanks.add(returnedBank);
				}
				return allBanks;
				
		}catch (SQLException e) {
			//TODO Add Logger
			return null;
		}
	}

	@Override
	public void updateBank(Bank bankMod,Customer currentUser) throws SQLException {
		
		try { 
			String sql = "UPDATE bank SET current_balance = ? WHERE username = ? and account_number = ?;";

            statement = connUtil.createConnection().prepareStatement(sql);
            statement.setDouble(1, bankMod.getCurrentBalance());
            statement.setString(2, currentUser.getUsername());
            statement.setString(3, bankMod.getAccountNumber());
            
            statement.executeUpdate();

        } catch (SQLException e) {
			//TODO Add Logger
		}
		
	}

	@Override
	public void deleteBank(Customer currentUSer) throws SQLException {
		
		try {
			String sql = "delete from bank where username = ?;";
			
			statement = connUtil.createConnection().prepareStatement(sql);
			statement.setString(1, currentUSer.getUsername());
			statement.executeUpdate();
			
			}catch (SQLException e) {
				//TODO Add Logger
			}
		
	}

}
