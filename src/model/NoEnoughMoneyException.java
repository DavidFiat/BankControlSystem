package model;

public class NoEnoughMoneyException extends Exception {

	public NoEnoughMoneyException(double balance) {
		super("Insufficient balance, your balance is " + balance);
	}

}
