package list;

/**
 * A ListIterator specifically for ArrayLists
 */

public class ArrayListIterator<E>
        extends ArrayIterator<E>
        implements ListIterator<E> {

    private boolean forward = true;

    ArrayListIterator(List<E> list) {
        super(list);
    }

    ArrayListIterator(List<E> list, int start) {
        super(list);
        ndx = start - 1;
    }

    public boolean hasPrevious() {
        forward = true;
        return ndx >= 0;
    }

    public E previous() {
        forward = false;
        ndx--;
        return list.get(ndx + 1);
    }

    public void remove() {
        if (forward) {
            list.remove(ndx);
            ndx--;
        } else {
            list.remove(ndx + 1);
        }
    }

    public E next() {
        forward = true;
        return super.next();
    }
}
