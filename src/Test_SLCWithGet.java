import org.junit.*;

public class Test_SLCWithGet {

    SLCWithGet<Integer> sortedList = new SLCWithGet<>();

    @Test
    public void add(){
        sortedList.add(1);
        System.out.println(sortedList.toString());
        sortedList.add(2);
        System.out.println(sortedList.toString());
        sortedList.add(1);
        System.out.println(sortedList.toString());
        sortedList.add(4);
        System.out.println(sortedList.toString());
        sortedList.add(5);
        System.out.println(sortedList.toString());


        System.out.println(sortedList.toString());
        assert (1==1);

    }
}
