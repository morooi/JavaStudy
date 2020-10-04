import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] ss = sc.nextLine().split(" ");
        BigDecimal n = new BigDecimal(ss[0]), r = new BigDecimal(ss[2]);
        int m = Integer.parseInt(ss[1]);
        BigDecimal x = new BigDecimal(0);
        BigDecimal nn = n.multiply(BigDecimal.valueOf(4));
        for (int i = 0; i < m; i++) {
            x = x.add(r);
            BigDecimal yushu = x.divideAndRemainder(nn)[1];
            BigDecimal[] yiquan = yushu.divideAndRemainder(n);
            if (yiquan[0].equals(BigDecimal.valueOf(0))) {
                System.out.format("%.2f %.2f\n", yiquan[1], 0.00);
            } else if (yiquan[0].equals(BigDecimal.valueOf(1))) {
                System.out.format("%.2f %.2f\n", n, yiquan[1]);
            } else if (yiquan[0].equals(BigDecimal.valueOf(2))) {
                System.out.format("%.2f %.2f\n", n.subtract(yiquan[1]), n);
            } else if (yiquan[0].equals(BigDecimal.valueOf(3))) {
                System.out.format("%.2f %.2f\n", 0.00, n.subtract(yiquan[1]));
            }
        }

    }


    @Test
    public void test() {
        BigDecimal n = new BigDecimal("7495417.6435616808"), r = new BigDecimal("6125201.7312234128");
        System.out.println(Arrays.toString(n.multiply(BigDecimal.valueOf(4)).divideAndRemainder(r)));

    }
}
