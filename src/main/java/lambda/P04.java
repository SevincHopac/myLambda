package lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P04 {

    public static void main(String[] args) {
        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul tk", "matematik", 600, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1400, 71);
        Universite u04 = new Universite("marmara", "bilg muh", 1080, 77);
        Universite u05 = new Universite("odtu", "gemi mh", 333, 74);

        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));

        System.out.println("notOrt74Buyuk(unv) = " + notOrt74Buyuk(unv));
        bosluk();
        System.out.println("mathControl(unv) = " + mathControl(unv));

        System.out.println("ogrSayBK(unv) = " + ogrSayBK(unv));
        mathPrint(unv);
        ogrsay550(unv);
        ogrsay1050(unv);

    }

    //task 01--> bütün Ünv. lerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.

    public static boolean notOrt74Buyuk(List<Universite> list) {

        return list.stream().allMatch(t -> t.getNotOrt() > 74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini kontrol eden pr create ediniz.

    public static boolean mathControl(List<Universite> list) {

        return list.stream().anyMatch(t -> t.getBolum().toLowerCase().equals("matematik"));

    /*   return list.
                stream(). // akış sağlandı
                        anyMatch(t -> t.getBolum(). // objelerin bölüm isimleri alındı
                        toLowerCase(). // bölüm isimlerindeki karakterler küçük harfe çevrildi
                        contains("mat")); // mat kelimeis var mı kontrol*/
    }


    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.

    public static Map<String, Integer> ogrSayBK(List<Universite> list) {

        Map<String, Integer> uniOgSay = new LinkedHashMap<>();  // koydugumuz gibi siralar

        List<Universite> siraliUni = list.stream().sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).collect(Collectors.toList());


        List<String> uniisimleri = siraliUni.stream().map(Universite::getUnivercity).collect(Collectors.toList());
        List<Integer> ogsayilari = siraliUni.stream().map(Universite::getOgrSayisi).collect(Collectors.toList());

        for (int i = 0; i < uniisimleri.size(); i++) {
            uniOgSay.put(uniisimleri.get(i), ogsayilari.get(i));
        }
        return uniOgSay;
    }


    //task 04-->"matematik" bolumlerinin sayisini  print ediniz.

    public static void mathPrint(List<Universite> list) {

        System.out.println(list.stream().filter(t -> t.getBolum().equalsIgnoreCase("matematik")).count());

    }


    //task 05-->Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu bulunuz.

    public static void ogrsay550(List<Universite> list) {
      /*  Stream<Integer> not = list.stream().filter(t -> t.getOgrSayisi() > 550).sorted(Comparator.comparing(Universite::getNotOrt).

                reversed()).map(Universite::getNotOrt).limit(1);
        not.forEach(t-> System.out.println("En buksek not ort: " +t));*/

        System.out.println("Ogrenci sayilari 550'dan fazla olan universite'lerin en buyuk notOrt'unu " + list.stream().filter(t -> t.getOgrSayisi() > 550).mapToInt(Universite::getNotOrt).max());
    }


    //task 06-->Ogrenci sayilari 1050'dan az olan universite'lerin en kucuk notOrt'unu bulunuz.

    public static OptionalInt ogrsay1050(List<Universite> list) {
        return list.stream().filter(t -> t.getOgrSayisi() < 1050).mapToInt(Universite::getNotOrt).min();
    }



    public static void bosluk() {
        System.out.println("\n-------------");
    }
}


