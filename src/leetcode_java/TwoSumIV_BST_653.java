package leetcode_java;

/*
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class TwoSumIV_BST_653 {
	public boolean findTarget(TreeNode root, int k) {
		HashSet<Integer> set = new HashSet<Integer>();
		boolean isFound = treeSearch(root, k, set);
		return isFound;
	}

	public boolean treeSearch(TreeNode node, int k, HashSet set) {
		if (null == node)
			return false;
		if (set.contains(k - node.val)) {
			return true;
		}
		set.add(node.val);
		boolean isFound = treeSearch(node.left, k, set);
		if (!isFound) {
			isFound = treeSearch(node.right, k, set);
		}
		return isFound;
	}

	public boolean findTarget_2(TreeNode root, int k) {
		List<Integer> nums = new ArrayList<>();
		inorder(root, nums);
		for (int i = 0, j = nums.size() - 1; i < j;) {
			if (nums.get(i) + nums.get(j) == k)
				return true;
			if (nums.get(i) + nums.get(j) < k)
				i++;
			else
				j--;
		}
		return false;
	}

	public void inorder(TreeNode root, List<Integer> nums) {
		if (root == null)
			return;
		inorder(root.left, nums);
		nums.add(root.val);
		inorder(root.right, nums);
	}

	public boolean findTarget_3(TreeNode root, int k) {
        return dfs(root, root,  k);
    }
    
    public boolean dfs(TreeNode root,  TreeNode cur, int k){
        if(cur == null)return false;
        return search(root, cur, k - cur.val) || dfs(root, cur.left, k) || dfs(root, cur.right, k);
    }
    
    public boolean search(TreeNode root, TreeNode cur, int value){
        if(root == null)return false;
        return (root.val == value) && (root != cur) 
            || (root.val < value) && search(root.right, cur, value) 
                || (root.val > value) && search(root.left, cur, value);
    }
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
