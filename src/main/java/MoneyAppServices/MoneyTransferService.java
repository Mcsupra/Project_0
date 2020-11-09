package MoneyAppServices;

import MoneyAppPojos.Bank;
import MoneyAppPojos.Credit;
import MoneyAppPojos.Customer;

public interface MoneyTransferService {
	
	public boolean SendMoney(Customer fromUser, Credit fromUserCredit, String toUsername ,double amount);
	
	public boolean AddFunds(Customer currentUser, Bank fromBankObj, Credit toCardObj,double amount);
	
	public boolean Removefunds(Customer currentUser, Credit fromUserCard, Bank toUserBank,double amount);
	
}
