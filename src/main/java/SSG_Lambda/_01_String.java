package SSG_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _01_String {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(Arrays.asList("Software", "Test", "Life", "Cycle", "STLC", "software", "development", "SRS", "RTM", "Lambda"));

        // 1. structured prog.
        for (String w : list) {
            System.out.println(w + " ");
        }
        System.out.println();

        // 2. functional prog.
        list.forEach(t -> System.out.println(t + " "));

        // list words with first letters s and l
        System.out.println(startWithSL(list));

        // add * to all beginning and ending of all String
        addAstariksString(list);

        // alfabetik olarak list olarak sirala
        alfabetik(list);

        // all l delete
        deleteL(list);

        // if string contains e ,crate new list with string
        containsEore(list);

        //length 4 and 6 haric list
        exceptforLength4or6(list);
    }

    public static void exceptforLength4or6(List<String> list) {
        System.out.println("--------");
        list.stream().filter(t -> t.length() != 4 && t.length() != 6).collect(Collectors.toList()).forEach(Utils::printSameLine);
    }

    public static List<String> startWithSL(List<String> list) {
        //   return list.stream().filter(t->t.startsWith("s") || t.startsWith("L")).collect(Collectors.toList());
        return list.stream().filter(t -> t.substring(0, 1).equalsIgnoreCase("s") || t.substring(0, 1).equalsIgnoreCase("l")).collect(Collectors.toList());
    }

    public static void addAstariksString(List<String> list) {

        list.stream().map(t -> "*" + t + "*").forEach(Utils::printSameLine);
    }

    public static void alfabetik(List<String> list) {
        System.out.println("-----Alfabetik-----");
        list.stream().sorted().collect(Collectors.toList()).forEach(Utils::printSameLine);
    }

    public static void deleteL(List<String> list) {
        System.out.println("---delete l----");
        list.stream().map(t -> t.replaceAll("l", "")).forEach(Utils::printSameLine);
    }

    public static void containsEore(List<String> list) {

        System.out.println("----e or E----");
        list.stream().filter(t -> t.contains("e") || t.contains("E")).collect(Collectors.toList()).forEach(Utils::printSameLine);
        //list.stream().filter(t->t.toLowerCase().contains("e")).collect(Collectors.toList()).forEach(Utils::printSameLine);
    }


}
