import java.util.LinkedList;

public class TrieStruct {


	char content;
    boolean isEnd;
    int count;
    LinkedList<TrieStruct> childList;

 //Defining a trie structure
    public TrieStruct(char c)
    {
        childList = new LinkedList<TrieStruct>();
        isEnd = false;
        content = c;
        count = 0;
    }
    public TrieStruct subNode(char c)
    {
        if (childList != null)
            for (TrieStruct eachChild : childList)
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }
}
