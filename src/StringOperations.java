
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/**
 * Created by Nikhil on 1/27/2016.
 */
public class StringOperations {
    //ArrayList<String> arrayList = new ArrayList<>();
    HashMap<String, Integer> map = new HashMap<>();

    /**
     * Code to process the lines from the file, apply string operations,
     and determine the most frequently occurring element name.
     * processInputString() will process each line from file, parse it and then
     * store it into map with its count showing frequency of element string.
     * @param
     *
     */
    public static int compareString(String os, String ns){
        int retVal=0;

        if (os.length()<ns.length()) {
            for (int i=0; i<os.length(); i++) {
                if (os.charAt(i)==ns.charAt(i)) {
                    retVal++;
                } else {
                    retVal--;
                }
            }
        } else {
            for (int i=0; i<ns.length(); i++) {
                if (os.charAt(i)==ns.charAt(i)) {
                    retVal++;
                } else {
                    retVal--;
                }
            }
        }

        return retVal;
    }

    /**
     * displayCount will finally used to display frequent element name
     * and its count.
     */
    public void  displayCount(){
        //ArrayList<Integer> valuesFromMap = new ArrayList<>(map.values());
        //ArrayList<String> elementsFromMap = new ArrayList<>(map.keySet());
        //System.out.println(valuesFromMap);
        //System.out.println(elementsFromMap);
        Iterator<Integer> valuesItr = map.values().iterator();
        int max=1;
        while(valuesItr.hasNext()){
            int newMax =0;
            if((newMax = valuesItr.next())>max){
                max = newMax;
            }
        }
        //System.out.println("Maximum Count is " + max);
        System.out.print("The most frequently occurring element is ");
        //Iterator<Map.Entry<String,Integer>> entry = map.entrySet().iterator();
        int moreThanOne=0;
        //ArrayList<String> frequentElements = new ArrayList<>();

        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(Objects.equals(max,entry.getValue())){
                moreThanOne++;
                //System.out.println("And Corresponding value is " + entry.getKey());
                if(moreThanOne==1) {
                    //frequentElements.add(entry.getKey());
                    System.out.print(entry.getKey());
                }else if(moreThanOne>1){
                    //frequentElements.add(entry.getKey());
                    System.out.print("," + entry.getKey());
                }
            }
        }
        if(moreThanOne==1) {
            System.out.print(". It appears " + max + " times");
        }else if(moreThanOne>1){
            System.out.print(". Both appears " + max + " times");
        }
    }

    /**
     * this will take each line as input, parse whole line
     * and return required element name     *
     * @param line
     * @return element name as a string
     */
    public String parseLine(String line){
        int startPoint = line.indexOf("\"");
        int lastPoint = line.indexOf("\"",line.indexOf("\"")+1);
        return line.substring(startPoint+1,lastPoint);
    }

}