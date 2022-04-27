package Main;

public class Test {
    public static void test(int it){
        if (it <= 0) {
            throw new IllegalArgumentException("Expelled students count should be greater than 0");
        } else {
            System.out.println("nice!");
        }
    }
}
