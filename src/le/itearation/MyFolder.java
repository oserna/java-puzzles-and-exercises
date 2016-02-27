package le.itearation;

import java.util.Queue;

public class MyFolder<T, U> implements Folder<T, U>
{
	
	/**
	 * Traverse the elements of the queue applying the function passed
	 * as parameter. 
	 */
    public U fold(U u, Queue<T> ts, Function2<T, U, U> function){
    	
        if(u == null || ts == null || function == null)
            throw new IllegalArgumentException();
        
        //get the head of the queue
        T t = ts.poll();
        
        //recursion control, until the queue is empty 
        if (t == null)
          return u;
        
        //apply the function to every element polled from the queue
        return fold(function.apply(t, u), ts, function);
    }
    
    
    public U foldWithoutRecursion(U u, Queue<T> queue, Function2<T, U, U> function){

        if(u == null || queue == null || function == null)
            throw new IllegalArgumentException();

    	U applied = u;
    	for (T t : queue) {
    		applied = function.apply(t, applied);
    	}
    	
    	return applied;
    }
    
    
}
