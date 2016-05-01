/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author mehul
 */
//We maintain a parent array to keep the track of the subsets of elements... 
//Each subset is represented by a representative element.
//If the edge vetices belong to different subsets, find the union of them.
//which means merge the subsets to have a single representative element.
//While discovering if the 2 vertices have the same parent the graph contains a cycle!
public class UnionFindDetectCycle {
    static MyGraph graph;
    public static void main(String args[]){
        graph = new MyGraph(3, 3);
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        // add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        // add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
        
        System.out.println(findCycle() ? "yeah" : "no");
    }
    
    public static boolean findCycle(){
        int parent[] = new int[3];
        for(int i = 0; i < 3; i++)
            parent[i] = -1;
        
        for(int i = 0; i < 3; i++){
            int start = find(graph.edge[i].src, parent);
            int end = find(graph.edge[i].dest, parent);
            
            if(start == end)
                return true;
            
            union(parent, start, end);
        }
        return false;
    }
    
    public static void union(int parent[], int x, int y){
        int str = find(x, parent);
        int end = find(y, parent);
        parent[str] = end;
    }
    
    static int find(int i, int parent[]){
        if(parent[i] == -1)
            return i;
        return find(parent[i], parent);
    }
    
    static void union(){
        
    }
}

class MyGraph{
    int v, e;
    Edge edge[];
    MyGraph(int v, int e){
        this.v = v;
        this.e = e;
        edge = new Edge[e];
        for(int i = 0; i < e; i++)
            edge[i] = new Edge();
    }
}

class Edge{
        int src;
        int dest;
}


