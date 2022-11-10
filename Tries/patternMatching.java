package Tries;


import java.util.ArrayList;

//class TrieNode{
//
//	char data;
//	boolean isTerminating;
//	TrieNode children[];
//	int childCount;
//
//	public TrieNode(char data) {
//		this.data = data;
//		isTerminating = false;
//		children = new TrieNode[26];
//		childCount = 0;
//	}
//}


public class patternMatching {

	private TrieNode root;
	public int count;
	public patternMatching() {
		root = new TrieNode('\0');
	}

	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}
	
    public void add(String word){
        add(root,word);
    }

    private void add(TrieNode root, String word){
        if(word.length() == 0){
            root.isTerminating = true;
            return ;
        }
        
        TrieNode child = root.children[word.charAt(0)-'a'];
        if(child == null){
            child = new TrieNode(word.charAt(0));
            root.children[word.charAt(0)-'a'] = child;
        }
        add(child,word.substring(1));
    }
  
    
    // ------------------------ Pattern Matching ------------------------------------
	public boolean PatternMatching(ArrayList<String> vect, String pattern) {
        // Write your code here
//         for(String s: vect){
//             if(s.contains(pattern))
//                 return true;
//         }
        
//         return false;        
        for(String s: vect){
            for(int i =0; i< s.length() ; i++){
                add(s.substring(i));
            }
        }
        
        return search(pattern);
	}

}
