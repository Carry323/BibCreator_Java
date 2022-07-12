import java.lang.Exception;

public class FileInvalidException extends Exception {
	
	public FileInvalidException() {
		
		super("Error: Input file cannot be parsed due to missing information ");
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
