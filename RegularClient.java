package bankSystem;

public class RegularClient extends Client{

	public RegularClient(int id, String name, float balance) {
		super(id, name, balance);
		super.commisionRate = 3;
		super.interestRate = (float) 0.1;
	}
	
	@Override
	public String toString() {
		return "client type: Regular, client ID: " + super.getId();
	}
}
