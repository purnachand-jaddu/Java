package com.mentor.training.questions;

import java.util.LinkedList;
import java.util.Queue;

public class FindClosestZero
{

	public static void main(String[] args)
	{
		FindClosestZero sol = new FindClosestZero();
		int[][] input = new int[][]{
				{1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
				{0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
				{0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
				{1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
				{0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
				{0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
				{0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
				{1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
				{1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
				{1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};
		sol.updateMatrix(input);
	}

	public int[][] updateMatrix(int[][] mat) {
		int numRows = mat.length;
		int numColumns = mat[0].length;
		Queue<Entry> q = new LinkedList<>();
		boolean[][] visited = new boolean[numRows][numColumns];
		for(int i=0;i<numRows;i++)
		{
			for(int j=0;j<numColumns;j++)
			{
				if(mat[i][j] == 0)
				{
					q.add(new Entry(i,j));
					visited[i][j] = true;
				}
			}
		}
		int[][] result = new int[numRows][numColumns];
		int distance = 0;
		while(!q.isEmpty())
		{
			distance++;
			Queue<Entry> aux = new LinkedList<>();
			while(!q.isEmpty())
			{
				Entry entry = q.poll();
				int currX = entry.x;
				int currY = entry.y;
				if(currX-1 >=0 && !visited[currX-1][currY])
				{
					if(mat[currX-1][currY] == 1)
					{
						result[currX-1][currY] = distance;
					}
					aux.add(new Entry(currX-1,currY));
					visited[currX-1][currY] = true;
				}
				if(currX+1 < numRows && !visited[currX+1][currY])
				{
					if(mat[currX+1][currY] == 1)
					{
						result[currX+1][currY] = distance;
					}
					aux.add(new Entry(currX+1,currY));
					visited[currX+1][currY] = true;
				}
				if(currY-1>=0 && !visited[currX][currY-1])
				{
					if(mat[currX][currY-1] == 1)
					{
						result[currX][currY-1] = distance;
					}
					aux.add(new Entry(currX,currY-1));
					visited[currX][currY-1] = true;
				}
				if(currY+1 < numColumns && !visited[currX][currY+1])
				{
					if(mat[currX][currY+1] == 1)
					{
						result[currX][currY+1] = distance;
					}
					aux.add(new Entry(currX,currY+1));
					visited[currX][currY+1] = true;
				}
			}
			q=aux;
		}
		return result;
	}

	private class Entry
	{
		int x;
		int y;
		private Entry(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
}
