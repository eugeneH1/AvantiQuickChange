import functionality.text.StringFunctions;

public class Main {
    public static void main(String[] args) {
        String test = "THis iS not in tItle Case";
        String test2 = "wHat";

        String title = StringFunctions.toTitle(test);
        System.out.println(title);
        System.out.println("tHis".toLowerCase());
        System.out.println(StringFunctions.toSen(test));

    }

}