package jdbc.exception;

//있는 사람 또  추가할때 발생하는 예외 클래스..
public class DuplicateIDException extends Exception {
	public DuplicateIDException(){
		this("This is DuplicateIDException...");
	}
	public DuplicateIDException(String message){
		super(message);
	}
}
