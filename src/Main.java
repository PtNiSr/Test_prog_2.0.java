import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string (string must have one symbol +, -, / or * and include ONLY Roman OR Arabic numbers)");
        String q = new String();
        q = scanner.nextLine();

        while (q.isBlank() == true) {
            System.out.println("Enter the string");
            q = scanner.nextLine();
        }
            q = calc(q);
}

    static int poiskznaka(String Txt, int n, char symbol, int j) {

        for (int i = 0; i < n; i++) {
            if (Txt.charAt(i) == symbol) {
                j++;
            }
        }
        return j;
    }

    static int keynumber(int k, int num1, int num2, int num3) {
        switch (k) {
            case 1:
                num3 = num1 + num2;
                break;
            case 2:
                num3 = num1 - num2;
                break;
            case 3:
                num3 = num1 * num2;
                break;
            case 4:
                num3 = num1 / num2;
                break;
        }
        return num3;
    }

    static double keynumberd(int k, double num1, double num2, double num3) {
        switch (k) {
            case 1:
                num3 = num1 + num2;
                break;
            case 2:
                num3 = num1 - num2;
                break;
            case 3:
                num3 = num1 * num2;
                break;
            case 4:
                num3 = num1 / num2;
                break;
        }
        return num3;
    }

    //public static String calc

    public static String arabcalc(String q, double num3, int k, int n) {
        int m = 0;
        while ((q.charAt(m) != '+') && (q.charAt(m) != '-') && (q.charAt(m) != '/') && (q.charAt(m) != '*')) {
            m++;
        }

        int num1 = Integer.parseInt(q.substring(0, m));
        int num2 = Integer.parseInt(q.substring(m + 1, n));
        double num11 = (double) num1;
        double num21 = (double) num2;

        double num31 = keynumberd(k, num1, num2, num3);
        q = Double.toString(num31);
        return q;
    }

    static String romancalc(String q, int num3, int k, int n) {

        Integer[] numbers = new Integer[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = 0;
        }

        for (int i = n - 1; i >= 0; i--) {

            switch (q.charAt(i)) {
                case 'I':
                    numbers[i] = 1;
                    break;
                case 'V':
                    numbers[i] = 5;
                    break;
                case 'X':
                    numbers[i] = 10;
                    break;
                default:
                    numbers[i] = 0;
            }
            if ((i != n - 1) && (numbers[i] < numbers[i + 1])) {
                numbers[i] = -1 * numbers[i];
            }
        }
        int num1 = 0;
        int num2 = 0;
        System.out.println();
        int i = 0;
        while (numbers[i] != 0) {
            num1 = num1 + numbers[i];
            i++;
        }

        i = n - 1;
        while (numbers[i] != 0) {
            num2 = num2 + numbers[i];
            i--;
        }

        num3 = keynumber(k, num1, num2, num3);

        String answerR = new String();

        if (num3 < 0) {
            System.out.println("Romans did not know negative value");
        } else if (num3 == 0) {
            System.out.println("It is Zero");
        } else {

            Integer[] romanum = new Integer[10];
            romanum[0] = 1;
            romanum[1] = 4;
            romanum[2] = 5;
            romanum[3] = 9;
            romanum[4] = 10;
            romanum[5] = 40;
            romanum[6] = 50;
            romanum[7] = 90;
            romanum[8] = 100;
            romanum[9] = 400;

            String[] romal = new String[10];
            romal[0] = "I";
            romal[1] = "IV";
            romal[2] = "V";
            romal[3] = "IX";
            romal[4] = "X";
            romal[5] = "XL";
            romal[6] = "L";
            romal[7] = "XC";
            romal[8] = "C";

            i = 0;
            for (i = 0; i < 10; i++) {
                if ((num3 < romanum[i]) && (num3 != 0)) {
                    int raz1 = num3 / romanum[i - 1];
                    num3 = num3 - romanum[i - 1] * raz1;
                    for (k = 0; k < raz1; k++) {
                        answerR = answerR + romal[i - 1];
                    }
                    i = 0;
                    k = 0;
                }
            }
        }
        return answerR;
    }
    public static String calc(String q) {

        int j = 0;
        int k = 0;
        int m = 0;
        int l = 0;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        double num11 = 0;
        double num21 = 0;
        double num31 = 0;

        q = q.replaceAll(" ", "");
        int n = q.length();

        j = poiskznaka(q, n, '+', j);
        if ((j == 1) && (k == 0)) {
            k = 1;
        }
        j = poiskznaka(q, n, '-', j);
        if ((j == 1) && (k == 0)) {
            k = 2;
        }
        j = poiskznaka(q, n, '*', j);
        if ((j == 1) && (k == 0)) {
            k = 3;
        }
        j = poiskznaka(q, n, '/', j);
        if ((j == 1) && (k == 0)) {
            k = 4;
        }

        if ((j != 1) || (q.charAt(0) == '+') || (q.charAt(0) == '-') || (q.charAt(0) == '*') || (q.charAt(0) == '/') || (q.charAt(n - 1) == '+') || (q.charAt(n - 1) == '-') || (q.charAt(n - 1) == '*') || (q.charAt(n - 1) == '/')) {
            System.out.println("Incorrect string, check the number of +, -< /, *. The math operator must not be at the begin or/and at the end of the string");
        }

        else {
            m = m + poiskznaka(q, n, 'I', l);
            m = m + poiskznaka(q, n, 'V', l);
            m = m + poiskznaka(q, n, 'X', l);

            if (m == 0) {
                q = arabcalc(q, num31, k, n);
                System.out.println(q);
            } else {
                q = romancalc(q, num3, k, n);
                System.out.println(q);
            }
        }
        return q;
    }
}

