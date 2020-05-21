import java.util.Scanner;

public class displayCalendar {

	static int getTotalNumberOfDays(int month, int year) {

		int totalDays = 0;

		for (int i = 1800; i < year; i++) {
			if (isLeapYear(i)) {
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}

		for (int i = 1; i < month; i++) {
			totalDays += getNumberOfDaysInMonth(i, year);
		}

		return totalDays;
	}

	static int getFirstDayOfMonth(int month, int year) {

		int janFirst1800 = 3;
		int totalNumberOfDays = getTotalNumberOfDays(month, year);
		return (totalNumberOfDays + janFirst1800) % 7;

	}

	static int getNumberOfDaysInMonth(int month, int year) {

		int daysInMonth = 0;

		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			daysInMonth = 31;
		}

		if (month == 4 || month == 6 || month == 9 || month == 11) {
			daysInMonth = 30;
		}

		if (month == 2) {
			if (isLeapYear(year)) {
				daysInMonth = 29;
			} else {
				daysInMonth = 28;
			}
		}

		return daysInMonth;
	}

	static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
	}

	static String getMonthName(int month) {

		String monthName = "";

		switch (month) {
		case 1:
			monthName = "January";
			break;
		case 2:
			monthName = "February";
			break;
		case 3:
			monthName = "March";
			break;
		case 4:
			monthName = "April";
			break;
		case 5:
			monthName = "May";
			break;
		case 6:
			monthName = "June";
			break;
		case 7:
			monthName = "July";
			break;
		case 8:
			monthName = "August";
			break;
		case 9:
			monthName = "September";
			break;
		case 10:
			monthName = "October";
			break;
		case 11:
			monthName = "November";
			break;
		case 12:
			monthName = "December";
		}

		return monthName;
	}

	static void printMonthHeader(int month, int year) {

		System.out.println();
		System.out.println("         " + getMonthName(month) + " " + year);
		System.out.println("–––––––––––––––––––––––––––––");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

	}

	static void printMonthBody(int month, int year) {

		int firstDayOfMonth = getFirstDayOfMonth(month, year);
		int numberOfDaysInMonth = getNumberOfDaysInMonth(month, year);

		int i = 0;
		for (i = 0; i < firstDayOfMonth; i++) {
			System.out.print("    ");
		}

		for (i = 1; i <= numberOfDaysInMonth; i++) {
			if (i < 10) {
				System.out.print("   " + i);
			} else {
				System.out.print("  " + i);
			}
			if ((i + firstDayOfMonth) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	static void printMonth(int month, int year) {

		printMonthHeader(month, year);
		printMonthBody(month, year);
		System.out.println();

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int year;
		int month;

		System.out.println("Welcome to Centennial College Calendar!");

		do {

			System.out.print("Please enter the year (yyyy format, 999 to exit): ");
			year = input.nextInt();

			if (year != 999) {

				System.out.print("Please enter the month (1 - 12): ");
				month = input.nextInt();

				printMonth(month, year);
			}

		} while (year != 999);

		input.close();
		System.out.print("You chose to exit. Goodbye!");

	}
	
}
