package com.dollarsbank.model;

public class SavingsAccount {

	double amount;

	public SavingsAccount() {

	}

	public SavingsAccount(double amount) {
		super();
		this.amount = amount;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "| Savings Account has: $" + amount + " | ";
	}

}
