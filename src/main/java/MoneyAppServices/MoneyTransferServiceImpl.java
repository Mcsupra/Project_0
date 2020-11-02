package MoneyAppServices;

import MoneyAppPojos.Bank;
import MoneyAppPojos.Credit;

public class MoneyTransferServiceImpl implements MoneyTransferService{

	@Override
	public boolean SendMoney(Credit fromUserCredit, Credit toUserCredit, double amount) {
		if (fromUserCredit.getBalance()>amount) {
			fromUserCredit.setBalance(fromUserCredit.getBalance()-amount);
			toUserCredit.setBalance(toUserCredit.getBalance()+amount);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	
	public boolean AddFunds(Bank fromBankObj, Credit toCardObj, double amount) {
		if (fromBankObj.getCurrentBalance()>amount) {
			fromBankObj.setCurrentBalance(fromBankObj.getCurrentBalance()-amount);
			toCardObj.setBalance(toCardObj.getBalance()+amount);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean Removefunds(Credit fromUserCard, Bank toUserBank, double amount) {
		if (fromUserCard.getBalance()>amount) {
			toUserBank.setCurrentBalance(toUserBank.getCurrentBalance()+amount);
			fromUserCard.setBalance(fromUserCard.getBalance()-amount);
			return true;
		}
		else {
			return false;
		}
	}


	
}
