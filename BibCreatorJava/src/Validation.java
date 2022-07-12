import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Validation {
	

	//method to create 3 files for each .bib
	
	
	public static void processFilesForValidation()  {
		
		int number = 1;
		String fileTitle = "Latex";
		while(number <= 10) {
			String fileName = fileTitle + number + ".bib";
			String fileName1 = "IEEE";
			String fileName2 = "ACM";
			String fileName3 = "NJ";
			//delete if files is not valid
			if(validateFile(readFile(fileName), fileName) != null) {
				//message that file has invalid field and delete 3 created files
				System.out.println(validateFile(readFile(fileName), fileName));	
				//DELETE 3 CREATED FILES	
				File f;	
				f = new File(fileName1 + number + ".json");
				f.delete();
				f = new File(fileName2 + number + ".json");
				f.delete();
				f = new File(fileName3 + number + ".json");
				f.delete();
				}
			//write if file is valid 
			else {
				
				File file1 = new File(fileName1 + number + ".json");  //IEEE
				File file2 = new File(fileName2 + number + ".json");   //ACM
				File file3 = new File(fileName3 + number + ".json");  //JN
				PrintWriter pw = null;
				
				// write to IEEE file
				try {
					String resIEEE = "";	  
					String ContentIEEE = "";
					String[] article = readFile(fileName).split("@ARTICLE");
					    
					for(int i= 0; i < article.length; i++) {
						String[] rows = article[i].split("\n");	
					  			
					  	for(int j= 1; j < rows.length; j++) {
					  		if (rows[j].indexOf("author={")!= -1){
					  			ContentIEEE = rows[j].substring(rows[j].indexOf("author={")+8, rows[j].indexOf("},")) + ". ";
					  			}
					  		
					  		if (rows[j].indexOf("title={") != -1){
					  			ContentIEEE += "'" + rows[j].substring(rows[j].indexOf("title={")+7, rows[j].indexOf("},")) + "', ";
					  			}	
					  		
					  		if (rows[j].indexOf("journal={") != -1){
					  			ContentIEEE += rows[j].substring(rows[j].indexOf("journal={")+9, rows[j].indexOf("},")) + ", ";
					  			}	
					  		
					  		if(rows[j].indexOf("volume={") != -1){
					  			ContentIEEE += "vol." + rows[j].substring(rows[j].indexOf("volume={")+8, rows[j].indexOf("},")) + ", ";
					  			}
					  				
					  		if(rows[j].indexOf("number={") != -1){
					  			ContentIEEE += "no." + rows[j].substring(rows[j].indexOf("number={")+8, rows[j].indexOf("},")) + ", ";
					  			}
					  				
					  		if(rows[j].indexOf("pages={") != -1) {
							  	ContentIEEE += "p." + rows[j].substring(rows[j].indexOf("pages={")+7, rows[j].indexOf("},")) + ", ";
						  		}
					  				
					  		if(rows[j].indexOf("month={") != -1) {
							  	ContentIEEE += rows[j].substring(rows[j].indexOf("month={")+7, rows[j].indexOf("},"));
						  		}
					  		if(rows[j].indexOf("year={") != -1) {
					  			ContentIEEE += rows[j].substring(rows[j].indexOf("year={")+6, rows[j].indexOf("},"));
						  	} 		
					  	}
					  	resIEEE += ContentIEEE + "\n";
					}
					pw = new PrintWriter(file1);
					pw.write(resIEEE);
					pw.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
								 
				//write to ACM file
				try {
					String resACM = "";	  
					String ContentACM = "";
					int numberTitle = 1;
					String[] article = readFile(fileName).split("@ARTICLE");
						
					for(int i= 0; i <article.length; i++) {
						String[] rows = article[i].split("\n");	
							
						for(int j= 1; j < rows.length; j++) {
								
							if ((rows[j].indexOf("author={")!= -1 && rows[j].indexOf("and") != -1)) {
								ContentACM = "[" + numberTitle + "]" + rows[j].substring(rows[j].indexOf("author={")+8, rows[j].indexOf("and")) + "et al.";
								numberTitle++;
								}
															  		
					  		if (rows[j].indexOf("title={") != -1){
					  			ContentACM += rows[j].substring(rows[j].indexOf("title={")+7, rows[j].indexOf("},")) + ". ";
					  			}	
					  		
					  		if (rows[j].indexOf("journal={") != -1){
					  			ContentACM += rows[j].substring(rows[j].indexOf("journal={")+9, rows[j].indexOf("},")) + ". ";
					  			}	
					  		
					  		if(rows[j].indexOf("volume={") != -1){
					  			ContentACM += rows[j].substring(rows[j].indexOf("volume={")+8, rows[j].indexOf("},")) + ", ";
					  			}
					  			
					  		if(rows[j].indexOf("year={") != -1) {
					  			ContentACM += rows[j].substring(rows[j].indexOf("year={")+6, rows[j].indexOf("},"));
						  	} 	
					  		if(rows[j].indexOf("number={") != -1){
					  			ContentACM += "PP." + rows[j].substring(rows[j].indexOf("number={")+8, rows[j].indexOf("},")) + ", ";
					  			}
					  				
					  		if(rows[j].indexOf("pages={") != -1) {
					  			ContentACM += rows[j].substring(rows[j].indexOf("pages={")+7, rows[j].indexOf("},")) + ", ";
						  		}
					  				
					  		if((rows[j].indexOf("doi={") != -1) && rows[j].indexOf("},") != -1) {
							  	ContentACM += "DOI:https://doi.org/" + rows[j].substring(rows[j].indexOf("doi={")+5, rows[j].indexOf("},")) + ". ";
						  	}
 						}
						resACM += ContentACM + "\n";
					}
					pw = new PrintWriter(file2);
					pw.write(resACM);
					pw.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
					 
				// write to NJ file
				try {
					String resNJ = "";	  
					String ContentNJ = "";
					String[] article = readFile(fileName).split("@ARTICLE");
						
					for(int i= 0; i < article.length; i++) {
						String[] rows = article[i].split("\n");	
							
						for(int  j= 1; j < rows.length; j++) {
						
							if(rows[j].indexOf("author={") != -1)  {
							  	ContentNJ = rows[j].substring(rows[j].indexOf("author={" )+8, rows[j].indexOf("},")).replace("and", " & " ) + ". ";
							}
			
							if(rows[j].indexOf("title={") != -1)  {
							  	ContentNJ += rows[j].substring(rows[j].indexOf("title={")+7, rows[j].indexOf("},")) + ". ";
						  	}
							if(rows[j].indexOf("journal={") != -1)  {
							  	ContentNJ += rows[j].substring(rows[j].indexOf("journal={")+9, rows[j].indexOf("},")) + ". ";
						  	}
							if(rows[j].indexOf("volume={") != -1) {
							  	ContentNJ += rows[j].substring(rows[j].indexOf("volume={")+8, rows[j].indexOf("},")) + ", ";
							}
							if(rows[j].indexOf("pages={") != -1)  {
								ContentNJ += rows[j].substring(rows[j].indexOf("pages={")+7, rows[j].indexOf("},")) + ", ";
							}
							if(rows[j].indexOf("year={") != -1)  {
							  	ContentNJ += "(" + rows[j].substring(rows[j].indexOf("year={")+6, rows[j].indexOf("},")) + ").";	
						  	}				
						}
						resNJ += ContentNJ + "\n";
					}
					pw = new PrintWriter(file3);
					pw.write(resNJ);
					pw.close();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
			number++;

		}
	}

	public static String validateFile(String fileContent, String fileName) {
		String[] content = fileContent.split("@ARTICLE");
	
		//Pattern pattern = Pattern.compile("^\\{^$\\}$");
		//Matcher matcher = pattern.matcher(fileContent);
		//boolean found = matcher.matches();
		for(int i= 0; i < content.length; i++) {
	
			String[] temp = content[i].split("=\\{}");
			String str = "";
			for(int j= 1; j < temp.length; j++) {
				if(temp.length>1) {
					temp=temp[0].split(",");
					str = (temp[temp.length - 1]);
					
					String info = "\nCould not open input file   " +
							fileName + " .bib for reading.\nField " +"'" + temp[j].substring(0, temp[j].indexOf("=")) +"'"+ " is Empty. Processing stopped at this point.";	
					return info;
				}
			}
		}
		return null;
	}
	
	public static String readFile(String fileName){
		Scanner scanner = new Scanner(System.in);
		Scanner fileReader = null; // use for reading file
		String fileContent = "";
		try {
			fileReader = new Scanner(new FileInputStream(fileName));
		}
		catch(IOException e) {
			System.out.println("Could not open input file " + fileName + " for reading. \\nPlease check if file exists! Program will terminate fter closing any opened files");
				System.exit(0); 

		}
		while (fileReader.hasNext() == true ) {
			fileContent += fileReader.nextLine() + "\n";
	    }
		return fileContent;
	}

}
