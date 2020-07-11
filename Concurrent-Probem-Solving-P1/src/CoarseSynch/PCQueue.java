package CoarseSynch;

import java.util.concurrent.Semaphore;

public class PCQueue extends Thread{
	public int n = -1000; //the value that gets added or removed from the queue
	boolean flag = true; //a flag that is initially true 
	private static Semaphore prod = new Semaphore(1); //the semaphore for the producer
	private static Semaphore cons = new Semaphore(0); // the semaphore for the consumer
	public static int dimension; //the dimension of the queue
	
	PCQueue(int dimension){ //constructor
		PCQueue.dimension = dimension; 
	}
	
	public synchronized void put(int val) //synchronised function for adding values
	//called into the Producer class
	{
		try { //try to acquire access to the PCQueue thread
			prod.acquire(); //acquires access
			this.n = val; //inputs the value into the queue through the parameter val
			this.flag = false; //flag becomes false
			notify(); //notify the awaiting threads
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cons.release(); //release the semaphore 
		
		while(!this.flag) //while the flag is false, it means that the consumer is
			//accessing the queue
		{
			try {
				wait(); //the producer waits until the flag is true
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}
	}
	
	public synchronized int get() { //synchronised function for removing values 
		//called into the Consumer class
		try {
			cons.acquire(); // acquire the semaphore 
			notify(); //notify the other threads 
			this.flag = true; //flag becomes true 
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prod.release(); //release the semaphore, give access to the other threads 
		
		while(this.flag) { //while the flag is true, it means that the producer is accessing 
			//the thread 
			try {
				wait(); //the consumer waits until the flag is true 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		int temp = this.n; //into the local variable temp, the last added value of n is memorised
		return temp; //return that value
	}

}
