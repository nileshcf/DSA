package com.dsa.LeetCode.Tree;

public class DFS {

	void inOrder(TreeNode node)
	{
		if(node==null)
			return;

		inOrder(node.left);
		System.out.println(" "+node.val+" ");
		inOrder(node.right);

	}

	void postOrder(TreeNode node)
	{
		if(node==null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.println(" "+node.val+" ");

	}

	void preOrder(TreeNode node)
	{
		if(node==null)
			return;

		System.out.println(" "+node.val+" ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args) {
		DFS dfs = new DFS();

		// -------- Scenario 1: Balanced Tree --------
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(2);
		root1.right = new TreeNode(3);
		root1.left.left = new TreeNode(4);
		root1.left.right = new TreeNode(5);
		root1.right.left = new TreeNode(6);
		root1.right.right = new TreeNode(7);

		System.out.println("Balanced Tree:");
		System.out.print("InOrder: ");
		dfs.inOrder(root1);
		System.out.println();

		System.out.print("PreOrder: ");
		dfs.preOrder(root1);
		System.out.println();

		System.out.print("PostOrder: ");
		dfs.postOrder(root1);
		System.out.println("\n");

		// -------- Scenario 2: Left Skewed Tree --------
        /*
              1
             /
            2
           /
          3
        */
		TreeNode root2 = new TreeNode(1);
		root2.left = new TreeNode(2);
		root2.left.left = new TreeNode(3);

		System.out.println("Left Skewed Tree:");
		System.out.print("InOrder: ");
		dfs.inOrder(root2);
		System.out.println();

		System.out.print("PreOrder: ");
		dfs.preOrder(root2);
		System.out.println();

		System.out.print("PostOrder: ");
		dfs.postOrder(root2);
		System.out.println("\n");

		// -------- Scenario 3: Right Skewed Tree --------
        /*
        1
         \
          2
           \
            3
        */
		TreeNode root3 = new TreeNode(1);
		root3.right = new TreeNode(2);
		root3.right.right = new TreeNode(3);

		System.out.println("Right Skewed Tree:");
		System.out.print("InOrder: ");
		dfs.inOrder(root3);
		System.out.println();

		System.out.print("PreOrder: ");
		dfs.preOrder(root3);
		System.out.println();

		System.out.print("PostOrder: ");
		dfs.postOrder(root3);
		System.out.println("\n");

		// -------- Scenario 4: Single Node --------
		TreeNode root4 = new TreeNode(10);

		System.out.println("Single Node Tree:");
		System.out.print("InOrder: ");
		dfs.inOrder(root4);
		System.out.println();

		System.out.print("PreOrder: ");
		dfs.preOrder(root4);
		System.out.println();

		System.out.print("PostOrder: ");
		dfs.postOrder(root4);
		System.out.println("\n");
	}

}
