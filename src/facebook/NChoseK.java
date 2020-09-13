package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.mathsisfun.com/pascals-triangle.html
 */
public class NChoseK {

        private int nChooseK(long n, long k) {
            if(k == 0) return 1;
            return (int) (nChooseK(n, k-1) * (n-k+1) / k);
        }

        public List<Integer> getRow(int rowIndex) {
            List<Integer> ret = new ArrayList<>(rowIndex+1);
            for(int i = 0 ; i <= rowIndex ; i++) {
                ret.add(nChooseK(rowIndex, i));
            }
            return ret;
        }

        public static void main(String args[]){
            NChoseK nChoseK = new NChoseK();
            int result = nChoseK.nChooseK(4,2);

            System.out.println(result);
        }
}
