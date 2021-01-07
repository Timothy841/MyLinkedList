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
     a.setNext(end);
   }
   size++;
   return true;
  }
 /*
 public boolean add(int index, String value);
 public String get(int index);
 public String set(int index, String value);
 */
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
   return a;
 }
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
