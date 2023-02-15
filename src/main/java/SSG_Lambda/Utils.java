package SSG_Lambda;

public class Utils {
    public static void printSameLine(Object o){
        System.out.print(o+" ");
    }

    public static boolean isOdd(int n){
        return n%2 !=0;
    }

    public static boolean isEven(int n){
        return n%2 ==0;
    }

    public static boolean isNegative(int n){
        return n<0;
    }

    public static boolean isPositive(int n){
        return n>0;
    }

    public static int square(int n){
        return n*n;
    }

    public static int sumNum(int a,int b){
        return a+b;
    }

    public static int cube(int a){
        return a*a*a;
    }
}
