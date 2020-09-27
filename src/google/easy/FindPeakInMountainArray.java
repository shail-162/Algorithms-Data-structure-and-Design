package google.easy;

/**
 * Let's call an array arr a mountain if the following properties hold:
 *
 * arr.length >= 3
 * There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [0,1,0]
 * Output: 1
 * Example 2:
 *
 * Input: arr = [0,2,1,0]
 * Output: 1
 * Example 3:
 *
 * Input: arr = [0,10,5,2]
 * Output: 1
 * Example 4:
 *
 * Input: arr = [3,4,5,1]
 * Output: 2
 * Example 5:
 *
 * Input: arr = [24,69,100,99,79,78,67,36,26,19]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 3 <= arr.length <= 104
 * 0 <= arr[i] <= 106
 * arr is guaranteed to be a mountain array.
 */
public class FindPeakInMountainArray {

    public static int peakIndexInMountainArrayBinary(int[] arr) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low+high)/2;

            if (arr[mid]> arr[mid-1] && arr[mid]> arr[mid+1]){
                return mid;
            }
//[24,69,100,99,79,78,67,36,26,19]
//40,48,61,75,100,99,98,39,30,10
            //move left
            if (arr[mid]> arr[mid+1] && arr[mid]<arr[mid-1]){
                high = mid;
            } else { //move right
                low = mid;
            }
        }

        return -1;
    }


    public static int peakIndexInMountainArrayLinear(int[] arr) {
        int max = 0;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++){
            if (arr[i] > maxValue){
                maxValue = arr[i];
                max = i;
            }
        }

        return max;
    }

    public static void main(String args[]) {
        //int[] arr= {24,69,100,99,79,78,67,36,26,19};
        //int[] arr ={0,10,5,2};
        int[] arr = {3,4,5,1};
        //int[] arr= {40,48,61,75,100,99,98,39,30,10};
        int res = peakIndexInMountainArrayBinary(arr);

        System.out.println(res);
    }
}
