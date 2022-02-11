package cool.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Calculate {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            int count = 0;
            List<Integer> intList = new ArrayList<>();
            System.out.println("Input:");
            do {
                try {
                    int integerValue = Integer.parseInt(scanner.nextLine());
                    intList.add(integerValue);

                    if (intList.size() == 9) {
                        System.out.println("Output:");
                        add(intList.subList(0, 2));
                        add(intList.subList(0, 4));
                        add(intList.subList(0, 6));
                        add(intList.subList(0, 8));

                        intList.clear();
                        System.out.println("Input:");
                    }
                } catch (Exception e) {
                    System.out.println("Error, allow entering integer only");
                }
            } while (true);
        } finally {
            scanner.close();
        }
    }

    public static void add(List<Integer> intList) {
        if (intList == null && intList.size() == 0) {
            System.out.println("Error, intList cannot be null or empty");
            return;
        }

        int lineNum = intList.size() - 1;
        StringBuilder sb = new StringBuilder("Line#");
        sb.append(lineNum);
        sb.append(" ");

        for (int iv : intList) {
            sb.append(iv);
            sb.append("+");
        }
        int sum = intList.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sb.substring(0, sb.length() - 1) + "=" + sum);
    }
}
