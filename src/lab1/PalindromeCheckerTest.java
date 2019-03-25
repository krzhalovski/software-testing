package lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PalindromeCheckerTest {
	public PalindromeChecker palindromeChecker = new PalindromeChecker();
	
	public static Collection<Object[]> palindromes() {
		return Arrays.asList(new Object[][] {
			{"Hello", false},
			{"HelloolleH", true},
			{"abAAba", true},
			{"abaABA", false},
			{"kalabalak", true}
		});
	}
	
	@DisplayName(value = "Testing with the palindrome ABBA")
	@Test
	public void testPalindrome() throws NullException, NotAWordException {
		assertEquals(true, palindromeChecker.palindrome("ABBA"));
	}
	
	@DisplayName(value = "Testing with a non-palindrome ABBB")
	@Test
	public void testNonPalindrome() throws NullException, NotAWordException {
		assertEquals(false, palindromeChecker.palindrome("ABBB"));
	}
	
	@DisplayName(value = "Testing with a null word")
	@Test
	public void testNullException() throws NullException, NotAWordException {
		assertThrows(NullException.class, () -> palindromeChecker.palindrome(null));
	}
	
	@DisplayName(value = "Testing with an empty string")
	@Test
	public void testEmptyWord() throws NullException, NotAWordException {
		assertThrows(NotAWordException.class, () -> palindromeChecker.palindrome(""));
	}
	
	@DisplayName(value = "Testing with the non word w0rd!")
	@Test
	public void testNonWord() throws NullException, NotAWordException {
		assertThrows(NotAWordException.class, () -> palindromeChecker.palindrome("w0rd!"));
	}
	
	@DisplayName(value = "Parameterized test")
	@ParameterizedTest
	@MethodSource("palindromes")
	public void parameterizedTest(String word, boolean result) throws NullException, NotAWordException {
			System.out.println("Parameterized word is: " + word);
			assertEquals(result, palindromeChecker.palindrome(word));
	}
}
