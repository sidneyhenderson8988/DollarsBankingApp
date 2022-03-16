package com.dollarsbank.application;

import java.util.Scanner;

import com.dollarsbank.utility.ConsolePrinterUtility;

public class DollarsBankApplication {

	public static void main(String[] args) {

		ConsolePrinterUtility cputil = new ConsolePrinterUtility();
		Scanner input = new Scanner(System.in);

		int choice = 0;
		boolean proceed = true;

		do {

			cputil.welcomeMenu();
			choice = input.nextInt();

			switch (choice) {
			case 1:
				cputil.createAccount();
				break;
			case 2:
				cputil.loginMenu();
				cputil.loginChecker();

				int con = 0;
				do {
					cputil.welcomeCustomer();
					cputil.welcomeCustLogic();
					System.out.println("\nWould you like to make another query on your account? 1 for yes, 2 for no: ");
					con = input.nextInt();
				} while (con == 1);

				break;
			case 3:
				proceed = false;
			default:
				break;
			}

		} while (proceed);

		input.close();
		System.out.println("******END******");

	}

}
