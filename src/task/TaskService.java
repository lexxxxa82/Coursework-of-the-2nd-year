package task;

import exceptions.IncorrectArgumentException;
import java.util.*;

public class TaskService {
    private final Map<Integer, Task> taskMap = new HashMap<>();
    private final Set<Task> removedTasks = new HashSet<>();

    public void add(Periodicity taskPeriodicity) throws IncorrectArgumentException {
        var tp = taskPeriodicity.createTask();
        tp.askData();
        taskMap.putIfAbsent(tp.getId(), tp);
        System.out.println("Задача создана: " + tp);
    }

    public void remove(int id) {
        Task task = taskMap.get(id);
        removedTasks.add(task);
        taskMap.values().removeIf(t -> t.getId() == id);
        System.out.printf("Задача '%s' удалена  \n", task);
    }


    public void listTaskMap() {
        System.out.println("Актуальный список задач: ");
        for (Map.Entry<Integer, Task> taskMap : taskMap.entrySet()) {
            System.out.println(taskMap.getKey() + " " + taskMap.getValue());
        }
    }

    public void findTask(String substr) {
        var tmp = substr.toLowerCase();
        taskMap.values().stream()
                .filter(task -> task.contains(tmp))
                .forEach(System.out::println);
    }

}