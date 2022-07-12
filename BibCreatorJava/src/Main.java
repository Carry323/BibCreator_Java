import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;
import java.lang.Exception;

public class Main {


	public static void main(String[] args) {
		System.out.println("Welcome to BibCreator");
		
		
		Exist FE = new Exist();
		FE.FilesExist();
		
		Create CF = new Create(); 
		CF.createFiles();
		
		Validation VF = new Validation();
		VF.processFilesForValidation();
		
		Scanner scanner = new Scanner(System.in);
		// the user has only 2 chances to open the file
		for (int i = 0; i < 2; i++) {
			System.out.print("Please enter the name of the files you want to review in format NameNumber.json (IEEE6.json)");
			System.out.print("\nYou can choose beetwen IEEE, ACM and NJ formats");
			
			String FileNameForUser = scanner.nextLine();
			File file1 = new File(FileNameForUser);
			BufferedReader bufferedReader = null;
			try {

			bufferedReader = new BufferedReader(new FileReader(file1));
			String line;
			System.out.println("There are the contents of the file: "+file1);
				//read each line using readLine() method and print it
			while((line = bufferedReader.readLine()) != null){
						System.out.println(line);
					}
			System.exit(0);
			}
			catch (IOException e) {

			}
		}System.out.print("your tries are over");
		scanner.close();
		


	}




}
