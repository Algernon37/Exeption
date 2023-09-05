package Семинар3;
//  Создайте класс Сетчик, у которого есть метод add(), увеличивающий значение внутренней int переменной на 1. Сделайте так, чтобы с объектом такого типа можно было работать в блоке try-with-resources. Нужно бросить исключение, если работа с объектом типа счетчик была не в ресурсном try и/или ресурс остался открытым. Подумайте какой тип исключения подойдет луше всего.

public class Task2 {
  public static void main(String[] args) {
    try (Counter count = new Counter()) {
      count.add();
      count.close(); // чтобы вызвать ошибку
      count.printCount();
    } catch (Exception e) {
      System.err.println("error");
    }
  }

}
