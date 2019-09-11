
/**
* ADT MyStack: Public Part<br>. 
* The interface includes all the operations available to a MyStack user<br>
*/
public interface MyStack {

	//-------------------------------------------------------------------
	// Create an empty myStack: my_create_empty
	//-------------------------------------------------------------------
	//public myStack my_create_empty(); --> Java does not support constructors in interfaces
		
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyStack is empty: isEmpty
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyStack, it returns whether it is empty or not.<br>
	 * @return: Whether MyStack is empty or not.
	 */	
	public boolean isEmpty();
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from the top of MyStack and removes it: pop
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyStack, it returns and removes the item in the top of the stack (if any).<br>
	 * @return: element from the top of MyStack (ERROR if there are no items in MyStack).
	 */	
	public int pop();
		

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to the top of MyStack: push 
	//-------------------------------------------------------------------
	/**
	* Given a concrete MyStack, add an item in the top of the stack.<br>
	* @param element: New item to be added to MyStack.	 
    */	

	public void push(int element);
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> prints all the elements from MyStack: print
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyStack, prints all the elements (if any).<br>
	 * 
	 */	
	public void print();

}
