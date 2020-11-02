package MoneyAppServices;

import MoneyAppPojos.Bank;
import MoneyAppPojos.Credit;

public class CreateMoneyImpl implements CreateMoney {


	@Override
	public Bank createBank(String bankName, double currentBalance, String accountNumber, String routingNumber) {
	
		Bank newBank = new Bank(bankName,currentBalance,accountNumber,routingNumber);
		return newBank;
	}
	
	@Override
	public Credit createCredit(String cardNum, String cardType, int expirationDate, int cVV, double balance) {
		Credit newCredit = new Credit(cardNum, cardType, expirationDate, cVV, balance);
		return newCredit;
	}
	

}
