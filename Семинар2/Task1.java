// Запишите в файл следующие строки:
// Анна=4
// Елена=5
// Марина=6
// Владимир=?
// Константин=?
// Иван=4
// Реализуйте метод, который считывает данные из файла и сохраняет в двумерный
// массив (либо HashMap, если студенты с ним знакомы). В отдельном методе нужно
// будет пройти по структуре данных, если сохранено значение ?, заменить его на
// соответствующее число.Если на каком-то месте встречается символ, отличный от
// числа или ?, бросить подходящее исключение.Записать в тот же файл данные с
// замененными символами ?.


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task1 {

    public static void main(String[] args) {
        String path;
        if (args.length != 1) {
            path = "C:\\Users\\иван\\Desktop\\дз по GB\\JS.exceptions\\Семинар2\\file.txt";
            return;
        }

        path = args[0];

        try {
            List<String[]> data = readFile(path);
            writeFile(cacheLetter(data), path);
        } catch (IOException e) {
            System.err.println("Произошла ошибка при работе с файлом: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<String[]> readFile(String path) throws IOException {
        List<String[]> result = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = file.readLine()) != null) {
                String[] temp = line.split("=");
                if (temp.length != 2 || (!temp[1].equals("?") && !isNumeric(temp[1]))) {
                    throw new RuntimeException("Некорректные данные в строке: " + line);
                }
                result.add(temp);
            }
        }
        return result;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static List<String[]> cacheLetter(List<String[]> data) {
        for (String[] strings : data) {
            if (strings[1].equals("?")) {
                strings[1] = String.valueOf(strings[0].length());
            }
        }
        return data;
    }

    public static void writeFile(List<String[]> data, String path) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String[] strings : data) {
                bw.write(strings[0] + "=" + strings[1]);
                bw.newLine();
            }
        }
    }
    
}
