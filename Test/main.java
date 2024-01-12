package Test;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Введите выражение (или 'exit' для завершения): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Калькулятор завершен.");
                break;
            }

            String result = calc(input);
            System.out.println("Результат: " + result);
        }

        scanner.close();
    }

    public static String calc(String input) {
        try {
            // Разделение входной строки на операнды и оператор
            String[] tokens = input.split("\\s+");
            if (tokens.length != 3) {
                throw new IllegalArgumentException("Некорректный формат выражения");
            }

            // Преобразование строк в целые числа
            int operand1 = Integer.parseInt(tokens[0]);
            String operator = tokens[1];
            int operand2 = Integer.parseInt(tokens[2]);

            // Проверка допустимости чисел
            if (operand1 < 1 || operand1 > 10 || operand2 < 1 || operand2 > 10) {
                throw new IllegalArgumentException("Числа должны быть от 1 до 10 включительно");
            }

            // Выполнение операции в зависимости от оператора
            int result;
            switch (operator) {
                case "+":
                    result = operand1 + operand2;
                    break;
                case "-":
                    result = operand1 - operand2;
                    break;
                case "*":
                    result = operand1 * operand2;
                    break;
                case "/":
                    if (operand2 == 0) {
                        throw new ArithmeticException("Деление на ноль недопустимо");
                    }
                    result = operand1 / operand2;
                    break;
                default:
                    throw new IllegalArgumentException("Неподдерживаемый оператор: " + operator);
            }

            // Возвращение результата в виде строки
            return String.valueOf(result);

        } catch (Exception e) {
            // Обработка исключений и возвращение сообщения об ошибке
            return "Ошибка: " + e.getMessage();
        }
    }
}