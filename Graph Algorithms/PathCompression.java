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
public class PathCompression {
    public static void main(String args[]){
        MyGraph2 graph = new MyGraph2(3, 3);
        
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
 
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;
 
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;
    }
    
    public static boolean checkCycle(MyGraph2 graph){
        Subset subsets[] = new Subset[3];
        for(int i = 0; i < 3; i++){
            subsets[i].rank = 0;
            subsets[i].parent = i;
        }
        
        for(int i = 0; i < 3 ; i++){
            int src  = find(subsets, graph.edge[i].src);
            int dest  = find(subsets, graph.edge[i].dest);
            
            if(src == dest)
                return true;
            union(subsets, src, dest);
        }
        return false;
    }
    
    private static int find(Subset subsets[], int k){
        if(subsets[k].parent != k)
            subsets[k].parent = find(subsets, subsets[k].parent);//Path Compression Step
        return subsets[k].parent;
    }
    
    private static void union(Subset subsets[], int src, int dest){
        int x = find(subsets, src);
        int y = find(subsets, dest);
        //Attach the subtree with the lower rank to the tree with the higher rank!
        if(subsets[x].rank < subsets[y].rank )
            subsets[x].parent = y;
        else if(subsets[x].rank < subsets[y].rank )
            subsets[y].parent = x;
        else{
            //if the rank of both the nodes is same, make any onne of them as the parent
            //and increase its rank!
            subsets[y].parent = x;
            subsets[x].rank++;
        }
    }
}

class MyGraph2{
    int v, e;
    Edge2 edge[];
    
    MyGraph2(int v, int e){
        this.v = v;
        this.e = e;
        edge = new Edge2[v];
        for(int i = 0; i < e; i ++){
            edge[i] = new Edge2();
        }
    }
}

class Edge2{
    int src;
    int dest;
}

class Subset{
    int rank;
    int parent;
}
