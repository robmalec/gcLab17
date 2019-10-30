package co.grandcircus;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {
	private static final String FILE_NAME = "countries.txt";
	private static final Path FILE_PATH = Paths.get("resources", FILE_NAME);
	private static final File FILE = FILE_PATH.toFile();

	public static void createOurFile() {
		// We can reference a folder name as the first param if we want to organize our
		// text files
		// in a folder or directory

		if (Files.notExists(FILE_PATH)) {
			try {
				Files.createFile(FILE_PATH);
				System.out.println("The file was created successfully.");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Something bad happened!");
			}
		} else {
			System.out.println("The file already exists!");
		}
	}

	public static int readCountries(ArrayList<Country> list) {
		String tempLine = "";
		int longestNameLength = 20;

		try {
			BufferedReader br = new BufferedReader(new FileReader(FILE));

			while (br.ready()) {
				String s = br.readLine();
				int nameLength = s.indexOf(",");
				if (nameLength > longestNameLength) {
					longestNameLength = nameLength + 1;
				}
				list.add(new Country(br.readLine()));
			}
			//System.out.println(br.readLine());
			
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception");
		}
		
		return longestNameLength;
	}

	public static void writeCountries(ArrayList<Country> list) {
		PrintWriter output = null;
		try {
			output = new PrintWriter(new FileOutputStream(FILE, false));
			
			for (Country c : list) {
				output.println(c);
			}
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("Hey, contact customer service!");
			e1.printStackTrace();
		} finally {
			output.close();
			System.out.println("Countries file successfully updated.");
		}
	}

	public static String getFileName() {
		return FILE_NAME;
	}
}
