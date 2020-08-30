package facebook;

import java.io.*;

/**
 * Passing Yearbooks
 * There are n students, numbered from 1 to n, each with their own yearbook. They would like to pass their yearbooks around and get them signed by other students.
 * You're given a list of n integers arr[1..n], which is guaranteed to be a permutation of 1..n (in other words, it includes the integers from 1 to n exactly once each, in some order).
 * The meaning of this list is described below.
 * Initially, each student is holding their own yearbook. The students will then repeat the following two steps each minute:
 * Each student i will first sign the yearbook that they're currently holding (which may either belong to themselves or to another student),
 * and then they'll pass it to student arr[i]. It's possible that arr[i] = i for any given i,
 * in which case student i will pass their yearbook back to themselves. Once a student has received their own yearbook back,
 * they will hold on to it and no longer participate in the passing process.
 * It's guaranteed that, for any possible valid input, each student will eventually receive their own yearbook back
 * and will never end up holding more than one yearbook at a time.
 * You must compute a list of n integers output,
 * whose ith element is equal to the number of signatures that will be present in student i's yearbook once they receive it back.
 * Signature
 * int[] findSignatureCounts(int[] arr)
 * Input
 * n is in the range [1, 100,000].
 * Each value arr[i] is in the range [1, n], and all values in arr[i] are distinct.
 * Output
 * Return a list of n integers output, as described above.
 * Example 1
 * n = 2
 * arr = [2, 1]
 * output = [2, 2]
 * The first student will sign their own yearbook and pass it to the second, who will also sign it and pass it back to the first student,
 * resulting in 2 signatures. Meanwhile, the second student's yearbook will similarly be signed both by themselves and then by the first student.
 * Example 2
 * n = 2
 * arr = [1, 2]
 * output = [1, 1]
 * Each student will simply pass their yearbook back to themselves, resulting in 1 signature each.
 *
 * @author shailesh
 */
class PassingYearbooks {

    int[] findSignatureCounts(int[] arr) {
        // Write your code here
        int output[] = new int[arr.length];
        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i] == i) {
                output[i] = i + 1;
            } else {
                if (arr[i] < i){
                    output[i] = arr.length;
                } else {
                    int sig =  arr[i] - i;
                    output[i] = sig;
                }
            }
        }
        return output;
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
        int[] arr_1 = {2, 1};
        int[] expected_1 = {2, 2};
        int[] output_1 = findSignatureCounts(arr_1);
        check(expected_1, output_1);

        int[] arr_2 = {1, 2};
        int[] expected_2 = {1, 1};
        int[] output_2 = findSignatureCounts(arr_2);
        check(expected_2, output_2);

        int[] arr_3 = {2, 3, 5, 1, 4};
        int[] expected_3 = {2, 2, 3, 5, 5};
        int[] output_3 = findSignatureCounts(arr_3);
        check(expected_3, output_3);

    }

    public static void main(String[] args) throws IOException {
        new PassingYearbooks().run();
    }
}