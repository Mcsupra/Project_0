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
	List<Credit> fromCard = new ArrayList<>();
	List<Credit> allCards = new ArrayList<>();
	List<Bank> allBanks = new ArrayList<>();
	Credit validCard = new Credit();
	Bank validBank = new Bank();
	Customer currentUser = new Customer();
	
	@Override
	public boolean SendMoney(String fromUser, String toUsername, double amount) {
		
		int count = 0;
		Customer toCustomer;
		Customer fromCustomer;
		
		try {
			
			fromCustomer = userDao.readCustomer(fromUser);
			fromCard = creditDao.readCredit(fromCustomer);
			
			for (int i = 0; i < fromCard.size();i++) {
				if (fromCard.get(i).getBalance() > amount){
					validCard = fromCard.get(i);
					count++;
					break;
				}
			} 
			
			if (count == 0)
				return false;
			
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
			return false;
		}
		
		validCard.setBalance(validCard.getBalance()-amount);
		
		try {
			creditDao.updateCredit(validCard, fromCustomer);
			return true;
		} catch (SQLException e) {
			// TODO Add logger
			return false;
		}		
	}

	@Override
	public boolean AddFunds(String username, double amount) {
		
		int count = 0;
		
		try {
			currentUser = userDao.readCustomer(username);
			allBanks = bankDao.readBank(currentUser);
			allCards = creditDao.readCredit(currentUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (allCards == null)
			return false;
			
		for (int i = 0; i < allBanks.size();i++) {
			if (allBanks.get(i).getCurrentBalance()>amount) {
				validBank = allBanks.get(i);
				count++;
				break;
			}
		}
		
		if (count == 0)
			return false;
		
		
		
			validBank.setCurrentBalance(validBank.getCurrentBalance()-amount);
			allCards.get(0).setBalance(allCards.get(0).getBalance()+amount);
		
		
		try {
			creditDao.updateCredit(allCards.get(0), currentUser);
			bankDao.updateBank(validBank, currentUser);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

	@Override
	public boolean Removefunds(String username, double amount) {
		
		int count = 0;
		
		try {
			currentUser = userDao.readCustomer(username);
			allBanks = bankDao.readBank(currentUser);
			allCards = creditDao.readCredit(currentUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (allBanks == null)
			return false;
			
		for (int i = 0; i < allCards.size();i++) {
			if (allCards.get(i).getBalance()>amount) {
				validCard = allCards.get(i);
				count++;
				break;
			}
		}
		
		if (count == 0)
			return false;
		
		
		
			validCard.setBalance(validCard.getBalance()-amount);
			allBanks.get(0).setCurrentBalance(allBanks.get(0).getCurrentBalance()+amount);
		
		
		try {
			creditDao.updateCredit(validCard, currentUser);
			bankDao.updateBank(allBanks.get(0), currentUser);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}

}
