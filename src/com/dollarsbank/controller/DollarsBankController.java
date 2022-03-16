package com.dollarsbank.controller;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.dollarsbank.model.Account;
import com.dollarsbank.utility.FileStorageUtility;

public class DollarsBankController {

	Scanner input = new Scanner(System.in);
	FileStorageUtility fsutil = new FileStorageUtility();

	public void makeDeposit(Account loggedAccount) {

		// Deposit Logic
		System.out.println("\nDeposit for account: " + loggedAccount.getC1().getUserID());
		double origAmountD = loggedAccount.getS1().getAmount();
		System.out.println("Current balance: " + origAmountD);
		System.out.println("\nPlease enter an amount to Deposit: ");
		double depoAmountD = input.nextDouble();
		double totalD = depoAmountD + origAmountD;
		loggedAccount.getS1().setAmount(totalD);
		System.out.println("\n Your current total is: " + totalD);
		LocalDateTime myTime = LocalDateTime.now();
		loggedAccount.getTransactions().add("\n* Deposited $" + depoAmountD + " into savings at: " + myTime);

	}

	public void makeWithdrawal(Account loggedAccount) {

		// Withdrawal Logic
		System.out.println("\nWithdrawal from account: " + loggedAccount.getC1().getUserID());
		double origAmountW = loggedAccount.getS1().getAmount();
		System.out.println("Current balance: " + origAmountW);
		System.out.println("\nPlease enter an amount to Withdraw: ");
		double withdrawAmount = input.nextDouble();
		double totalW = 0;
		if (withdrawAmount <= origAmountW) {
			totalW = origAmountW - withdrawAmount;
			loggedAccount.getS1().setAmount(totalW);
		} else {
			System.out.println("\nOperation Failed: Not enough funds to withdraw amount");
		}

		System.out.println("\n Your current total is: " + loggedAccount.getS1().getAmount());
		LocalDateTime myTime2 = LocalDateTime.now();
		loggedAccount.getTransactions().add("\n* Withdrew $" + withdrawAmount + " from savings at: " + myTime2);

	}

	public void makeTransfer(Account loggedAccount, Account transAccount, double transAmount) {
		
		// Transfer logic
		double origAmountT = loggedAccount.getS1().getAmount();
		double totalT = 0;

		if (transAmount <= origAmountT) {
			totalT = origAmountT - transAmount;
			loggedAccount.getS1().setAmount(totalT);

			transAccount.getS1().setAmount(transAccount.getS1().getAmount() + transAmount);

		} else {
			System.out.println("\nOperation Failed: Not enough funds to transfer amount");
		}

		System.out.println("\nYour current total is: " + loggedAccount.getS1().getAmount());
		System.out.println("\n" + transAccount.getC1().getUserID() + "'s current total is: "
				+ transAccount.getS1().getAmount() + "\n");

		LocalDateTime myTime3 = LocalDateTime.now();
		loggedAccount.getTransactions().add("\n* Transfered $" + transAmount + " from your savings to "
				+ transAccount.getC1().getUserID() + " at " + myTime3);
	}

}
