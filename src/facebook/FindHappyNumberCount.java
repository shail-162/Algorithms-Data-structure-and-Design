package facebook;

import java.util.Arrays;

/**
 * @author Shailesh
 *
 * Count Pairs Problem Description Given an array of integers A, and an integer K find number of happy elements.
 * Element X is happy if there exists at least 1 element whose difference is less than K
 * i.e. an element X is happy, if there is another element in the range [X-K, X+K] other than X itself.
 * Constraints 1 <= N <= 10^5
 * 0 <= K <= 10^5
 * 0 <= A[i] <= 10^9
 * Input First line contains two integers N and K where N is size of the array and K is a number as described above
 * Second line contains N integers separated by space.
 * Output Print a single integer denoting the total number of happy elements.
 * Time Limit 1
 *
 * Examples Example 1
 *
 * Input
 * 6 3
 * 5 5 7 9 15 2
 * Output
 * 5
 *
 * Explanation
 * Other than number 15, everyone has at least 1 element in the range [X-3, X+3].
 * Hence they are all happy elements. Since these five are in number, the output is 5.
 * Example 2
 * Input
 * 3 2
 * 1 3 5
 * Output
 * 3
 * Explanation
 *
 * All numbers have at least 1 element in the range [X-2, X+2].
 * Hence they are all happy elements. Since these three are in number, the output is 3.
 */
public class FindHappyNumberCount {

    public static void main(String[] args) {

        int[] arr = {5,5,7,9,15,2} ;
        //int arr[] ={1,3,5} k =2
        int cnt = getCountOfHappyNumbers(arr, 3);
        System.out.println(cnt);
    }

    /**
     * Complexity O(n*log(n))
     * @param num
     * @param k
     * @return
     */
    public static int getCountOfHappyNumbers(int[] num, int k){
        int count = 0;
        Arrays.sort(num);
        for (int i =0; i < num.length; i++){
            int x = num[i] - k;
            int y = num[i] + k;

            if (i < num.length-1 && x <=num[i+1] && y>= num[i+1]) {
                count++;
            } else if (i > 0 && x<=num[i-1] && y>=num[i-1]){
                count++;
            }
        }
        return count;
    }
}

