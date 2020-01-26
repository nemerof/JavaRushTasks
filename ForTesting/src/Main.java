public class Main {
    public static void main(String[] args) {
        System.out.println(method(25));
    }

    public static boolean method(int n) {
        double sq = Math.sqrt(n);
        boolean bool = (sq % 1 == 0);
        return bool;
    }
}
