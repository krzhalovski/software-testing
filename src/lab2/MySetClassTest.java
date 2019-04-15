package lab2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MySetClassTest {
	
	public static Collection<Object[]> baseCasesIM(){
		return Arrays.asList(new Object[][] {
			{new HashSet<Object>(), new HashSet<Object>(),  new HashSet<Object>()},
			{new HashSet<Object>(), null, null},
			{new HashSet<Object>(), new HashSet<Object>(Arrays.asList(new Object[] {2})), new HashSet<Object>()},
			{null, new HashSet<Object>(), null},
			{new HashSet<Object>(Arrays.asList(new Object[] {2})) , new HashSet<Object>(), new HashSet<Object>()}
		});
	}
	
	public static Collection<Object[]> baseCasesFM() {
		return Arrays.asList(new Object[][] {
			{Arrays.asList(new Object[] {1, 2, 3}), Arrays.asList(new Object[] {4, 5, 6}), Arrays.asList(new Object[] {})},
			{Arrays.asList(new Object[] {1, 2, 3}), Arrays.asList(new Object[] {4, 5, 6, 7}), Arrays.asList(new Object[] {})},
			{Arrays.asList(new Object[] {1, 2, 3}), Arrays.asList(new Object[] {4, 5}), Arrays.asList(new Object[] {})},
			{Arrays.asList(new Object[] {1, 2}), Arrays.asList(new Object[] {4, 5, 6}), Arrays.asList(new Object[] {})},
			{Arrays.asList(new Object[] {1, 2, 3, 4}), Arrays.asList(new Object[] {4, 5, 6}), Arrays.asList(new Object[] {4})}
		});
	}
	
	@ParameterizedTest
	@MethodSource("baseCasesIM")
	public void testBaseCasesIM (Set<Object> s1, Set<Object> s2, Set<Object> expected) {
		assertEquals(expected, MySetClass.intersection(s1, s2));
	}
	
	@ParameterizedTest
	@MethodSource("baseCasesFM")
	public void testBaseCasesFM (List<Object> s1, List<Object> s2, List<Object> expected) {
		assertEquals(new HashSet<Object>(expected), MySetClass.intersection(new HashSet<Object>(s1), new HashSet<Object>(s2)));
	}
	
}
