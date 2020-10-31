package MoneyAppPojos;

public class Credit {
	private String cardName;
	
	private String cardNum;
	
	private String cardType;
	
	private String expirationDate;
	
	private int CVV;

	public Credit(String cardName, String cardNum, String cardType, String expirationDate, int cVV) {
		super();
		this.cardName = cardName;
		this.cardNum = cardNum;
		this.cardType = cardType;
		this.expirationDate = expirationDate;
		CVV = cVV;
	}

	public Credit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getCVV() {
		return CVV;
	}

	public void setCVV(int cVV) {
		CVV = cVV;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CVV;
		result = prime * result + ((cardName == null) ? 0 : cardName.hashCode());
		result = prime * result + ((cardNum == null) ? 0 : cardNum.hashCode());
		result = prime * result + ((cardType == null) ? 0 : cardType.hashCode());
		result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
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
		Credit other = (Credit) obj;
		if (CVV != other.CVV)
			return false;
		if (cardName == null) {
			if (other.cardName != null)
				return false;
		} else if (!cardName.equals(other.cardName))
			return false;
		if (cardNum == null) {
			if (other.cardNum != null)
				return false;
		} else if (!cardNum.equals(other.cardNum))
			return false;
		if (cardType == null) {
			if (other.cardType != null)
				return false;
		} else if (!cardType.equals(other.cardType))
			return false;
		if (expirationDate == null) {
			if (other.expirationDate != null)
				return false;
		} else if (!expirationDate.equals(other.expirationDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Credit [cardName=" + cardName + ", cardNum=" + cardNum + ", cardType=" + cardType + ", expirationDate="
				+ expirationDate + ", CVV=" + CVV + "]";
	}
	
	
}
