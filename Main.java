import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение (например, '3 + 4'): ");
        String input = scanner.nextLine();

        try {
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    static String calc(String input) throws Exception {
        String[] parts = input.trim().split(" ");

        if (parts.length != 3) {
            throw new Exception("Ввод должен содержать два числа и одну операцию.");
        }

        int a = parseNumber(parts[0]);
        String operation = parts[1];
        int b = parseNumber(parts[2]);

        switch (operation) {
            case "+":
                return Integer.toString(a + b);
            case "-":
                return Integer.toString(a - b);
            case "*":
                return Integer.toString(a * b);
            case "/":
                if (b == 0) {
                    throw new Exception("Деление на ноль невозможно.");
                }
                return Integer.toString(a / b); // Целочисленное деление
            default:
                throw new Exception("Недопустимая операция. Используйте +, -, * или /.");
        }
    }

    static int parseNumber(String numberStr) throws Exception {
        try {
            int number = Integer.parseInt(numberStr);
            if (number < 1 || number > 10) {
                throw new Exception("Числа должны быть от 1 до 10 включительно.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Числа должны быть целыми числами.");
        }
    }
}