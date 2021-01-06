public class Node{

  private String data;
  private Node next,prev;

  public Node(String value){
   data = value;
  }

  public String get(){
    return data;
  }

  public Node getNext(){
    return next;
  }

  public Node getPrev(){
    return prev;
  }

  public void set(String a){
    data = a;
  }

  public void setNext(Node a){
    next = a;
  }

  public void setPrev(Node a){
    prev = a;
  }
  //write get/set methods for all three instance variables.
}
