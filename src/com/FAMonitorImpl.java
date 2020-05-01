package com;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.json.JSONException;

public class FAMonitorImpl extends UnicastRemoteObject implements FAListener,Serializable,Runnable {
	private static final long serialVersionUID = 1L;

	protected FAMonitorImpl() throws RemoteException {
		super();
	}

	@Override
	public void alarmsChanged(String alarms) throws RemoteException, JSONException {
		System.out.println(alarms);
	}
	
	@Override
	public void run() {
		for(;;) {
			try {
				Thread.sleep(10000);
			} 
			catch (InterruptedException ie) {
				System.out.println(ie);
			}
		}
	}
}
