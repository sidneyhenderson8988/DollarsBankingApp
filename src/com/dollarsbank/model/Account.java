package com.dollarsbank.model;

import java.util.ArrayList;

public class Account {

	Customer c1;
	SavingsAccount s1;
	ArrayList<String> transactions = new ArrayList<String>();

	public Account() {
	}

	public Account(Customer c1, SavingsAccount s1) {
		super();
		this.c1 = c1;
		this.s1 = s1;
	}

	public ArrayList<String> getTransactions() {
		return transactions;
	}

	public void get5Transactions() {
		int count = 0;
		for (int i = transactions.size(); i-- > 0;) {

			System.out.println(transactions.get(i));
			count++;
			if (count == 5) {
				break;
			}
		}
	}

	public void setTransactions(ArrayList<String> transactions) {
		this.transactions = transactions;
	}

	public Customer getC1() {
		return c1;
	}

	public void setC1(Customer c1) {
		this.c1 = c1;
	}

	public SavingsAccount getS1() {
		return s1;
	}

	public void setS1(SavingsAccount s1) {
		this.s1 = s1;
	}

	@Override
	public String toString() {
		return "+-------Account Details:-------+\n" + c1 + " \n| Savings Info:" + s1 + " | \n";
	}

}
