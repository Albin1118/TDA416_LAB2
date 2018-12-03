/**
 * This is a regular <tt>BinarySearchTree</tt>, but extended with the method <tt>get</tt>, and
 * moving elements to the top when searching for them with <tt>get</tt> for faster future searches for when getting
 * elements that are searched for often.
 * @param <E> The comparable type of the tree's elements.
 */
public class SplayWithGet<E extends Comparable<? super E>> extends BinarySearchTree<E> implements CollectionWithGet<E> {

    @Override
    public E get(E e) {

        if( root == null){
            return null;
        }

        boolean found = splayFind(e,root);

        if(found){
            return root.element;
        }else{
            return null;
        }

    }

    private boolean splayFind( E elem, Entry t ) {
        if ( t == null )
            return false;
        else {

            //if( t.left == null && t.right == null){ //If both children of the current node are null, stop the search and return t
            //    splay(t);
            //    return null;
            //}

            int jfr = elem.compareTo( t.element );
            if ( jfr  < 0 ) {
                //Entry found = splayFind(elem, t.left);
                if( t.left == null){
                    splay(t);
                    return false;
                }
                else{
                    return splayFind(elem, t.left);
                }
            }else if ( jfr > 0 ) {
                //Entry found = splayFind(elem, t.right);
                if( t.right == null ){
                    splay(t);
                    return false;
                }
                else {
                    return splayFind(elem, t.right);
                }
            }else {
                splay(t);
                return true;
            }
        }
    }  //   find

    /**
     * Moves the data in the specified Entry e to the top of the tree.
     *
     * If e is the root:
     *      do nothing because it is already at the top.
     * If e is a direct child of the root:
     *      do a zig if it is the left child otherwise do a zag.
     * Else:
     *      move it up two steps (with a combination of two zig/zag) and make a recursive call.
     *
     * @param e The Entry to splay to the top.
     */
    private void splay(Entry e){
        if (e == root)
            return;

        if (e.parent == root) {
            if (e == root.left) {
                zig(root);
            } else {
                zag(root);
            }
            return;
        }

        Entry parent = e.parent;
        Entry grandparent = parent.parent;
        if (parent == grandparent.left) {
            if (e == parent.left) {
                zigzig(grandparent);
            } else {
                zagzig(grandparent);
            }
        } else {
            if (e == parent.left) {
                zigzag(grandparent);
            } else {
                zagzag(grandparent);
            }
        }
        splay(grandparent);
    }

    // ========== ========== ========== ==========

    /* Rotera 1 steg i hogervarv, dvs
              x'                 y'
             / \                / \
            y'  C   -->        A   x'
           / \                    / \
          A   B                  B   C
    */
    private void zig( Entry x ) {
        Entry   y = x.left;
        E    temp = x.element;
        x.element = y.element;
        y.element = temp;
        x.left    = y.left;
        if ( x.left != null )
            x.left.parent   = x;
        y.left    = y.right;
        y.right   = x.right;
        if ( y.right != null )
            y.right.parent  = y;
        x.right   = y;
    } //   rotateRight
    // ========== ========== ========== ==========

    /* Rotera 1 steg i vanstervarv, dvs
              x'                 y'
             / \                / \
            A   y'  -->        x'  C
               / \            / \
              B   C          A   B
    */
    private void zag( Entry x ) {
        Entry  y  = x.right;
        E temp    = x.element;
        x.element = y.element;
        y.element = temp;
        x.right   = y.right;
        if ( x.right != null )
            x.right.parent  = x;
        y.right   = y.left;
        y.left    = x.left;
        if ( y.left != null )
            y.left.parent   = y;
        x.left    = y;
    } //   rotateLeft
    // ========== ========== ========== ==========

    /* Rotera 2 steg i hogervarv, dvs
              x'                  z'
             / \                /   \
            y'  D   -->        y'    x'
           / \                / \   / \
          A   z'             A   B C   D
             / \
            B   C
    */
    private void zagzig( Entry x ) {
        Entry   y = x.left,
                z = x.left.right;
        E       e = x.element;
        x.element = z.element;
        z.element = e;
        y.right   = z.left;
        if ( y.right != null )
            y.right.parent = y;
        z.left    = z.right;
        z.right   = x.right;
        if ( z.right != null )
            z.right.parent = z;
        x.right   = z;
        z.parent  = x;
    }  //  doubleRotateRight
    // ========== ========== ========== ==========

    /* Rotera 2 steg i vanstervarv, dvs
               x'                  z'
              / \                /   \
             A   y'   -->       x'    y'
                / \            / \   / \
               z   D          A   B C   D
              / \
             B   C
     */
    private void zigzag( Entry x ) {
        Entry  y  = x.right,
                z  = x.right.left;
        E      e  = x.element;
        x.element = z.element;
        z.element = e;
        y.left    = z.right;
        if ( y.left != null )
            y.left.parent = y;
        z.right   = z.left;
        z.left    = x.left;
        if ( z.left != null )
            z.left.parent = z;
        x.left    = z;
        z.parent  = x;
    } //  doubleRotateLeft
    // ========== ========== ========== ==========

    /* Rotera 1 steg vänster, 1 steg höger, dvs
              x'                  z'
             / \                /   \
            y'  D   -->        B     x'
           / \                      / \
          z'  A                    y'  D
         / \                      / \
        B   C                    C   A
    */
    private void zigzig( Entry x ){
        Entry y = x.left;
        Entry z = x.left.left;
        E e = x.element;
        x.element = z.element;
        z.element = e;
        y.left = z.right;
        if ( y.left != null ){
            y.left.parent = y;
        }
        z.right = x.right;
        if( z.right != null){
            z.right.parent = z;
        }
        x.left = z.left;
        if( x.left != null ){
            x.left.parent = x;
        }
        x.right = z;
        z.parent = x;
        z.left = y;
        y.parent = z;

    }

    /* Rotera 1 steg höger, 1 steg vänster, dvs
               x'                  z'
              / \                /   \
             D   y'   -->       x'    B
                / \            / \
               A   z'         D   y'
                  / \            / \
                 C   B          A   C
     */
    private void zagzag( Entry x ){
        Entry y = x.right;
        Entry z = x.right.right;
        E e = x.element;
        x.element = z.element;
        z.element = e;
        y.right = z.left;
        if ( y.right != null ){
            y.right.parent = y;
        }
        z.left = x.left;
        if( z.left != null){
            z.left.parent = z;
        }
        x.right = z.right;
        if( x.right != null ){
            x.right.parent = x;
        }
        x.left = z;
        z.parent = x;
        z.right = y;
        y.parent = z;
    }
}
