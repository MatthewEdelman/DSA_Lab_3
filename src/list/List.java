/**
 * Interface that has Abstract Methods for Lists
 *
 * @author (Matthew Edelman)
 * @version (September 5th, 2020)
 */
package list;

/**
 * This class enforces all the methods that classes that implement List needs to compile
 *
 * @author (Edelman)
 * @version (Sep 2020)
 */

public interface List<E> {
    E get(int ndx);

    E set(int ndx, E value);

    void add(E value);

    void add(int ndx, E value);

    E remove(int ndx);

    boolean remove(Object obj);

    int indexOf(Object obj);

    boolean contains(Object obj);

    boolean isEmpty();

    int size();

    void clear();

    Iterator<E> iterator();

    public ListIterator<E> listIterator();

    public ListIterator<E> listIterator(int start);

}
