package Семинар3.Homework;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные в формате: Фамилия Имя Отчество ДатаРождения НомерТелефона Пол");
            String input = scanner.nextLine();

            String[] userData = input.split(" ");
            if (userData.length != 6) {
                System.err.println("Ошибка: Введите все данные в правильном формате.");
                return;
            }

            String lastName = userData[0];
            String firstName = userData[1];
            String middleName = userData[2];
            String birthDate = userData[3];
            String phoneNumber = userData[4];
            String gender = userData[5];

            if (!isValidDate(birthDate) || !isValidPhoneNumber(phoneNumber) || !isValidGender(gender)) {
                System.err.println("Ошибка: Неверный формат данных.");
                return;
            }

            String fileName = lastName + ".txt";
            String dataToWrite = lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(dataToWrite);
                writer.newLine();
                System.out.println("Данные успешно записаны в файл: " + fileName);
            } catch (IOException e) {
                System.err.println("Ошибка при записи данных в файл: " + e.getMessage());
            }

        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static boolean isValidDate(String date) {
        String regex = "\\d{2}.\\d{2}.\\d{4}";
        return date.matches(regex);
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Ваша проверка формата номера телефона здесь
        String regex = "\\d+";
        return phoneNumber.matches(regex) && !phoneNumber.isEmpty();
    }

    public static boolean isValidGender(String gender) {
        return gender.equals("f") || gender.equals("m");
    }
}
