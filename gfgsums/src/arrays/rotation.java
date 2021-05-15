package arrays;

import java.util.ArrayList;

public class rotation {
    public ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < A.size()-B; i++) {
            int get_index = (i+B)%A.size();
            ret.add(A.get(get_index));
        }
        return ret;
    }

}
