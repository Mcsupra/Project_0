package MoneyAppWebServices;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MoneyAppDao.BankDaoPostgres;
import MoneyAppDao.CreditDaoPostgres;
import MoneyAppDao.UserDaoPostgres;
import MoneyAppPojos.Bank;
import MoneyAppPojos.Credit;
import MoneyAppPojos.Customer;
import MoneyAppServices.MoneyTransferService;



public class TransferWebImpl implements MoneyTransferService {

	public static CreditDaoPostgres creditDao = new CreditDaoPostgres();
	public static UserDaoPostgres userDao = new UserDaoPostgres();
	public static BankDaoPostgres bankDao = new BankDaoPostgres();
	List<Credit> sendCard = new ArrayList<>();
	
	@Override
	public boolean SendMoney(Customer fromUser, Credit currentCredit, String toUsername, double amount) {
		
		
		Customer toCustomer;
		try {
			
			if (currentCredit.getBalance() < amount){
				return false;
			} 
			
			toCustomer = userDao.readCustomer(toUsername);
			sendCard = creditDao.readCredit(toCustomer);
			if (sendCard == null)
				return false;
			else {
				sendCard.get(0).setBalance(sendCard.get(0).getBalance() + amount);
				creditDao.updateCredit(sendCard.get(0),toCustomer);
			}
		} catch (SQLException e) {
			// TODO Add logger
			e.printStackTrace();
			return false;
		}
		
		currentCredit.setBalance(currentCredit.getBalance()-amount);
		try {
			creditDao.updateCredit(currentCredit, fromUser);
		} catch (SQLException e) {
			// TODO Add logger
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean AddFunds(Customer currentUser, Bank fromBankObj, Credit toCardObj, double amount) {
		if (fromBankObj.getCurrentBalance()<amount)
			return false;
		else {
			fromBankObj.setCurrentBalance(fromBankObj.getCurrentBalance()-amount);
			toCardObj.setBalance(toCardObj.getBalance()+amount);
		}
		
		try {
			creditDao.updateCredit(toCardObj, currentUser);
			bankDao.updateBank(fromBankObj, currentUser);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean Removefunds(Customer currentUser, Credit fromUserCard, Bank toUserBank, double amount) {
		
		if (fromUserCard.getBalance()<amount)
			return false;
		else {
			fromUserCard.setBalance(fromUserCard.getBalance()-amount);
			toUserBank.setCurrentBalance(toUserBank.getCurrentBalance()+amount);
		}
		
		try {
			creditDao.updateCredit(fromUserCard, currentUser);
			bankDao.updateBank(toUserBank, currentUser);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
