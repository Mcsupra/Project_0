package MoneyAppDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ConnectionUtil.ConnectionUtil;
import MoneyAppPojos.Credit;
import MoneyAppPojos.Customer;

public class CreditDaoPostgres implements CreditDao {
	
	private PreparedStatement statement;
	
	public ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	
	@Override
	public void createCredit(Credit newCard, Customer currentUser) throws SQLException {
		
		String sql = "insert into credit (card_num,card_type,exp_date,cvv,balance,username) "
				+ "values(?,?,?,?,?,?);";

		try {
				statement = connUtil.createConnection().prepareStatement(sql);
				statement.setString(1,newCard.getCardNum());
				statement.setString(2,newCard.getCardType());
				statement.setInt(3, newCard.getExpirationDate());
				statement.setInt(4,newCard.getCVV());
				statement.setDouble(5,newCard.getBalance());
				statement.setString(6,currentUser.getUsername());
			
				statement.executeUpdate();
				
		} catch (SQLException e) {
					// TODO Add log
		}
		
	}

	@Override
	public List<Credit> readCredit(Customer currentUser) throws SQLException {
		
		String sql = "select * from credit where username = ?";
		List<Credit> allCards = new ArrayList<>();
		
		try {
				
				statement = connUtil.createConnection().prepareStatement(sql);
				statement.setString(1, currentUser.getUsername());
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()) {
					Credit returnedCredit = new Credit(rs.getString(1),
													   rs.getString(2),
													   rs.getInt(3),
													   rs.getInt(4),
													   rs.getDouble(5));
					allCards.add(returnedCredit);
				}
				return allCards;
				
		}catch (SQLException e) {
			//TODO Add Logger
			return null;
		}
	}

	@Override
	public void updateCredit(Credit cardMod, Customer currentUser) throws SQLException {
		
		try { 
			String sql = "UPDATE credit SET balance = ? WHERE username = ? and card_num = ?;";
			
            statement = connUtil.createConnection().prepareStatement(sql);
            
            statement.setDouble(1, cardMod.getBalance());
            statement.setString(2, currentUser.getUsername());
            statement.setString(3, cardMod.getCardNum());
            
            statement.executeUpdate();

        } catch (SQLException e) {
			//TODO Add Logger
		}
		
	}

	@Override
	public void deleteCredit(Customer currentUser) throws SQLException {
		
		String sql = "delete from credit where username = ?;";
		
		try {
			statement = connUtil.createConnection().prepareStatement(sql);
			statement.setString(1, currentUser.getUsername());
			statement.executeUpdate();
		}catch (SQLException e) {
			//TODO Add Logger
		}
		
	}

}
