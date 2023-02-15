package lambda;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static void printAll(Object o){
        System.out.print(o+" ");
    }

    public static List<Integer> evenNumbersToList(List<Integer> list){
        return list.stream().filter(t->t%2==0).collect(Collectors.toList());
    }

    public static boolean isEvenBoolean(int a){
        return a%2==0;
    }

    public static boolean isOddBoolean(int a){
        return a%2==1;
    }


    public static int kareAl(int a){
        return a*a;
    }

    public static int cube(int a){
        return a*a*a;
    }
}
