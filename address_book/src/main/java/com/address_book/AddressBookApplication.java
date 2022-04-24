package com.address_book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
		AddressBook addressBook = new AddressBook();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\n\n\n\n");
		while (true) { //infinite loop it will run forever
			System.out.println("\n\n\n1. Add an entry\n"
					+ "2. Remove and entry\n"
					+ "3. Search for a specific entry\n"
					+ "4. Print the contents of the address book\n"
					+ "5. Delete the contents of the address book\n"
					+ "6. Quit the program\n");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter email: ");
				String email = sc.next();
				if (addressBook.entryWithEmailNExists(email)) {
					System.out.println("Entry already exists\n");
					continue;
				}
				System.out.println("Enter first name: ");
				String firstName = sc.next();
				System.out.println("Enter last name: ");
				String lastName = sc.next();
				System.out.println("Enter phone no: ");
				String phoneNo = sc.next();
				addressBook.addEntry(new Entry(firstName, lastName, phoneNo, email));
				break;
			case 2:
				System.out.println("Enter email: ");
				email = sc.next();
				if (!addressBook.entryWithEmailNExists(email)) {
					System.out.println("Entry doesnt exists\n");
					continue;
				}
				addressBook.removeEntry(email);
				break;
			case 3:
				System.out.print("Search criteria: (0::firstName\n1::lastName\n"
						+ "2::phone-no\n3::email\n");
				int searcCritera = sc.nextInt();
				System.out.println("Property value: ");
				String value = sc.next();
				List<Entry> byProperty = addressBook.findByProperty(value, searcCritera);
				for (int i = 0; i < byProperty.size(); i++) {
					System.out.println("Found property " + byProperty.get(i));
				}
				break;
			case 4:
				addressBook.printEntries();
				break;
			case 5:
				addressBook.removeContents();
				break;
			case 6:
				System.out.println("The program will now exit");
				return; //Terminate app
			default:
				System.out.println("\nWrong input");

			}
		}
	}
}
