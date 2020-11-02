package MoneyAppServices;

import MoneyAppPojos.Bank;
import MoneyAppPojos.Credit;

public interface MoneyTransferService {
	
	public boolean sendMoney(Credit fromUserCredit, Credit toUserCredit);
	
	public boolean addFunds(Bank fromBankObj, Credit toCardObj);
	
	public boolean removefunds(Credit fromUserCard, Bank toUserBank);
	
}
