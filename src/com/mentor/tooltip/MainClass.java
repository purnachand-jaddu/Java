package tooltipframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        List<String> myList= Arrays.asList("A","B","C","D","E");
        ListInfo<String> myInfo=new ListInfo<>(myList,"Header1",a->a);
        ListInfo<String> myInfo1=new ListInfo<>(myList,"Header2",a->a);
        ListInfo<String> myInfo2=new ListInfo<>(myList,"Header3",a->a);
        ListInfo<String> myInfo3=new ListInfo<>(myList,"Header4",a->a);
        ListInfo<String> myInfo4=new ListInfo<>(myList,"Header4",a->a);

        List<ListInfo> listInfos=new ArrayList<>();
        listInfos.add(myInfo);
        listInfos.add(myInfo1);
        listInfos.add(myInfo2);
        listInfos.add(myInfo3);
        listInfos.add(myInfo4);

        StringBuilder sb = new StringBuilder();
        new TruncatedTootip(sb).appendCollections(listInfos);

        System.out.println(sb.toString());
    }
}
