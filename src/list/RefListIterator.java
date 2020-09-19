package list;

public class RefListIterator<E> extends RefIterator<E> implements ListIterator<E> {

    private boolean forward = true;

    RefListIterator(LinkedList<E> list) {
        super(list);
    }

    RefListIterator(LinkedList<E> list, int start) {
        super(list);
        for (int i = 0; i < start; i++) {
            cursor = cursor.next;
        }
    }

    public boolean hasNext() {
        if (list.isEmpty()) {
            return false;
        }
        if (forward) {
            return cursor.next != list.tail;
        }
        return true;
    }

    public E next() {
        if (forward) {
            cursor = cursor.next;
        }
        forward = true;
        return cursor.value;
    }

    public boolean hasPrevious() {
        if (!forward) {
            return cursor.prev != list.head;
        }
        return cursor != list.head;
    }

    public E previous() {
        if (!forward) {
            cursor = cursor.prev;
        }
        forward = false;
        return cursor.value;
    }

    public void remove() {
        super.remove();
        if (forward) {
            cursor = cursor.prev;
        } else {
            cursor = cursor.next;
        }
    }
}
