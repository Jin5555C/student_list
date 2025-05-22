package org.example;

import static org.example.InputUtil.readInt;
import static org.example.InputUtil.readValidScore;
import static org.example.InputUtil.validContainsName;
import static org.example.InputUtil.validNotContainsName;

import java.util.Scanner;

public class StudentList {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    StudentManager manager = new StudentManager();

    while (true) {
      System.out.println("1.学生を追加");
      System.out.println("2.学生を削除");
      System.out.println("3.点数を更新");
      System.out.println("4.平均点を計算");
      System.out.println("5.全学生の情報を表示");
      System.out.println("6.終了");

      int choice = readInt(scanner, "１～６の中からひとつ選択してください ");

      switch (choice) {
        case 1 -> {
          String name = validContainsName(
              manager.getAllStudents().stream().map(Student::getName).toList(),
              scanner, "名前を入力してください。"
          );
          int score = readValidScore(scanner, name + " の点数を入力してください");
          manager.addStudent(name, score);
        }

        case 2 -> {
          if (checkEmptyStudents(manager)) {
            break;
          }
          displayStudents(manager);
          String name = validNotContainsName(
              manager.getAllStudents().stream().map(Student::getName).toList(),
              scanner, "削除する学生の名前を入力してください。"
          );
          manager.removeStudent(name);
          System.out.println(name + " を削除しました。");
        }

        case 3 -> {
          if (checkEmptyStudents(manager)) {
            break;
          }
          displayStudents(manager);
          String name = validNotContainsName(
              manager.getAllStudents().stream().map(Student::getName).toList(),
              scanner, "点数を更新する学生の名前を入力してください: "
          );
          int newScore = readValidScore(scanner, "新しい点数を入力してください: ");
          manager.updateScore(name, newScore);
          System.out.println(name + " の点数を更新しました。");
        }

        case 4 -> {
          if (checkEmptyStudents(manager)) {
            break;
          }
          double avg = manager.getAverageScore();
          System.out.printf("平均点: %.1f 点%n", avg);
        }

        case 5 -> {
          if (checkEmptyStudents(manager)) {
            break;
          }
          displayStudents(manager);
        }

        case 6 -> {
          System.out.println("プログラムを終了します。");
          scanner.close();
          return;
        }

        default -> System.out.println("無効な選択肢です。1～6の数字を入力してください。");
      }
    }
  }

  private static boolean checkEmptyStudents(StudentManager manager) {
    if (manager.isEmpty()) {
      System.out.println("学生データがありません。１で学生を追加してください");
      return true;
    }
    return false;
  }

  private static void displayStudents(StudentManager manager) {
    System.out.println("学生一覧:");
    for (Student s : manager.getAllStudents()) {
      System.out.println(" - " + s.getName() + ": " + s.getScore() + "点");
    }
  }
}
