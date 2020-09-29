package model;

import java.util.*;

import datastructure.IStack;
import datastructure.Stack;

public class Client {

	public static final int DEBIT_CARD = 1;
	public static final int CREDIT_CARD = 2;
	private String name;
	private String ID;
	private int account;
	private int card;
	private double amount;
	private String dayOfIncorporation;
	private int payday;
	private int year;
	private Calendar c;
	private IStack<Operation> operations;

	public Client(String name, String iD, int account, int card) {
		this.name = name;
		ID = iD;
		this.account = account;
		this.card = card;
		c = new GregorianCalendar();
		dayOfIncorporation = (c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR));
		payday = c.get(Calendar.DATE);
		year = c.get(Calendar.YEAR);
		operations = new Stack<>();
		
		
	}
	
	public IStack<Operation> getOperations() {
		return operations;
	}

	public void setOperations(IStack<Operation> operations) {
		this.operations = operations;
	}

}
