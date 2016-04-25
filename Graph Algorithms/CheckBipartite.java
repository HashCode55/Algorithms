/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author mehul
 */
//if the graph can be coloured in 2 colors, it is bipartite, else it is not.
public class CheckBipartite {
    static int vertices = 4;
    
    public static boolean checkBipartite(int graph[][]){
        int color[] = new int[vertices];
        
        for(int i  = 0; i < color.length; i++)
            color[i] = -1;
        LinkedList<Integer> queue = new LinkedList();
        int src = 0;
        color[src] = 0;
        queue.add(src);
        while(queue.size() != 0){
            int u = queue.poll();
            for(int i = 0; i < vertices; i++){
                if(graph[u][i] == 1 && color[i] == -1){
                    color[i] = 1 - color[u];
                    queue.add(i);
                }
                else if (graph[u][i] == 1 && color[i] == color[u]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String ars[]){
        int G[][] = {{0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0}
        };
        System.out.println(checkBipartite(G));
    }
}
