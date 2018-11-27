public class SLCWithGet<E extends Comparable<? super E>> extends LinkedCollection<E> implements CollectionWithGet<E> {


    public SLCWithGet() {
        super();
    }

    /**
     *  Adds Element e to the list
     * @param e element to be added to the list
     * @return returns true if add was successfull(will always return true)
     */
    @Override
    public boolean add( E e ){

        if( head == null || (e.compareTo(head.element) < 0) ){
            return super.add(e);
        }

        Entry p = head;

        while(p.next != null){
            if (e.compareTo(p.next.element) < 0){
                p.next = new Entry(e, p.next);
                return true;
            }
            p = p.next;
        }
        p.next = new Entry(e, null);
        return true;
    }

    /**
     * Will return an element in the list that equals e
     * @param e The dummy element to compare to.
     * @return element in list that equals e, or null if no element in list is equal to e
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
