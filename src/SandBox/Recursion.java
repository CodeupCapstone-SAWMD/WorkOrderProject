package SandBox;

public class Recursion {
    public static int countDown(int num){
        if (num == 0){
            System.out.println("Blast Off!");
            return 0;
        }else {
            System.out.println(num);
            return countDown(num-1);
        }
    }

    public static void main(String[] args) {
        countDown(10);
    }

}
