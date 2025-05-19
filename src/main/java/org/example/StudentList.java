package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

import static org.example.InputUtil.*;


public class StudentList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();

        while (true){
            System.out.println("1.学生を追加");
            System.out.println("2.学生を削除");
            System.out.println("3.点数を更新");
            System.out.println("4.平均点を計算");
            System.out.println("5.全学生の情報を表示");
            System.out.println("6.終了");

            int choice;
            choice = readInt(scanner, "１～６の中からひとつ選択してください ");
            switch (choice){
                case 1: // 学生を追加
                    String addName = validContainsName(names,scanner,"名前を入力してください。");
                    int addScore = readValidScore(scanner,addName+ " の点数を入力してください");
                    names.add(addName);
                    scores.add(addScore);
                    break;


                case 2: // 学生を削除
                    if (checkEmptyStudents(names)) {
                        break;
                    }
                    System.out.println("現在の学生一覧:");
                    IntStream.range(0, names.size()).mapToObj(i -> " - " + names.get(i) + ": " + scores.get(i) + "点").forEach(System.out::println);

                    String deleteName = validNotContainsName(names,scanner,"削除する学生の名前を入力してください。");
                    int deleteIndex = names.indexOf(deleteName);
                    names.remove(deleteIndex);
                    scores.remove(deleteIndex);
                    System.out.println(deleteName + " を削除しました。");
                    break;

                case 3: // 点数を更新
                    if (checkEmptyStudents(names)) {
                        break;
                    }
                    System.out.println("現在の学生一覧:");
                    IntStream.range(0, names.size()).mapToObj(i -> " - " + names.get(i) + ": " + scores.get(i) + "点").forEach(System.out::println);

                    String updateName = validNotContainsName(names, scanner, "点数を更新する学生の名前を入力してください: ");
                    int updateIndex = names.indexOf(updateName);
                    int updateScore = readValidScore(scanner, "新しい点数を入力してください: ");
                    scores.set(updateIndex, updateScore);
                    System.out.println(updateName + " の点数を更新しました。");
                    break;

                case 4: // 平均点を計算
                    if (checkEmptyStudents(names)) {
                        break;
                    }
                    double average = scores.stream()
                            .mapToInt(Integer::intValue)
                            .average()
                            .orElse(0);
                    System.out.printf("平均点: %.1f 点%n", average);
                    break;


                case 5: // 全学生の情報を表示
                    if (checkEmptyStudents(names)) {
                        break;
                    }
                    System.out.println("学生一覧:");
                    IntStream.range(0, names.size()).mapToObj(i -> " - " + names.get(i) + ": " + scores.get(i) + "点").forEach(System.out::println);
                    break;

                case 6: // 終了
                    System.out.println("プログラムを終了します。");
                    scanner.close();
                    return;

                default:
                    System.out.println("無効な選択肢です。1～6の数字を入力してください。");
                    break;
            }
        }

    }

    private static boolean checkEmptyStudents(List<String> names) {
        if (names.isEmpty()) {
            System.out.println("学生データがありません。１で学生を追加してください");
            System.out.println();
            return true;
        }
        return false;
    }


}