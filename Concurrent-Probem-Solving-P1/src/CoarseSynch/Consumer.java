package CoarseSynch;

public class Consumer extends Thread{ // the Consumer class
	private PCQueue queue; //private object of type queue 
	
	public Consumer(PCQueue queue){ //constructor
		this.queue = queue;
	}
	
	public void run() {
		for(int i = 0; i<PCQueue.dimension; i++) //for how big the queue is
		{
			queue.get(); //remove a value from the queue
			System.out.printf("The consumer removed %d \n",i); //prints what the consumer removes from the queue
		}
	}

}
