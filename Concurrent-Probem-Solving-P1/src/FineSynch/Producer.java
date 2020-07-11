package FineSynch;

public class Producer extends Thread{ //the Producer class 
	private PCQueue queue; //private object of type queue 
	
	Producer(PCQueue queue){ //constructor 
		this.queue = queue; 
	}
	
	public void run() { 
		
		for(int i =0 ; i<=PCQueue.dimension; i++) //for how many producers are
		{
			queue.put(i); //adds that value into the queue 
			System.out.printf("The producer added %d \n", i); //prints what the producer added
		}
	}

}
