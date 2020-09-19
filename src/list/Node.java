package list;

/**
 * This class create Nodes so that elements in the LinkedList can refer forwards and backwards to each other.
 *
 * @author (Edelman)
 * @version (Sep 2020)
 */

public class Node<E>{
    E value;
    Node <E> next;
    Node <E> prev;

    /**
     * Node Constructor
     * @param value
     * @param next
     */
    Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
    }

    /**
     * Another Node Constructor
     * @param value
     * @param next
     * @param prev
     */
    Node(E value, Node<E> next, Node<E> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
