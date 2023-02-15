package lambda;

import java.util.*;

public class P02 {


    //Optional yapi Java 8 ile geldi

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(4, 2, 6, 11, -5, 7, 3, 15));

        ciftKarePrint(list);
        System.out.println();
        tekKupBirFazlaprint(list);
        System.out.println();
        sqrtEven(list);
        System.out.println();
        biggestNumber(list);
        System.out.println();
        kareMax(list);
        System.out.println();
        allNumSum(list);
        System.out.println();
        allNumMultip(list);
        System.out.println();
        minNum(list);
        System.out.println();
        bestenBuyukEnKucukTekNum(list);
        ciftKareAscendingOrder(list);
    }

    // Task-1 : Functional Programming ile listin cift elemanlarinin  karelerini
    // ayni satirda aralarina bosluk bırakarak print ediniz

    public static void ciftKarePrint(List<Integer> list){
        list.stream().filter(Utils::isEvenBoolean).map(Utils::kareAl).forEach(Utils::printAll);
    }

    // Task 2 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print edin

    public static void tekKupBirFazlaprint(List<Integer> list){
      list.stream().filter(Utils::isOddBoolean).map(Utils::cube).map(t->t+1).forEach(Utils::printAll);
//      list.stream().filter(t->t%2 !=0).map(t->(t*t*t)+1).forEach(Utils::printAll);
    }


    // Task-3 : Functional Programming ile listin cift elemanlarinin
    // karekoklerini ayni satirda aralarina bosluk birakarak yazdiriniz

    public static void sqrtEven(List<Integer> list){
        list.stream().filter(Utils::isEvenBoolean).map(Math::sqrt).forEach(t-> System.out.printf( "%.2f \n" , t ));
    }

    //Task 4 : List in en buyuk elemanini yazdiriniz.

    public static void biggestNumber(List<Integer> list){

        Optional<Integer> maxnum = list.stream().reduce(Math::max);
        System.out.println(maxnum);
    }

    // Task-5 : List'in cift elemanlarin karelerinin en buyugunu print ediniz

    public static void kareMax(List<Integer> list){

        System.out.println(list.stream().filter(Utils::isEvenBoolean).map(Utils::kareAl).reduce(Math::max));

    }

    // Task-6: List'teki tum elemanlarin toplamini yazdiriniz.Lambda Expression...

    public static void allNumSum(List<Integer> list){
        System.out.println("--->all sum");
        System.out.println(list.stream().reduce(Math::addExact));

     //   System.out.println(list.stream().reduce(0, (x, y) -> x + y));
    }

    // Task-7: deki tum elemanlarin carpimi

    public static void allNumMultip(List<Integer> list){

        System.out.println("-->all multi");
        System.out.println(list.stream().reduce(1,Math::multiplyExact));

    }

    // Task-8 : List'teki elemanlardan en kucugunu  print ediniz.

    public static void minNum(List<Integer> list){

        System.out.println(list.stream().reduce(Integer::min));

    }

    // Task-9 : List'teki 5'ten buyuk en kucuk tek sayiyi print ediniz.

    public static void bestenBuyukEnKucukTekNum(List<Integer> list){

        System.out.println(list.stream().filter(t -> t > 5 && (t % 2 != 0)).reduce(Integer::min));

    }

    // Task-10 : list'in cift  elemanlarinin karelerini  kucukten buyuge print ediniz.

    public static void ciftKareAscendingOrder(List<Integer> list){
        list.stream().filter(Utils::isEvenBoolean).map(Utils::kareAl).sorted().forEach(Utils::printAll);
    }

}
