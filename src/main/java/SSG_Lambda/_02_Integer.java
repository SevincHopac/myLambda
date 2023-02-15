package SSG_Lambda;

import jdk.jshell.execution.Util;

import java.util.*;
import java.util.stream.Collectors;

public class _02_Integer {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5,-2,-3,-1,0,1,1,35,3,4,8,5));

        list.stream().forEach(Utils::printSameLine);
        negatifPrint(list);
        squareList(list);
        ascendingOrder(list);
        descendingOrder(list);
        birlerBes(list);
        oddPrint(list);
        oddPrint2(list);
        System.out.println(evenNumMulti(list));
        System.out.println(evenNumMulti2(list));
        squareSumNega(list);
        posiCube(list);
        besBuyuk(list);
        negaSquareList(list);
        negaSquareList2(list);
        areAllNumNega(list);
        hundredEquals(list);
        ilkBesSUM(list);
    }

    // listenin ilk 5 elemanini sum
    public static void ilkBesSUM(List<Integer> list){
        System.out.println(list.stream().limit(5).reduce(0, (x, y) -> x + y));
    }



    // listenin 100 e esit elemani yok mu
    public static void hundredEquals(List<Integer> list){
        System.out.println(list.stream().noneMatch(t -> t == 100));
    }



    // listenin tüm elemanlari sifirdan kucuk mu
    public static void areAllNumNega(List<Integer> list){
        System.out.println();
        System.out.println(list.stream().allMatch(Utils::isNegative));
    }



    // peek - negatiflerin karelerinden list olusturalim
    public static void negaSquareList(List<Integer> list){
        list.stream().filter(Utils::isNegative).map(Utils::square).forEach(Utils::printSameLine);
    }

    public static void negaSquareList2(List<Integer> list){
        System.out.println();
        System.out.println("************");
        list.stream().filter(Utils::isNegative).peek(t-> System.out.println("Number: "+t)).
                map(Utils::square).peek(t-> System.out.println("Square: "+t )).collect(Collectors.toList()).forEach(Utils::printSameLine);
    }


    // 5 ten buyuk sayi var mi

    public static void besBuyuk(List<Integer> list){
        System.out.println(list.stream().anyMatch(t -> t > 5));
    }



    // positive en büyüklerin küpü
    public static void posiCube(List<Integer> list){
        System.out.println(list.stream().filter(Utils::isPositive).map(Utils::cube).reduce(Math::max));
    }





    // Sum ->square of negative num
    public static void squareSumNega(List<Integer> list){
        System.out.println(list.stream().filter(Utils::isNegative).map(Utils::square).reduce(Utils::sumNum));
    }




    //even numbers multiplication

    public static Optional<Integer> evenNumMulti(List<Integer> list){
        System.out.println();
        return list.stream().filter(Utils::isEven).reduce(Math::multiplyExact);
    }

    public static int evenNumMulti2(List<Integer> list){
        System.out.println();
        return list.stream().filter(Utils::isEven).reduce(1,(x,y)->x*y);
    }



    // odd number print between with one space

    public static void oddPrint(List<Integer> list){
        System.out.println();
        list.stream().filter(t->t%2!=0).forEach(Utils::printSameLine);
    }

    public static void oddPrint2(List<Integer> list){
        System.out.println();
        list.stream().filter(Utils::isOdd).forEach(Utils::printSameLine);
    }



    // list elemanlari top
    public static void listSum(List<Integer> list){
        list.stream().reduce(Integer::sum);
        list.stream().reduce(0,(a,b)->a+b);
    }




    // list pozitif elemanalri icin kuplerinibulup birler bas 5 olanlardan new list
    public static void birlerBes(List<Integer> list){
        System.out.println();
        list.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList()).forEach(Utils::printSameLine);
    }




    //descending order
    public static void descendingOrder(List<Integer> list){
        System.out.println();
        list.stream().sorted(Comparator.reverseOrder()).forEach(Utils::printSameLine);
    }



    //ascending order
    public static void ascendingOrder(List<Integer> list){
        System.out.println("------------");
        list.stream().sorted().distinct().forEach(Utils::printSameLine);  //-----  distinct()  -> farkli
    }



    public static void negatifPrint(List<Integer> list){
        System.out.println("-----------");
        list.stream().filter(t->t<0).forEach(Utils::printSameLine);

    }

    // karelerinden new list

    public static void squareList(List<Integer> list){
        System.out.println("-------");
        list.stream().map(t->t*t).collect(Collectors.toList()).forEach(Utils::printSameLine);
    }
}
