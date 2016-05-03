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
public class PrimsAdjMat {
    public static void main(String args[]){
        int graph[][] = new int[][] {{0, 2, 0, 6, 0},
                                    {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7},
                                    {6, 8, 0, 0, 9},
                                    {0, 5, 7, 9, 0},
                                   };
        primMST(graph);
    }
    
    public static void primMST(int graph[][]){
        int key[] = new int[5];
        int parent[] = new int[5];
        boolean mstSet[] = new boolean[5];
        for(int i = 0; i < 5; i++){
            parent[i] = -1;
            key[i] = Integer.MAX_VALUE;
        }
        //include the 0 as the source vertex
        key[0] = 0;
        parent[0] = -1;
        
        for(int i = 0; i < 4; i++){
            //find the minimum key in the mstSet
            int u = minKey(key, mstSet);
            //add this vertex in the min set
            mstSet[u] = true;
            
            //Now we need to update the adjacent nodes of the current node
            for(int j = 0; j < 5; j++){
                if(graph[u][j] != 0
                        &&mstSet[j] == false
                        && graph[u][j] < key[j]){
                    key[j] = graph[u][j];
                    parent[j] = u;
                }
            }
        }
        printMST(parent, graph);
        
    }
    
    private static void printMST(int parent[], int graph[][]){
        for(int i = 1; i < 5; i++){
            System.out.println(parent[i] + " - " + i + " = " + graph[i][parent[i]]);
        }
    }
    //make the minimum key function as we made in the dijkstra's algorithm!
    public static int minKey(int key[], boolean mstSet[]){
        int min = Integer.MAX_VALUE;
        int minKey = 0;
        for(int i =0 ; i < 5; i++){
            if(!mstSet[i] && key[i] < min){
                min = key[i];
                minKey = i;
            }
        }
        return minKey;
    }
}
