package model;

import java.util.*;

import datastructure.IStack;
import datastructure.Stack;

public class Client {

	public static final int DEBIT_CARD = 1;
	public static final int CREDIT_CARD = 2;
	private String name;
	private String ID;
	private String account;
	private int card;
	private double amount;
	private String dayOfIncorporation;
	private int payday;
	private int year;
	private Calendar c;
	private IStack<Operation> operations;

	public Client(String name, String iD, String account, int card) {
		this.name = name;
		this.ID = iD;
		this.account = account;
		this.card = card;
		c = new GregorianCalendar();
		dayOfIncorporation = ((c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR)));
		payday = (c.get(Calendar.DATE));
		year = (c.get(Calendar.YEAR));
		operations = new Stack<>();

	}

	public IStack<Operation> getOperations() {
		return operations;
	}

	public void setOperations(IStack<Operation> operations) {
		this.operations = operations;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getCard() {
		return card;
	}

	public void setCard(int card) {
		this.card = card;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDayOfIncorporation() {
		return dayOfIncorporation;
	}

	public void setDayOfIncorporation(String dayOfIncorporation) {
		this.dayOfIncorporation = dayOfIncorporation;
	}

	public int getPayday() {
		return payday;
	}

	public void setPayday(int payday) {
		this.payday = payday;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	

}
