package google.medium;

/**
 * You are given an array representing a row of seats where seats[i] = 1
 * represents a person sitting in the ith seat, and seats[i] = 0
 * represents that the ith seat is empty (0-indexed).
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the closest person
 * to him is maximized.
 *
 * Return that maximum distance to the closest person.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: seats = [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * Example 2:
 *
 * Input: seats = [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * Example 3:
 *
 * Input: seats = [0,1]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 2 <= seats.length <= 2 * 104
 * seats[i] is 0 or 1.
 * At least one seat is empty.
 * At least one seat is occupied.
 */
class MaxDistanceToClosetPerson {

    public static int maxDistToClosest(int[] seats) {

        int start = -1;
        int end = 0;
        int max = 0;

        for(int i=0; i < seats.length ; i++){

            if(seats[i] == 1){
                //condition when there are 0's at the start. eg: 0,0,0,0,1,0,1
                if(start == -1){
                    max = Math.max(end, max);
                }
                //condition when we have a boundry of 1's . eg: 1,0,0,0,1,1,1
                else{
                    max = Math.max((end-start)/2, max);
                }
                start = end = i;
            }
            end++;
        }
        //condition when there are 0's at the end. eg: 1,0,1,0,0,0,0
        if(start != end){
            max = Math.max(max, end-start-1);
        }

        return max;
    }

    public static void main(String[] args){
        int[] arr= {0,0,0,0,1,0,1};
        //int[] arr= {1,0,0,0};
        //int[] arr={0,1};
        int output = maxDistToClosest(arr);
        System.out.println(output);
    }
}
