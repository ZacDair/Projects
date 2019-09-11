
/**
* The main class of our project.<br>. 
*/
public class MyMain {
	
	/**
	 * This function is used to test the divide and conquer algorithms.
	 */
	public static void test(){
		//1. We create the object to test the exercises
		DivideAndConquerAlgorithms ex = new DivideAndConquerAlgorithms();
		
		//2. We create extra variables for the tests
		
		// m1 = []
		MyList<Integer> m1 = new MyDynamicList<Integer>();
		
		// m2 = [9,3,2]
		MyList<Integer> m2 = new MyDynamicList<Integer>();
		m2.addElement(0, 9);
		m2.addElement(1, 3);
		m2.addElement(2, 2);
		
		// m3 = [4,8,1,3,6,5,2,6]		
		MyList<Integer> m3 = new MyDynamicList<Integer>();
		m3.addElement(0, 4);
		m3.addElement(1, 8);
		m3.addElement(2, 1);	
		m3.addElement(3, 3);			
		m3.addElement(4, 6);
		m3.addElement(5, 5);
		m3.addElement(6, 2);	
		m3.addElement(7, 6);	
		
		//3. We create extra variables for the results		
		int resI = 0;
		boolean resB = false; 
		MyList<Integer> resM = null;
		
		//---------------------
		// TESTS
		//---------------------		

		//----------------------------
		//1. We test maxInt
		//----------------------------
		System.out.println("\n----------- Test: maxInt -------------\n");
		
		resI = ex.maxInt(m1);
		System.out.println(resI);
		
		resI = ex.maxInt(m2);
		System.out.println(resI);		
		
		resI = ex.maxInt(m3);
		System.out.println(resI);
		
		//----------------------------
		//2. We test isReverse
		//----------------------------
		System.out.println("\n----------- Test: isReverse -------------\n");
	
		resB = ex.isReverse(m1);
		System.out.println(resB);
		
		resB = ex.isReverse(m2);
		System.out.println(resB);		
		
		resB = ex.isReverse(m3);
		System.out.println(resB);		
		
		//----------------------------
		//3. We test getNumAppearances
		//----------------------------	
		System.out.println("\n----------- Test: getNumAppearances -------------\n");
		
		resI = ex.getNumAppearances(m1, 0);
		System.out.println(resI);
		
		resI = ex.getNumAppearances(m3, 6);
		System.out.println(resI);		
		
		resI = ex.getNumAppearances(m3, 5);
		System.out.println(resI); 		
		
		//----------------------------
		//4. We test n_toThePowerof_m
		//----------------------------
		System.out.println("\n----------- Test: n_toThePowerof_m -------------\n");
		
		resI = ex.power(3, 5);
		System.out.println(resI);
		
		resI = ex.power(2, 0);
		System.out.println(resI);		
		
		resI = ex.power(5, 2);
		System.out.println(resI);
		
		//----------------------------
		//5. We test lucas
		//----------------------------
		System.out.println("\n----------- Test: lucas -------------\n");

		resI = ex.lucas(0);
		System.out.println(resI);
		
		resI = ex.lucas(3);
		System.out.println(resI);

		resI = ex.lucas(15);
		System.out.println(resI);
		
		//----------------------------
		//6. We test drawImage
		//----------------------------
		System.out.println("\n----------- Test: drawImage -------------\n");

		ex.drawImage(1);
		
		ex.drawImage(3);
		
		ex.drawImage(5);
				
	}
	
	/**
	 * Main Method.
	 * @param args: We will run the program parameter free, so do not worry about it.
	 */
	public static void main(String[] args) {
		test();	
	}

}
