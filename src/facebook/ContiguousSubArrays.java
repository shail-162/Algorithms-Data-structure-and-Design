package facebook;

import java.util.LinkedList;
import java.util.List;

/**
 * Contiguous Sub-arrays
 * You are given an array arr of N integers. For each index i, you are required to determine the number of contiguous sub-arrays
 * that fulfills the following conditions:
 * The value at index i must be the maximum element in the contiguous sub-arrays, and
 * These contiguous sub-arrays must either start from or end on index i.
 * Signature
 * int[] countSub-arrays(int[] arr)
 * Input
 * Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
 * Size N is between 1 and 1,000,000
 * Output
 * An array where each index i contains an integer denoting the maximum number of contiguous sub-arrays of arr[i]
 * Example:
 * arr = [3, 4, 1, 6, 2]
 * output = [1, 3, 1, 5, 1]
 * Explanation:
 * For index 0 - [3] is the only contiguous sub-array that starts (or ends) with 3, and the maximum value in this sub-array is 3.
 * For index 1 - [4], [3, 4], [4, 1]
 * For index 2 - [1]
 * For index 3 - [6], [6, 2], [1, 6], [4, 1, 6], [3, 4, 1, 6]
 * For index 4 - [2]
 * So, the answer for the above input is [1, 3, 1, 5, 1]
 *
 * @author Shailesh
 */

public class ContiguousSubArrays {
    int[] countSubarrays(int[] arr) {
        // Write your code here
        if (arr == null || arr.length == 0) return null;
        int n = arr.length;
        int[] ans = new int[n];
        int[] L = getLeftCounts(arr, n);
        reverseArray(arr);
        int[] R = getLeftCounts(arr, n);
        reverseArray(R);
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] + R[i] + 1;
        }

        return ans;
    }

    private void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
    }

    private int[] getLeftCounts(int[] arr, int n) {
        int[] L = new int[n];
        List<Integer> maxes = new LinkedList<>();
        maxes.add(0);
        L[0] = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                L[i] = 0;
                continue;
            }
            maxes.add(i);

            int maxesIndex = maxes.size() - 2;
            int currentMaxIndex = maxes.get(maxesIndex);
            int currentMax = arr[currentMaxIndex];
            if (arr[i] >= currentMax) {
                while (maxesIndex > 0 && arr[i] >= currentMax) {
                    currentMaxIndex = --maxesIndex;
                    currentMax = arr[currentMaxIndex];
                }
            }

            if (arr[currentMaxIndex] <= arr[i]) {
                L[i] = L[currentMaxIndex] + i - currentMaxIndex;
            } else {
                int j = maxes.get(maxesIndex);
                int nextJ = maxes.get(maxesIndex + 1);

                // This is a decreasing sequence. Use Binary Search!
                while (j <= nextJ && arr[j] >= arr[i]) {
                    j++;
                }
                L[i] = i - j;
            }
        }
        return L;
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(int[] expected, int[] output) {
        int expected_size = expected.length;
        int output_size = output.length;
        boolean result = true;
        if (expected_size != output_size) {
            result = false;
        }
        for (int i = 0; i < Math.min(expected_size, output_size); i++) {
            result &= (output[i] == expected[i]);
        }
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printIntegerArray(expected);
            System.out.print(" Your output: ");
            printIntegerArray(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printIntegerArray(int[] arr) {
        int len = arr.length;
        System.out.print("[");
        for(int i = 0; i < len; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arr[i]);
        }
        System.out.print("]");
    }

    public void run() {
        int[] test_1 = {3, 4, 1, 6, 2};
        int[] expected_1 = {1, 3, 1, 5, 1};
        int[] output_1 = countSubarrays(test_1);
        check(expected_1, output_1);

        int[] test_2 = {2, 4, 7, 1, 5, 3};
        int[] expected_2 = {1, 2, 6, 1, 3, 1};
        int[] output_2 = countSubarrays(test_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }
    public static void main(String[] args) {
        new ContiguousSubArrays().run();
    }
}
