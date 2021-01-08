public class MyLinkedList{
  private int size;
  private Node start,end;

  public MyLinkedList(){
   size = 0;
  }

  public int size(){
   return size;
  };

  public boolean add(String value){
   if (size == 0){
     start = new Node(value);
     end = start;
     start.setNext(null);
     start.setPrev(null);
   }
   else{
     Node a = new Node(value);
     Node b = a;
     a = end;
     end = b;
     end.setNext(null);
     end.setPrev(a);
     a.setNext(end);
   }
   size++;
   return true;
  }

  public boolean add(int index, String value){
    if (index<0 || index>size){
      throw new IndexOutOfBoundsException();
    }
    Node a = new Node(value);
    Node b = find(index);
    if (size == 0){
      start = new Node(value);
      end = start;
      start.setNext(null);
      start.setPrev(null);
    }
    if (index==0){
      Node c = a;
      a = start;
      start = c;
      start.setPrev(null);
      start.setNext(a);
      a.setPrev(start);
    }
    else if (index==size){
      add(value);
      size--;
    }
    else {
      a.setNext(b);
      a.setPrev(b.getPrev());
      b.getPrev().setNext(a);
      b.setPrev(a);
    }
    size++;
    return true;
  }

  public String get(int index){
    return find(index).getData();
  }

  public String set(int index, String value){
    if (index<0 || index>size){
      throw new IndexOutOfBoundsException();
    }
    Node a = new Node(value);
    Node b = find(index);
    if (index==0){
      Node c = a;
      a = start;
      start = c;
      a.getNext().setPrev(start);
      start.setNext(a.getNext());
      start.setPrev(null);
      return a.getData();
    }
    else if (index == size){
      Node c = a;
      a = end;
      end = c;
      a.getPrev().setNext(end);
      end.setPrev(a.getPrev());
      end.setNext(null);
      return a.getData();
    }
    a.setNext(b.getNext());
    a.setPrev(b.getPrev());
    b.getPrev().setNext(a);
    b.getNext().setPrev(a);
    return b.getData();
  }

  public String toString(){
   String a = "";
   Node curr = start;
   for (int i = 0;i<size;i++){
     if (i<size-1){
       a+=curr.getData()+", ";
     }
     else{
       a+=curr.getData();
     }
     curr = curr.getNext();
   }
   return "["+a+"]";
  }

  private Node find(int a){
    Node b;
    if (a < size/2){
      b = start;
      for (int i = 0; i<a; i++){
        b = b.getNext();
      }
    }
    else{
      b = end;
      for (int i = size; i>a; i--){
        b = b.getPrev();
      }
    }
    return b;
  }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
