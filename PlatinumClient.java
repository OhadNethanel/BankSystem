package bankSystem;

public class PlatinumClient extends Client {

	public PlatinumClient(int id, String name, float balance) {
		super(id, name, balance);
		super.commisionRate = 1;
		super.interestRate = (float) 0.5;
	}

	@Override
	public String toString() {
		return "client type: Platinum, client ID: " + super.getId();
	}	
}
