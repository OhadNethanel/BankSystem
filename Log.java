package bankSystem;

import java.util.Date;

public class Log {
	private long timeStamp;
	private int clientId;
	private String description;
	private float amount;

	public Log(long timestamp, int clientId, String description, float amount) {
		this.timeStamp = timestamp;
		this.clientId = clientId;
		this.description = description;
		this.amount = amount;
	}

	@Override
	public String toString() {
		
        Date date=new Date(timeStamp);  
		return "client-ID: " + clientId + ", description: " + description + ", timestamp: " + date;
	}

	public String getData(){	
		 Date date=new Date(timeStamp);  
		return "timeStamp: " + date + ", client-ID: " + clientId + ", description: " + description  + ",  amount: " + amount;
				
	}

	public long getTimestamp() {
		return timeStamp;
	}

	public void setTimestamp(long timestamp) {
		this.timeStamp = timestamp;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

}
