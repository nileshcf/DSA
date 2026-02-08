package com.dsa.LeetCode.Tree;

public class Level {

	void dfsWithLevel(TreeNode node,int level)
	{
		if(node==null)
			return;

		System.out.println("Node --> "+node.val+" on level -->"+level);
		dfsWithLevel(node.left,level+1);
		dfsWithLevel(node.right,level+1);
	}



	int checkHeight(TreeNode node)
	{
		if(node==null)
			return 0;

		int left=checkHeight(node.left);
		if(left==-1)
			return -1;

		int right=checkHeight(node.right);
		if(right==-1)
			return -1;

		if(Math.abs(left-right)>1) return -1;

		return 1+Math.max(checkHeight(node.left),checkHeight(node.right));
	}
}
