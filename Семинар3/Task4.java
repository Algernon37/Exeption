package Семинар3;

// Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
// Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
// В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException и MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).

public class Task4 {
  public static void main(String[] args) {
    String[][] array = { { "1", "2", "3", "4" },
        { "1", "2", "3", "4" },
        { "1", "2", "3", "4" },
        { "1", "2", "3", "4" } };
    String[][] array1 = { { "1", "2", "3", "4" },
        { "1", "2", "3", "4" },
        { "1", "2", "3", "4" },
        { "1", "2", "3", "4" },
        { "1", "2", "3", "4" } };
    String[][] array2 = { { "1", "2", "3", "4" },
        { "1", "2", "3", "4" },
        { "1", "2", "3", "4" },
        { "1", "2", "ihhi", "4" } };

    try {
      System.out.println(summator2000(array));
      // System.out.println(summator2000(array1));
      System.out.println(summator2000(array2));
    } catch (MyArraySizeException | MyArrayDataException e) {
      System.err.println(e);
    }

  }

  public static int summator2000(String[][] matrix) {
    if (matrix.length != 4 || matrix.length != matrix[0].length)
      throw new MyArrayDataException("this matrix is " + matrix.length + " x " + matrix[0].length + " not 4x4");
    int sum = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length; j++) {
        try {
          sum += Integer.parseInt(matrix[i][j]);
        } catch (NumberFormatException e) {
          throw new MyArrayDataException(String.format("elem %d, %d is wrong: %s", i, j, matrix[i][j]));
        }
      }

    }
    return sum;
  }

}
