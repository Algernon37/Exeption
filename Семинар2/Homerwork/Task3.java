public static void main(String[] args) {
    try {
        int a = 90;
        int b = 0; // Изменено значение b на 0 для генерации ArithmeticException
        System.out.println(a / b);
        printSum(23, 234);
        int[] abc = {1, 2};
        abc[3] = 9;
    } catch (NullPointerException ex) {
        System.out.println("Указатель не может указывать на null!");
    } catch (IndexOutOfBoundsException ex) {
        System.out.println("Массив выходит за пределы своего размера!");
    } catch (ArithmeticException ex) {
        System.out.println("Попытка деления на ноль!");
    } catch (Throwable ex) {
        System.out.println("Что-то пошло не так...");
    }
}

public static void printSum(Integer a, Integer b) {
    System.out.println(a + b);
}
