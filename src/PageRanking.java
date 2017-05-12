import java.util.HashMap;
import java.util.TreeMap;

public class PageRanking {

	public int getCount(String word,TreeMap<String, Integer> frequencyData){
		
		//We check if the word is already present and take the count
		if (frequencyData.containsKey(word)){
			
			return frequencyData.get(word);

		}
		else{
			
			return 0;
		}
	}
	
	//prints the final data that is the summary
	
	public void printAllCounts(TreeMap<String, Integer> frequencyData)
	{
		System.out.println("************************************************");
        System.out.println("    Occurrences    Words");

        for(String word : frequencyData.keySet( ))
        {
        	
            System.out.printf("%15d    %s\n", frequencyData.get(word), word);
        }

        System.out.println("************************************************");
	}
	
	

}
