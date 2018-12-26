package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS
	// A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<Character> ca = new Stack<Character>();
		boolean r = false;
		int numClosed = 0;
		for (int i = 0; i < b.length(); i++) {
			ca.push(b.charAt(i));
		}
		char s = 'c';
		for (int i = 0; i < b.length(); i++) {
			s = ca.pop();
			if (s == '}') {
				numClosed++;
			}
			if (s == '{') {
				if (numClosed <= 0) {
					r = false;
					break;
				} else {
					r = true;
					numClosed--;
				}
			}
		}
		return r;
	}

}