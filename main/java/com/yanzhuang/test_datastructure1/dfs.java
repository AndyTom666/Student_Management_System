package com.yanzhuang.test_datastructure1;

public class dfs {

/*    boolean found = false;//found：判断我们是否已经找到了终止顶点t，找到就不继续递归了


    public void dfs(int s, int t) {
        found = false;
        boolean[] visited = new boolean[v];//v:顶点的个数  visited：记录被访问的顶点，以防重复访问
        for (int i = 0; i < v; ++i) {
            prev[i] = -1;//prev：用来记录搜索路径。比如从是从顶点2访问到的顶点3，那么prev[3]=2，相当于反向存储
        }
        recurDfs(s,t,visited,prev);
        System.out.println(prev,s,t);
    }

    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
        if (found == true) {
            return;
        }
        visited[w] = true;
        if (w == t) {
            found = true;
            return;
        }
        for (int i = 0; i < adj[w].size(); ++i) {//adj相当于是一张邻接表矩阵
            int q = adj[w].get(i);
            if (!visited[q]) {
                prev[q] = w;
                recurDfs(q, t, visited, prev);
            }
        }
    }*/

}

