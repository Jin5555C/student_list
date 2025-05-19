package org.example;

import java.util.List;
import java.util.Scanner;

public class InputUtil {



    public static int readInt(Scanner scanner, String prompt) {
        int value;
        while (true) {
            System.out.print(prompt);
            try {
                value = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("無効な入力です。整数を入力してください。");
                scanner.nextLine();
            }
        }
        return value;
    }

    public static String validContainsName (List<String> names, Scanner scanner, String prompt) {
        String addName;
        while (true) {
            System.out.print(prompt);
            addName = scanner.nextLine();

            if (names.contains(addName)) {
                System.out.println("その名前はすでに登録されています。別の名前を入力してください。");

            } else {
                break;
            }
        }
        return addName;
    }

    public static String validNotContainsName (List<String> names, Scanner scanner, String prompt) {
        String Name;
        while (true) {
            System.out.print(prompt);
            Name = scanner.nextLine();

            if (!names.contains(Name)) {
                System.out.println("その名前は登録されていません。別の名前を入力してください。");

            } else {
                break;
            }
        }
        return Name;
    }

    public static int readValidScore(Scanner scanner,String prompt) {
        int score;
        while (true) {
            score = readInt(scanner, prompt);
            if (score >= 0 && score <= 100) {
                break;
            } else {
                System.out.println("0〜100の間で入力してください。");
            }
        }
        return score;
    }

}
