package model;

public class Operation {

	private double amount;
	private String operation;

	public Operation(String operation, double amount) {
		this.amount = amount;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
