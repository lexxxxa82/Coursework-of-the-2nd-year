package Coursework.exceptions.task;

import java.time.LocalDate;

public class DailyTask extends Task {

    @Override
    public boolean appearsIn(LocalDate localDate) {
        return true;
    }
}