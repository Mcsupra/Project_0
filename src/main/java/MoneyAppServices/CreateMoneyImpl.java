package MoneyAppServices;

import MoneyAppPojos.Bank;
import MoneyAppPojos.Credit;


public class CreateMoneyImpl implements CreateMoney {
	
	private CacheServiceSIM<Bank> bankCache = new CacheServiceSIM<Bank>();
	private CacheServiceSIM<Credit> creditCache = new CacheServiceSIM<Credit>();
	
	

	public CreateMoneyImpl(CacheServiceSIM<Bank> bankCache, CacheServiceSIM<Credit> creditCache) {
		super();
		this.bankCache = bankCache;
		this.creditCache = creditCache;
	}
	
	public CreateMoneyImpl() {
		super();
	}


	public CacheServiceSIM<Bank> getBankCache() {
		return bankCache;
	}

	public void setBankCache(CacheServiceSIM<Bank> bankCache) {
		this.bankCache = bankCache;
	}

	public CacheServiceSIM<Credit> getCreditCache() {
		return creditCache;
	}

	public void setCreditCache(CacheServiceSIM<Credit> creditCache) {
		this.creditCache = creditCache;
	}

	@Override
	public Bank createBank(String bankName, double currentBalance, String accountNumber, String routingNumber) {
	
		Bank newBank = new Bank(bankName,currentBalance,accountNumber,routingNumber);
		bankCache.addToCache(accountNumber, newBank);
		return newBank;
	}
	
	@Override
	public Credit createCredit(String cardNum, String cardType, int expirationDate, int cVV, double balance) {
		Credit newCredit = new Credit(cardNum, cardType, expirationDate, cVV, balance);
		creditCache.addToCache(cardNum, newCredit);
		return newCredit;
	}
	

}
