package com.dsa.LeetCode.Tree;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int value)
	{
		this.val=value;
		this.right=null;
		this.left=null;
	}

	TreeNode(int value,TreeNode left,TreeNode right)
	{
		this.val=value;
		this.left=left;
		this.right=right;
	}
}
