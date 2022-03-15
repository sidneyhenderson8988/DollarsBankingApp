package com.dollarsbank.utility;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDateTime;

import com.dollarsbank.model.Account;
import com.dollarsbank.model.Customer;
import com.dollarsbank.model.SavingsAccount;

public class ConsolePrinterUtility {

	FileStorageUtility fsutil = new FileStorageUtility();
	Account loggedAccount = null;
	Account transAccount = null;

	// ArrayList<String> transactions = new ArrayList<String>();

	public void welcomeMenu() {

		System.out.println("\n+---------------------------+\n" + "| DOLLARSBANK Welcomes You! |\n"
				+ "+---------------------------+\n" + "1. Create New Account.\n" + "2. Login.\n" + "3. Exit\n\n"
				+ "Enter choice (1, 2, or 3) : ");

	}

	public void createAccount() {
		System.out.println("\n+-------------------------------+\n" + "| Enter details for new account |\n"
				+ "+-------------------------------+\n");

		Scanner input = new Scanner(System.in);
		System.out.println("Customer Name:");
		String cName = input.next();
		System.out.println("Customer Address:");
		String cAddr = input.next();
		System.out.println("Customer Contact Number:");
		String cConNum = input.next();
		System.out.println("User ID :");
		String cID = input.next();

		String cPass = null;
		do {
			System.out.println("Password : 8 characters With Lower, Upper, & Special");
			cPass = input.next();
			if (isValidPassword(cPass) == false) {
				System.out.println("Password is invalid, please try again!");
			}
		} while (isValidPassword(cPass) == false);

		System.out.println("Initial Deposit Amount");
		double cInitDepo = input.nextDouble();

		SavingsAccount newSavAcc = new SavingsAccount(cInitDepo);
		Customer newCust = new Customer(cName, cAddr, cConNum, cID, cPass);

		Account newAcc = new Account(newCust, newSavAcc);

		fsutil.storeAccounts(newAcc);

		Customer cust1 = new Customer("Sidney Henderson", "123 Main Street", "555-234-2345", "kim1", "P@ssword1");
		SavingsAccount savingsAcc1 = new SavingsAccount(1000);
		Account myAccount = new Account(cust1, savingsAcc1);
		fsutil.storeAccounts(myAccount);

		Customer cust2 = new Customer("Alex Henderson", "555 Creek Blvd", "312-465-2245", "alex2", "P@ssword2");
		SavingsAccount savingsAcc2 = new SavingsAccount(1000);
		Account myAccount2 = new Account(cust2, savingsAcc2);
		fsutil.storeAccounts(myAccount2);

		System.out.println(fsutil.getAccounts());

	}

	public void loginMenu() {

		System.out.println("\n+---------------------+\n" + "| Enter Login Details |\n" + "+---------------------+\n");

	}

	public void loginChecker() {
		Scanner input = new Scanner(System.in);

		System.out.println("User ID :");
		String cID = input.next();
		System.out.println("Password : 8 characters With Lower, Upper, & Special");
		String cPass = input.next();

		setLoggedAccount(fsutil.checkLogin(cID, cPass));
	}

	public Account getLoggedAccount() {
		return loggedAccount;
	}

	public void setLoggedAccount(Account account) {
		this.loggedAccount = account;
	}

	public Account getTransAccount() {
		return transAccount;
	}

	public void setTransAccount(Account transAccount) {
		this.transAccount = transAccount;
	}

	public static boolean isValidPassword(String password) {

		String regex = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";

		Pattern p = Pattern.compile(regex);

		if (password == null) {
			return false;
		}

		Matcher m = p.matcher(password);

		return m.matches();
	}

	public void welcomeCustomer() {
		System.out.println("\n+---------------------+\n" + "| Welcome Customer! |\n" + "+---------------------+\n"
				+ "1. Deposit Amount.\n" + "2. Withdraw Amount.\n" + "3. Funds Transfer\n"
				+ "4. View 5 Recent Transactions.\n" + "5. Display Customer Information.\n" + "6. Sign Out\n\n"
				+ "Enter choice (1, 2, 3, 4, 5, or 6) : ");
	}

	public int welcomeCustLogic() {
		int choice = 0;
		boolean proceed = true;
		Scanner input = new Scanner(System.in);
		choice = input.nextInt();

		switch (choice) {
		case 1:
			// Deposit Logic
			System.out.println("Deposit for account: " + getLoggedAccount().getC1().getUserID());
			double origAmountD = getLoggedAccount().getS1().getAmount();
			System.out.println("Current balance: " + origAmountD);
			System.out.println("\nPlease enter an amount to Deposit: ");
			double depoAmountD = input.nextDouble();
			double totalD = depoAmountD + origAmountD;
			getLoggedAccount().getS1().setAmount(totalD);
			System.out.println("\n Your current total is: " + totalD);
			LocalDateTime myTime = LocalDateTime.now();
			getLoggedAccount().getTransactions().add("\n*Deposited $" + depoAmountD + " into savings at: " + myTime);

			break;

		case 2:
			// Withdrawal Logic
			System.out.println("Withdrawal from account: " + getLoggedAccount().getC1().getUserID());
			double origAmountW = getLoggedAccount().getS1().getAmount();
			System.out.println("Current balance: " + origAmountW);
			System.out.println("\nPlease enter an amount to Withdraw: ");
			double withdrawAmount = input.nextDouble();
			double totalW = 0;
			if (withdrawAmount <= origAmountW) {
				totalW = origAmountW - withdrawAmount;
				getLoggedAccount().getS1().setAmount(totalW);
			} else {
				System.out.println("Operation Failed: Not enough funds to withdraw amount");
			}

			System.out.println("\n Your current total is: " + getLoggedAccount().getS1().getAmount());
			LocalDateTime myTime2 = LocalDateTime.now();
			getLoggedAccount().getTransactions().add("\n*Withdrew $" + withdrawAmount + " from savings at: " + myTime2);
			break;

		case 3:
			// Transfer logic
			System.out.println("Transfer from account: " + getLoggedAccount().getC1().getUserID());
			System.out.println("What is the username of the account you want to transfer to?");
			String userTransfer = input.next();
			System.out.println("How much would you like to transfer to " + userTransfer);
			double transAmount = input.nextDouble();

			setTransAccount(fsutil.transferCheck(userTransfer));

			double origAmountT = getLoggedAccount().getS1().getAmount();
			double totalT = 0;

			if (transAmount <= origAmountT) {
				totalT = origAmountT - transAmount;
				getLoggedAccount().getS1().setAmount(totalT);

				getTransAccount().getS1().setAmount(getTransAccount().getS1().getAmount() + transAmount);

			} else {
				System.out.println("Operation Failed: Not enough funds to transfer amount");
			}

			System.out.println("\n Your current total is: " + getLoggedAccount().getS1().getAmount());
			System.out.println("\n Their current total is: " + getTransAccount().getS1().getAmount() + "\n");

			LocalDateTime myTime3 = LocalDateTime.now();
			getLoggedAccount().getTransactions().add("\n*Transfered $" + transAmount + " from savings to "
					+ getTransAccount().getC1().getUserID() + " at " + myTime3);
			break;
		case 4:
			getLoggedAccount().get5Transactions();
			break;
		case 5:
			System.out.println(getLoggedAccount());
			break;
		case 6:
			System.out.println("Enter '2' to sign out: ");
			break;
		default:
			System.out.println("default case");
			break;
		}

		return choice;
	}

}
