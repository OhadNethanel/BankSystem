package bankSystem;

public class GoldClient extends Client {

	public GoldClient(int id, String name, float balance) {
		super(id, name, balance);
		super.commisionRate = 2;
		super.interestRate = (float) 0.3;
	}
	
	@Override
	public String toString() {
		return "client type: Gold, client ID: " + super.getId();
	}
}
