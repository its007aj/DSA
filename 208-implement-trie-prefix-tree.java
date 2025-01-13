class Node {
    Node next[] = new Node[26];
    boolean flag;

    public boolean containsLetter(char l){
        return this.next[l - 'a'] != null;
    }

    public void addLetter(char l, Node next){
        this.next[l - 'a'] = next;
    }

    public Node getNext(char l){
        return this.next[l - 'a'];
    }

    public void setEnd(){
        this.flag = true;
    }

    public boolean isEnd(){
        return this.flag;
    }
}

class Trie {

    public Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char l = word.charAt(i);
            if(!curr.containsLetter(l)){
                curr.addLetter(l, new Node());
            }
            curr = curr.getNext(l);
        }
        curr.setEnd();
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++){
            char l = word.charAt(i);
            if(!curr.containsLetter(l)){
                return false;
            }
            curr = curr.getNext(l);
        }
        return curr.isEnd() ? true : false;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            char l = prefix.charAt(i);
            if(!curr.containsLetter(l)){
                return false;
            }
            curr = curr.getNext(l);
        }
        return curr != null ? true : false;
    }
}
