package lab1;

public class NotAWordException extends Exception{
	public NotAWordException(String word) {
		super(word + " is not a word!");
	}
}
