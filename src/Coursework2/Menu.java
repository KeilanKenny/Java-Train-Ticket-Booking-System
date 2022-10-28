package Coursework2;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;

public class Menu {
	private static Scanner input = new Scanner(System.in);

	private static Seats[] seats = new Seats[18];

	public static void main(String[] args) throws Exception {

		loadSeats();

		String choice = "";

		do {
			System.out.println("\n--MAIN MENU --");
			System.out.println("1 -Reserve Seat");
			System.out.println("2 -Cancel Seat Reservation");
			System.out.println("3 -View Seat Reservations");
			System.out.println("Q -Quit");
			System.out.print("Pick: ");
			// This changes the value entered to upper case so if the user input "q" it will
			// be changed to "Q".
			choice = input.next().toUpperCase();

			switch (choice) {
			// This part chooses which method to run and then break allows the code to run
			// again and bring up the menu again.
			case "1": {
				reserveSeat();
				break;
			}
			case "2": {
				cancelSeat();
				break;
			}
			case "3": {
				viewSeats();
				break;
			}
			}
			// This piece of code means if Q is entered the code will stop running and print
			// "Goodbye" and the menu will not run again.
		} while (!choice.equals("Q"));
		System.out.println("--GOODBYE --");
		// Writer fileWriter = new FileWriter("M:\\data\\seats.txt");
		// filewriter.flush();
		// fileWriter.close();

	}

	private static void loadSeats() throws FileNotFoundException {
		Scanner file = new Scanner(new FileReader("M:\\data\\seats.txt"));
		int index = 0;
		// This piece of code reads the file and assigns the contents of the file to a
		// variable.
		while (file.hasNext()) {
			String seatNum = file.next();
			String seatClass = file.next();
			boolean isWindow = Boolean.parseBoolean(file.next());
			boolean isAisle = Boolean.parseBoolean(file.next());
			boolean isTable = Boolean.parseBoolean(file.next());
			double seatPrice = Double.parseDouble(file.next());
			String email = file.next();

			seats[index] = new Seats(seatNum, seatClass, isWindow, isAisle, isTable, seatPrice, email);
			index++;
		}
		file.close();
	}

	// If user entered "1"
	private static void viewSeats() {

		System.out.println("\n--SEATS--");
		// This piece of code refers to the array and makes the system print the file
		// contents.
		for (int i = 0; i < seats.length; i++) {
			System.out.println(seats[i]);
		}
	}

	// If user entered "2"
	public static void reserveSeat() {
		System.out.println("\n--RESERVE A SEAT--");
		// Brings up the file contents so user is able to see what seats are taken.
		viewSeats();

		System.out.print("Enter seat class(STD/1ST):");
		// This makes sure whatever is entered by the user upper case so it fits the
		// criteria of the file which is "STD" or "1ST" in upper case.
		String seatClass = input.next().toUpperCase();

		System.out.print("Window seat?(true/false):");
		boolean isWindow = input.nextBoolean();

		System.out.print("Aisle seat?(true/false):");
		boolean isAisle = input.nextBoolean();

		System.out.print("Table seat?(true/false):");
		boolean isTable = input.nextBoolean();

		System.out.print("Enter email address: ");
		// Converts input to upper case to make cancelling a seat reservation easier.
		String email = input.next().toUpperCase();

		for (int i = 0; i < seats.length; i++) {
			// This takes the first input and matches it to a seat class and so forth for
			// each variable.
			if (seats[i].getSeatClass().equals(seatClass))
				if (seats[i].getIsWindow() == isWindow)
					if (seats[i].getIsAisle() == isAisle)
						if (seats[i].getIsTable() == isTable)
							// Then once all the input have been matched with each variable the next piece
							// of code changes the "free" to the entered email.
							if (seats[i].getEmail().equals("free")) {
								seats[i].setEmail(email);
								// Next piece of code uses the new entered data to show what seat is booked for
								// the email.
								System.out.println(
										"Seat " + seats[i].getSeatNum() + " reserved for " + seats[i].getEmail());

								return;
							}
		}

	}

	// If user entered "3"
	private static void cancelSeat() {
		System.out.println("\n--CANCEL A SEAT RESERVATION--");
		viewSeats();

		System.out.print("Enter email address: ");
		// So that the email entered matches the email used to reserve a seat.
		String email = input.next().toUpperCase();

		for (int i = 0; i < seats.length; i++) {
			// If the email entered matches and email used to reserve a seat it will change
			// the email to "free".
			if (seats[i].getEmail().equals(email)) {
				seats[i].setEmail("free");
				System.out.println("Booking cancelled.");
				return;
			}
		}
	}
}