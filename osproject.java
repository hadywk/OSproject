package osproject;

import java.util.Scanner;


public class Osproject {
     public static void main(String[] args)
	{
    
    }
     static void firstFIt(int blockSize[], int processSize[]){
            int m = blockSize.length;
            int n = processSize.length;
            int allocatedMemory[] = new int[m];
            for(int i =0;i<m;i++){
                allocatedMemory[i]=-1;
            }
              for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                if (blockSize[j] >= processSize[i]&& allocatedMemory[j]==-1)
                {
                    
                    allocatedMemory[j] = processSize[i];
     break;
                   
                }
            }
        }
              printResults(allocatedMemory,blockSize);
     
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
	static void bestFit(int blockSize[], int processSize[])
	{
            // assigning default value to all array elements
            int m = blockSize.length;
            int n = processSize.length;
            int allocatedMemory[] = new int[m];
            
            for(int i =0;i<m;i++){
                allocatedMemory[i]=-1;
            }
            
            for(int i =0;i<n;i++){
                int max=Integer.MAX_VALUE;
                int index=-1;
                for(int j=0;j<m;j++){
                    if(processSize[i] <= blockSize[j] && allocatedMemory[j]==-1){
                        if(blockSize[j]-processSize[i] <= max){
                            max=blockSize[j]-processSize[i];
                            index=j;
                        }
                    }
                }
                if(index!=-1)
                    allocatedMemory[index] = processSize[i];   
            }
            
            printResults(allocatedMemory,blockSize);
	}
    
    }
