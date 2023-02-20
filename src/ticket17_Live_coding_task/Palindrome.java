package ticket17_Live_coding_task;

import java.util.Scanner;
//Написать программу, которая будет проверять, является ли слово из пяти букв,
// палиндромом (примеры: «комок», «ротор») и возвращает true/false.
public class Palindrome {
    public static void main(String[] args) {
        System.out.println("Введите слово из 5 букв. Регистр не имеет значения");
        Scanner sc = new Scanner(System.in);
        String s1;
        s1 = sc.nextLine().toLowerCase();
        if (s1.length() == 5) {
            System.out.println("Вы ввели правильное слово");
            if (s1.charAt(0) == s1.charAt(4) && s1.charAt(1) == s1.charAt(3)) {
                System.out.println("Вы ввели слово, которое является палиндромом ");
            } else {
                System.out.println("Вы ввели слово, которое не является палиндромом ");
            }
        } else {
            System.out.println("Вы ввели не правильное слово");
        }
    }
}
