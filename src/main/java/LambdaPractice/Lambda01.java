package LambdaPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda01 {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        hepsiniYazdir(list);

    }

    // S1:listi aralarinda bosluk birakarak yazdiriniz
    public static void hepsiniYazdir(List<Integer> list) {

        list.stream().forEach(t -> System.out.print(t + " "));
    }

    //S2: sadece negatif olanlari yazdir

    public static void negatifleriYazdir(List<Integer> list) {

        list.stream().filter(t -> t < 0).forEach(t -> System.out.print(t + " "));

    }

    //S3: pozitif olanlardan yeni bir liste olustur

    public static void ciftListesi(List<Integer> list) {

        System.out.println(
                list.
                        stream().
                        filter(t -> t > 0).
                        collect(Collectors.toList()));
    }

    //S4:pozitif veya çift olanları yazdırın

    public static void pozitfCift(List<Integer> list) {

        list.stream().
                filter(t -> t % 2 == 0 || t > 0).
                forEach(t -> System.out.print(t + " ")); //lambda expression

    }

    // S5: list in elemanlarin karelerini aynı satırda bır bosluklu yazdıralım

    //map():stream den gelen elemanları baska tıplere donusturmek veya uzerlerınde
    //ıslem yapmak ıcın (update) kullanılır

    public static void squarePrint(List<Integer> list) {

        list.stream().map(t -> t * t).forEach(t -> System.out.print(t + " "));

    }

    //S7: Listin cift elemanlarının kuplerini  aynı satırda bır bosluklu yazdıralım

    public static void ciftElKupPrint(List<Integer> list) {

        list.stream().filter(t -> t % 2 == 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));

    }

    //S8 : list in elemanlarin karelerinden tekrarsiz yazdıralım

    //distinct() => Bu method tekrarlı elemanları sadece bir kere akısa sokar.

    // Bu akışın farklı elemanlarından (Object.equals (Object) 'e göre) oluşan bir akış döndürür.

    // Sıralı akışlar için, farklı elemanın seçimi sabittir
    // (yinelenen öğeler için, karşılaşma sırasında ilk görünen öğe korunur.)
    // Sırasız akışlar için, herhangi bir kararlılık garantisi verilmez. Stream return eder.

    public static void elKareTekrarsiz(List<Integer> list) {

        list.stream().map(t -> t * t).distinct().forEach(t -> System.out.print(t + " "));
    }

    //S9: listin elemanlarini kucukten buyuge siralayalim

    public static void ascendingOrder(List<Integer> list) {

        list.stream().sorted().forEach(t -> System.out.print(t + " "));
    }

    //S10: listin elemanlarini buyukten kucuge siralayalim

    public static void discendingOrder(List<Integer> list) {

        list.stream().sorted(Comparator.reverseOrder()).forEach(t -> System.out.print(t + " "));
    }

    // S11: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim

    public static List<Integer> birlerBasBesolan(List<Integer> list) {

      return   list.stream().filter(t-> t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
    }

    //S12: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

    public static List<Integer> poztifKareBirlerbasBesOlmayanList(List<Integer> list) {

        return   list.stream().filter(t-> t>0).map(t->t*t).filter(t->t%10!=5).collect(Collectors.toList());
    }

    // S13 :list elemanlarini toplamini bulalim

    /*
        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
      kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
       bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılmlı bir hesaplama süreci elde edilmiş olmaktadır.
        reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
      reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
       İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.

*/

    public static void sum(List<Integer> list) {

        System.out.println(list.stream().reduce(0, (x, y) -> x + y));
        System.out.println(list.stream().reduce(0, Integer::sum));
    }



}
