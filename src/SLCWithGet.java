/**
 * Sorted Linked Collection with get.
 * This is a regular <tt>LinkedCollection</tt>, but adding elements into their natural order when using
 * <tt>add</tt>, and extended with the method <tt>get</tt>, see below.
 * @param <E> The comparable type of the list's elements.
 * @author Albin Söderberg
 * @author Anders Magnusson
 * @author Group 59
 */
public class SLCWithGet<E extends Comparable<? super E>> extends LinkedCollection<E> implements CollectionWithGet<E> {

    /**
     * Adds an element to the list sorted by the elements natural ordering.
     * @param e the object to add into the list
     * @return true if the object has been added to the list
     */
    @Override
    public boolean add( E e ){

        if(e == null || isEmpty() || (e.compareTo(head.element) <= 0) ){
            return super.add(e);
        }

        Entry p = head;

        while(p.next != null){
            if (e.compareTo(p.next.element) <= 0){
                p.next = new Entry(e, p.next);
                return true;
            }
            p = p.next;
        }
        p.next = new Entry(e, null);
        return true;
    }

    /**
     * Find the first occurrence of an element
     * in the list that is equal to the argument
     * <tt>e</tt> with respect to its natural order.
     * I.e. <tt>e.compareTo(element)</tt> is 0.
     *
     * @param e The dummy element to compare to.
     * @return  An element <tt>e'</tt> in the list
     *          satisfying <tt>e.compareTo(e') == 0</tt>.
     *          If no element is found, <tt>null</tt> is returned
     */
    @Override
    public E get(E e) {

        for ( E element  : this){
            if (e.compareTo(element) == 0){
                return element;
            }
        }

        return null;
    }
}
