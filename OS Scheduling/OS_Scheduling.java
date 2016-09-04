/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package os;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author mehul
 */
public class OS {

    /**
     * @param args the command line arguments
     */
    static class Process{
        int processId;
        int startTime;
        int burstTime;
        int priority;
        int waitTime;
        public Process(int processId, int startTime, int burstTime){
            this.processId = processId;
            this.startTime = startTime;
            this.burstTime = burstTime;
            //initially there is no priority
            this.priority = -1;
            this.waitTime = 0;
        }
        
        public void setPriority(int priority){
            this.priority = priority;
        }
        /*
        public int compareTo(Process prcs){
            int compare = ((Process)prcs).burstTime;
            return this.burstTime - compare;
        }
*/      
        //if priority is there uncomment this code                
        public int compareTo(Process prcs){
            int compare = ((Process)prcs).priority;
            return compare - this.priority;
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        print("Enter the number of processes you want to test upon.");
        int numPro = s.nextInt();
        
        Process processes[] = new Process[numPro];
        
        print("Enter the processes with their start and burst times.");
        //initialise the processes
        for(int i = 0; i < numPro; i++){
            processes[i] = new Process(s.nextInt(), s.nextInt(), s.nextInt());
        }
               
        System.out.println("Do you want to prioritize the processes? 1/0 for yes/no");
        int binAsk = s.nextInt();
        if(binAsk == 1){
            for(int i = 0; i < numPro; i++)
                processes[i].setPriority(s.nextInt());
        }      
        iniAlgos(processes);
    }
    
    public static void iniAlgos(Process processes[]){
        print("Processes Stored");
        print("Choose the sheduling algorithm - \n "
                + "1. Round Robin\n"
                + " 2. Shortest Job First Preemptive\n "
                + "3. Shortest Job First Non-Preemptive\n "
                + "4. First Come First Serve\n "
                + "5. Priority Scheduling\n");
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        switch(k){
                case 1:{
                    roundRobin(processes);
                    break;
                }                    
                case 2:{
                    sjfPre(processes);
                    break;
                }
                case 3:{
                    sjfNonPre(processes);
                    break;
                }
                case 4:{
                    fcfs(processes);
                    break;
                }
                case 5:{
                    prioritySche(processes);
                    break;
                }
                default:
                    fcfs(processes);
        }                           
    }
        
    /////ALGORITHMS/////
    
    private static void roundRobin(Process prcs[]){
        //implement the round robin algorithm using a queue 
        print("Enter the length of quantum you want to use for round robin");
        Scanner s = new Scanner(System.in);
        int quantum = s.nextInt();
        int n = prcs.length;
        LinkedList<Process> queue = new LinkedList<Process>();
        for(int i = 0; i < n; i++)
            queue.add(prcs[i]);
        int timeLine = 0;
        print("Here you go with the process time line:");
        System.out.print(timeLine);
        while(!queue.isEmpty()){
            Process k = queue.poll();
            k.waitTime += (timeLine - k.startTime);
            System.out.print("--P" + k.processId + "--");
            if(k.burstTime>quantum){
                k.burstTime-=quantum;
                queue.add(k);
                timeLine+=quantum;
            }else{
                timeLine+=k.burstTime;
                k.burstTime = 0;
            }
            k.startTime = timeLine;
            System.out.print(timeLine);
        }
        
        print("The wait times in order of the processes:");
        int sum = 0;
        for(int i = 0; i < n; i++){
            print("Process: " + prcs[i].processId + " Wait time: " + prcs[i].waitTime);
            sum+=prcs[i].waitTime;
        }
        sum/=n;
        print("Average wait time is " + sum);
    }
        
    private static void sjfPre(Process prcs[]){
        int n = prcs.length;
        int waitTimes[] = new int[n];
        
        int sum = 0;
        
        waitTimes[0] = 0;
        
        int curWait = 0;
        for(int i = 0; i < n; i++){
            
        }
    }
    
    private static void sjfNonPre(Process prcs[]){
        int n = prcs.length;
        int waitTimes[] = new int[n];
        
        int sum = 0;
        
        Arrays.sort(prcs);
        
        waitTimes[0] = 0;
        
        int curWait = prcs[0].burstTime;
        
        for(int i = 1; i < n; i++){
            waitTimes[i] = curWait - prcs[i].startTime;
            curWait+=prcs[i].burstTime;
            sum+=waitTimes[i];
        }
        
        sum/=n;
        printDetails(waitTimes, sum, prcs);
    }
    
    private static void fcfs(Process prcs[]){
        int n = prcs.length;
        int waitTimes[] = new int[n];
        waitTimes[0] = 0;
        int sum = 0;
        //current wait is the sum of all the wait times 
        int curWait = prcs[0].burstTime;
        for(int i = 1; i < n; i++){
            if(prcs[i].startTime > curWait){
                waitTimes[i] = 0;
                curWait = prcs[i].burstTime;
            }           
            else{
                waitTimes[i] = curWait - prcs[i].startTime;
                curWait+=prcs[i].burstTime;
            }
            sum+=waitTimes[i];
        }              
        sum/=n;
        printDetails(waitTimes, sum, prcs);        
    }
    
    private static void prioritySche(Process prcs[]){
        int n = prcs.length;
        int waitTimes[] = new int[n];
        
        int sum = 0;
        //as the sort used is stable and we have the 
        //processes in the order of arrival times 
        //what we'll get is a stable order of the processes
        //so there is no need to worry about the priority 
        //clashing.
        Arrays.sort(prcs);
        
        waitTimes[0] = 0;
        
        int curWait = prcs[0].burstTime;
        
        for(int i = 1; i < n; i++){
            waitTimes[i] = curWait - prcs[i].startTime;
            curWait+=prcs[i].burstTime;
            sum+=waitTimes[i];
        }
        
        sum/=n;
        printDetails(waitTimes, sum, prcs);
    }
    /////HELPER FUNCTIONS///////
    public static void printDetails(int waitTimes[], int avg, Process prcs[]){
        print("The wait times in order of the processes:");
        for(int i = 0; i < waitTimes.length; i++){
            print("Process: " + prcs[i].processId + " Wait time: " + waitTimes[i]);
        }
        print("Average wait time is " + avg);
    }
    public static void print(String s){
        System.out.println(s);
    }
    
}
