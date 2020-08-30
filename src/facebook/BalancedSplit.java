package facebook;

import java.util.Arrays;

/**
 * Balanced Split
 * Given an array of integers (which may include repeated integers),
 * determine if there's a way to split the array into two subarrays A and B
 * such that the sum of the integers in both arrays is the same, and all of the integers in A are strictly
 * smaller than all of the integers in B.
 * Note: Strictly smaller denotes that every integer in A must be less than, and not equal to,
 * every integer in B.
 * Signature
 * bool balancedSplitExists(int[] arr)
 * Input
 * All integers in array are in the range [0, 1,000,000,000].
 * Output
 * Return true if such a split is possible, and false otherwise.
 * Example 1
 * arr = [1, 5, 7, 1]
 * output = true
 * We can split the array into A = [1, 1, 5] and B = [7].
 * Example 2
 * arr = [12, 7, 6, 7, 6]
 * output = false
 * We can't split the array into A = [6, 6, 7] and B = [7, 12] since this doesn't satisfy the requirement that all integers in A are smaller than all integers in B.
 */
public class BalancedSplit {

    //[12, 7, 6, 7, 6]
    // 6 6 7 7 12

    //3, 6, 3, 4, 4

    boolean balancedSplitExists(int[] arr) {
        Arrays.sort(arr);
        int lsum = 0;
        int rsum =0;

        for (int i =0; i <= arr.length-1; i++){
            lsum+=arr[i];
        }

        //3 3 4 4 6
        //lsum -- 20

        for (int i = arr.length-1; i >=0; i--) {
            rsum = rsum + arr[i];
            lsum = lsum - arr[i];

            if (lsum == rsum){
                if(arr[i-1] < arr[i]){
                    return true;
                }
            }
        }


        return false;
    }




    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(boolean expected, boolean output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            System.out.print(expected);
            System.out.print(" Your output: ");
            System.out.print(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[" + str + "]");
    }

    public void run() {
        int arr_1[] = {1, 5, 7, 1};
        boolean expected_1 = true;
        boolean output_1 = balancedSplitExists(arr_1);
        check(expected_1, output_1);

        int arr_2[] = {12, 7, 6, 7, 6} ;
        boolean expected_2 = false;
        boolean output_2 = balancedSplitExists(arr_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new BalancedSplit().run();
    }
}
