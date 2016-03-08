
/* Bhavin Tandel
 * 08/03/2016; 15:14
 */

import java.util.*;
import java.io.*;

class Word implements Comparable<Word>{
	String word;
	int count;
	
	public void input_word(String w){
		word = w;
	}
	
	public void input_value(int i){
		count = i;
	}
	public int get_value(){
		return count;
	}
	public String get_string(){
		return word;
	}

	@Override
	public int compareTo(Word w) {

		return (w.count - count);
	}
}

public class HashMapWordCount{
	public static void main(String[] args){
		long startTime = System.currentTimeMillis();

		
		try {
			String fileName = "F:/Cloudwick/java_Cloudwick/gutenberg/war&peace.txt";
			FileReader file = new FileReader(fileName);
			BufferedReader br = new BufferedReader(file);
			Boolean flag = true;
			String currentLine;
			String []tokens; 
			Map<String, Word> hashMap = new HashMap<String, Word>();
			
			while ((currentLine = br.readLine()) != null){
				tokens = currentLine.split("[^a-zA-Z]");
				
				for ( String token : tokens){
					token = token.toLowerCase();
					if (!token.equals(" ") && token.length()>1){
						if (hashMap.containsKey(token)){
							Word tem = hashMap.get(token);
							tem.input_value((tem.get_value()) + 1);
						}
						else{
							Word tem = new Word();
							tem.input_word(token);
							tem.input_value(1);
							hashMap.put(token,tem);
						}
					}
				}
			}
			
			// to sort
			SortedSet<Word> sortedSet = new TreeSet<Word>(hashMap.values());
			Iterator<Word> it = sortedSet.iterator();
			int i = 0;
			while(it.hasNext() && i < 10){
				Word w = it.next();
				System.out.println(w.get_string() + " -- " + w.get_value());
				i++;
			}
			
			long stopTime = System.currentTimeMillis();
			System.out.println("Total time elapsed : " + (stopTime - startTime));

		}
		catch (Exception e){
			System.out.println(e.getMessage());
		    e.printStackTrace();

		}
	}

}
