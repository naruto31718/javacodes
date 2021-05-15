import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class tree {


    static HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorderTraversalHelper(root, ans);
        return ans;
    }

    public static void preorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preorderTraversalHelper(root.left, ans);
        preorderTraversalHelper(root.right, ans);
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorderTraversalHelper(root, ans);
        return ans;
    }

    public static void postorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        postorderTraversalHelper(root.left, ans);
        postorderTraversalHelper(root.right, ans);
        ans.add(root.val);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorderTraversalHelper(root, ans);
        return ans;
    }

    public static void inorderTraversalHelper(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, ans);
        ans.add(root.val);
        inorderTraversalHelper(root.right, ans);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        que.add(null);

        ArrayList<List<Integer>> l2 = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();

        while (!que.isEmpty() && que.size() > 1) {
            TreeNode p = que.remove();
            if (p == null) {
                l2.add(l1);
                l1 = new ArrayList<>();
                que.add(null);
            } else {
                l1.add(p.val);
                if (p.left != null) que.add(p.left);
                if (p.right != null) que.add(p.right);

            }
        }
        l2.add(l1);
        return l2;
    }

    public static TreeNode inbuildTree(int[] inorder, int[] postorder) {

        if (postorder.length == 0)
            return null;
        if (postorder.length == 1)
            return new TreeNode(postorder[0]);
        int rootVal = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootindex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootindex = i;
            }
        }
        root.left = inbuildTree(Arrays.copyOfRange(inorder, 0, rootindex - 1), Arrays.copyOfRange(postorder, 0, rootindex - 1));
        root.right = inbuildTree(Arrays.copyOfRange(inorder, rootindex + 1, inorder.length), Arrays.copyOfRange(postorder, rootindex, postorder.length - 1));
        return root;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lh = maxDepth(root.left);
            int rh = maxDepth(root.right);
            if (lh > rh) {
                return lh + 1;
            } else {
                return rh + 1;
            }
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            boolean ans = issymmetrichelper(root.left, root.right);
            return ans;
        }
    }

    public static boolean issymmetrichelper(TreeNode left, TreeNode right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else {
            return (left.val == right.val) && issymmetrichelper(left.left, right.right) && issymmetrichelper(left.right, right.left);
        }
    }

    public static TreeNode prebuildTree(int[] preorder, int[] inorder) {
        int i = 0;
        for (Integer n : inorder) {
            m.put(n, i++);
        }
        return prehelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, m);
    }

    public static TreeNode prehelper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend, Map<Integer, Integer> m) {
        if (pstart > pend || istart > iend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pstart]);
        int iroot = m.get(root.val);
        int res = iroot - istart;
        root.left = prehelper(preorder, pstart + 1, pstart + res, inorder, istart, iroot - 1, m);
        root.right = prehelper(preorder, pstart + res + 1, pend, inorder, iroot + 1, iend, m);
        return root;
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }

    private static List<TreeNode> helper(int lo, int hi) {
        List<TreeNode> result = new ArrayList<>();
        //base case
        if (lo > hi) {
            result.add(null);
            return result;
        }

        //subproblem to reach boootm
        for (int i = lo; i <= hi; i++) {
            List<TreeNode> left = helper(lo, i - 1);
            List<TreeNode> right = helper(i + 1, hi);
            //reconstruct tree from bottom to up
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    result.add(root);
                }
            }
        }
        //return list of root to last layer
        return result;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;

        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer minValue, Integer maxValue) {
        if (root == null) return true;

        if (minValue != null && root.val <= minValue) {
            return false;
        } else if (maxValue != null && root.val >= maxValue) {
            return false;
        } else {
            return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
        }
    }


    public static void main(String[] args) {

    }

}
