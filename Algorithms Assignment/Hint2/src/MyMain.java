
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
		MyList<Integer> resM = null;
		
		//---------------------
		// TESTS
		//---------------------		

		//----------------------------
		//1. We test recursiveDisplayElements
		//----------------------------
		System.out.println("\n----------- Test: recursiveDisplayElements -------------\n");
		
		ex.recursiveDisplayElements(m1);
		
		ex.recursiveDisplayElements(m2);
		
		ex.recursiveDisplayElements(m3);
		
		//----------------------------
		//2. We test smallerMyList
		//----------------------------
		System.out.println("\n----------- Test: smallerMyList -------------\n");
	
		resM = ex.smallerMyList(m1, 9);
		ex.recursiveDisplayElements(resM);
		
		resM = ex.smallerMyList(m2, 9);
		ex.recursiveDisplayElements(resM);
		
		resM = ex.smallerMyList(m3, 6);
		ex.recursiveDisplayElements(resM);
		
		//----------------------------
		//3. We test biggerEqualMyList
		//----------------------------	
		System.out.println("\n----------- Test: biggerEqualMyList -------------\n");
		
		resM = ex.biggerEqualMyList(m1, 9);
		ex.recursiveDisplayElements(resM);
		
		resM = ex.biggerEqualMyList(m2, 9);
		ex.recursiveDisplayElements(resM);
		
		resM = ex.biggerEqualMyList(m3, 6);
		ex.recursiveDisplayElements(resM);
		
		//----------------------------
		//4. We test concatenate
		//----------------------------
		System.out.println("\n----------- Test: concatenate -------------\n");
		
		resM = ex.concatenate(m1, m2);
		ex.recursiveDisplayElements(resM);
		
		resM = ex.concatenate(m2, m1);
		ex.recursiveDisplayElements(resM);		
		
		resM = ex.concatenate(m2, m3);
		ex.recursiveDisplayElements(resM);
		
		//----------------------------
		//5. We test quickSort
		//----------------------------
		System.out.println("\n----------- Test: quickSort -------------\n");

		resM = ex.quickSort(m1);
		ex.recursiveDisplayElements(resM);
		
		resM = ex.quickSort(m2);
		ex.recursiveDisplayElements(resM);

		resM = ex.quickSort(m3);
		ex.recursiveDisplayElements(resM);
		
	}
	
	/**
	 * Main Method.
	 * @param args: We will run the program parameter free, so do not worry about it.
	 */
	public static void main(String[] args) {
		test();	
	}

}
