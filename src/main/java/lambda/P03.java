package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class P03 {

    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("trilece", "havucDilim", "güvec", "kokorec", "kusleme", "arabAsi", "waffle", "kunefe", "güvec"));

        alfUpperUnique(menu);
        System.out.println();
        charSayTersSiraliUnique(menu);
        System.out.println();
        charSayNaturalOrderPrint(menu);
        System.out.println();
        charSay7denaz(menu);
        System.out.println();
        wWwithStart(menu);
        xWwithEnd(menu);
        charEnBuyuk(menu);
        ilkCharHaric(menu);


    }

    //TASK 1: List elemanlarini alfabetik buyuk harf ve tekrarsiz print ediniz.

    public static void alfUpperUnique(List<String> list) {

        list.stream().sorted().
                map(String::toUpperCase). // uppercase
                distinct().              // elemanlarin tekrarsiz olmasini sagladi
                forEach(Utils::printAll);
    }

    //Task -2 : List elemanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz.

    public static void charSayTersSiraliUnique(List<String> list) {

        list.stream().map(String::length).sorted(Comparator.reverseOrder()).distinct().forEach(Utils::printAll);
    }

    //TASK-3 : list elemanlarini character sayisina göre kucukten buyuge dioru print ediniz...

    public static void charSayNaturalOrderPrint(List<String> list) {

        list.stream().sorted(Comparator.comparing(String::length)).forEach(Utils::printAll);
    }

    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    // Task-4 : List elelmmalarinin karakter sayisinin 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void charSay7denaz(List<String> list) {

        System.out.println(list.stream().allMatch(t -> t.length() <= 7) ? "List elemanlari 7 ve daha az harfden olusuyor" : "List elemanlari 7 harfdenbuyuk");
    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.

    public static void wWwithStart(List<String> list) {

        System.out.println(list.stream().noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemek yok" : "w ile baslayan tatli var");
    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.

    public static void xWwithEnd(List<String> list) {

        System.out.println(list.stream().anyMatch(t -> t.endsWith("x")) ? "Herhangi biri x ile bitiyor" : "Hicbiri x ile bitmiyor");
    }

    //TASK -7 : karakter sayisi en buyuk elemani yazdiriniz.

    public static void charEnBuyuk(List<String> list) {

        Stream<String> sonIsim = list.stream().sorted(Comparator.comparing(t -> t.toString().length()).reversed()).limit(1);
        Object[] arr = sonIsim.toArray();
        System.out.println(Arrays.toString(arr));
    }

    //TASK -8 : List elemanlarini, son harfine göre siralayip ilk eleman haric kalan elemanlari print ediniz.

    public static void ilkCharHaric(List<String> list) {

        list.stream().sorted(Comparator.comparing(t->t.charAt(t.length()-1))).skip(3).forEach(Utils::printAll);
    }


}