package com.mitadt.practice;

import java.util.Scanner;

public class BankProject {
	private String name;
	private String address;
	private char acc_type;
	private float balance;
	
	private BankProject() {
		this.name = " ";	// "this" keyword refers to the current object that is being worked upon
		this.address = " ";
		this.acc_type = ' ';
		this.balance = 0;
	}
	
	Scanner sc = new Scanner(System.in); // To take input from the user
	
	private void openAccount() {
		System.out.print("Enter your name : ");
		this.name = sc.next();
		
		System.out.print("Enter your address : ");
		this.address = sc.next();
		
		System.out.print("Enter your account type ('c' for current, 's' for savings) : ");
		this.acc_type = sc.next().charAt(0);
		
		System.out.print("Enter initial balance : ");
		this.balance = sc.nextFloat();
		
		System.out.println("\n\t\tCongratulations! Your account has been created!\n");
	}
	
	private void depositMoney() {
		if (this.name != " ") {	// To check if the account exists
			System.out.println("Enter the amount you would like to deposit : ");
			float amount = sc.nextFloat();
			
			if (amount > 0) {	// To check if the amount that they've input is positive
				this.balance = this.balance + amount;
				System.out.println("\n\t\t" + amount + " deposited\n");
			}
			else
				System.out.println("\n\t\tValid amount not entered\n");
		}
		else
			System.out.println("\n\t\tPlease create an account first\n");
	}
	
	private void withdrawMoney() {
		if (this.name != " ") {	// To check if the account exists
			System.out.println("Enter the amount you would like to withdraw : ");
			float amount = sc.nextFloat();
			
			if (amount <= this.balance) {	// To check if they have sufficient balance for the transaction
				this.balance = this.balance - amount;
				System.out.println("\n\t\t" + amount + " withdrawn\n");
			}
			else
				System.out.println("\n\t\tCannot withdraw amount more than the balance\n");
		}
		else
			System.out.println("\n\t\tPlease create an account first\n");
	}
	
	private void displayAccountDetails() {
		System.out.println("\nAccount Holder Name : " + this.name);
		System.out.println("Account Holder Address : " + this.address);
		System.out.println("Account Type : " + this.acc_type);
		System.out.println("Account Balance : " + this.balance);
		System.out.println();
	}
	
	private static void showMenu() {
		System.out.println(" 1. To open an account, type 'o'\n 2. To deposit money, type 'd'\n 3. To withdraw money, type 'w'"
				+ "\n 4. To display the account details, type 'a'\n 5. To exit, type 'e'");
	}
	
	public static void main(String[] args) {
		BankProject bankObj = new BankProject();
		
		System.out.println("\n\t\tWelcome to the Bank Application\n");
		Scanner sc = new Scanner(System.in);	// To take input in this static local scope
		
		char choice = ' ';
		
		while (choice != 'e') {
			showMenu();
			choice = sc.next().charAt(0);	// The input will be a string, but we require a character
			
			if (choice == 'e')	// Exit condition
				break;
			
			switch (choice) {
				case 'o' :
					bankObj.openAccount();
					break;
				case 'd' :
					bankObj.depositMoney();
					break;
				case 'w' :
					bankObj.withdrawMoney();
					break;
				case 'a' :
					bankObj.displayAccountDetails();
					break;
					
				default :
					System.out.println("\n\t\tPlease enter a valid input\n");
			}
		}
		
		System.out.println("\n\t\tThank you for using the Bank Application!");
		
		sc.close();	// To close the scanning since it is not required further
	}
}
