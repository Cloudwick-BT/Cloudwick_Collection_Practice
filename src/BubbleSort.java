import java.util.*;

/* Bhavin Tandel
 * 08/03/2016; 19:48
 */

public class BubbleSort{
	
	public static <T> ArrayList<T> bubbleSort(ArrayList<T> arraylist ){
		for(int i = 0; i < arraylist.size(); i++){
			for (int j = i+1; j < arraylist.size(); j++){
				if((((Comparable<T>) arraylist.get(i))).compareTo((arraylist.get(j))) > 0){
					T temp = arraylist.get(i);
					arraylist.set(i, arraylist.get(j));
					arraylist.set(j, temp);
				}
			}
			//System.out.println(arraylist.get(i));
		}
		return arraylist;
	}
	
	public static void main(String[] args){
	int[] rndNum = new int[100000];
		long count = 4999950000L;
		for (int i=0; i<rndNum.length; i++){
			rndNum[i] = new Random().nextInt(Integer.MAX_VALUE);
		}
		ArrayList <Integer>  arraylist = new ArrayList<Integer>();

		for(Integer str : rndNum){
			arraylist.add(str);
		}
		long startTime = System.currentTimeMillis();

		// bubble sort
		arraylist = bubbleSort( arraylist);
		long stopTime = System.currentTimeMillis();
		System.out.println("Total time : " + (stopTime - startTime));
		System.out.println("Total operation : " + count/((stopTime - startTime)/1000));

	
	}

}
