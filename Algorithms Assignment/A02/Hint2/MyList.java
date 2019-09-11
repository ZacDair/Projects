
/**
* ADT MyList: Public Part<br>. 
* The interface includes all the operations available to a MyList user<br>
*/
public interface MyList<T> {

	//-------------------------------------------------------------------
	// Create an empty MyList: createEmpty
	//-------------------------------------------------------------------
	//public MyQueue createEmpty(); --> Java does not support constructors in interfaces
		
	//-------------------------------------------------------------------
	// Basic Operation --> Get number of items of MyList: length
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it returns its number of items.<br>
	 * @return: Number of items of MyList.
	 */	
	public int length();
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get the item from MyList at the desired index: getElement
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyList and a concrete index, it returns the item placed at that index (if any).<br>
	 * @param index: Index of MyList we are looking for.	 
	 * @return: Item placed at the desired index of MyList (ERROR if there is no item at such position).
	 */	
	public T getElement(int index);
		
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add item to MyList at the desired index: addElement 
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyList, an index and an item, it adds the item at the desired index of MyList (if capacity allows it).<br>
	 * @param index: Index of MyList we want to add the item at.
	 * @param item: Item we want to add to MyList.	 
	 */	
	public void addElement(int index, T item);
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove item from  the desired index of MyList: removeElement 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList and index, it removes the item placed at the desired index of MyList (if any).
	 * @param index: Index of MyList we want to remove its item from.
	 */	
	public void removeElement(int index);
	
}
