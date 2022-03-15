package com.dollarsbank.utility;

import java.util.ArrayList;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class FileStorageUtility {

	ArrayList<Account> accounts = new ArrayList<Account>();
	// ArrayList<Customer> customers = new ArrayList<Customer>();

	public void generateSample() {
		Customer cust1 = new Customer("Kim Henderson", "123 Main Street", "555-234-2345", "shende1", "test");
		SavingsAccount savingsAcc1 = new SavingsAccount(1000);
		Account myAccount = new Account(cust1, savingsAcc1);
		storeAccounts(myAccount);

		Customer cust2 = new Customer("Alex Henderson", "555 Creek Blvd", "312-465-2245", "alex2", "P@ssword2");
		SavingsAccount savingsAcc2 = new SavingsAccount(1000);
		Account myAccount2 = new Account(cust2, savingsAcc2);
		storeAccounts(myAccount2);

		System.out.println("Sample Data Generated");
		System.out.println(accounts);
	}

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public void storeAccounts(Account a1) {
		accounts.add(a1);
	}

//	public void storeCustomers(Customer c1) {
//		customers.add(c1);
//	}

	public Account checkLogin(String username, String password) {

		// System.out.println(customers);
		Account loggedCust = null;
		boolean found = false;

		// Add do-while here for bad creds maybe?
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getC1().getUserID().equals(username)
					&& accounts.get(i).getC1().getPassword().equals(password)) {
				System.out.println("Account found; welcome " + username);
				loggedCust = accounts.get(i);
				found = true;
				break;
			}
		}
		if (found = false) {
			System.out.println("Invalid Credentials, try again!");
		}

		return loggedCust;

	}

	public Account transferCheck(String username) {

		// System.out.println(accounts);
		Account transCust = null;
		boolean found;
		// Add do-while here for bad creds maybe?
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getC1().getUserID().equals(username)) {
				System.out.println("Found match");
				transCust = accounts.get(i);
				found = true;
				break;
			}
		}
		if (found = false) {
			System.out.println("Invalid Credentials, try again!");
		}

		return transCust;

	}

}
