package task;

import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtils {
    public static final String DATE_TIME_FORMAT = "dd.MM.yyyy HH:mm";
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_FORMAT);
    private static final Scanner scanner = new Scanner(System.in).useDelimiter("\\n");

    public static String askString(String message) {
        System.out.print(message + ": ");
        return scanner.next();
    }

    public static int askInt(String message) {
        System.out.println(message + ": ");
        return scanner.nextInt();
    }
    public static LocalDateTime askDateTime(){
        while (true) {
            try {
                System.out.println( "Введите дату и время в формате dd.MM.yyyy HH:mm");
                var strDateTime = scanner.next();
                return LocalDateTime.parse(strDateTime, DATE_TIME_FORMATTER);
            } catch (DateTimeException e) {
                System.out.println("введена дата в неверном формате");
            }
        }
    }

    public static String dateTimeToString(LocalDateTime dateTime) {
        return DATE_TIME_FORMATTER.format(dateTime);
    }
}
