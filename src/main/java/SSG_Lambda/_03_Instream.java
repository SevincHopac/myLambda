package SSG_Lambda;

import java.util.stream.IntStream;

public class _03_Instream {

    public static void main(String[] args) {

        // 1-30 (except 30) print
        printNumbers(30);

        // 20-50 print 50 dahil
        printNumbersDahil(20,50);

        //the sum of the numbers between the two desired values
        sumOfNumbers(1,6);

        // average of sum between two number
        avgOfSum(3,6);

        // how many numbers are there between two numbers divisible by 8
        numbersOfBetweenTwoNumbersBy8(1,80);

        //sum of numbers are there between two numbers divisible by 8
        sumNumbersOfBetweenTwoNumbersBy8(1,29);

        // multiplication of odd numbers between 7 and 15
        multiOfBetween(2,6);

        // 21 den bas 7 nin katlarinin tek olanlarinin ilk 10 say print
        multiSeven(10);

    }

    public static void multiSeven(int a){
        IntStream.iterate(21,t->t+7).filter(t->t%2==1).limit(10).forEach(Utils::printSameLine);
    }

    public static void multiOfBetween(int a, int b){
        System.out.println(IntStream.rangeClosed(a, b).filter(t -> t % 2 == 1).reduce(1, (t, w) -> t*w));
    }


    public static void sumNumbersOfBetweenTwoNumbersBy8(int a, int b){
        System.out.println();
        System.out.println(IntStream.rangeClosed(a, b).filter(t -> t % 8 == 0).sum());
    }



    public static void numbersOfBetweenTwoNumbersBy8(int a, int b){
        System.out.println(IntStream.rangeClosed(a, b).filter(t -> t % 8 == 0).count());
        IntStream.rangeClosed(a, b).filter(t -> t % 8 == 0).forEach(Utils::printSameLine);
    }

    public static void avgOfSum(int a, int b){
        System.out.println(IntStream.rangeClosed(a, b).average());
    }

    public static void sumOfNumbers(int a, int b){
        System.out.println();
        System.out.println(IntStream.rangeClosed(a, b).sum());
    }


    public static void printNumbersDahil(int number,int endNumber) {
        System.out.println();
        IntStream.rangeClosed(number, endNumber).forEach(Utils::printSameLine);
    }

    public static void printNumbers(int number) {
        IntStream.range(1, number).forEach(Utils::printSameLine);
    }
}
