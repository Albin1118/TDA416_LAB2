import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class Test_SLCWithGet {

    SLCWithGet<Integer> sortedList = new SLCWithGet<>();

    @Test
    public void add(){
        sortedList.add(1);
        System.out.println(sortedList.toString());
        sortedList.add(5);
        System.out.println(sortedList.toString());
        sortedList.add(10);
        System.out.println(sortedList.toString());
        sortedList.add(3);
        System.out.println(sortedList.toString());
        sortedList.add(7);
        System.out.println(sortedList.toString());

        int[] expected = {1, 3, 5, 7, 10};
        assertEquals(Arrays.toString(expected), sortedList.toString());

    }

    @Test
    public void get(){
        sortedList.add(1);
        sortedList.add(2);
        sortedList.add(3);

        assertTrue(1 == sortedList.get(1));
        assertTrue(2 == sortedList.get(2));
        assertTrue(3 == sortedList.get(3));

        ///////////////////////////////////////////////////
        SLCWithGet<String> sortedList2 = new SLCWithGet<>();
        sortedList2.add("1");
        sortedList2.add("2");
        sortedList2.add("3");

        assertTrue("1" == sortedList2.get("1"));
        assertTrue("2" == sortedList2.get("2"));
        assertTrue("3" == sortedList2.get("3"));
    }
}
