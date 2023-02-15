package lambda;

import java.util.stream.IntStream;

public class P05{

    public static void main(String[] args) {

        sum(5);
        System.out.println();
        System.out.println(sum1(5));
        System.out.println(evenSum(5));
        System.out.println(evenPozSum(5));
        System.out.println(oddPozSum(5));
        ikininKuvvetiIlkX(5);
        System.out.println();
        istenilenSayiKuvvetiIlkX(3,2);
        System.out.println();
        faktoriyel(5);


    }

    //TASK 01 --> Structured Programming ve Functional Programming ile
    // 1'den x'e kadar (x dahil) tamsayilari toplayan bir program create ediniz.

    public static void  sum(int x){
        int top=0;

        for (int i = 0; i <= x; i++) {
            top+=i;
        }
        System.out.println(top);
    }


    public static int sum1(int a){

        return IntStream.range(1,a+1).sum();
    }


    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

    public static int evenSum(int x) {

        return IntStream.range(1, x + 1).filter(Utils::isEvenBoolean).sum();
    }

    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

    public static int evenPozSum(int x) {

        return IntStream.iterate(2,t->t+2).limit(x).sum();
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.

    public static int oddPozSum(int x) {

        return IntStream.iterate(1,t->t+2).limit(x).sum();
    }

    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.

    public static void ikininKuvvetiIlkX(int x){

        IntStream.iterate(2,t->t*2).limit(x).forEach(Utils::printAll);
    }


    //TASK 06 --> Istenilen bir sayinin ilk x pozitif kuvvetini ekrana yazdiran programi  create ediniz.

    public static void istenilenSayiKuvvetiIlkX(int iste, int x){

        IntStream.iterate(iste,t->t*iste).limit(x).forEach(Utils::printAll);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz. // 5*4*3*2*1= 5!

    public static void faktoriyel(int a){

     //   System.out.println(IntStream.rangeClosed(1, a).reduce(Math::multiplyExact));

        System.out.println(IntStream.rangeClosed(1, a).reduce(1, (x, y) -> x * y));
    }
}
