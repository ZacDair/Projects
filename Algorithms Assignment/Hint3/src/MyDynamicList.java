
/**
* ADT MyList: Private Part<br>. 
* The class implements all the operations available in MyList<br>
*/
public class MyDynamicList<T> implements MyList<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	/**
	 * @param items: It stores the items of MyList.
	 * @param numItems: It represents the number of items of MyList.
	 * @param maxItems: It represents the maximum number of items a MyList can contain.  
	 */
	private MyNode<T> head;
	private int numItems;

	//-------------------------------------------------------------------
	// Basic Operation --> Create an empty myList: my_create_empty
	//-------------------------------------------------------------------
	//public myList my_create_empty(){}

	/**
	 * The constructor creates 1 instance (1 object) of the class MyStaticList<br>
	 */		
	public MyDynamicList(){
		this.head = null;
		this.numItems = 0;
	}
		
	//-------------------------------------------------------------------
	// Basic Operation --> Get number of integers in myList: my_get_length
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, it returns its number of items.<br>
	 * @return: Number of items of MyList.
	 */	
	public int length(){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = 0;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. The number of elements is included in the attribute numItems
		scenario = 1;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. The number of elements is included in the attribute numItems 
		case 1: 
			res = this.numItems;
			break;
		}			

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------	
		return res;
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Get integer of myList at a concrete index: my_get_element
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyList and a concrete index, it returns the item placed at that index (if any).<br>
	 * @param index: Index of MyList we are looking for.	 
	 * @return: Item placed at the desired index of MyList (ERROR if there is no item at such position).
	 */	
	public T getElement(int index){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		T res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. Valid index
		if ((index >= 0) && (index < numItems))
			scenario = 1;
		//Rule 2. Invalid index
		else
			scenario = 2;
		
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
		//Rule 1. Valid index
		case 1: 
			//1. We declare a reference node and a count of the elements we have traversed so far
			MyNode<T> current = this.head;
			int count = 0; 
			
			//2. We look for the node to be consulted  
			while (count < index){
				//2.1. We make current to point to its next node
				current = current.getNext();
				
				//2.2. We increase the amount of nodes visited so far.
				count = count + 1;
			}
			
			//3. We assign the result to the info of the desired node
			res = current.getInfo();

			break;
		
		//Rule 2. Invalid index 
		case 2: 
			res = null;
			System.out.println("ERROR: Cannot get item, invalid index " + index);
			break;
		
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;	
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Add integer to myList at a concrete index: my_add_element 
	//-------------------------------------------------------------------
	/**
	 * Given a concrete MyList, an index and an item, it adds the item at the desired index of MyList (if capacity allows it).<br>
	 * @param index: Index of MyList we want to add the item at.
	 * @param item: Item we want to add to MyList.	 
	 */	
	public void addElement(int index, T item){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. Valid index, add at head
		if (index == 0) 
			scenario = 1;
		else{
			//Rule 2. Valid index, add after head
			if ((index > 0) && (index <= this.numItems))
				scenario = 2;
			//Rule 3. Invalid index
			else
				scenario = 3;
		}
			
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		MyNode<T> newNode = null;
		MyNode<T> currentNode = null;

		switch(scenario){	
				
		//Rule 1. Valid index, add at head
		case 1: 
			//1. We declare a reference node to head
			currentNode = head;
			
			//2. We create the node 
			newNode = new MyNode<T>(item, null);
			
			//3. We make newNode to be the first node of MyList 
			this.head = newNode;
			
			//4. We make the new node to point at current
			newNode.setNext(currentNode);
		 
			//5. We increase numItems
			this.numItems = this.numItems + 1;
			
			break;
			
		//Rule 2. Valid index, add after head
		case 2: 
			//1. We declare a reference node to head, and another one pointing to its previous node. 
			//We also declare a count of the elements we have traversed so far
			currentNode = head;
			MyNode<T> previousNode = null;
			int count = 0;
				
			//2. We look for the place the node should be inserted  
			while (count < index){
				//2.1. We make previous node to point to the current one. 
				previousNode = currentNode;
				
				//2.2. We make current to point to its next node
				currentNode = currentNode.getNext();
				
				//2.3. We increase the amount of nodes visited so far.
				count = count + 1;
			}
				
			//3. We create the node 
			newNode = new MyNode<T>(item, null);

			//4. We make previous node to point to newNode
			previousNode.setNext(newNode);
				
			//5. We make the new node to point at current
			newNode.setNext(currentNode);

			//6. We increase numItems
			this.numItems = this.numItems + 1;
			
			break;
		
		//Rule 3. Invalid index 
		case 3: 
			System.out.println("ERROR: Cannot add item, invalid index " + index);
			break;
			
		}
	}
	
	//-------------------------------------------------------------------
	// Basic Operation --> Remove index of myList: my_remove_element 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList and index, it removes the item placed at the desired index of MyList (if any).
	 * @param index: Index of MyList we want to remove its item from.
	 */	
	public void removeElement(int index){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. Invalid index
		if ((index < 0) || (index > this.numItems))  
			scenario = 1;
		else{
			//Rule 2. Valid index, remove first node
			if (index == 0)
				scenario = 2;
			//Rule 3. Valid index, remove after first node
			else
				scenario = 3;
		}
			
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	

		//Rule 1. Invalid index 
		case 1: 
			System.out.println("ERROR: Cannot remove item, invalid index " + index);
			break;
		
		//Rule 2. Valid index, remove first node
		case 2: 
			//1. Update head 
			head = head.getNext();

			//2. We decrease the number of items
			this.numItems = this.numItems - 1;
		
			break;
			
		//Rule 1. Valid index, remove after first node
		case 3: 
			//1. We declare a reference node to head, and another one pointing to its previous node. 
			//We also declare a count of the elements we have traversed so far
			MyNode<T> currentNode = head;
			MyNode<T> previousNode = null;
			int count = 0;
				
			//2. We look for the place the node should be deleted  
			while (count < index){
				//2.1. We make previous node to point to the current one. 
				previousNode = currentNode;
				
				//2.2. We make current to point to its next node
				currentNode = currentNode.getNext();
				
				//2.3. We increase the amount of nodes visited so far.
				count = count + 1;
			}
				
			//3. Update previous 
			previousNode.setNext(currentNode.getNext());
				
			//4. We make current to point to null
			currentNode = null;
			
			//4. We decrease the number of items
			this.numItems = this.numItems - 1;
			
			break;	
		}
	}
	
}

