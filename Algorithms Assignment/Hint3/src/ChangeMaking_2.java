
/**
* Classical Change making problem with an unlimited amount of coins of each type. <br> 
* Version 2: Selection function with more elaborated policy: First biggest-coin.<br> 
* Depending on the type of coins, it can lead to an optimal solution.<br>
* The class encapsulates all the functions of the Greedy schema<br>
*/

public class ChangeMaking_2 {

	//---------------------------------------
	//	Constructor
	//---------------------------------------
	/**
	 * Constructor of the class. Do not edit it.
	 */
	public ChangeMaking_2(){}

	//-------------------------------------------------------------------
	// 0. displayElements --> Displays all elements of a MyList 
	//-------------------------------------------------------------------	
	/**
	 * Given a concrete MyList, this function displays its elements by screen (if any).
	 * @param m: The MyList we want to display its elements.	  
	 */	
	public void displayElements(MyList<Integer> m){
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
			System.out.print("MyList has " + size + " items: [");
			
			//2. We traverse the items
			for (int i = 0; i < size - 1; i++)
				System.out.print(m.getElement(i) + ", ");
			System.out.println(m.getElement(size - 1) + "]");
			
			break;
	
		}
		
	}
		
	//-------------------------------------------------------------------
	// 1. getCandidate --> It selects the next candidate to be considered.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution that is not a final solution, this function selects the new candidate to be added to it.<br> 
	 * The policy followed is more elaborated: Pick the biggest non-discarded type of coin.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @param discarded: The MyList stating whether a candidate has been discarded so far or not.
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @return: The index of candidate to be selected.
	 */	
	public int getCandidate(int changeGenerated, 
							MyList<Integer> discarded, 
							MyList<Integer> coinValues){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		int res = -1;
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int length = coinValues.length();
		int i = 0;
		int biggest = 0;
		while (res==-1) {
			while (i < length) {
				int element = 0;
				int temp = 0;
				if (discarded.getElement(i) == 0) {
					element = coinValues.getElement(i);
					if(i<length-1){
						if(discarded.getElement(i+1)==0){
							temp = discarded.getElement(i+1);
						}
						else{
							temp = -1;
						}
					}
					else{
						temp = -1;
					}
					if(discarded.getElement(biggest)==0) {
						if (element >= coinValues.getElement(biggest) || temp >= coinValues.getElement(biggest)) {
							if (element > temp) {
								biggest = i;
							} else {
								biggest = i++;
							}
						}
					}
					else{
						biggest = i;
					}
				}
				i++;
			}
			res = biggest;
		}


		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------

		return res;		
	}
	
	//-------------------------------------------------------------------
	// 2. isValid --> It selects if a candidate can be added to the solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution and a selected candidate, this function 
	 * states whether the candidate must be added to the solution or discarded.<br> 
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @param changeGenerated: The quantity of change we have generated so far. 
	 * @param itemSelected: The index of the candidate selected.
	 * @return: Whether the candidate fits or not into the solution.
	 */	

	public boolean isValid(MyList<Integer> coinValues,
						   int amount,
						   int changeGenerated,
						   int itemSelected){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = false;

		//-----------------------------
		//SET OF OPS
		//
		if(coinValues.getElement(itemSelected)+changeGenerated<=amount){
			res = true;
		}


					
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}
	
	//-------------------------------------------------------------------
	// 3. isFinal --> It selects if the current solution is the final solution  
	//-------------------------------------------------------------------	
	/**
	 * Given a current solution, this function states whether it is a final solution or it can still be improved.<br> 
	 * To determine it, it checks whether there is (at least) one more coin that can be used as part of the change.
	 * @param changeGenerated: The change generated by the current solution. 
	 * @param discarded: The MyList stating whether a candidate has been discarded so far or not.
	 * @param coinValues: The MyList containing the set of coins supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: Whether the current solution is the final solution.
	 */	
	public boolean isFinal(int changeGenerated,
						   MyList<Integer> discarded,
						   MyList<Integer> coinValues, 
						   int amount){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		boolean res = true;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int i = 0;
		while(i<coinValues.length()){
			if(coinValues.getElement(i)+changeGenerated<=amount){
				res = false;
			}
			i++;
		}

		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}

	//-------------------------------------------------------------------
	// 4. objectiveFunction --> This function computes the value of the final solution.  
	//-------------------------------------------------------------------	
	/**
	 * Given the final solution to the problem, this function 
	 * computes its value according to:<br>
	 * How many coins are used in the solution.<br>
	 * How accurate it is the change.<br> 
	 * @param sol: The MyList containing the solution to the problem.
	 * @param changeGenerated: The change generated by the current solution. 
	 * @param amount: The amount of change we want to generate. 
	 * @return: The value of such solution.
	 */	
	public MyList<Integer> getQuality(MyList<Integer> sol, 
									  int changeGenerated, 
									  int amount){
		
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;

		//-----------------------------
		//SET OF OPS
		//-----------------------------
		int i = 0;
		res = new MyDynamicList<Integer>();
		while(i<sol.length()){
			int element = sol.getElement(i);
			changeGenerated = changeGenerated + element;
			res.addElement(i,element);
			i++;
		}

		
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}
	
	//-------------------------------------------------------------------
	// 5. solve --> This function solves the problem using a greedy algorithm.  
	//-------------------------------------------------------------------	
	/**
	 * Given an instance of the GP1 problem, this function solves it using 
	 * a greedy algorithm.<br> 
	 * @param coinValues: A MyList containing the value of each type of coin supported. 
	 * @param amount: The amount of change we want to generate.
	 * @return: A MyList containing the amount of coins of each type being selected.
	 */	
	public MyList<Integer> solve(MyList<Integer> coinValues, int amount){
		//-----------------------------
		//Output Variable --> InitialValue
		//-----------------------------
		MyList<Integer> res = null;
		MyList<Integer> solutionValue = null;
		MyList<Integer> discarded = null;
		int changeGenerated = 0;
		int size = coinValues.length();
		res = new MyDynamicList<Integer>();
		for (int i = 0; i < size; i++)
			res.addElement(0, 0);
		discarded = new MyDynamicList<Integer>();
		for (int i = 0; i < size; i++)
			discarded.addElement(0, 0);
		int scenario = 0;
		//-----------------------------
		//SET OF OPS
		//-----------------------------
		if(coinValues.length()==0){
			scenario = 1;
		}
		else{
			scenario = 2;
		}
		switch(scenario){
			case 1:{
				System.out.println("Empty List");
				break;
			}
			case 2:{
				while(!isFinal(changeGenerated,discarded,coinValues,amount)) {
					int coinPicked = -1;
					coinPicked = getCandidate(changeGenerated, discarded, coinValues);
					if (isValid(coinValues, amount, changeGenerated, coinPicked)) {
						if(res.getElement(coinPicked)==0){
							res.removeElement(coinPicked);
							res.addElement(coinPicked, 1);
						}
						else {
							int count = res.getElement(coinPicked);
							count++;
							res.removeElement(coinPicked);
							res.addElement(coinPicked, count);
						}
						changeGenerated = changeGenerated + coinValues.getElement(coinPicked);
					}
					else {
						discarded.removeElement(coinPicked);
						discarded.addElement(coinPicked, 1);
					}

				}
				System.out.println("Res: ");
				displayElements(res);
				solutionValue = getQuality(res,changeGenerated,amount);
				System.out.println("Solution Val: ");				displayElements(solutionValue);
			}
		}
		//-----------------------------
		//Output Variable --> Return FinalValue
		//-----------------------------		
		return res;		
	}
	
}
