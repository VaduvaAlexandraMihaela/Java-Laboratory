package FineSynch;

import java.util.concurrent.Semaphore;

public class PCQueue {
	public int n = -1000; //the value n that gets added or removed from the queue 
	boolean flag = true; //a flag that is initially true 
	//it signals that the queue is empty and the producer can produce values 
	private static Semaphore prod = new Semaphore(1); //the semaphore for the producer 
	private static Semaphore cons = new Semaphore(0); //the semaphore for the consumer 
	public static int dimension; //the capacity of the queue
	private final Object lock = new Object(); //object for the lock 
	
	PCQueue(int dimension){ //the constructor
		PCQueue.dimension = dimension; 
	}
	
	public void put(int val) //function for adding values 
	//called into the Producer class 
	{
		synchronized(lock) { //synchronised block, uses the lock 
			try {
				prod.acquire(); // the producer acquires access 
				this.n = val; //inputs the value into the queue through the parameter val
			} catch (InterruptedException e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
			cons.release(); //releases the queue
		}
	}
	
	public  int get() { //function for removing values 
		//called into the Consumer class 
		synchronized(lock){ //synchronised block, uses the lock 
			try {
				cons.acquire(); //the consumer acquires access
			} catch (InterruptedException e) {
				 //TODO Auto-generated catch block
				e.printStackTrace();
			}
			prod.release(); //releases the queue
	
			int temp = this.n; //into the local variable temp, the last added value of n is memorised 
			return temp; //return that value
		}
	}


}
