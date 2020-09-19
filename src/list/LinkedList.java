/**
 * Contains methods that find if lists have objects and finds their indexs
 *
 * @author (Matthew Edelman)
 * @version (September 5th, 2020)
 */
package list;

/**
 * This class implements all of the List Interface methods
 *
 * @author (Edelman)
 * @version (Sep 2020)
 */

public class LinkedList<E>
        implements List<E> {
    int size = 0;

    /**
     * Creates Nodes that are used throughout the program to create linked lists
     */
    Node<E> head = new Node<E>(null, null, null);
    Node<E> tail = new Node<E>(null, null, head);
    private Node<E> ref;


    public LinkedList() {
        head.next = tail;
    }

    /**
     * The 'cursor' of the program, it finds an element of a certain index and sets ref to that value
     *
     * @param ndx
     */
    private void setRef(int ndx) {
        if (ndx <= this.size / 2) {
            ref = head.next;
            for (int i = 0; i < ndx; i++) {
                ref = ref.next;
            }
        } else {
            ref = tail.prev;
            for (int i = 0; i < this.size - 1 - ndx; i++) {
                ref = ref.prev;
            }
        }
    }

    public E get(int ndx) {
        setRef(ndx);
        return ref.value;
    }


    public E set(int ndx, E value) {
        setRef(ndx);
        E result = ref.value;
        ref.value = value;
        return result;
    }


    public void add(E value) {

        Node<E> temp = new Node<E>(value, tail, tail.prev);
        tail.prev.next = temp;
        tail.prev = temp;
        size++;
    }

    public void add(int ndx, E value) {
        if (ndx == size) {
            add(value);
        } else {
            Node<E> ref = head;
            for (int i = 0; i < ndx; i++) {
                ref = ref.next;
            }
            Node<E> temp = new Node<E>(value, ref.next);
            ref.next = temp;
            size++;
        }
    }

    public E remove(int ndx) {
        setRef(ndx);
        ref.next.prev = ref.prev;
        ref.prev.next = ref.next;
        size--;
        return ref.value;
    }

    public boolean remove(Object obj) {
        if (this.contains(obj)) {
            remove(indexOf(obj));
            return true;
        }
        return false;
    }

    public int indexOf(Object obj) { //This finds the Index of an Item in the list and returns it's index or -1 if it's not found
        for (int ndx = 0; ndx < this.size; ndx++) {
            if (this.get(ndx).equals(obj)) {
                return ndx;
            }
        }
        return -1;
    }


    public boolean contains(Object obj) { //Checks if indexOf found object and returns a Boolean
        if (this.indexOf(obj) < 0) {
            return false;
        }
        return true;
    }

    public int size() {
        return this.size;
    }


    public void clear() {
        this.size = 0;
        head.next = tail;
        tail.prev = head;
    }


    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    /**
     * Iterates through an LinkedList and converts to to a string with items separated by commas and returns it
     *
     * @return
     */
    public String toString() {

        String returnValue = "[";

        for (int ndx = 0; ndx < this.size; ndx++) {
            if (ndx < this.size - 1) {
                returnValue = returnValue + (this.get(ndx) + ",");
            } else {
                returnValue = returnValue + this.get(ndx);
            }
        }
        returnValue += "]";
        return returnValue;
    }

    /**
     * Delete all Strings which exceed the given max in length
     * public void deleteLongStrings (int max, List <String> names)
     * {
     * for (int ndx = 0; ndx < names.size(); ndx++) {
     * String stringFromList = names.get(ndx).toString();
     * if(stringFromList.length() > max){
     * names.remove(ndx)
     * }
     * }
     * <p>
     * }
     */
    public int indexOfLast(Object obj) {
        int indexOfLatest = -10;
        for (int ndx = 0; ndx < this.size; ndx++) {
            if (this.get(ndx).equals(obj)) {
                indexOfLatest = ndx;
            }
        }
        if (indexOfLatest == -10) {
            indexOfLatest = -1;
        }
        return indexOfLatest;
    }

    public Iterator<E> iterator() {
        return new RefIterator<E>(this);
    }


    public ListIterator<E> listIterator() {
        return new RefListIterator<E>(this);
    }

    public ListIterator<E> listIterator(int start) {
        return new RefListIterator<E>(this, start);
    }


}


