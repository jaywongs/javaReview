package jay.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by jaywangs on 2019/4/10
 */
public class Graph {
    static final int maxNum = 20; // 图 最大点数量
    static final int maxValue = 65535; // 图最大权值

    int type; //图种类 0-无向图 1-有向图

    int size;
    char [] vertexs; //存储点
    int [][] matrix; // 存储邻接矩阵
    private boolean [] isVisited;

    public Graph(int type, char [] vertexs, char [][] edges) {
        size = vertexs.length;
        matrix = new int[size][size];
        this.vertexs = vertexs;
        this.type = type;
        this.isVisited = new boolean[size];

        for (char[] c : edges) {
            int p1 = getPosition(c[0]);
            int p2 = getPosition(c[1]);
            matrix[p1][p2] = 1;
            if (this.type != 1)
                matrix[p2][p1] = 1;
        }
    }

    //根据点获取位置
    private int getPosition(char c) {
        for (int i = 0; i < vertexs.length; i++){
            if (vertexs[i] == c)
                return i;
        }
        return -1;
    }

    //图的遍历输出
    public void print(){
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print(vertexs[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(vertexs[i] + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // 设置是否访问过
    public void setisVisited(char vertex) {
        int i = getPosition(vertex);
        this.isVisited[i] = true;
    }

    //打印当前遍历节点
    private void visit(int i) {
        System.out.print(vertexs[i] + " ");
    }

    // 从第i个节点开始深度优先遍历 递归
    private void traverse(int i ) {
        visit(i);
        isVisited[i] = true;

        for (int j = 0; j < size; j++) {
            if (matrix[i][j] == 1 && !isVisited[j]){
                traverse(j);
            }
        }
    }

    //dfs 整个图的深度优先遍历(递归)
    public void DFSTraverse() {
        for (int i = 0; i < size; i++){
            if (!isVisited[i]){
                traverse(i);
            }
        }
    }

    //dfs 整个图的深度优先遍历(非递归)
    public void DFSTraverse2() {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < size; i++) {
            if (!isVisited[i]){
                stack.push(i);
            }
            while (!stack.isEmpty()){
                int cur = stack.pop();
                if (!isVisited[cur]){
                    visit(cur);
                    isVisited[cur] = true;
                }
                for (int j = size - 1; j > 0; j--) {
                    if (matrix[cur][j] == 1 && !isVisited[j])
                        stack.push(j);
                }
            }
        }
    }

    //bfs广度优先遍历 （连通图）
    public void BFSTraverse(int start){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            if (!isVisited[cur]){
                visit(cur);
                isVisited[cur] = true;
            }
            for (int j = 0; j < size; j++) {
                if (matrix[cur][j] == 1 && !isVisited[j]){
                    queue.offer(j);
                }
            }
        }
    }

    //bfs广度优先遍历 （非连通图）
    public void bfsTraverse2(){
        for (int i = 0; i < size; i++) {
            if (!isVisited[i])
                BFSTraverse(i);
        }
    }

    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G','H','I','J','K'};
        char[][] edges = new char[][]{
                {'A', 'C'},
                {'A', 'D'},
                {'A', 'F'},
                {'B', 'C'},
                {'C', 'D'},
                {'E', 'G'},
                {'D', 'G'},
                {'I', 'J'},
                {'J', 'G'},};
        Graph graph = new Graph(0, vexs, edges);
        graph.print();
        graph.bfsTraverse2();

    }

}
