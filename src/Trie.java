
public class Trie {

	private TrieStruct root;

    /* Constructor */
    public Trie()
    {
        root = new TrieStruct(' ');
    }
    /* Function to insert word */

    public void insert(String word)
    {
        if (search(word) == true)
            return;
        TrieStruct current = root;
        for (char ch : word.toCharArray() )
        {
        	TrieStruct child = current.subNode(ch);
            if (child != null)
                current = child;
            else
            {
                current.childList.add(new TrieStruct(ch));
                current = current.subNode(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }
    /* Function to search for word */
    public boolean search(String word)
    {
    	TrieStruct current = root;
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return false;
            else
                current = current.subNode(ch);
        }
        if (current.isEnd == true)
            return true;
        return false;
    }


}
