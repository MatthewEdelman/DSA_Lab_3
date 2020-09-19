/**
 * Method that converts an ArrayList into a String
 *
 * @author (Matthew Edelman)
 * @version (September 5th, 2020)
 */

package list;

/**
 * ArrayList class that implements the methods implemented by the List interface
 *
 * @author (Edelman)
 * @version (Sep 2020)
 */

public class ArrayList<E>
        implements List<E> {
    int size = 0;
    E[] values;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int cap) {
        values = (E[]) new Object[cap];
    }

    public E get(int ndx) {
        return values[ndx];
    }

    public E set(int ndx, E value) {
        E result = values[ndx];
        values[ndx] = value;
        return result;
    }


    public void add(E value) {
        add(size, value);
    }


    public void add(int ndx, E value) {
        if (values.length == size) {
            alloc();
        }
        for (int i = size; i > ndx; i--) {
            values[i] = values[i - 1];
        }
        values[ndx] = value;
        size++;
    }

    public E remove(int ndx) {
        E result = values[ndx];
        for (int i = ndx; i < size - 1; i++) {
            values[i] = values[i + 1];
        }
        size--;
        return result;
    }

    public boolean remove(Object obj) {
        if (this.contains(obj)) {
            remove(this.indexOf(obj));
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }


    public void clear() {
        this.size = 0;
    }


    public boolean isEmpty() {
        if (this.size == 0) {
            return true;
        }
        return false;
    }

    /**
     * When the current array is out of space this method doubles it's size
     */
    private void alloc() {
        E[] tempArray = (E[]) new Object[2 * values.length];

        for (int i = 0; i < size; i++) {
            tempArray[i] = values[i];
        }
        values = tempArray;
    }

    public int indexOf(Object obj) {
        for (int ndx = 0; ndx < this.size; ndx++) {
            if (this.get(ndx).equals(obj)) {
                return ndx;
            }
        }
        return -1;
    }


    public boolean contains(Object obj) {
        for (int ndx = 0; ndx < this.size; ndx++) {
            if (this.get(ndx).equals(obj)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Iterates through an ArrayList and converts to to a string with items separated by commas and returns it
     *
     * @return
     */
    public String toString() {
        String returnValue = "[";
        for (int i = 0; i < this.size; i++) {
            returnValue += values[i];
            if (i < size - 1) {
                returnValue += ",";
            }
        }
        returnValue += "]";
        return returnValue;
    }

    public Iterator<E> iterator() {
        return new ArrayIterator<E>(this);
    }

    public ListIterator<E> listIterator() {
        return new ArrayListIterator<E>(this);
    }

    public ListIterator<E> listIterator(int start) {
        return new ArrayListIterator<E>(this, start);
    }

    //public void deleteLongStrings (int max, List <String> names) { }
}

