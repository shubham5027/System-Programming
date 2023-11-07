import java.util.Scanner; 

class FIT
{
	static void firstFit(int blockSize[], int b, int processSize[], int p)
	{
		int allocation[] = new int[p];
        int occupied[] = new int [b];

		for (int i = 0; i < p; i++)
			allocation[i] = -1;
        for (int i = 0; i < b; i++) 
            occupied[i] = 0;

		for (int i = 0; i < p; i++)
		{
			for (int j = 0; j < b; j++)
			{
				if (!(occupied[j] > 0) && blockSize[j] >= processSize[i])
				{
					allocation[i] = j;
                    occupied[j] = 1;
					break;
				}
			}
		}

		System.out.println("");
		System.out.println("First Fit");
		System.out.println("\nProcess No.\tProcess Size\tBlock no.");
		for (int i = 0; i < p; i++)
		{
			System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");

			if (allocation[i] != -1)
				System.out.print(allocation[i] + 1);
			else
				System.out.print("Not Allocated");

			System.out.println();
		}
		System.out.println("---------------------------------------------");
	}

	//---------------------------------------------------------------------------------------------

	static void nextfit(int blockSize[], int b, int processSize[], int p){

		int allocation[] = new int[p], j = 0;
        int occupied[] = new int[b];
        
		for (int i = 0; i < p; i++)
			allocation[i] = -1;
        for (int i = 0; i < b; i++) 
            occupied[i] = 0;

        for(int i = 0; i < p; i++) { 
            int count = 0;
            while (count < b) { 
                if (!(occupied[j] > 0) && blockSize[j] >= processSize[i]) { 
                    allocation[i] = j;
                    occupied[j] = 1;
                    break;
                }
                j = (j + 1) % b; 
                count+=1;
            }
        } 

		System.out.println("");
		System.out.println("Next Fit");
		System.out.println("\nProcess No.\tProcess Size\tBlock no.");
		for (int i = 0; i < p; i++)
		{
			System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");

			if (allocation[i] != -1)
				System.out.print(allocation[i] + 1);
			else
				System.out.print("Not Allocated");

			System.out.println();
		}
		System.out.println("---------------------------------------------");

    }

	//---------------------------------------------------------------------------------------------

	static void bestfit(int blockSize[], int b, int processSize[], int p){

		int allocation[] = new int[p];
        
		for (int i = 0; i < p; i++)
			allocation[i] = -1;

        for(int i = 0; i < p; i++) { 
            int bestIdx = -1;
            for (int j = 0; j < b; j++) {
                if (blockSize[j] >= processSize[i]){
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (blockSize[bestIdx] > blockSize[j])
                        bestIdx = j;
                }
            }
            if (bestIdx != -1){
                allocation[i] = bestIdx;
                blockSize[bestIdx] -= processSize[i];
            }
        } 

		System.out.println("");
		System.out.println("Best Fit");
		System.out.println("\nProcess No.\tProcess Size\tBlock no.");
		for (int i = 0; i < p; i++)
		{
			System.out.print(" " + (i+1) + "\t\t" + processSize[i] + "\t\t");

			if (allocation[i] != -1)
				System.out.print(allocation[i] + 1);
			else
				System.out.print("Not Allocated");

			System.out.println();
		}
		System.out.println("---------------------------------------------");

    }

	static void worstFit(int blockSize[], int b, int processSize[], int p) {
		int allocation[] = new int[p];
		
		for (int i = 0; i < p; i++)
			allocation[i] = -1;
		
		for (int i = 0; i < p; i++) {
			int worstIdx = -1;
			for (int j = 0; j < b; j++) {
				if (blockSize[j] >= processSize[i]) {
					if (worstIdx == -1 || blockSize[worstIdx] < blockSize[j]) {
						worstIdx = j;
					}
				}
			}
			if (worstIdx != -1) {
				allocation[i] = worstIdx;
				blockSize[worstIdx] -= processSize[i];
			}
		}
		
		System.out.println("");
		System.out.println("Worst Fit");
		System.out.println("\nProcess No.\tProcess Size\tBlock no.");
		for (int i = 0; i < p; i++) {
			System.out.print(" " + (i + 1) + "\t\t" + processSize[i] + "\t\t");
			
			if (allocation[i] != -1) {
				System.out.print(allocation[i] + 1);
			} else {
				System.out.print("Not Allocated");
			}
			
			System.out.println();
		}
		System.out.println("---------------------------------------------");
	}
	

	//---------------------------------------------------------------------------------------------

	public static void main(String[] args)
	{
        try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter no. of processors : ");
			int processors = sc.nextInt();
			System.out.println("Enter no. of blocks : ");
			int blocks = sc.nextInt();

			int blockSize[] = new int[blocks];
			int processSize[] = new int[processors];

			System.out.println("Enter " + processors +" Processors ");
			for (int i = 0; i < processors; i++) {
			    processSize[i] = sc.nextInt();
			}

			System.out.println("Enter " + blocks + 	" Blocks ");
			for (int i = 0; i < blocks; i++) {
			    blockSize[i] = sc.nextInt();
			}

			int b = blocks;
			int p = processors;
			
			firstFit(blockSize, b, processSize, p);
			nextfit(blockSize, b, processSize, p);
			bestfit(blockSize, b, processSize, p);
			worstFit(blockSize, b, processSize, p);

		}
	}
}