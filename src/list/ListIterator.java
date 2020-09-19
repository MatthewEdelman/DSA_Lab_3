package list;

/** An Iterator which can go to the previous
 * value as well as the next value.
 */


public interface ListIterator<E>
        extends Iterator<E> {
    /* Implicit cursor
       a  b  c  d
            ^
       next() -> c
       previous() -> b
     */

    /** @retrun true only if there is a previous value*/
    boolean hasPrevious();

    /** @return the previous value, and move
     * the implicit cursor to the left
     */
    public E previous();


}
