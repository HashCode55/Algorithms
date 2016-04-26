/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.LinkedList;
import graphs.Graph;
import java.util.Iterator;

/**
 *
 * @author mehul
 */

//(COMPLEX ALGO)
//Articulation point is the point which make the graph disconnected by its removal.
//we maintain a discovery array while traversing the nodes in dfs
//and another array name low which tells the lowest point to whhich we can go via back edge in the graph
//if the low[v] > dist[src], it is an AP.
public class ArticulationPoint {
    static LinkedList<Integer> adjL[];
    static int vert;
    static int time = 0;
    public static void main(String args[]){
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.addEdge(4, 0);
        
        adjL = g1.getList();
        vert = g1.getVertices();
        checkArticulation();
    }
    
    public static void checkArticulation(){
        boolean visited[] = new boolean[vert];
        int parent[] = new int[vert];
        int dist[] = new int[vert];
        int low[] = new int[vert];
        boolean ap[] = new boolean[vert];
        
        for(int i = 0; i < vert; i++){
            parent[i] = -1;
            dist[i] = 0;
            low[i] = 0;
        }
        
        for(int i = 0; i < vert; i++){
            if(!visited[i])
                APUtil(visited, parent, dist, low, ap, i);
        }
        
        for(int i = 0; i < vert; i++){
            if(ap[i])
                System.out.println(i);
        }
    }
    
    private static void APUtil(boolean visited[], int parent[], int dist[], int low[], boolean ap[], int src){
        int childs = 0;
        visited[src] = true;
        System.out.println("Currently at node " + src);
        Iterator<Integer> i = adjL[src].listIterator();
        dist[src] = low[src] = ++time;
        while(i.hasNext()){
            int v = i.next();
            System.out.println("currently v is " + v + " for " + src);
            if (!visited[v])
            {
                childs++;
                parent[v] = src;
                APUtil(visited, parent, dist, low, ap, v);
 
                // Check if the subtree rooted with v has a connection to
                // one of the ancestors of u
                low[src]  = Math.min(low[src], low[v]);
                System.out.println("low value updated to " + low[src] + " for node inside if " + src +" " + v);    
                // u is an articulation point in following cases
 
                // (1) u is root of DFS tree and has two or more chilren.
                if (parent[src] == -1 && childs > 1)
                    ap[src] = true;
 
                // (2) If u is not root and low value of one of its child
                // is more than discovery value of u.
                if (parent[src] != -1 && low[v] >= dist[src])
                    ap[src] = true;
            }
 
            // Update low value of u for parent function calls.
            else if (v != parent[src]){
                low[src]  = Math.min(low[src], dist[v]);
                System.out.println("low value updated to " + low[src] + " for node " + src);
            }
            
            
        }
    }
    
    
}


