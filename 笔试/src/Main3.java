import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] res = new int[n + 2];
        res[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n + 2; i++) {
            int n2 = 2 * res[a], n3 = 3 * res[b], n7 = 7 * res[c];
            res[i] = Math.min(n2, Math.min(n3, n7));
            if (n2 == res[i]) a++;
            if (n3 == res[i]) b++;
            if (n7 == res[i]) c++;
        }
        System.out.println(res[n + 1]);
    }
}
