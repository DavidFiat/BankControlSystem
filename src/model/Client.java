package model;

import java.util.*;

import customExceptions.NoEnoughMoneyException;
import datastructure.IStack;
import datastructure.Stack;

public class Client implements Comparable<Client> {

	public static final int DEBIT_CARD = 1;
	public static final int CREDIT_CARD = 2;
	public static final int GENERAL = 1;
	public static final int HANDICAPPED = 2;
	public static final int ELDERLY = 3;
	public static final int PREGNANT = 4;
	public static final int CHILDREN_IN_ARM = 5;
	private int priority;
	private String name;
	private String ID;
	private String account;
	private int card;
	private String dayOfIncorporation;
	private int payday;
	private int year;
	private Calendar c;
	private IStack<Operation> operations;

	public Client(String name, String iD, String account, int card, int priority) {
		this.name = name;
		this.ID = iD;
		this.account = account;
		this.card = card;
		c = new GregorianCalendar();
		dayOfIncorporation = ((c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR)));
		payday = (c.get(Calendar.DATE));
		year = (c.get(Calendar.YEAR));
		operations = new Stack<>();
		Operation o = new Operation("Creation", 0);
		operations.push(o);

	}

	public Client(String name, String iD, int priority) {
		this.name = name;
		this.ID = iD;
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
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

	public double getAmount() {
		return operations.top().getAmount();
	}

	public void withdraw(double money) throws NoEnoughMoneyException {
		if (getAmount() < money) {
			throw new NoEnoughMoneyException(getAmount());

		} else {
			Operation o = new Operation("Withdrawal", getAmount() - money);
			operations.push(o);
		}
	}

	public void consign(double money) {
		Operation o = new Operation("Consignation", getAmount() + money);
		operations.push(o);

	}

	public void payCreditCard(double debt) throws NoEnoughMoneyException {
		if (getAmount() < debt) {
			throw new NoEnoughMoneyException(getAmount());

		} else {
			Operation o = new Operation("CardPayment", getAmount() - debt);
			operations.push(o);
		}

	}
	
	public void payCash(double debt) {
		Operation o = new Operation("CashPayment", getAmount() - debt);
		operations.push(o);
	}

	public Operation visualizeLast() {
		return operations.top();
	}

	public void UNDO() {
		operations.pop();

	}

	public int compareTo(Client c) {
		return (int) (this.getAmount() - (c.getAmount()));

	}

	public int compareById(Client client) {
		return ID.compareTo(client.getID());
	}

}
