package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();

        System.out.println(arrayList.size());
        arrayList.add(0,"1");
        arrayList.addAll(1, Arrays.asList(new String[]{"1", "2"}));
        arrayList.add(2,"5");
        arrayList.add(5,"5");
        System.out.println(arrayList);
    }
}
