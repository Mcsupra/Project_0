package MoneyAppPojos;

public class Bank {
	
	private String bankName;
	
	private long currentBalance;
	
	private String accountNumber;
	
	private String routingNumber;

	public Bank(String bankName, long currentBalance, String accountNumber, String routingNumber) {
		super();
		this.bankName = bankName;
		this.currentBalance = currentBalance;
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
	}

	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public long getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(long currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		result = prime * result + (int) (currentBalance ^ (currentBalance >>> 32));
		result = prime * result + ((routingNumber == null) ? 0 : routingNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bank other = (Bank) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		if (currentBalance != other.currentBalance)
			return false;
		if (routingNumber == null) {
			if (other.routingNumber != null)
				return false;
		} else if (!routingNumber.equals(other.routingNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", currentBalance=" + currentBalance + ", accountNumber=" + accountNumber
				+ ", routingNumber=" + routingNumber + "]";
	}
	
	

}
