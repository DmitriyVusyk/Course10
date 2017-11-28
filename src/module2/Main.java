package module2;

import java.util.Scanner;

/**
 * Написать программу, которая делает следующее:
 * спрашивает у пользователя имя (String)
 * спрашивает у пользователя город проживания (String)
 * спрашивает у пользователя возраст (int)
 * спрашивает у пользователя хобби (String)
 * перед каждым вводом данных, программа должна вывести информацию пользователю с требованием ввода соответствующей информации.
 * программа выводит красиво оформлено всю информацию о пользователе в трех разных вариантах:
 * ----------------------------------
 * Вариант 1 (табличный):
 * Имя:               хххххх
 * Город:            хххххх
 * Возраст:        хххххх
 * Хобби:           хххххх
 * ----------------------------------
 * Вариант 2 (текстовый):
 * Человек по имени хххххх живет в городе хххххх.
 * Этому человеку хххххх лет и любит он заниматься хххххх.
 * ----------------------------------
 * Вариант 3 (иной):
 * хххххх - имя
 * хххххх - город
 * хххххх - возраст
 * хххххх - хобби
 * ----------------------------------
 */

class Main {

    public static void main(String[] args) {

        User user = new User();
        Scanner in = new Scanner(System.in);


        System.out.println("Enter your name: ");
        user.setName(in.nextLine());

        System.out.println("Enter your city: ");
        user.setCity(in.nextLine());

        System.out.println("How old are you? ");
        user.setAge(in.nextInt());

        System.out.println("What is your hobby? ");
        in.nextLine();
        user.setHobby(in.nextLine());

        System.out.println(user);
        System.out.println("=============================");

        System.out.println("\n Человек по имени " + user.getName() + " живет в городе " + user.getCity() + ".\n" +
                " Этому человеку " + user.getAge() + " лет и любит он заниматься " + user.getHobby());
        System.out.println("=============================");

        System.out.println("\n" + user.getName() + " - имя\n" +
                        user.getCity() + " - город\n" +
                        user.getAge() + " - возраст\n" +
                        user.getHobby() + " - хобби");
        System.out.println("=============================");
    }
}
