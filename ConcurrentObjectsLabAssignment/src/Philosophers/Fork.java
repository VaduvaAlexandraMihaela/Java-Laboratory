package Philosophers;

import java.io.IOException;
import java.nio.channels.Pipe;

public class Fork {
	private boolean flag = true; //the flag is initially false
	public int id; //the id of the current fork
	forks chan = new forks(id);
	
	Fork(int id) //constructor for the Fork class
	{
		this.id = id;
	}
	
	public long getId() //returns the id of the fork 
	{
		return id;
	}
	
	public boolean take() {
		while(flag) {
			try {
				Pipe.open();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			flag = false; 
			}
		return true;
	}
	
	public void putDown() {
		
	}
	

}
