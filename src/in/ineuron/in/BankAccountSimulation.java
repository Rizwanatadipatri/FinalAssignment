package in.ineuron.in;

import java.util.Scanner;

public class BankAccountSimulation {

	private double balance;

	public BankAccountSimulation() {
		balance = 0.0;
	}

	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposited: $" + amount);
	}

	public void withdraw(double amount) {
		if (amount <= balance) {
			balance -= amount;
			System.out.println("Withdrawn: $" + amount);
		} else {
			System.out.println("Insufficient funds. Unable to withdraw.");
		}
	}

	public double getBalance() {
		return balance;
	}

	public static void main(String[] args) {
		BankAccountSimulation account = new BankAccountSimulation();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("Bank Account Simulation");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.print("Enter the amount to deposit: $");
				double depositAmount = sc.nextDouble();
				account.deposit(depositAmount);
				break;
			case 2:
				System.out.print("Enter the amount to withdraw: $");
				double withdrawAmount = sc.nextDouble();
				account.withdraw(withdrawAmount);
				break;
			case 3:
				System.out.println("Current Balance: $" + account.getBalance());
				break;
			case 4:
				System.out.println("Exiting program...");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}

			System.out.println();
		}

	}
}
