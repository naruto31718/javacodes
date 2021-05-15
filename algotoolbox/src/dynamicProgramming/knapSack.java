package dynamicProgramming;
import java.util.*;

public class knapSack {
	
	
	static int max(int a, int b)
    {
          return (a > b) ? a : b;
    }
	
	static int zeroone_knapSack(int W, int wt[],int val[], int n) {
		int i, w;
        int K[][] = new int[n + 1][W + 1];
 
        // Build table K[][] in bottom up manner
        //using dynamicProgramming 
        for (i = 0; i <= n; i++)
        {
            for (w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w]
                        = max(val[i - 1]
                         + K[i - 1][w - wt[i - 1]],
                         K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
 
        return K[n][W];
	}
	
	//class for highest val/weight ratio
	
	static class ItemValue {
        Double cost;
        double wt, val, ind;
 
        @SuppressWarnings("deprecation")
		public ItemValue(int wt, int val, int ind)
        {
            this.wt = wt;
            this.val = val;
            this.ind = ind;
            cost = new Double((double)val / (double)wt);
        }
    }
	
	static double fractional_knapSack(int capacity, int wt[],int val[]) {
		ItemValue[] iVal = new ItemValue[wt.length];
		 
        for (int i = 0; i < wt.length; i++) {
            iVal[i] = new ItemValue(wt[i], val[i], i);
        }
 
        // sorting items by value;
        Arrays.sort(iVal, new Comparator<ItemValue>() {
            @Override
            public int compare(ItemValue o1, ItemValue o2)
            {
                return o2.cost.compareTo(o1.cost);
            }
        });
 
        double totalValue = 0d;
 
        for (ItemValue i : iVal) {
 
            int curWt = (int)i.wt;
            int curVal = (int)i.val;
 
            if (capacity - curWt >= 0) {
                // this weight can be picked whole
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {
                // item cant be picked whole
                double fraction
                    = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                capacity
                    = (int)(capacity - (curWt * fraction));
                break;
            }
        }
 
        return totalValue;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
