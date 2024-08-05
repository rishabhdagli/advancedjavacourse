package Unit9;

import java.io.*;
public class Client implements Serializable {
	private int clientId;
	private String clientName;
	private Address clientAddress;
	
	public Client() {
		clientId = 0;
		clientName = "";
		clientAddress = new Address();
	}
	
	public Client(int id, String name, Address addr) {
		clientId = id;
		clientName = name;
		clientAddress = addr;
	}
	
	public int getId() {
		return clientId;
	}
	
	public String getName() {
		return clientName;
	}
	
	public Address getAddress() {
		return clientAddress;
	}
	
	public void setId(int id) {
		clientId = id;
	}
	
	public void setName(String name) {
		clientName = name;
	}
	
	public String toString() {
		return "ClientID: "+clientId+" - Client Name: "+clientName+" - Client Address: "+clientAddress;
	}
}

