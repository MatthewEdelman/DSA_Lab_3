package list;

/** An ArrayIterator is an Iterator which allow
 * iteration through an ArrayList.
*/

class ArrayIterator<E>
        implements Iterator<E>{
    List<E> list; //Postition of the last value obtained by a call to next();
    int ndx = -1;

    //Constructor
    ArrayIterator(List<E> list){
        this.list = list;
    }

    public boolean hasNext() {
        return ndx < list.size() - 1;
    }

    public E next(){
        ndx++;
        return list.get(ndx);
    }

    public void remove(){
        list.remove(ndx);
        ndx--;
    }
}
