package bankSystem;

import java.util.ArrayList;

public abstract class Client {
	private int id;
	private String name;
	private float balance;
	//private Account[] accounts;
	private ArrayList<Account> accounts;// Creating arraylist
	
	protected float commisionRate;
	protected float interestRate;
	private Logger logger;

	public Client(int id, String name, float balance) {
		this.id = id;
		this.name = name;
		this.balance = balance;

		Logger logger = new Logger(name);

		// defaults
		
		//accounts = new Account[5];
		accounts = new ArrayList<Account>(5);
		
		commisionRate = 0;
		interestRate = 0;
	}

	public void addAccount(Account account) {
		for (int i = 0; i < this.accounts.size(); i++) {
			if (this.accounts.get(i) == null) {
				this.accounts.set(i, account);
				long timeStamp = System.currentTimeMillis();
				Logger.log(new Log(timeStamp, this.id, "new account added", balance));
				break;
			}

		}
	}

	public Account getAccount(int index) {
		return this.accounts.get(index);
	}

	// public void removeAccount(int id) { OLD

	public void removeAccount(Account accountTwo) {
		for (int i = 0; i < this.accounts.size(); i++) {
			// if (this.accounts[i].getId() == id) { OLD

			if (accountTwo.equals(this.accounts.get(i))) {
				this.balance += this.accounts.get(i).getBalance();

				this.accounts.set(i, null);
				long timeStamp = System.currentTimeMillis();
				Logger.log(new Log(timeStamp, id, "account id: " + id + " removed", balance));
			}

		}

	}

	public void deposit(float amount) {
		this.balance += (amount - (this.commisionRate / 100 * amount));
	}

	public void withdraw(float amount) throws Exception {
		if (amount > balance) {
			new WithdrawException("Insufficient balance!", this.id, balance, amount);
		}else {
			this.balance -= (amount + (this.commisionRate / 100 * amount));
			Bank.addCommission(this.commisionRate / 100 * amount);
		}
		
	}

	public void autoUpdateAccounts() {
		for (int i = 0; i < this.accounts.size(); i++) {
			float calculatedAmount = this.accounts.get(i).getBalance()
					+ (this.interestRate / 100 * this.accounts.get(i).getBalance());
			this.accounts.get(i).setBalance(calculatedAmount);

			long timeStamp = System.currentTimeMillis();
					Logger.log(new Log(timeStamp, this.accounts.get(i).getId(), "interest added", calculatedAmount)));
		}

	}

	@Override
	public boolean equals(Object obj) {
		final Account otherAccount = (Account) obj;
		if (this.id != otherAccount.getId()) {
			return false;
		}
		return true;
	}

	public float getFortune() {
		float fortune = 0;
		for (int i = 0; i < this.accounts.size(); i++) {
			fortune += this.accounts.get(i).getBalance();
		}
		fortune += this.balance;
		return fortune;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}
}
