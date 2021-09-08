package bankSystem;

public class Account {
	private int id;
	private float balance;

	public Account(int id, float balance) {
		this.id = id;
		this.balance = balance;
		
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
		
		long timeStamp = System.currentTimeMillis();
		Logger.log(new Log(timeStamp,this.id, "new balance set: " + balance,balance));
	}

	public int getId() {
		return id;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		final Account otherAccount = (Account) obj;
		if (this.id != otherAccount.getId()) {
			return false;
		}
		return true;		
	}
}
