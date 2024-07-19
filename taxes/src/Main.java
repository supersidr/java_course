import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Создаем scanner - объект, который будет считывать из стандартного потока ввода/вывода (console)
        Scanner scanner = new Scanner(System.in);

        int earnings = 0;    // доходы
        int spendings = 0;   // расходы

        //Цикл будет работать, пока пользователь не введет `end`
        while (true) {
            // Выводим информацию о возможных операциях пользователю
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStrEarn = scanner.nextLine(); // Не используйте тут nextInt (!)
                    int moneyEarn = Integer.parseInt(moneyStrEarn);
                    earnings += moneyEarn;
                    break;
                case 2:
                    // действия при выборе второй операции
                    System.out.println("Введите сумму расхода:");
                    String moneyStrSpend = scanner.nextLine(); // Не используйте тут nextInt (!)
                    int moneySpend = Integer.parseInt(moneyStrSpend);
                    spendings += moneySpend;
                    break;
                case 3:
                    // действия при выборе третьей операции
                    int usnEarnings = taxEarnings(earnings);
                    int usnEarningsMinusSpendings = taxEarningsMinusSpendings(earnings, spendings);

                    int savings = getSavings(usnEarnings, usnEarningsMinusSpendings);
                    if (usnEarnings < usnEarningsMinusSpendings) {
                        System.out.println("Мы советуем вам УСН доходы");
                        System.out.println("Ваш налог составит: " + usnEarnings + " рублей");
                        System.out.println("Налог на другой системе: " + usnEarningsMinusSpendings + " рублей");
                    } else {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + usnEarningsMinusSpendings + " рублей");
                        System.out.println("Налог на другой системе: " + usnEarnings + " рублей");
                    }

                    System.out.println("Экономия: " + savings + " рублей");
                    break;
                default:
                    System.out.println("Такой операции нет");
            }

        }
        System.out.println("Программа завершена!");
    }

    private static int getSavings(int usnEarnings, int usnEarningsMinusSpendings) {
        int savings = usnEarnings - usnEarningsMinusSpendings;
        return Math.abs(savings);
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }


}
