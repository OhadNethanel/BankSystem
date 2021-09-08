package bankSystem;

public class WithdrawException extends Exception {

	private int clientId;
	private float currentBalance;
	private float withdrawAmount;

	public WithdrawException(String message, int clientId, float currBalance, float withdrawAmount) throws Exception {
		throw new Exception(message + " , clientId: " + clientId + " has " + currBalance + "$, therefor you cannot withdraw " + withdrawAmount + "$");
	}

	public int getClientId() {
		return clientId;
	}

	public float getCurrentBalance() {
		return currentBalance;
	}

	public float getWithdrawAmount() {
		return withdrawAmount;
	}

}
