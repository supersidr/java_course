import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> menuList = new ArrayList<>();
        List<String> taskList = new ArrayList<>();
        menuList.add("Выход из программы");
        menuList.add("Добавить дело");
        menuList.add("Показать дела");
        menuList.add("Удалить дело по номеру");
        menuList.add("Удалить дело по названию");

        String inputMessage = "Введите название задачи: ";
        String taskMessage = "Ваш список дел: ";

        while (true) {
            printList(menuList, "Выберите операцию: ", 0);
            System.out.print("Ваш выбор: ");
            String input = scanner.nextLine();
            if ("0".equals(input)) {
                break;
            }

            if ("1".equals(input)) {
                System.out.print(inputMessage);
                String inputTask = scanner.nextLine();
                taskList.add(inputTask);
                System.out.println("Добавлено!");
                printList(taskList, taskMessage, 1);
            }

            if ("2".equals(input)) {
                printList(taskList, taskMessage, 1);
            }

            if ("3".equals(input)) {
                System.out.print("Введите номер для удаления: ");
                String inputTask = scanner.nextLine();
                if (taskList.size() >= Integer.parseInt(inputTask)) {
                    taskList.remove(Integer.parseInt(inputTask) - 1);
                    System.out.println("Удалено!");
                } else {
                    System.out.println("Такой задачи в списке дела нет!");
                }
                printList(taskList, inputMessage, 1);
            }

            if ("4".equals(input)) {
                System.out.print("Введите задачу для удаления: ");
                String inputTask = scanner.nextLine();
                if (taskList.remove(inputTask)) {
                    System.out.println("Удалено!");
                } else {
                    System.out.println("Такой задачи в списке дела нет!");
                }
                printList(taskList, inputMessage, 1);
            }
        }
    }

    public static void printList(List<String> list, String message, int startIndex) {
        System.out.println(message);
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + startIndex) + ". " + list.get(i));
        }
        System.out.println();
    }
}
