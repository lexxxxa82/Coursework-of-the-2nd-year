package task;

import exceptions.IncorrectArgumentException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task {

    private static int idGenerator = 0;
    private String title;
    private Type type;
    private final int id;
    private LocalDateTime dateTime;
    private String description;

    public Task() {
        idGenerator++;
        id = idGenerator;
    }
    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, id, dateTime, description);
    }

    @Override
    public String toString() {
        return String.format("id: %d, тип: %s, заголовок: %s, описание: %s, Дата и время: %s", id, type, title,
                description, InputUtils.dateTimeToString(dateTime));
    }
    public void askData() throws IncorrectArgumentException {
        System.out.println("выберите тип задачи:");
        for (Type taskType : Type.values()) {
            System.out.println(taskType);
        }
        type = Type.valueOf(InputUtils.askString("Ваш выбор").toUpperCase());
        title = InputUtils.askString("название");
        if (title == null || title.isBlank() || title.isEmpty()) {
            throw new IncorrectArgumentException("Введите правильный заголовок");
        }
        description = InputUtils.askString("Введите описание");
        if (description == null || description.isBlank() || description.isEmpty()) {
            throw new IncorrectArgumentException("Введите правильное описание");
        }
        dateTime = InputUtils.askDateTime();
    }
    public boolean contains(String substr) {
        var strId = String.valueOf(id);
        var strType = String.valueOf(type);
        return strId.contains(substr)
                || title.toLowerCase().contains(substr)
                || strType.toLowerCase().contains(substr)
                || InputUtils.dateTimeToString(dateTime).toLowerCase().contains(substr)
                || description.toLowerCase().contains(substr);
    }

    public abstract boolean appearsIn(LocalDate localDate);
}

