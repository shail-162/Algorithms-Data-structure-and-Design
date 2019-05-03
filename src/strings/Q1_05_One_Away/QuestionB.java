package strings.Q1_05_One_Away;

/**
 * There are 3 types of edits can be performed on a strings : insert a char, delete a char and replace a char.
 * Given two strings, write a function to check if they are one edit [or zero edits] away.
 *
 * Fox example:
 * pale, ple --> true
 * pales, pale --> true
 * pale, bale --> true
 * pale, bae --> false
 */

public class QuestionB {

public static boolean oneEditAway(String first, String second) {
		/* Length checks. */
		if (Math.abs(first.length() - second.length()) > 1) {
			return false;
		}
		
		/* Get shorter and longer string.*/
		String s1 = first.length() < second.length() ? first : second; //small
		String s2 = first.length() < second.length() ? second : first; //large

		int index1 = 0;
		int index2 = 0;
		boolean foundDifference = false;
		while (index2 < s2.length() && index1 < s1.length()) {
			if (s1.charAt(index1) != s2.charAt(index2)) {
				/* Ensure that this is the first difference found.*/
				if (foundDifference) return false;
				foundDifference = true;
				if (s1.length() == s2.length()) { // On replace, move shorter pointer
					index1++;
				}
			} else {
				index1++; // If matching, move shorter pointer 
			}
			index2++; // Always move pointer for longer string 
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		String a = "palee";
		String b = "pale";
		boolean isOneEdit1 = oneEditAway(a, b);
		System.out.println(a + ", " + b + ": " + isOneEdit1);

		String c = "pale";
		String d = "pkle";
		boolean isOneEdit2 = oneEditAway(c, d);
		System.out.println(c + ", " + d + ": " + isOneEdit2);
	}

}
