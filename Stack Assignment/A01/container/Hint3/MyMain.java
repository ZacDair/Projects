
/**
* The main class of our project.<br>. 
*/
public class MyMain {

	//-------------------------------------
	//	testMyStack 
	//-------------------------------------	
	/** 
	* This function test the MyStack interface and its static implementation.<br>
	*/
	public static void testMyStack() {
		
		//-------------------------------------
		//	1. We create myStack of two different types 
		//-------------------------------------
		MyStack<Integer> m1;
		//m1 = my_create_empty(); //--> We cannot create a new myStack using explicitly my_create_empty()
		m1 = new MyDoubleDynamicStack<Integer>(); //--> Instead we choose to follow the implementation class. 

		MyStack<Boolean> m2;
		//m1 = my_create_empty(); //--> We cannot create a new myStack using explicitly my_create_empty()
		m2 = new MyDoubleDynamicStack<Boolean>(); //--> Instead we choose to follow the implementation class. 
		
		//-------------------------------------
		//	2. isEmpty 
		//-------------------------------------
		System.out.println("Is m1 empty? " + m1.isEmpty()); //--> The current length is 0 as myStack is created initially empty
		System.out.println("Is m2 empty? " + m2.isEmpty()); //--> The current length is 0 as myStack is created initially empty

		//-------------------------------------
		//	3. Add some elements 
		//-------------------------------------
		m1.addByFirst(3); //--> m1 : [3]
		m1.addByFirst(4); //--> m1 : [4, 3]
		
		m1.addByLast(6); //--> m1 : [4, 3, 6]
		m1.addByLast(5); //--> m1 : [4, 3, 6, 5]
		
		System.out.println("Is m1 empty? " + m1.isEmpty()); //--> The current length is 0 as myStack is created initially empty
		System.out.println("Is m2 empty? " + m2.isEmpty()); //--> The current length is 0 as myStack is created initially empty
						
		m2.addByFirst(true); //--> m2 : [true]
		m2.addByLast(false); //--> m2 : [true, false]
		m2.addByLast(true); //--> m2 : [true, false, true]
		
		//-------------------------------------
		//	4. Get the first item in myStack   
		//-------------------------------------	
		System.out.println("First item = " + m1.first()); //--> Returns 4
		m1.removeByFirst();
		System.out.println("First item = " + m1.first()); //--> Returns 3
		m1.removeByFirst();
		
		System.out.println("Last item = " + m1.last()); //--> Returns 5
		m1.removeByLast();
		System.out.println("Last item = " + m1.last()); //--> Returns 6
		m1.removeByLast();
		
		//-------------------------------------
		//	5. Remove two elements and fail to remove another one
		//-------------------------------------			
		System.out.println("Is m1 empty? " + m1.isEmpty()); //--> The current length is 0 as myStack is created initially empty
		m1.removeByFirst();
		m1.removeByLast();
	
	}
	
	//-------------------------------------
	//	main 
	//-------------------------------------		
	/**
	 * Main Method:<br> 
	 * Calls to the function testMyStack to test MyStack and its implementation.<br>
	 * @param args: We will run the program parameter free, so do not worry about it. 
	 */	
	public static void main(String[] args) {
		//1. We call to the function testMyStack
		testMyStack();
	}

}
