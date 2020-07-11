package CoarseSynch;

public class Producer extends Thread{ //the Producer class
	private PCQueue queue; //private object of type queue
	
	Producer(PCQueue queue){ //the constructor 
		this.queue = queue;
	}
	
	public void run() {
		for(int i =0 ; i<=PCQueue.dimension; i++) //for how big the queue is 
			//i takes each value from 0 to the number
		{
			queue.put(i); //add that value into the queue
			System.out.printf("The producer added %d \n", i); //prints what the producer added
		}
	}

}
