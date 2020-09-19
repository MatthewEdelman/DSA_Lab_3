package list;
/** A Refiterator is an Iterator which allows iteration through a LinkedList.
 */

class RefIterator<E>
        implements Iterator<E>{
    LinkedList<E> list;
    //Reference to the Node storing the last value
    //obtained by a call to next();
    Node<E> cursor;

    //Constructor
    RefIterator(LinkedList<E> list){
        this.list = list;
        cursor = list.head;
    }

    public boolean hasNext() {
        return cursor.next != list.tail;
    }

    public E next() {
        cursor = cursor.next;
        return cursor.value;
    }

    public void remove() {
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        list.size--;
    }
}
