package osproject;

import java.util.Scanner;


public class Osproject {
     public static void main(String[] args)
	{
    
    }
    
     static void printResults(int allocatedMemory[], int blockSize[]){
             for(int i=0;i<allocatedMemory.length;i++){
                if(allocatedMemory[i]!=-1)
                    System.out.println("Process Size "+ allocatedMemory[i]+ " => Block Size "+blockSize[i]);
            }
        }
        static int[] inputBlocks(){
            
            System.out.println("Enter number of Blocks");
            Scanner scan = new Scanner(System.in);
            int size = scan.nextInt();
            int Blocks[] = new int[size];
            System.out.println("Enter Data of Blocks /n");
            for(int i=0;i<Blocks.length;i++){
                Blocks[i]=scan.nextInt();
            }
            return Blocks;
        }
        
        static int[] inputProcesses(){
            
            System.out.println("Enter number of Processes/n");
            Scanner scan = new Scanner(System.in);
            int size = scan.nextInt();
            int Processes[] = new int[size];
            System.out.println("Enter Data of Processes/n");
            for(int i=0;i<Processes.length;i++){
                Processes[i]=scan.nextInt();
            }
            return Processes;
        }
    
    }
