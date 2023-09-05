package Семинар3;

/**
 * Seminar3
 */
public class Task1 {

  /*
   * Задание №1
   * Создайте метод doSomething(), который может быть источником одного из
   * типов checked exceptions (тело самогометода прописывать не обязательно).
   * Вызовите этот метод из main и обработайте в нем исключение, которое
   * вызвалметод doSomething()
   */
  public static void main(String[] args) {
    try {
      doSomething();
    } catch (Exception e) {
      System.err.println("catch some exception");
    }

  }

  public static void doSomething() throws Exception {
    throw new Exception("something wrong");
  }
}