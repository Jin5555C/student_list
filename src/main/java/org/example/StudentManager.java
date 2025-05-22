package org.example;

import java.util.ArrayList;
import java.util.List;


public class StudentManager {

  private final List<Student> students = new ArrayList<>();

  public void addStudent(String name, int score) {
    students.add(new Student(name, score));
  }

  public void removeStudent(String name) {
    students.removeIf(s -> s.getName().equals(name));
  }

  public void updateScore(String name, int newScore) {
    for (Student s : students) {
      if (s.getName().equals(name)) {
        s.setScore(newScore);
        return;
      }
    }
  }

  public double getAverageScore() {
    return students.stream()
        .mapToInt(Student::getScore)
        .average()
        .orElse(0);
  }

  public List<Student> getAllStudents() {
    return students;
  }

  public boolean isEmpty() {
    return students.isEmpty();
  }
  

}
