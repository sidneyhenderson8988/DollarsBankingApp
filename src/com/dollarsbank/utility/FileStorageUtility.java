package com.dollarsbank.utility;

import java.util.ArrayList;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class FileStorageUtility {

	ArrayList<Account> accounts = new ArrayList<Account>();

	public ArrayList<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		this.accounts = accounts;
	}

	public void storeAccounts(Account a1) {
		accounts.add(a1);
	}

	public Account checkLogin(String username, String password) {

		Account loggedCust = null;
		boolean found = false;

		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getC1().getUserID().equals(username)
					&& accounts.get(i).getC1().getPassword().equals(password)) {
				System.out.println("\n*** Account found; welcome " + username + " ***");
				loggedCust = accounts.get(i);
				found = true;
				break;
			}
		}

		if (found == false) {
			System.out.println("\nInvalid Credentials, try again!");
		}
		return loggedCust;
	}

	public Account transferCheck(String username) {

		Account transCust = null;
		boolean found = false;
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getC1().getUserID().equals(username)) {
				System.out.println("\nFound match!");
				transCust = accounts.get(i);
				found = true;
				break;
			}
		}

		if (found == false) {
			System.out.println("\nInvalid Credentials, try again!");
		}

		return transCust;
	}
}
