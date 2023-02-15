package LambdaPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("Elma");
        list.add("portakall");
        list.add("uzum");
        list.add("cilek");
        list.add("greyfurt");
        list.add("nar");
        list.add("mandalina");
        list.add("armut");
        list.add("elma");
        list.add("keciboynuzu");
        list.add("Ayva");


        System.out.println("ilkHarfBykGerisiKucukList(list) = " + ilkHarfBykGerisiKucukList(list));
        System.out.println("*******************");
        ecIlkharfliler(list);
        System.out.println("*******************");
        yildizekle(list);
        System.out.println("*******************");
        eOlanlar(list);
        System.out.println("*******************");
        lsil(list);
    }


    //S1: list elemanlarını ilk harf buyuk gerisi kucuk sekılde listeleyelim

    public static List<String> ilkHarfBykGerisiKucukList(List<String> list){

     return  list.stream().
             map(t->t.substring(0,1).toUpperCase()+t.substring(1).toLowerCase()).
             collect(Collectors.toList());
    }

    // S2: ilk harfi e ve ya c olanlari listeleyelim

    public static void ecIlkharfliler(List<String> list){

        list.stream().filter(t->t.toLowerCase().startsWith("e") || t.toLowerCase().startsWith("c")).
                collect(Collectors.toList()).
                forEach(t-> System.out.print(t +" "));

    }

    //S3: tum stringlerin basina ve sonuna yildiz ekleyerek yazdiralim

    public static void yildizekle(List<String> list){

        list.stream().map(t->"*"+t+"*").forEach(Utils::stringPrint);
    }

    //S4 : icinde e olanlardan yeni bir list olusturunuz

    public static void eOlanlar(List<String> list){

        System.out.println(list.stream().filter(t -> t.toLowerCase().contains("e")).collect(Collectors.toList()));
    }

    //S5: tum 'l' leri silelim yazdiralim

    public static void lsil(List<String> list){

        System.out.println(list.stream().map(t -> t.replace("l", "")).collect(Collectors.toList()));

    }

    //S6: List elemanarını 2.harfe gore sıralayıp
    //ilk 5 elemandan char sayısı en buyuk elemanı print

    public static void iKinciHarfegoreSiralaIlk5elemandanEnbuyukcharSayisi(List<String> list){

        System.out.println(list.stream().map(t -> t.replace("l", "")).collect(Collectors.toList()));

        System.out.println(list.stream().
                sorted(Comparator.comparing(t -> t.charAt(1))).
                limit(5). //ilk 5 eleman akisa devam ediyor
                        sorted(Comparator.comparing(String::length).reversed()).
                findFirst()); //  Optional[String]

    }


}
