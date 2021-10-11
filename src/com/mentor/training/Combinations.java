package com.mentor.training;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Combinations
{

	public static void main(String[] args)
	{
		Combinations sol = new Combinations();
		System.out.println(sol.combine(4, 2));
	}

	public List<List<Integer>> combine(int n, int k)
	{
		return createDecisionTreeAndGetCombinations(n, k);
	}

	private List<List<Integer>> createDecisionTreeAndGetCombinations(int n, int k)
	{
		TreeNode root = new TreeNode();
		Queue<TreeNode> q = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			TreeNode child = new TreeNode(i);
			child.paths.add(child.val);
			addToResultIfLengthIsK(k, result, child);
			root.addChild(child);
			q.add(child);
		}
		int currentLevel = 1;
		while (currentLevel < k) {
			Queue<TreeNode> aux = new LinkedList<>();
			while (!q.isEmpty()) {
				TreeNode parent = q.poll();
				int currVal = parent.val;
				for (int i = currVal + 1; i <= n; i++) {
					TreeNode child = new TreeNode(i);
					child.paths.addAll(parent.paths);
					child.paths.add(child.val);
					addToResultIfLengthIsK(k, result, child);
					parent.addChild(child);
					aux.add(child);
				}
			}
			q = aux;
			currentLevel++;
		}
		return result;
	}

	private void addToResultIfLengthIsK(int k, List<List<Integer>> result, TreeNode child)
	{
		if (child.paths.size() == k) {
			result.add(child.paths);
		}
	}

	private class TreeNode
	{

		private int val;
		private List<TreeNode> children = new ArrayList<>();
		private List<Integer> paths = new ArrayList<>();

		private TreeNode()
		{
			//For root
			this.val = -1000;
		}

		private TreeNode(int val)
		{
			this.val = val;
		}

		private void addChild(TreeNode child)
		{
			children.add(child);
		}
	}
}
