import java.util.*;

/* Bhavin Tandel
 * 08/03/2016; 19:48
 */

public class BubbleSort  {
	
	
	public static <T> T[] bubbleSort(T[] arraylist ){
		for(int i = 0; i < arraylist.length; i++){
			for (int j = i+1; j < arraylist.length; j++){
				if((((Comparable<T>) arraylist[i])).compareTo((arraylist[j])) > 0){
					T temp = arraylist[i];
					arraylist[i] = arraylist[j];
					arraylist[j] = temp;
				}
			}
			//System.out.println(arraylist.get(i));
		}
		return arraylist;
	}
	
	public static void main(String[] args){
	Integer[] rndNum = new Integer[100000];
		long count = 4999950000L;
		for (int i=0; i<rndNum.length; i++){
			rndNum[i] = new Random().nextInt(Integer.MAX_VALUE);
		}
		
		long startTime = System.currentTimeMillis();

		// bubble sort
		rndNum = bubbleSort(rndNum);
		long stopTime = System.currentTimeMillis();
		System.out.println("Total time : " + (stopTime - startTime));
		System.out.println("Total operation : " + count/((stopTime - startTime)/1000));

	
	}

	

}
