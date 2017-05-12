import java.util.*;
import java.util.NoSuchElementException.*;
public class StartingApp {
	public static void main(String[] args) {
		int count = 0;
		PageRanking rank = new PageRanking();
		
		//create a map having word as the key and count as values
		TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>();
		
		//We extract data from the websites
		String[] links = {"http://www.whatis.techtarget.com/definition/interface","https://www.jsoup.org","http://www.linfo.org/physical_layer.html"};
		gettingData d = new gettingData();
		
		//The loop parses through the links and extracts the data to take only paragraph data
		
		for(int i = 0; i < links.length; i++)
		{
			
			d.getData(links[i],frequencyData);
		}
		
		rank.printAllCounts(frequencyData);
		Scanner scan = new Scanner(System.in);
		System.out.println("Which word do you want to search? ");
		String word = scan.next();
		//checks if the word is present or not and stores it with its count
		for(int i = 0; i < links.length; i++)
		{
			
			d.getData(links[i],word);
		}
		
		

	}


}
