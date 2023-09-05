package Семинар3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task3 {

  public static void main(String[] args) {
    try {

      // zeroDivider();
      nullArray();
      tryFile();
    } catch (ZeroDivException e) {
      System.err.println("aha " + e);
    } catch (EmptyArrayElemException e) {
      System.err.println("ahajha " + e);
    } catch (CantFindExeption e) {
      System.err.println("ohoho " + e);
    }
  }

  // Создайте класс исключения,который будет выбрасываться при делении на 0.
  // Исключение должно отображать понятное дляпользователя сообщение об ошибке

  public static void zeroDivider() throws ZeroDivException {
    try {
      int a = 1 / 0;
    } catch (ArithmeticException e) {
      throw new ZeroDivException("cant divide by zero!");
    }
  }

  // Создайте класс исключений, которое будет возникать при обращении к пустому
  // элементу в массиве ссылочного типа.
  // Исключение должно отображать понятное дляпользователя сообщение об ошибке
  public static void nullArray() throws EmptyArrayElemException {
    Integer[] arr = { 1, 2, null };
    try {
      for (int i = 0; i < arr.length; i++) {
        System.out.println(arr[i]);
        arr[i]++;
      }
    } catch (NullPointerException e) {
      throw new EmptyArrayElemException("null element not valid");
    }
  }

  // Создайте класс исключения, которое будет возникать при попытке открыть
  // несуществующий файл.
  // Исключение должно отображать понятное дляпользователя сообщение об ошибке

  public static void tryFile() throws CantFindExeption {
    try (FileReader fr = new FileReader("123")) {
      fr.read();
    } catch (FileNotFoundException e) {
      throw new CantFindExeption("there is no such file");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
