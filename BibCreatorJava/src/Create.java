import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Create {
	
	
	public static void createFiles() {
		int numberOfLatex = 1;
		String fileName1 = "IEEE";
		String fileName2 = "ACM";
		String fileName3 = "NJ";
		
		while(numberOfLatex <= 10) {
			String str1 = fileName1 + numberOfLatex + ".json";
			String str2 = fileName2 + numberOfLatex + ".json";
			String str3 = fileName3 + numberOfLatex + ".json";

			File file;
			file = new File(str1);
			try {
				file.createNewFile();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
			file = new File(str2);
			try {
				file.createNewFile();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
			file = new File(str3); 
			try {
				file.createNewFile();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			numberOfLatex++;
		}
	}

}
