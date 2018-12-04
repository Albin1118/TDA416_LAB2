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
        //System.out.println(tree.toString());
    }

    @Test
    public void get_splay_zig(){
        tree.add(10);
        tree.add(15);
        tree.add(5);
        tree.add(8);
        tree.add(2);
        /////////////////////

        System.out.println(tree.toString());
        tree.get(5);
        System.out.println(tree.toString());

    }

    @Test
    public void get_splay_zag(){
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(12);
        tree.add(18);
        /////////////////////

        System.out.println(tree.toString());
        tree.get(11);
        System.out.println(tree.toString());

    }

    @Test
    public void get_splay_zagzig(){
        tree.add(10);
        tree.add(15);
        tree.add(5);
        tree.add(2);
        tree.add(8);
        tree.add(9);
        tree.add(7);
        /////////////////////

        System.out.println(tree.toString());
        tree.get(8);
        System.out.println(tree.toString());

    }

    @Test
    public void get_splay_zigzag(){
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(18);
        tree.add(13);
        tree.add(14);
        tree.add(12);
        /////////////////////

        System.out.println(tree.toString());
        tree.get(13);
        System.out.println(tree.toString());

    }

    @Test
    public void get_splay_zigzig(){
        tree.add(10);
        tree.add(15);
        tree.add(5);
        tree.add(8);
        tree.add(3);
        tree.add(4);
        tree.add(2);
        /////////////////////

        System.out.println(tree.toString());
        tree.get(3);
        System.out.println(tree.toString());

    }

    @Test
    public void get_splay_zagzag(){
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(14);
        tree.add(17);
        tree.add(18);
        tree.add(16);
        /////////////////////

        System.out.println(tree.toString());
        tree.get(17);
        System.out.println(tree.toString());

    }
}
