package google.medium;

/**
 * In a row of trees, the i-th tree produces fruit with type tree[i].
 *
 * You start at any tree of your choice, then repeatedly perform the following steps:
 *
 * Add one piece of fruit from this tree to your baskets.  If you cannot, stop.
 * Move to the next tree to the right of the current tree.  If there is no tree to the right, stop.
 * Note that you do not have any choice after the initial choice of starting tree: you must perform step 1, then step 2, then back to step 1, then step 2, and so on until you stop.
 *
 * You have two baskets, and each basket can carry any quantity of fruit, but you want each basket to only carry one type of fruit each.
 *
 * What is the total amount of fruit you can collect with this procedure?
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,1]
 * Output: 3
 * Explanation: We can collect [1,2,1].
 * Example 2:
 *
 * Input: [0,1,2,2]
 * Output: 3
 * Explanation: We can collect [1,2,2].
 * If we started at the first tree, we would only collect [0, 1].
 * Example 3:
 *
 * Input: [1,2,3,2,2]
 * Output: 4
 * Explanation: We can collect [2,3,2,2].
 * If we started at the first tree, we would only collect [1, 2].
 * Example 4:
 *
 * Input: [3,3,3,1,2,1,1,2,3,3,4]
 * Output: 5
 * Explanation: We can collect [1,2,1,1,2].
 * If we started at the first tree or the eighth tree, we would only collect 4 fruits.
 *
 *
 * Note:
 *
 * 1 <= tree.length <= 40000
 * 0 <= tree[i] < tree.length
 */

/**
 * Solution:
 *
 * This problem is vary similar to the problem 159. Longest Substring with At Most Two Distinct Characters
 * Key Points:
 *
 * Suppose we have a sliding window [i, j]. In this window, there has only at most two elements and we try to maximize the window [i, j].
 * We use a counter to count the frequency of each type fruit, i.e. tree[i]. If count[tree[i]] == 0,
 * this means that fruit tree[i] is a new type fruit, we need to decrease k, which represent the amount of unique fruit in the window [i, j].
 * If k < 0, which means we have more than 2 kinds of fruits,
 * then we need to move the front pointer i to shrink the window to make sure there have only two kinds of fruits in the new range [i, j].
 * We try to update the res at every current window.
 *
 *
 */
class FruitIntoBasket {

    public static int totalFruit2(int[] tree, int k) {
        int res = 0;
        int[] count = new int[tree.length];

        //count[]={1,1, 1}
        //k= -1
        for (int start =0, end = 0; end < tree.length ; end++) {
                if (count[tree[end]]++ == 0) {
                    k--;
                }

                while (k < 0){
                    if (--count[tree[start++]] == 0) {
                        k++;
                    }
                }

                res = Math.max(res, (end - start) + 1);
        }

        return res;
    }

    public static void main(String[] args){
        //int[] arr= {0,1,6,6,4,4,6};
       // int[] arr = {1,2,3,2,2};
        int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
        //int count[] = new int[arr.size];
        //int[] arr= {0,1,2,2};
        int res = totalFruit2(arr, 2);
        System.out.println(res);
    }
}
