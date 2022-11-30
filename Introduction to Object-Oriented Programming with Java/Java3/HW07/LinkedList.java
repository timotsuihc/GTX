import java.util.NoSuchElementException;
public class LinkedList<T> implements List<T>{

  Node<T> head;
  Node<T> tail;
  int size;

  public LinkedList(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public Node<T> getHead(){
    return head;
  }

  public Node<T> getTail(){
    return tail;
  }


  /**
   * Adds the passed in data to the specified index.
   * @param data  the data to add to the List
   * @param index the index to add at
   */

  @Override
  public void addAtIndex(T data, int index){
    if(data == null){
      throw new IllegalArgumentException("You cannot add null data to the list");
    }

    if((index > size) || index < 0){
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }

    Node<T> insertNode = new Node<T>(data);
    Node<T> currentNode;


    if(head == null){
      head = insertNode;
    }
    else if(index == 0){
      insertNode.setNext(head);
      head = insertNode;
    }
    else{
      currentNode = head;
      for(int i=0; i<index-1; i++){
        currentNode = currentNode.getNext();
      }
      insertNode.setNext(currentNode.getNext());
      currentNode.setNext(insertNode);
    }
    size++;
    //tail
    if(insertNode.getNext() == null) {
      tail = insertNode;
    }
    return;
  }

  /**
   * Retrieves the data of the node that's specified.
   * @param index the index of the node whose data we are retrieving
   */
  @Override
  public T getAtIndex(int index){
    if(index<0 || index>=size){
      throw new IllegalArgumentException("Your index is out of the list bounds");
    }
    Node<T> currentNode = head;
    for(int i=0; i<index; i++){
      currentNode = currentNode.getNext();
    }
    return currentNode.getData();
  }

  /**
   * Removes the data at the specified index and returns the data that was removed.
   * @param index removes the Node at this index
   */
  @Override
  public T removeAtIndex(int index){
    if(index<0 || index>=size){
      throw new IllegalArgumentException("Your index is out of bounds");
    }

    Node<T> currentNode = null;
    T removedData= null;

    if(index == 0){
      removedData = head.getData();
      head = head.getNext();
      if(head == null){
        tail = null;
      }
    }
    else{
      currentNode = head;
      for(int i=0; i<index-1; i++){
        currentNode = currentNode.getNext();
      }
      removedData = currentNode.getNext().getData();
      currentNode.setNext(currentNode.getNext().getNext());
      if(currentNode.getNext() == null){
        tail = currentNode;
      }
    }
    size--;
    return removedData;
  }

  /**
   * Removes the Node with the data passed in if a Node containing the data exists.
   * @param data the data to remove from the List
   */
  @Override
  public T remove(T data){
    if(data == null){
      throw new IllegalArgumentException("You cannot remove null data from the list");
    }

    Node<T> currentNode = null;
    T removedData = null;

    if(size == 0){
      throw new NoSuchElementException("The data is not present in the list");
    }
    if(head.getData().equals(data)){
      removedData = head.getData();
      head = head.getNext();
      if(head == null){
        tail = null;
      }
      size--;
      return removedData;
    }
    else{
      currentNode = head;
      while(currentNode.getNext() != null){
        if(currentNode.getNext().getData().equals(data)){
          removedData = currentNode.getNext().getData();
          currentNode.setNext(currentNode.getNext().getNext());
          size--;
          if(currentNode.getNext() == null){
            tail = currentNode;
          }
          return removedData;
        }
        currentNode = currentNode.getNext();
      }
      throw new NoSuchElementException("The data is not present in the list");
    }
  }

  /**
   * Clears the LinkedList - garbage collection is your friend here.
   * THIS SOLUTION SHOULD CAN BE O(1)
   */
  @Override
  public void clear(){
    head = null;
  }

  /**
   * Checks whether the LinkedList is empty or not.
   * @return boolean value indicating whether it's empty or not
   */
  @Override
  public boolean isEmpty(){
    if(head == null){
      return true;
    }
    else{
      return false;
    }
  }
  /**
   * Returns the size of the List
   * @return integer size of the list
   */
  @Override
  public int size(){
    return size;
  }

  public static void main(String[] args) {
    LinkedList<Integer> testList = new LinkedList<Integer>();

    System.out.println("size: " + testList.size());
    System.out.println("is empty: " + testList.isEmpty());
    for(int i = 0; i<testList.size(); i++){
      System.out.println(testList.getAtIndex(i));
    }

    testList.addAtIndex(99 ,0);
    testList.addAtIndex(98 ,1);
    testList.addAtIndex(97 ,2);


    System.out.println("size: " + testList.size());
    System.out.println("is empty: " + testList.isEmpty());
    for(int i = 0; i<testList.size(); i++){
      System.out.println(testList.getAtIndex(i));
    }

    testList.removeAtIndex(2);

    System.out.println("size: " + testList.size());
    System.out.println("is empty: " + testList.isEmpty());
    for(int i = 0; i<testList.size(); i++){
      System.out.println(testList.getAtIndex(i));
    }

  }


}
