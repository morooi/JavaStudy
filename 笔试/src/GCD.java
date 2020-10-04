import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            int xiaotou_a = map.getOrDefault(a, 0), xiaotou_b = map.getOrDefault(b, 0);
            if (xiaotou_a >= k) {
                map.put(a, -1);
            } else if (xiaotou_a >= 0) {
                map.put(a, xiaotou_a + 1);
            }
            if (xiaotou_b >= k) {
                map.put(b, -1);
            } else if (xiaotou_b >= 0) {
                map.put(b, xiaotou_b + 1);
            }

            for (int j = i + 1; j < n; j++) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i + 1);
                list.add(j + 1);
                lists.add(list);
            }
        }
        int count = 0;
        for (ArrayList<Integer> list : lists) {
            System.out.println(list);
            int i = map.get(list.get(0)) + map.get(list.get(1));
            if (i >= k) {
                count++;
            }
        }
        System.out.println(count);
    }
}
