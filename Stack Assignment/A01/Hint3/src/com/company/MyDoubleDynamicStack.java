package com.company;
/**
* ADT MyStack: Private Part<br>. 
* The class implements all the operations available in MyStack<br>
*/
public class MyDoubleDynamicStack<T> implements MyStack<T> {

	//--------------------------------------------------
	// Attributes
	//--------------------------------------------------
	private MyDoubleLinkedNode<T> head;
	private MyDoubleLinkedNode<T> tail;
	private int numItems;
	//-------------------------------------------------------------------
	// Basic Operation --> Check if myStack is empty: myCreateEmpty
	//-------------------------------------------------------------------	
	//public myStack myCreateEmpty(){}
	
	public MyDoubleDynamicStack(){
		this.head = null;
		this.tail = null;
		this.numItems = 0;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Check if myStack is empty: isEmpty
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

		switch(scenario){
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
	// Basic Operation (Partial) --> Get first element from front of MyStack: first
	//-------------------------------------------------------------------

	public T first(){
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

		//Rule 1. if its an empty stack
		if (isEmpty()){
			scenario = 1;
		}
		//Rule 2. if the stack is not empty get first T
		else{
			scenario = 2;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){
			case 1:
				System.out.println("Error Stack is empty");
				break;
			case 2:
				MyDoubleLinkedNode<T> current = this.head;
				res = current.getInfo();
				break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}

	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyStack: addByFirst 
	//-------------------------------------------------------------------

	public void addByFirst(T element){
		//-----------------------------
		//SET OF OPS
		//-----------------------------
	
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		//Rule 1. if the stack is empty add the element.
		if (isEmpty()){
			scenario = 1;
		}
		//Rule 2. if the stack is not empty get previous node info and add element
		else{
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		MyDoubleLinkedNode<T> newNode = null;
		MyDoubleLinkedNode<T> previousNode = null;
		switch(scenario){
			//Rule 1. Add the element
			case 1:
				newNode = new MyDoubleLinkedNode<>(null,element,null);
				newNode.setInfo(element);
				newNode.setRight(null);
				newNode.setLeft(null);
				head = newNode;
				this.numItems++;
				tail = head;
				break;
			//Rule 2. Add the element get previous node info
			case 2:
				previousNode = head;
				newNode = new MyDoubleLinkedNode<T>(null,element,previousNode);
				this.numItems++;
				newNode.setInfo(element);
				newNode.setRight(previousNode);
				newNode.setLeft(null);
				head = newNode;
				tail = previousNode;
				break;



		}

	}

	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyStack: removeByFirst 
	//-------------------------------------------------------------------	

	public void removeByFirst(){
		//-----------------------------
		//SET OF OPS
		//-----------------------------
	
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		//Rule.1 Remove the first element if its not empty
		if (!isEmpty()) {
			scenario =1;
		}
		//Rule.2 Error if there is no elements to remove
		else{
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch (scenario){
			//Rule.1 Remove the first element if its not empty
			case 1:
				//1. Update head
				head = head.getRight();

				//2. We decrease the number of items
				this.numItems = this.numItems - 1;
				break;
			case 2:
				System.out.println("Error stack is empty");
				break;
		}


	}


	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Get first element from front of MyStack: last
	//-------------------------------------------------------------------

	public T last(){
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

		//Rule 1. if its an empty stack
		if (isEmpty()){
			scenario = 1;
		}
		//Rule 2. if the stack is not empty get last T
		else{
			scenario = 2;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){
			case 1:
				System.out.println("Error Stack is empty");
				break;
			case 2:

				MyDoubleLinkedNode<T> current = this.tail;
				res = current.getInfo();
				break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}


	//-------------------------------------------------------------------
	// Basic Operation --> Add element to back of MyStack: addByLast 
	//-------------------------------------------------------------------

	public void addByLast(T element){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		//Rule 1. if the stack is empty add the element.
		if (isEmpty()){
			scenario = 1;
		}
		//Rule 2. if the stack is not empty get previous node info and add element
		else{
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		MyDoubleLinkedNode<T> newNode = null;
		MyDoubleLinkedNode<T> previousNode = null;
		switch(scenario){
			//Rule 1. Add the element
			case 1:
				newNode = new MyDoubleLinkedNode<>(null,element,null);
				newNode.setInfo(element);
				newNode.setRight(null);
				newNode.setLeft(null);
				tail = newNode;
				this.numItems++;
				break;
			//Rule 2. Add the element get previous node info
			case 2:
				previousNode = tail;
				newNode = new MyDoubleLinkedNode<T>(previousNode,element,null);
				this.numItems++;
				newNode.setInfo(element);
				newNode.setRight(null);
				newNode.setLeft(previousNode);
				tail = newNode;
				break;



		}

	}
	
	//-------------------------------------------------------------------
	// Basic Operation (Partial) --> Remove element from front of MyStack: removeByFirst 
	//-------------------------------------------------------------------	

	public void removeByLast(){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		//Rule.1 Remove the first element if its not empty
		if (!isEmpty()) {
			scenario =1;
		}
		//Rule.2 Error if there is no elements to remove
		else{
			scenario = 2;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario){
			//Rule.1 Remove the first element if its not empty
			case 1:
				//1. Update tail
				tail = tail.getLeft();

				//2. We decrease the number of items
				this.numItems = this.numItems - 1;
				break;
			case 2:
				System.out.println("Error stack is empty");
				break;
		}
	}
}

