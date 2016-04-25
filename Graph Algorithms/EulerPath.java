/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author mehul
 */

//To check the euler path- 
//check if the graph is connected (single vertices can exist), if no, it doesn't have a euler path
//if yes and with no vertices with odd degree, it has a cycle 
//else it has a euler path.
//for checking the connected part, simple dfs has been used.
public class EulerPath {
    static LinkedList<Integer> adjL[];
    static int vert;
    
    public static void main(String args[]){
        Graph g1 = new Graph(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        
        adjL = g1.getList();
        vert = g1.getVertices();
        
        test();
    }
    
    public static void test(){
        int check = isEulerian();
        switch(check){
            case 0:
                System.out.println("Not Euler");
                break;
            case 1:
                System.out.println("Has a Euler Path");
                break;
            case 2:
                System.out.println("Has a Euler Circuit");
                break;
        }
    }
    
    private static int isEulerian(){
        if(!isConnected())
            return 0;
        int odd = 0;
        for(int i = 0; i < vert; i++){
            if(adjL[i].size() % 2 != 0)
                odd++;
        }
        if(odd > 2)
            return 0;
        
        return (odd == 2)? 1 : 2;
    }
    //we need to check if all the vertices with non-zero degree have been visited or not.
    private static boolean isConnected(){
        boolean visited[] = new boolean[vert];
        //find a vertex with non zero degree 
        int i = 0;
        for(i = 0; i < vert; i++){
            if(adjL[i].size() != 0)
                break;
        }
        if(i == vert)
            return true;
        
        DFSUtil(visited, i);
        
        for(int j = 0; j < vert; j++){
            if(visited[j] == false && adjL[j].size() > 0)
                return false;
        }
        return true;
    }
    
    private static void DFSUtil(boolean visited[], int src){
        visited[src] = true;
        Iterator<Integer> i = adjL[src].listIterator();
        while(i.hasNext()){
            int k = i.next();
            if(!visited[k])
                DFSUtil(visited, k);
        }
    }
}
