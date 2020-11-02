package MoneyAppServices;

import MoneyAppPojos.Bank;
import MoneyAppPojos.Credit;

public class MoneyTransferServiceImpl<T> implements MoneyTransferService{

	@Override
	public boolean sendMoney(Credit fromUserCredit, Credit toUserCredit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addFunds(Bank fromBankObj, Credit toCardObj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removefunds(Credit fromUserCard, Bank toUserBank) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
