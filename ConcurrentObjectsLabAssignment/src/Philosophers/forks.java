package Philosophers;

import java.nio.channels.*;

public class forks {
	int id; 
	Pipe chan;
	
	forks(int id){
		this.id = id; 
	}

}
