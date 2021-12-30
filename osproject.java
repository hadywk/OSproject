package osproject;

import java.util.Scanner;


public class Osproject {
     public static void main(String[] args)
	{
	 	//starting with choosing the algorithm 
	     //and the whole execution begins here
	     algorithmChoice();
    
    }
	
	//function where it assignes the process to the first block that is big enough to take the process
	
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
	
	//function where the the processes are assigned to the blocks that will result a large internal fragmentation
	static void worstFit(int blockSize[], int processSize[])
	{
            // assigning default value to all array elements
            int m = blockSize.length;
            int n = processSize.length;
            int allocatedMemory[] = new int[m];
            
            for(int i =0;i<m;i++){
                allocatedMemory[i]=-1;
            }
            
            for(int i =0;i<n;i++){
                int max=Integer.MIN_VALUE;
                int index=-1;
                for(int j=0;j<m;j++){
                    if(processSize[i] <= blockSize[j] && allocatedMemory[j]==-1){
                        if(blockSize[j]-processSize[i] >= max){
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

	
	//function to print the results of the allocated array depending on the algorithm used.
	// as it shows for every process size, the block size that it be partitioned in
     static void printResults(int allocatedMemory[], int blockSize[]){
             for(int i=0;i<allocatedMemory.length;i++){
                if(allocatedMemory[i]!=-1)
                    System.out.println("Process Size "+ allocatedMemory[i]+ " => Block Size "+blockSize[i]);
            }
        }
	
	// getting user input for number of the block
	// and the sizes of blocks in memory
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
        
	
	//getting user input for the processes number
	//and the size of each process 
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
	
	
	//function where the process is assigned to the block that is big enough to take the process and also with smallest internal fragmentation.
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
	
	//user choices of the algorithm used on the allocation of data
	//after setting the blocks in memory and the process size needed
     static void algorithmChoice(){
            System.out.println("Best Fit , Worst Fit , First Fit /n");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            switch(input.toLowerCase()){
                case "best fit":bestFit(inputBlocks(),inputProcesses());break;
                case "worst fit":worstFit(inputBlocks(),inputProcesses());break;
                case "first fit":firstFIt(inputBlocks(),inputProcesses());break;
            }
        }
    }
