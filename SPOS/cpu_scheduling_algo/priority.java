import java.util.*;

class Process {
    int processId;
    int arrivalTime;
    int burstTime;
    int priority;
    int CT;
    int waitingTime;
    int turnaroundTime;

    Process(int processId, int arrivalTime, int burstTime, int priority) {
        this.processId = processId;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
        this.CT = 0;
    }
}

class priority {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int numProcesses = scanner.nextInt();

        List<Process> processes = new ArrayList<>();

        for (int i = 0; i < numProcesses; i++) {
            System.out.println("Enter details for process " + (i + 1));
            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();
            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();
            System.out.print("Priority: ");
            int priority = scanner.nextInt();

            processes.add(new Process(i + 1, arrivalTime, burstTime, priority));
        }

        // Sort the processes by priority (lower priority number indicates higher priority)
        Collections.sort(processes, Comparator.comparingInt(p -> p.priority));

        int currentTime = 0;
        float totalWaitingTime = 0;
        float totalTurnaroundTime = 0;

        System.out.println("Pid\tAT\tBT\tPT\tCT\tWT\tTAT");

        for (Process process : processes) {
            if (process.arrivalTime > currentTime) {
                currentTime = process.arrivalTime;
            }

            process.waitingTime = currentTime - process.arrivalTime;
            process.turnaroundTime = process.waitingTime + process.burstTime;
             process.CT=currentTime+process.burstTime;
            currentTime += process.burstTime;

            totalWaitingTime += process.waitingTime;
            totalTurnaroundTime += process.turnaroundTime;
          
            System.out.println(process.processId + "\t" + process.arrivalTime + "\t" +
                    process.burstTime + "\t" + process.priority + "\t"+process.CT +"\t"+
                    process.waitingTime + "\t" + process.turnaroundTime);
        }

        float averageWaitingTime = totalWaitingTime / numProcesses;
        float averageTurnaroundTime = totalTurnaroundTime / numProcesses;

        System.out.println("\nAverage Waiting Time: " + averageWaitingTime);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
        scanner.close();
    }
}
