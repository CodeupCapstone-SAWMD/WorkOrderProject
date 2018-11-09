package SandBox;

public class Recursion_2 {

    public static int recursion2 (int num) {
        if (num == 1) {
            System.out.println(num);
        } else {
            recursion2( num - 1);
            System.out.println(num);
        }
        return 0;
    }

    public static void main(String[] args) {
        recursion2(7);
    }
}
