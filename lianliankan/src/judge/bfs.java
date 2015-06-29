package judge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Piece { // ������
	int x;
	int y;
	int step; // ·����

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
	private char g[][]; // ��ͼ
	private int w, h; // ��ͼ�Ŀ�͸�
	private int dir[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } }; // �ĸ���������һ��������ĸ��ڽӵ㣨��ͨ����)
	private boolean visited[][];

	private Piece start, goal; // ����Ŀ���

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
	 * BFS������start����ġ���ͨ���ڽӣ��㲢��ǣ�·������1����ͬһ�㣬��һ�������������ڶ���
	 * ·������2���ǵڶ��㣬����������һ���Ĳ������ѣ���ǹ��ĵ㲻���ٱ�ǡ�
	 */
	public void bfs() {
		int i;
		Queue<Piece> que = new LinkedList<Piece>();
		que.add(start); // ������
		visited[start.x][start.y] = true; // ���Ϊ�ѷ���
		while (!que.isEmpty()) // ���зǿ�
		{
			Piece temp1 = que.poll(); // ����
			if (temp1.x == goal.x && temp1.y == goal.y
					&& goal.step > temp1.step) {
				goal.step = temp1.step;
				break;// �����������Ŀ�꣬�����˳���
			}

			// ����temp1���ĸ��ڽӵ�,���ҡ��¡���
			for (i = 0; i < 4; ++i) {

				Piece temp2 = new Piece();
				temp2.x = temp1.x + dir[i][0];
				temp2.y = temp1.y + dir[i][1];
				while (temp2.x >= 0 && temp2.x <= h + 1 && temp2.y >= 0
						&& temp2.y <= w + 1 && !visited[temp2.x][temp2.y]
						&& g[temp2.x][temp2.y] == ' ') { // temp2��temp1��ͨ

					visited[temp2.x][temp2.y] = true; // ���Ϊ�ѷ���
					temp2.step = temp1.step + 1; // ͬһ��������ͨ�ĵ㣬·������ͬ��
					que.add(new Piece(temp2.x, temp2.y, temp2.step)); // ���

					temp2.x += dir[i][0]; // ��ͬһ�����ϼ�����
					temp2.y += dir[i][1];

				}
			}
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int nPacase = 0;
		int nCase = 0;
		Piece start = new Piece();// ���
		Piece goal = new Piece();// Ŀ���

		int w = 8;
		int h = 11;
		char g[][] = new char[h + 2][w + 2];
		for (int i = 1; i <= h; ++i) {
			String line = in.nextLine();
			for (int j = 1; j <= w; j++)
				g[i][j] = line.charAt(j - 1); // ��ͼ
		}

		nPacase = 0;

		// ��Χ�ӿ�
		for (int i = 0; i <= w + 1; i++) {
			g[0][i] = ' ';
			g[h + 1][i] = ' ';
		}
		for (int i = 0; i <= h + 1; ++i) {
			g[i][0] = ' ';
			g[i][w + 1] = ' ';
		}

		// ����ͼ����ȷ��

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
					c[i][j] = g[i][j]; // ��¡����

			}

			start.y = in.nextInt();
			start.x = in.nextInt();
			goal.y = in.nextInt();
			goal.x = in.nextInt();

			start.step = 0;
			goal.step = Integer.MAX_VALUE;
			if (start.x == 0 && start.y == 0 && goal.x == 0 && goal.y == 0) // �����˳�
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