import javafx.scene.control.ScrollPane;

/**
 * The class contains the Divide and Conquer-based Algorithms we are using. 
 */
public class DivideAndConquerAlgorithms {


	//----------------------------------------------
	// Class constructor5
	//----------------------------------------------	
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public DivideAndConquerAlgorithms(){}
		
	//-------------------------------------------------------------------
	// 0. iterativeDisplayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this iterative algorithm displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void iterativeDisplayElements(MyList<Integer> m){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0; 
		
		//Rule 1. MyList is empty
		if (m.length() == 0) 
			scenario = 1;
		//Rule 2. MyList is non-empty
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION 
		//-----------------------------
		switch(scenario){	
				
		//Rule 1. MyList is empty
		case 1: 
			//1. We print the empty message
			System.out.println("Empty MyList");
			
			break;
			
		//Rule 2. MyList is non-empty
		case 2: 
			//1. We print the initial message
			int size = m.length();
			System.out.println("MyList Contains the following " + size + " items: ");
			
			//2. We traverse the items
			for (int i = 0; i < size; i++)
				System.out.println("Item " + i + ": " + m.getElement(i));
			
			break;
	
		}
		
	}

	//-------------------------------------------------------------------
	// 1. maxInt --> Computes the maximum item of MyList 
	//-------------------------------------------------------------------	
	/**
	 * The function computes the maximum item of m (-1 if m is empty). 
	 * @param m: The MyList we want to compute its maximum item.
	 * @return: The maximum item of MyList	  
	 */	
	public int maxInt(MyList<Integer> m){
		int scenario =0;
		int listLength = m.length();
		int i = 0;
		int maxIntVal = 0;
		if (listLength == 0){
			scenario = 1;
		}
		if (listLength == 1){
			scenario = 2;
		}
		if(listLength >1){
			scenario = 3;
		}
		switch(scenario){
			case 1: {
				System.out.println("List is empty");
				maxIntVal = -1;
				break;
			}
			case 2:{
				maxIntVal = m.getElement(0);
				break;
			}
			case 3:{
				//1 get the first two elements
				int element1 = m.getElement(0);
				int element2 = m.getElement(1);
				//2 compare to determine the biggest
				//2.1 if element 2 is the biggest
				if(element1 <= element2){
					maxIntVal = element2;
					m.removeElement(0);
					maxInt(m);
					m.addElement(0,element1);
				}
				//2.2 if element 1 is the biggest
				if (element1 >= element2){
					maxIntVal = element1;
					m.removeElement(1);
					maxInt(m);
					m.addElement(1,element2);
				}
				break;
			}

		}
		return maxIntVal;
	}

	//-------------------------------------------------------------------
	// 2. isReverse --> Computes if MyList is sorted in decreasing order 
	//-------------------------------------------------------------------	
	/**
	 * The function computes whether m is sorted in decreasing order or not.  
	 * @param m: The MyList we want to check.
	 * @return: Whether m is sorted in decreasing order or not.  
	 */	
	public boolean isReverse(MyList<Integer> m){
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
		//Rule 1. MyList is empty or contains just one element
		if (m.length() < 2)
			scenario = 1;
			//Rule 2. MyList has more than one element
		else
			scenario = 2;

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){

			//1. MyList is empty or contains just one element
			case 1:
				//1. We assign res to true
				if(m.length()==0){
					System.out.println("List is empty");
				}
				res = true;

				break;

			//2. MyList has more than one element
			case 2:
				//1. We get the first two elements of MyList
				int element1 = m.getElement(0);
				int element2 = m.getElement(1);

				//2. If the first one is bigger than the second, we keep testing the rest of MyList
				if (element1 >= element2){
					m.removeElement(0);
					res = isReverse(m);
					m.addElement(0, element1);
				}
				//3. If the first one is smaller than the second one, we can conclude MyList is not sorted
				else
					res = false;

				break;
		}

		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------
		return res;
	}
	//-------------------------------------------------------------------
	// 3. getNumAppearances --> Computes the amount of times that integer appears in MyList  
	//-------------------------------------------------------------------	
	/**
	 * The function computes the amount of times that the integer n appears in m.   
	 * @param m: The MyList we want to use.
	 * @param n: The number we want to compute its appearances for.
	 * @return: The amount of appearances of n into m  
	 */	
	public int getNumAppearances(MyList<Integer> m, int n){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int numCount = 0;
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		int numToCheck = n;
		if(m.length()==0){
			scenario = 1;
		}
		else{
			if (m.length()==1){
				scenario = 2;
			}
		 	else{
		 		scenario = 3;
			}
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){
			case 1:{
				System.out.println("List is empty");
				numCount = -1;
				break;
			}
			case 2:{
				int element = m.getElement(0);
				if (element == numToCheck){
					numCount++;
				}
				break;
			}
			case 3:{
				int element = m.getElement(0);
				if(element==numToCheck){
					m.removeElement(0);
					int tempCount =getNumAppearances(m,n);
					numCount=numCount+tempCount;
					m.addElement(0,element);
					numCount++;
				}
				else{
					m.removeElement(0);
					int tempCount =getNumAppearances(m,n);
					numCount=numCount+tempCount;
					m.addElement(0,element);
				}
				break;
			}
		}
		return numCount;
	}
	
	//-------------------------------------------------------------------
	// 4. power --> Computes the m-est power of n
	//-------------------------------------------------------------------	
	/**
	 * The function computes n to the power of m.
	 * @param n: The base number.
	 * @param m: The power of n we want to compute
	 * @return: n to the power of m.  
	 */	

	public int power(int n, int m){
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
		//1. if its to the power of 0, res is 1
		if (m==0){
			scenario = 1;
		}
		//2. if its negative
		else if(m <0){
			scenario = 2;
		}
		//3. if its positive
		else{
			scenario =3;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario){
			//1. anything to the power of 0 is 1
			case 1:{
				res =1;
				break;
			}
			//2. use recursion to solve if it is negative
			case 2:{
				res = n*(power(n,m+1));
				break;
			}
			//3.use recursion to solve if its positive
			case 3:{
				res = n*(power(n,m-1));
				break;
			}
		}
		return res;
	}
	
	//-------------------------------------------------------------------
	// 5. lucas --> Computes the n-est term of the Lucas series
	//-------------------------------------------------------------------	
	/**
	 * The function computes the n-est term of the Lucas series
	 * @param n: The n-est term of the series we want to compute
	 * @return: The term being computed 
	 */	
	public int lucas(int n){
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
		if(n==0){
			scenario = 1;
		}
		else if(n==1){
			scenario = 2;
		}
		else if(n>1){
			scenario = 3;
		}
		else{
			scenario = 4;
		}

		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch(scenario){
			case 1:{
				res = 2;
				break;
			}
			case 2:{
				res = 1;
				break;
			}
			case 3:{
				res = lucas(n-1) + lucas(n-2);
				break;
			}
			case 4:{
				System.out.println("Negative number for n, returning -1 instead");
				res = -1;
				break;
			}
		}
		return res;
	}

	//-------------------------------------------------------------------
	// 6. drawImage --> Prints a pattern of a given length
	//-------------------------------------------------------------------	
	/**
	 * The function prints prints a pattern of a given length.
	 * *
	 * **
	 * ***
	 * ... 
	 * @param n: The length of the desired pattern
	 */	
	public void drawImage(int n){
		//-----------------------------
		//SET OF OPS
		//-----------------------------

		//-----------------------------
		// I. SCENARIO IDENTIFICATION
		//-----------------------------
		int scenario = 0;
		if(n==0){
			scenario = 1;
		}
		else if(n<0){
			scenario = 2;
		}
		else{
			scenario = 3;
		}
		//-----------------------------
		// II. SCENARIO IMPLEMENTATION
		//-----------------------------
		switch (scenario){
			case 1:{
				//no pattern for 0
				break;
			}
			case 2:{
				System.out.println("No pattern for negative values");
				break;
			}
			case 3:{
				drawImage(n-1);
				for(int i = 0; i < n; i++) {
					System.out.print("*");
				}
				System.out.println();
				break;
			}
		}
	}
}
