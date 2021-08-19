package com.example.leetcode;

/**
 * @author huangchunchen
 * @date 2021/8/14 10:35
 * @description
 */
public class unhappyFriends {
    public static void main(String[] args) {
        int[][] preferences = {{1,2,3},{3,2,0},{3,1,0},{1,2,0}};
        int[][] pairs = {{0,1},{2,3}};
        System.out.println(unhappyFriends(4, preferences, pairs));
    }

    public static int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] order = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                order[i][preferences[i][j]] = j;
            }
        }
        int[] match = new int[n];
        for (int[] pair : pairs) {
            int person0 = pair[0], person1 = pair[1];
            match[person0] = person1;
            match[person1] = person0;
        }
        int unhappyCount = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = order[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]) {
                    unhappyCount++;
                    break;
                }
            }
        }
        return unhappyCount;
    }
}
