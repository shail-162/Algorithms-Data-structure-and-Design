package facebook;

/**
 * Matching Pairs
 * Given two strings s and t of length N, find the maximum number of possible matching pairs in strings s and t
 * after swapping exactly two characters within s.
 * A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present at the
 * ith and jth index of s, respectively.
 * The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
 * Note: This means you must swap two characters at different indices.
 * Signature
 * int matchingPairs(String s, String t)
 * Input
 * s and t are strings of length N
 * N is between 2 and 1,000,000
 * Output
 * Return an integer denoting the maximum number of matching pairs
 * Example 1
 * s = "abcd"
 * t = "adcb"
 * output = 4
 * <p>
 * Explanation:
 * Using 0-based indexing, and with i = 1 and j = 3, s[1] and s[3] can be swapped, making it  "adcb".
 * Therefore, the number of matching pairs of s and t will be 4.
 * Example 2
 * s = "mno"
 * t = "mno"
 * output = 1
 * Explanation:
 * Two indices have to be swapped, regardless of which two it is, only one letter will remain the same.
 * If i = 0 and j=1, s[0] and s[1] are swapped, making s = "nmo", which shares only "o" with t.
 */
public class MatchingPairs {

    // Add any helper functions you may need here

    //s = "abcd"
    //t = "adcb"

    int matchingPairs(String s, String t) {
        int matchPairsCount = 0;

        if (s.equals(t)) {
            return s.length() - 2;
        }

        char[] jArray = t.toCharArray();
        int ind = 0;
        int swappedIndex = -1;

        for (char i : s.toCharArray()) {
            if (swappedIndex != ind) {
                if (i == jArray[ind]) {
                    matchPairsCount++;
                } else {
                    int sindex = t.indexOf(i);
                    int tindex = s.indexOf(jArray[ind]);

                    if (sindex!= -1 && tindex!= -1 && i == jArray[sindex] &&
                            s.charAt(tindex) == jArray[ind]) {
                        matchPairsCount =  matchPairsCount + 2;
                        swappedIndex = sindex;
                    }
                }
            }

            ind++;
        }

        return matchPairsCount;
    }


    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() {
        String s_1 = "abcde";
        String t_1 = "adcbe";
        int expected_1 = 5;
        int output_1 = matchingPairs(s_1, t_1);
        check(expected_1, output_1);

        String s_2 = "abcd";
        String t_2 = "abcd";
        int expected_2 = 2;
        int output_2 = matchingPairs(s_2, t_2);
        check(expected_2, output_2);

        String s_3 = "abdc";
        String t_3 = "abce";
        int expected_3 = 3;
        int output_3 = matchingPairs(s_3, t_3);
        check(expected_3, output_3);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new MatchingPairs().run();
    }
}
