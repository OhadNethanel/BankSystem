package bankSystem;

import java.util.ArrayList;

public class Logger {
	private String driverName;

	public Logger(String driverName) {
		this.driverName = driverName;
	}
	
	public static void log(Log log) {
		System.out.println(log.getData());	
	}

	
	//change the empty getLogs() method to return an ArrayList
	public ArrayList<Log> getLogs() {
		//Log[] logList = new Log[0];
		ArrayList<Log> logs = null;
		return logs;
	}


}
