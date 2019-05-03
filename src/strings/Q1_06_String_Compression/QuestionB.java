package strings.Q1_06_String_Compression;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3. If the compressed string would not become smaller than
 * the original string should be returned. you can assume string has only uppercase and lower case letters.
 */
public class QuestionB {
	public static String compress(String str) {
		StringBuilder compressed = new StringBuilder();
		int countConsecutive = 0;
		for (int i = 0; i < str.length(); i++) {
			countConsecutive++;
			
			/* If next character is different than current, append this char to result.*/
			if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
				compressed.append(str.charAt(i));
				compressed.append(countConsecutive);
				countConsecutive = 0;
			}
		}
		return compressed.length() < str.length() ? compressed.toString() : str;
	}
	
	public static void main(String[] args) {
		String str = "aa";
		System.out.println(str);
		System.out.println(compress(str));
	}
}
