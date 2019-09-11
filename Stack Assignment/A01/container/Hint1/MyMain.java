
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
		//	1. We create myStack 
		//-------------------------------------
		MyStack m;
		//m = my_create_empty(); //--> We cannot create a new myStack using explicitly my_create_empty()
		m = new MyStaticStack(3); //--> Instead we choose to follow the implementation class. 

		//-------------------------------------
		//	2. isEmpty 
		//-------------------------------------
		System.out.println("Is it empty: " + m.isEmpty()); //--> The current length is 0 as myStack is created initially empty
				
		//-------------------------------------
		//	3. Add three elements 
		//-------------------------------------
		m.push(3); //--> m : [3]
		m.push(4);	//--> m : [4, 3]	
		m.push(5); //--> m : [5, 4, 3]
		m.push(6); //--> Fails, as myStack is already full
		
		//-------------------------------------
		//	4. print & isEmpty 
		//-------------------------------------
		System.out.print("Stack=") ;
		m.print();  //--> m : [5, 4, 3]
		System.out.println("") ;
		System.out.println("Is it empty: " + m.isEmpty()); //--> The current length is 3
		
		//-------------------------------------
		//	5. Get and remove the first item in myStack 
		//-------------------------------------	
		System.out.println("Item that was on top of the stack = " + m.pop()); //--> Returns 5

		System.out.println("Item that was on top of the stack = " + m.pop()); //--> Returns 4
		
		System.out.println("Item that was on top of the stack = " + m.pop()); //--> Returns 3
		
		System.out.println("Item that was on top of the stack = " + m.pop()); //--> Fails
		
		//-------------------------------------
		//	6. print  
		//-------------------------------------
		System.out.print("Stack=") ;
		m.print();  //--> m : [ ]
		System.out.println("") ;
		
	
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
