package Coursework.exceptions.task;

import java.time.LocalDate;

public class MonthlyTask extends Task {

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return localDate.getDayOfMonth() == getDateTime().toLocalDate().getDayOfMonth();
    }
}
