package FineSynch;


public class Consumer extends Thread{ //the Consumer class
	private PCQueue queue; //private object of type queue
	
	Consumer(PCQueue queue){ //the constructor
		this.queue = queue;
	}
	
	public void run() {
		for(int i = 0; i<PCQueue.dimension; i++) //for how many consumers are 
			//i takes each value from 0 to the number
		{
			queue.get(); //removes that value from the queue
			System.out.printf("The consumer removed %d \n",i); //prints what the consumer removes from the queue
		}
	}

}
