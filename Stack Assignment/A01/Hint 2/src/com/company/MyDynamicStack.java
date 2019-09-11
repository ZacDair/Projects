package com.company;
/**
 * ADT MyStack: Private Part<br>.
 * The class implements all the operations available in MyStack<br>
 */
public class MyDynamicStack implements MyStack {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyNode head;
	private int numItems;
	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyStack is empty: myCreateEmpty
	//-------------------------------------------------------------------
	//public myStack myCreateEmpty(){}

	public MyDynamicStack(){
		this.head = null;
		this.numItems = 0;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if MyStack is empty: isEmpty
	//-------------------------------------------------------------------

	public boolean isEmpty(){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = true;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		//Rule 1 check if the stack is empty
		if (numItems == 0){
			scenario = 1;
		}
		//Rule 2 check if the stack is not empty
		else{
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------

		switch(scenario) {
			//Rule 1 check if the stack is empty
			case 1:
				res = true;
				break;
			//Rule 2 check if the stack is not empty
			case 2:
				res = false;
				break;
		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from the top of MyStack and removes it: pop
	//-------------------------------------------------------------------

	public int pop(){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;

		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		//Rule 1. if there is 0 items remove nothing
		if (numItems == 0){
			scenario = 1;
		}
		//Rule 2. if there is more than 0 items remove top item
		else{
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){
			//Rule 1. if there is 0 items remove nothing
			case 1:
				System.out.println("Unable to pop an element, Stack is empty");
				res = 0; //returning 0 to show the element is empty (would need to use a different value for empty if 0 was a possible item to be added in the stack.)
				break;

			//Rule 2. if there is more than 0 items remove top item
			case 2:
				//1. Update res to popped item
				res = head.getInfo();
				//2. Update head
				head = head.getNext();
				//3. We decrease the number of items
				this.numItems = this.numItems - 1;
				break;

		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Add element to the top of MyStack: push
	//-------------------------------------------------------------------

	public void push(int element){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 1;
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		MyNode newNode = null;
		MyNode currentNode = null;

		switch(scenario) {

			//Rule 1. Valid index, add at head
			case 1:
				//1. We declare a reference node to head
				currentNode = head;

				//2. We create the node
				newNode = new MyNode(element, null);

				//3. We make newNode to be the first node of MyList
				this.head = newNode;

				//4. We make the new node to point at current
				newNode.setNext(currentNode);

				//5. We increase numItems
				this.numItems = this.numItems + 1;

				break;
		}
	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> prints all the elements from MyStack: print
	//-------------------------------------------------------------------

	public void print(){

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		//Rule 1. if the stack is empty
		int scenario = 0;
		if (numItems == 0){
			scenario = 1;
		}
		//Rule 2. if the stack is full

		else{
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){
			//Rule 1. if its an empty stack
			case 1:
				System.out.print(" The Stack is empty");
				break;

			//Rule 2. if its a full stack
			case 2:
				MyNode currentNode = head;
				for (int i = 0; i<numItems;i++) {
					System.out.print(currentNode.getInfo());
					if(currentNode.getNext() != null) {
						currentNode = currentNode.getNext();
					}
					else{
						System.out.print(" End of Stack");
					}
				}

				break;
		}

	}

}
