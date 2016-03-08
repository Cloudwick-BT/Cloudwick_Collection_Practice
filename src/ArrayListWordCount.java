/* Bhavin Tandel
 * 08/03/2016; 11:54 am
 */

import java.util.*;
import java.io.*;


public class ArrayListWordCount {
	public static void main(String[] args) {
	  long startTime = System.currentTimeMillis();

	try{
		 String FILENAME = "F:/Cloudwick/java_Cloudwick/gutenberg/war&peace.txt";
	     FileReader FILE = null;
	     BufferedReader BR = null;
	     String CURRENTLINE = null;
	     String[] LINE = null;
	     ArrayList<Integer> VALUES = new ArrayList<Integer>(); 
	     ArrayList<String> INDEX = new ArrayList<String>();
	     FILE = new FileReader(FILENAME);
         BR = new BufferedReader(FILE);
         Boolean flag = true;

         while ((CURRENTLINE = BR.readLine()) != null) {
             LINE = CURRENTLINE.split("[^a-zA-Z]");
             for(String STR : LINE){
                 STR = STR.toLowerCase();
            	 flag = true;

                 if (STR.length()>1 && !STR.equals(" ")) {
                	 for (int I=0; I < INDEX.size(); I++){
                		 if ((INDEX.get(I)).equals(STR)) {
                			 VALUES.set(I,(VALUES.get(I))+1);
                			 flag = false;
                			 break;
                		 } 
                	 }

                	 if ((flag)){
                		 INDEX.add(STR);
                		 VALUES.add(1);
                	 }
                 }
             }
         }

         BR.close();
         
         // to sort
         int TEMP;
         String STR = null;
         flag = false;
         for(int i = 0; i < INDEX.size(); i++ ){
        	 TEMP = VALUES.get(i);
        	 STR = INDEX.get(i);
        	 int j;
        	 for (j = i+1; j < VALUES.size(); j++){
        		 if (VALUES.get(j) > TEMP){
        			 TEMP = VALUES.get(j);
        			 STR = INDEX.get(j);
        			 flag = true;
        		 }
        	 }
        	 
        	 VALUES.set(VALUES.indexOf(TEMP), (VALUES.get(i)));
        	 INDEX.set(INDEX.indexOf(STR), (INDEX.get(i)));
        	 VALUES.set(i, TEMP);
        	 INDEX.set(i, STR);

         }
         
         for(int i = 0 ; i<10 ; i++){
        	 System.out.println(INDEX.get(i) + " - " + VALUES.get(i));
         }

         
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	    e.printStackTrace();

	}

	long stopTime = System.currentTimeMillis();
	System.out.println("Total time elapsed : " + (stopTime - startTime));
	}

}
