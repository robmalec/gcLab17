package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

public class CountryApp {
	static ArrayList<Country> cList = new ArrayList<>();
	static Scanner scn = new Scanner(System.in);
	static int longestNameLength = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		longestNameLength = CountriesTextFile.readCountries(cList);

		int nextMove = 0;
		Boolean listEdited = false;

		System.out.println("Welcome to the Countries Maintenance Application!");
// While loop
		while (nextMove != 3) {
			nextMove = Validator.getInt(scn,
					"1 - See the list of the countries\n2 - Add a country\n3 - Exit\n\nEnter menu number: ");
			System.out.println("");

			switch (nextMove) {
			case 1:
				showCountries();
				break;
			case 2:
				addCountry();
				listEdited = true;
				break;
			case 3:
				break;
			}
			System.out.println("");
		}

		if (listEdited) {
			CountriesTextFile.writeCountries(cList);
		}

// Indication that the program has ended
		System.out.println("Goodbye.");
		scn.close();
	}

	static void showCountries() {
		if (cList.size() != 0) {
			final String FORMAT = "%-" + String.valueOf(longestNameLength) + "s%-10s";
			System.out.printf(FORMAT, "Country name", "Population");
			System.out.println("");
			System.out.println("");

			for (Country c : cList) {
				System.out.printf(FORMAT, c.getName(), String.valueOf(c.getPopulation()));
				System.out.println("");
			}
		} else {
			System.out.println("There aren't yet any countries in your database.  Add one!");
		}
	}

	static void addCountry() {
		System.out.println("Adding a country:");
		System.out.println("");
		String name = Validator.getString(scn, "Enter country name: ");
		if (name.length() > longestNameLength) {
			longestNameLength = (name.length() + 1);
		}
		
		int population = Validator.getInt(scn, "Enter country population: ");

		cList.add(new Country(name, population));
		System.out.println("This country has been saved. ");
	}

}
