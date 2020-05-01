package com;
import java.rmi.Naming;
import java.rmi.Remote;

public class FASensorClient {
	public static void main(String[] args) {
		System.setProperty("java.security.policy", "file:allowall.policy");
		FASensor faSensor = null;
		try {
			String[] a = Naming.list("//localhost/faSensor");
			for (String string : a) {
				System.out.println(string);
			}
			Remote remoteSensor = Naming.lookup("//localhost/faSensor");
			faSensor = (FASensor) remoteSensor;
			
			String initials = faSensor.getAlarms();
			System.out.println(initials);
			
			FAListener faListener = new FAMonitorImpl();
			faSensor.addFAListener(faListener);
			
			((FAMonitorImpl) faListener).run();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
