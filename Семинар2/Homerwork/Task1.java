import java.util.Scanner;



public class Task1 {
    public static void main(String[] args) {
        float userInput = getValidFloatInput();
        System.out.println("Вы ввели: " + userInput);
    }

    public static float getValidFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float number = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите дробное число: ");
                String input = scanner.nextLine();
                number = Float.parseFloat(input);
                validInput = true; 
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите дробное число.");
            }
        }

        return number;
    }
}
