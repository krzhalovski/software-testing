package lab1;

public class PalindromeChecker {
	
	public PalindromeChecker() {}
	
	public Boolean palindrome(String word) throws NullException, NotAWordException {
		if(word==null) throw new NullException();
		
		if(word.length() == 0 || !word.matches("^[a-zA-Z]*$"))
			throw new NotAWordException(word);
		
		return new StringBuilder(word).reverse().toString().equals(word);
	}
}
