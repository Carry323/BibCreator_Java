import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exist {
	
	//method to check if all 10 files exist
	
	public static void FilesExist() {
		int numberOfLatex = 1;
		String fileTitle = "Latex";
		while(numberOfLatex <= 10) {
			Path currentRelativePath = Paths.get("");
			String s = currentRelativePath.toAbsolutePath().toString() + "/" + fileTitle + numberOfLatex + ".bib";
			File f = new File(s);
			//if some file does not exist then show a message and exit program
			if(!f.exists()) { 
			    System.out.println("Could not open input file " + fileTitle + numberOfLatex + ".bib" + " for reading. Please check if file exists! Program will terminate after closing any opened files.");
			    System.exit(0);
			}
			else {
				//System.out.println("All is good");
			}
			numberOfLatex++;
		}
	}
	

}
