package bankSystem;

import java.util.ArrayList;

public class Bank {

	private ArrayList<Client> clients;// Creating arraylist

	// Client[] clients;
	Logger logService;
	Logger logger;

	private static float commissionSum = 0;

	private Bank() { //to make a singleton
		
		//clients = new Client[100];
		clients = new ArrayList<Client>(100);
		
		logService = new Logger("BankLogger");
	}

	public void setBalance() {
		float balance = 0;
		for (int i = 0; i < clients.size(); i++) {
			balance += clients.get(i).getFortune();
		}
		balance += commissionSum;
		System.out.println(balance);
	}

	public float getBalance() {
		float balance = 0;
		for (int i = 0; i < clients.size(); i++) {
			balance += clients.get(i).getFortune();
		}
		return balance;
	}

	public void addClient(Client client) {

		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i) == null) {
				clients.set(i, client);
				long timeStamp = System.currentTimeMillis();
				Logger.log(new Log(timeStamp, client.getId(), "client: " + client.getId() + " Added",
						client.getFortune()));
			}
		}

	}

//	public void removeClient(int id) { OLD WAY

	public void removeClient(Client clientTwo) {

		for (int i = 0; i < clients.size(); i++) {

			// if (clients[i].getId() == id) { OLD WAY
			if (clientTwo.equals(clients.get(i))) {

				clients.set(i, null);
				long timeStamp = System.currentTimeMillis();
				Logger.log(new Log(timeStamp, clientTwo.getId(), "client: " + clientTwo.getId() + " removed", 0));
			}
		}

	}

	public ArrayList<Client> getClients() {
		return this.clients;
	}

	public static void addCommission(float commission) {
		commissionSum += commission;
	}

	public void printClientList() {

		for (int i = 0; i < clients.size(); i++) {
			if (clients.get(i) != null) {
				clients.get(i).toString();
			}
		}
	}

	public void viewLogs() {

	}

	public void startAccountUpdater() {

	}
}
