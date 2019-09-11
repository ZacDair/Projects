
/**
* ADT MyQueue: Public Part<br>. 
* The interface includes all the operations available to a MyQueue user<br>
*/
public interface MyStack<T> {

	//-------------------------------------------------------------------
	// Create an empty MyQueue: my_create_empty
	//-------------------------------------------------------------------
	//public myQueue my_create_empty(); --> Java does not support constructors in interfaces
		
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyQueue is empty: isEmpty
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyQueue, it returns whether it is empty or not.<br>
	 * @return: Whether MyQueue is empty or not.
	 */	
	public boolean isEmpty();
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: first
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyQueue, it returns its head element (if any).<br>
	 * @return: Head element from MyQueue (ERROR if there are no items in MyQueue).
	 */	
	public T first();
		
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to back of MyQueue: addByFirst 
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyQueue, add an item by its head.<br>
	 * @param element: New item to be added to MyQueue.	 
	 */	
	public void addByFirst(T element);
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByFirst 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyQueue, remove an item by its head.<br>
	 */	
	public void removeByFirst();

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyQueue: last
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyQueue, it returns its tail element (if any).<br>
	 * @return: Tail element from MyQueue (ERROR if there are no items in MyQueue).
	 */	
	public T last();
		
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to back of MyQueue: addByLast 
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyQueue, add an item by its tail.<br>
	 * @param element: New item to be added to MyQueue.	 
	 */	
	public void addByLast(T element);
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyQueue: removeByLast 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyQueue, remove an item by its tail.<br>
	 */	
	public void removeByLast();
	
}
