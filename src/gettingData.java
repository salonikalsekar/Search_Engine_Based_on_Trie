// These are the packages imported

import java.util.TreeMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class gettingData {

//This function takes the data from the web pages. 
//It only takes the data displayed in the paragraph (p) tag
	
	//this function searches the word and displays the count for a particular link
	public void getData(String link,String searchWord)
	{
		//Overloading takes place for getData function
		int count = 0;
		try
		{
			
			Trie myTrie = new Trie();
			Document document = Jsoup.connect(link).get();
			Elements paragraph = document.select("p");
			PageRanking rank = new PageRanking();
			TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>();
			for(Element para : paragraph)
			{
				String p = para.text();
				//Replacing all the punctuation marks
				p = p.replaceAll("[,.!?:;()-]", "\\s");
				
				for(int i = 0; i < p.length(); i++)
				{
				
				//take each word one by one
					int indexOfSpace = p.indexOf(" ");
					String word = p.substring(0, indexOfSpace);
				//inserting it in the trie 
					myTrie.insert(word.toLowerCase());
				//counts the occurences in the hashmap used for indexing
					count = rank.getCount(word, frequencyData) + 1 ;
					frequencyData.put(word, count);
						
					
					p = p.substring(indexOfSpace+1,p.length()-1);
					
				
				}
			
				
				
			}
			
			
			int temp = rank.getCount(searchWord, frequencyData);
			
			//Printing the results
			
			System.out.println("The status of "+searchWord+" in "+ link + "is "+myTrie.search(searchWord));
			System.out.println(searchWord+" occurs "+temp+" times ");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
			
	}
	//we use this function to display all the words in the web pages and their counts
	public void getData(String link,TreeMap<String, Integer> frequencyData)
	{
		int count = 0;
		try
		{
			//We extract the data from the webpage and inserted in hashmap
			Trie myTrie = new Trie();
			Document document = Jsoup.connect(link).get();
			Elements paragraph = document.select("p");
			PageRanking rank = new PageRanking();
			
			for(Element para : paragraph)
			{
				String p = para.text();
				p = p.replaceAll("[,.!?:;()-]", "\\s");
				//p = p.replaceAll("[^0-9]+", " ");
				//System.out.println(para.text());
				
				
				
				for(int i = 0; i < p.length(); i++)
				{
					int indexOfSpace = p.indexOf(" ");
					//System.out.println(indexOfSpace);
					String word = p.substring(0, indexOfSpace);
					
						myTrie.insert(word.toLowerCase());
						count = rank.getCount(word, frequencyData) + 1 ;
						
						// we put the words in the hashmap to calculate the count
						frequencyData.put(word, count);
						
				
					p = p.substring(indexOfSpace+1,p.length()-1);
					
					
					
				
				}
			
				
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
			
	}

	
}
