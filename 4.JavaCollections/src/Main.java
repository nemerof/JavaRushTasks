import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[2];
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        Main main = new Main();
        System.out.println(main.multiplicative(input));
    }

    public int additive(int number) {
        String strNum = String.valueOf(number);
        if (strNum.length() == 1) {
            return number;
        } else {
            int sum = 0;
            char[] array = strNum.toCharArray();
            for (char c : array) {
                sum += Integer.parseInt(String.valueOf(c));
            }
            return additive(sum);
        }
    }

    public int multiplicative(int number) {
        String strNum = String.valueOf(number);
        if (strNum.length() == 1) {
            return number;
        } else {
            int sum = 1;
            char[] array = strNum.toCharArray();
            for (char c : array) {
                sum *= Integer.parseInt(String.valueOf(c));
            }
            return additive(sum);
        }
    }
}
