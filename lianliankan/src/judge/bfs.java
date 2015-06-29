package judge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Piece { // 顶点类
	int x;
	int y;
	int step; // 路段数

	public Piece() {
		this(0, 0, 0);
	}

	public Piece(int x, int y, int step) {
		this.x = x;
		this.y = y;
		this.step = step;
	}
}

public class bfs {
	private char g[][]; // 地图
	private int w, h; // 地图的宽和高
	private int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // 四个方向，任意一点可能有四个邻接点（相通才是)
	private boolean visited[][];

	private Piece start, goal; // 起点和目标点

	public bfs(int w, int h, Piece start, Piece goal, char[][] g) {
		this.w = w;
		this.h = h;
		this.g = g;
		this.start = start;
		this.goal = goal;
		visited = new boolean[h + 2][w + 2];
	}

	public Piece getGoal() {
		return goal;
	}

	/*
	 * BFS访问与start最近的、相通（邻接）点并标记，路段数是1的是同一层，第一层完了再搜索第二层
	 * 路段数是2的是第二层，。。。（就一个四叉树而已）标记过的点不必再标记。
	 */
	public void bfs() {
		int i;
		Queue<Piece> que = new LinkedList<Piece>();
		que.add(start); // 起点入队
		visited[start.x][start.y] = true; // 标记为已访问
		while (!que.isEmpty()) // 队列非空
		{
			Piece temp1 = que.poll(); // 出队
			if (temp1.x == goal.x && temp1.y == goal.y
					&& goal.step > temp1.step) {
				goal.step = temp1.step;
				break;// 如果搜索到了目标，程序退出。
			}

			// 访问temp1的四个邻接点,左、右、下、上
			for (i = 0; i < 4; ++i) {

				Piece temp2 = new Piece();
				temp2.x = temp1.x + dir[i][0];
				temp2.y = temp1.y + dir[i][1];
				while (temp2.x >= 0 && temp2.x <= h + 1 && temp2.y >= 0
						&& temp2.y <= w + 1 && !visited[temp2.x][temp2.y]
						&& g[temp2.x][temp2.y] == ' ') { // temp2与temp1相通

					visited[temp2.x][temp2.y] = true; // 标记为已访问
					temp2.step = temp1.step + 1; // 同一方向上相通的点，路段数相同。
					que.add(new Piece(temp2.x, temp2.y, temp2.step)); // 入队

					temp2.x += dir[i][0]; // 在同一方向上继续走
					temp2.y += dir[i][1];

				}
			}
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int nPacase = 0;
		int nCase = 0;
		Piece start = new Piece();// 起点
		Piece goal = new Piece();// 目标点

		int w = 8;
		int h = 11;
		char g[][] = new char[h + 2][w + 2];
		for (int i = 1; i <= h; ++i) {
			String line = in.nextLine();
			for (int j = 1; j <= w; j++)
				g[i][j] = line.charAt(j - 1); // 地图
		}

		nPacase = 0;

		// 外围加框
		for (int i = 0; i <= w + 1; i++) {
			g[0][i] = ' ';
			g[h + 1][i] = ' ';
		}
		for (int i = 0; i <= h + 1; ++i) {
			g[i][0] = ' ';
			g[i][w + 1] = ' ';
		}

		// 测试图的正确性

		for (int i = 0; i <= h + 1; i++) {
			for (int j = 0; j <= w + 1; j++)
				System.out.print(g[i][j]);
			System.out.println();
		}

		System.out.println("Board #" + (++nCase) + ":");
		while (1 == 1) {
			char[][] c = new char[h + 2][w + 2];

			for (int i = 0; i <= h + 1; i++) {
				for (int j = 0; j <= w + 1; j++)
					c[i][j] = g[i][j]; // 克隆数组

			}

			start.y = in.nextInt();
			start.x = in.nextInt();
			goal.y = in.nextInt();
			goal.x = in.nextInt();

			start.step = 0;
			goal.step = Integer.MAX_VALUE;
			if (start.x == 0 && start.y == 0 && goal.x == 0 && goal.y == 0) // 程序退出
				break;

			if (c[goal.x][goal.y] == 'X') {
				c[goal.x][goal.y] = ' ';

			}
			bfs m = new bfs(w, h, start, goal, c);
			m.bfs();

			if (m.getGoal().step == Integer.MAX_VALUE)
				System.out.println("Pair " + (++nPacase) + ": impossible.");
			else
				System.out.println("Pair " + (++nPacase) + ": "
						+ m.getGoal().step + " segments.");

		}
		System.out.println();
	}

}