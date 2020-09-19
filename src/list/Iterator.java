package list;
/** An Iterator allows the client to step through a Collection,
 * such as a List, and selectively remove values.
*/
public interface Iterator<E> {
    /** @ return true iff there are more values to be
     * obtained with this Iterator.
     */
    boolean hasNext();

    /** @return the next value in the associated collections.
     *Pre: hasNext() is true.
     */
    E next();

    /** REmove the last value obtained with this Iterator
     *Pre: next() has been called at least once since the
     *last call to remove().
     */
     void remove();
}
