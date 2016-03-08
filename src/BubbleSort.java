import java.awt.List;
import java.util.*;

/* Bhavin Tandel
 * 08/03/2016; 19:48
 */

public class BubbleSort {
	public static void main(String[] args){
		String[] strArray = new String[] { "egg", "ball", "frog", "Abascus", "Zebra", "keyboard"};
		ArrayList <String>  arraylist = new ArrayList<String>();
		//arraylist.addAll(Arrays.asList(strArray));
		for(String str : strArray){
			arraylist.add(str);
		}

		for(int i = 0; i < arraylist.size(); i++){
			for (int j = i; j < arraylist.size(); j++){
				if(((arraylist.get(i)).toLowerCase()).compareTo((arraylist.get(j)).toLowerCase()) > 0){
					String temp = arraylist.get(i);
					arraylist.set(i, arraylist.get(j));
					arraylist.set(j, temp);
				}
			}
			System.out.println(arraylist.get(i));
		}
	
	}

}
