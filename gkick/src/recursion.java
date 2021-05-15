import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class recursion {

    static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

    public static int pascaltriangle(int i, int j) {
        int ans = 0;
        if (j == 1 || j == i) {
            return 1;
        }
        ans += pascaltriangle(i - 1, j - 1) + pascaltriangle(i - 1, j);
        return ans;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        for (int j = 1; j <= rowIndex + 1; j++) {
            int a = pascaltriangle(rowIndex + 1, j);
            ans.add(a);
        }
        return ans;
    }

    public static List<Long> getRowfast(int rowIndex) {
        List<Long> prev = new ArrayList<>();
        prev.add(1L);
        for (int i = 1; i <= rowIndex; i++) {
            List<Long> curr = new ArrayList<>();
            for (int j = 0; j <= prev.size(); j++) {
                if (i == j || i == 0 || j == 0) {
                    curr.add(1L);
                } else {
                    long val = prev.get(j - 1) + prev.get(j);
                    curr.add(val);
                }
            }
            prev = curr;
        }
        return prev;
    }

    public static int climbStairs(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n < 4) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public static double myPow(double x, int n) {
        double n1 = Double.valueOf(n);
        double ans = Math.pow(x,n);
        return ans;
    }

    public static void main(String[] args) {
        double a = myPow(2,100);
        System.out.println(a);
    }

    public void swap(char i, char j) {
        char temp = i;
        i = j;
        j = temp;
    }

    public void reverseString(char[] s) {
        helper(0, s);
    }

    public void helper(int ind, char[] str) {
        if (str == null || ind >= (str.length) / 2) {
            return;
        }
        helper(ind + 1, str);
        char temp = str[ind];
        str[ind] = str[str.length - 1 - ind];
        str[str.length - 1 - ind] = temp;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode smallAnswer = swapPairs(head.next.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = smallAnswer;
        head = temp;
        return head;
    }

    public void printlist(ListNode head) {
        while (head.next != null) ;
        {
            System.out.print(head.val + " ");
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root.val == val) {
            return root;
        } else if (val > root.val && root.right != null) {
            return searchBST(root.right, val);
        } else if (val < root.val && root.left != null) {
            return searchBST(root.left, val);
        }
        return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
            return l1==null ? l2 :l1;
        }
        ListNode dummy=new ListNode(-1);
        ListNode current=dummy;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                current.next =l1;
                l1=l1.next;
            }
            else{
                current.next=l2;
                l2=l2.next;
            }

            current=current.next;
        }
        if(l1==null||l2==null){
            current.next=l1==null ?l2:l1;
        }
        return dummy.next;
    }

    public int kthGrammar(int N, int K) {
        // Base case for recursion
        if(N==1 || K==1)
            return 0;
        // Find the index of parent of Kth element in N-1th row
        int parent = (K+1)/2;
        //Find parent Val recursively
        int parentVal = kthGrammar(N-1,parent);
        // If parent is 0, its children would be 01
        if(parentVal ==0) {
            if(K%2==1)
                return 0;
            else
                return 1;
        } else { // If parent is 1, its children would be 10
            if(K%2==1)
                return 1;
            else
                return 0;
        }
    }

    public boolean searchMatrix(int[][] a, int target) {
        int n = a.length;
        int m = a[0].length;

        int i = 0;
        int j = m - 1;

        while(i < n && j >= 0){

            if(a[i][j] == target)
                return true;

            else if(target > a[i][j])
                i++;
            else
                j--;
        }
        return false;
    }
}
