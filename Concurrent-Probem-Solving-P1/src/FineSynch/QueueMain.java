package FineSynch;


public class QueueMain {
	
	public static void main(String[] args) {
		PCQueue queue = new PCQueue(10); //new queue object of capacity of 10 
		Producer[] producer = new Producer[4]; //new producer object, capacity of 4
		int cores = Runtime.getRuntime().availableProcessors(); //the value of the available cores
		Consumer[] consumer = new Consumer[cores]; //declaring a number of consumers of how 
		//many processors are available
		
	for(int i =0; i< 4; i++) {
		producer[i] = new Producer(queue); //new producer 
	}
		
		
	for(int i =0; i< cores; i++) {
		consumer[i] = new Consumer(queue); //new consumer
	}
	
	for(int h = 0; h <4; h++) { //starting the producers
		producer[h].start(); 
	}
	
	for(int l = 0; l < cores; l++) { //starting the consumers
		consumer[l].start();
	}
		
	}
		
}
