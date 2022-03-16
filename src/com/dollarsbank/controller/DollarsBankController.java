package com.dollarsbank.controller;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.dollarsbank.utility.ConsolePrinterUtility;


public class DollarsBankController {

	ConsolePrinterUtility cputil = new ConsolePrinterUtility();
	Scanner input = new Scanner(System.in);
	
	public void makeDeposit(){
		
		// Deposit Logic
					System.out.println("Deposit for account: " + cputil.getLoggedAccount().getC1().getUserID());
					double origAmountD = cputil.getLoggedAccount().getS1().getAmount();
					System.out.println("Current balance: " + origAmountD);
					System.out.println("\nPlease enter an amount to Deposit: ");
					double depoAmountD = input.nextDouble();
					double totalD = depoAmountD + origAmountD;
					cputil.getLoggedAccount().getS1().setAmount(totalD);
					System.out.println("\n Your current total is: " + totalD);
					LocalDateTime myTime = LocalDateTime.now();
					cputil.getLoggedAccount().getTransactions().add("\n*Deposited $" + depoAmountD + " into savings at: " + myTime);
		
	}
	
}
