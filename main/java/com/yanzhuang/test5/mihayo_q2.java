package com.yanzhuang.test5;

import java.util.*;
import java.io.*;

public class mihayo_q2 {
    private static List<List<Integer>> G;
    private static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = br.readLine().split(" ");
        n = Integer.parseInt(tokens[0]);
        k = Integer.parseInt(tokens[1]);

        G = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            G.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            tokens = br.readLine().split(" ");
            int u = Integer.parseInt(tokens[0]) - 1;
            int v = Integer.parseInt(tokens[1]) - 1;
            G.get(u).add(v);
            G.get(v).add(u);
        }

        System.out.println(dfs(0, 0, -1));
    }

    public static int dfs(int cur, int depth, int parent) {
        if (depth > k) {
            return 0;
        }
        int ans = 1;
        if (G.get(cur).size() > 1 || parent == -1) {
            for (Integer child : G.get(cur)) {
                if (child != parent) {
                    ans += dfs(child, depth + 1, cur);
                }
            }
        } else {
            ans += Math.max(0, k - depth);
        }
        return ans;
    }
}
/*
2 一颗有根树，根节点编号为1，边长度均为1，每次操作可以将一个新叶子节点接在原来的一个叶子上，新加的边长度也是1，可以进行任意多次操作。求操作结束后，与根节点距离不超过k的节点数最大值是多少。 输入：第一行输入两个整数n和k，接下来n-1行，每行输入两个整数代表这俩个节点之间有一条边； 输出一个整数代表答案

 */
