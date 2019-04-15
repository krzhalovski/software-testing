package lab2;

import java.util.HashSet;
import java.util.Set;

public class MySetClass {
	
	public static Set<Object> intersection(Set<Object> s1, Set<Object> s2) {
		if(s1==null || s2==null) throw new NullPointerException();
		Set<Object> intersection = new HashSet<Object>(s1);
		intersection.retainAll(s2);
		return intersection;
	}

}
