import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Test_SplayWithGet {

    SplayWithGet<Integer> tree = new SplayWithGet<>();


    @Test
    public void add(){
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(18);
        System.out.println(tree.toString());
    }

    @Test
    public void get(){
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(18);
        /////////////////////

        System.out.println(tree.toString());
        tree.get(2);
        System.out.println(tree.toString());

        assertTrue(tree.get(8) == null); System.out.println(tree.get(8));
        assertTrue(tree.get(16) == null); System.out.println(tree.get(16));
        assertTrue(tree.get(24) == null); System.out.println(tree.get(24));

        assertTrue(tree.get(10) == 10);
        assertTrue(tree.get(18) == 18);




    }
}
