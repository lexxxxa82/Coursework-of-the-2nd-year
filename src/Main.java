import exceptions.IncorrectArgumentException;
import exceptions.TaskNotFoundException;
import task.Periodicity;
import task.TaskService;
import task.InputUtils;

import java.util.Scanner;

public class Main {
    private static final TaskService taskService = new TaskService();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.println("Выберите команду: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            add();
                            break;
                        case 2:
                            remove();
                            break;
                        case 3:
                            listTaskMap();
                            break;
                        case 4:
                            findTask();
                            break;
                        case 0:
                            break label;
                        default:
                            System.out.println(" Ошибка пункта меню");
                            System.out.println(" Выберите пункт меню из списка!");
                    }
                } else {
                    scanner.next();
                }
            }
            System.out.println("досвидания");
        } catch (TaskNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IncorrectArgumentException e) {
            System.out.println(e.getArgument());
        }
    }

    private static void printMenu() {
        System.out.println("Доступные команды: \n 1. Добавить задачу \n 2. Удалить задачу " +
                " \n 3. Показать список задач \n 4. Найти задачу \n 0. Выход");
    }

    private static void add() throws IncorrectArgumentException {
        System.out.println(" Выберите периодичность задачи: ");
        for (Periodicity Periodicity : Periodicity.values()) {
            System.out.println(Periodicity);
        }
        var strPeriodicity = InputUtils.askString("Ваш выбор").toUpperCase();
        var periodicity = Periodicity.valueOf(strPeriodicity);
        taskService.add(periodicity);
    }

    private static void remove() throws TaskNotFoundException {
        int id = InputUtils.askInt("Введите идентификатор задачи, которую вы хотите удалить");
        taskService.remove(id);
    }


    private static void listTaskMap() {
        taskService.listTaskMap();
    }


    private static void findTask() {
        var substr = InputUtils.askString("Введите строку, чтобы найти");
        taskService.findTask(substr);
    }
}

