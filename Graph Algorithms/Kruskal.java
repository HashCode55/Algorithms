/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.Arrays;

/**
 *
 * @author mehul
 */
public class Kruskal {
    public static void main(String args[]){
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        GraphImp graph = new GraphImp(V, E);
 
        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = 10;
 
        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 6;
 
        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].weight = 5;
 
        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 15;
 
        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].weight = 4;
        
        kruskalMST(graph);
    }
    
    public static void kruskalMST(GraphImp graph){
        SubsetImp subsets[] = new SubsetImp[graph.v];
        EdgeImp result[] = new EdgeImp[graph.v - 1];
        int k = 0; //counter variable to maintain the result array
        Arrays.sort(graph.edge);
        
        for(int i = 0; i < graph.v; i++){
            subsets[i] = new SubsetImp();
            subsets[i].rank = 0;
            subsets[i].parent = i;
        }
        
        for(int i = 0; i < result.length; i++){
            result[i] = new EdgeImp();
        }
        
        for(int i = 0; i < graph.e; i++){
            int src = find(subsets, graph.edge[i].src);
            int dest = find(subsets, graph.edge[i].dest);
            
            if(src != dest){
                result[k++] = graph.edge[i];
                union(subsets, src, dest);
            }
            
        }
        
        for(int i = 0;i < result.length; i++){
            System.out.println(result[i].src+ " -- "+result[i].dest + " == "+
                               result[i].weight);
        }
    }
    private static int find(SubsetImp subsets[], int i){
        if(subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);//Path Compression step
        return subsets[i].parent;
    }
    
    private static void union(SubsetImp subsets[], int src, int dest){
        int x = find(subsets, src);
        int y = find(subsets, dest);
        
        if(subsets[x].rank < subsets[y].rank)
            subsets[x].parent = y;
        else if(subsets[y].rank < subsets[x].rank)
            subsets[y].parent = x;
        else{
            subsets[x].parent = y;
            subsets[y].rank++;
        }
    }
}

class GraphImp{
    int v, e;
    EdgeImp edge[];
    GraphImp(int v, int e){
        this.v = v;
        this.e = e;
        edge = new EdgeImp[e];
        for(int i = 0; i < e; i++)
            edge[i] = new EdgeImp();
    }
}

class EdgeImp implements Comparable<EdgeImp>{
    int src, dest, weight;
    
    public int compareTo(EdgeImp compareEdge){
        return this.weight - compareEdge.weight;
    }
}

class SubsetImp{
    int parent;
    int rank;
}
