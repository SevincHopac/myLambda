package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P01 {

      /*

      Java8 ile geldi.

      1)  Lambda --> mathod create  etme değil mevcut method'ları(library)secip kullanmaktır...
          Lambda'lar sayesinde daha az kod ve hızlı geliştirme sağlanabilmektedir.

      2) "Functional Programming" de "Nasil yaparim?" degil "Ne yaparim?" dusunulur.
          "Structured Programming" de "Ne yaparim?" dan cok "Nasil Yaparim?" dusunulur

      3)  "Functional Programming" hiz, code kisaligi, code okunabilirligi
          ve hatasiz code yazma acilarindan cok faydalidir.

      4)  Lambda sadece collections'larda(List, Queue ve Set) ve array'lerde kullanilabilir ancak map'lerde kullanılmaz.

*/

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(Arrays.asList(34, 22, 16, 11, 35, 20, 63, 21, 65, 44, 66, 64, 81, 38, 15));

        struPrintNumber(numbers);
        System.out.println();
        funcPrintNumber(numbers);
        System.out.println();
        funcPrintNumber2(numbers);
        System.out.println();
        evenPrint(numbers);
        System.out.println();
        System.out.println(Utils.evenNumbersToList(numbers));
        System.out.println();
        evenPrint1(numbers);
        System.out.println();
        print34Kucuk(numbers);


    }

    //TASK  : "Structured Programming" kullanarak list elemanlarını aynı satirda
    // aralarında bosluk olacak sekilde print ediniz.

    public static void struPrintNumber(List<Integer> list) {

        for (Integer w : list) {
            System.out.print(w + " ");
        }

    }

    public static void funcPrintNumber(List<Integer> list) {

        list.forEach(t -> System.out.print(t + " "));
    }

    public static void funcPrintNumber1(List<Integer> list) {

        // sadece print icin stream() siz de yazabiliriz
        list.forEach(System.out::print);
    }


    public static void funcPrintNumber2(List<Integer> list) {

        list.forEach(Utils::printAll);
    }


    //TASK  : functional Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void evenPrint(List<Integer> list) {

        list.stream().filter(t -> t % 2 == 0).forEach(Utils::printAll);
    }

    public static void evenPrint1(List<Integer> list) {

        list.stream().filter(Utils::isEvenBoolean).forEach(Utils::printAll);
    }

    //TASK  : structural Programming ile list elemanlarinin  cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.
    public static void struPrintEven(List<Integer> list) {

        for (Integer w : list) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }
        }
    }

    //TASK :functional Programming ile list elemanlarinin 34 den kucuk cift olanlarini ayni satirda aralarina bosluk birakarak print ediniz.

    public static void print34Kucuk(List<Integer> list){
        list.stream().filter(Utils::isEvenBoolean).filter(t->t<34).forEach(Utils::printAll);

      //  list.stream().filter(t->t%2==0 && t<34).forEach(Utils::printAll);
    }

}
