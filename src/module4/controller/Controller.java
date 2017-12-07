package module4.controller;

import module4.api.ControllerAPI;
import module4.utils.Module4Utils;

import java.util.Scanner;

/**
 * This class describe menu logic for module 4 task 7
 */
public class Controller implements ControllerAPI {

    public Controller() {
    }

    /**
     * show menu Text
     */
    private void showMenuText() {

        System.out.println("Please select a Task:" +
                "\n 1: Print number from 0 to x" +
                "\n 2: Draw rectangle with height and length" +
                "\n 3: Draw a square with side length" +
                "\n 4: Compare two numbers (compare int int or compare int float)" +
                "\n 5: Print number from 0 to x with recursion" +
                "\n 6: Draw rectangle with height and length with recursion" +
                "\n 7: Exit");

    }

    /**
     * Switch between the menu items
     */
    private void runMenu() {

        boolean answerMenuSelect = false;

        Scanner scanner = new Scanner(System.in);
        while (!answerMenuSelect) {
            switch (scanner.nextLine()) {

                case "1":
                    runTask1();
                    answerMenuSelect = true;
                    showMenuOneMoreTime();
                    break;

                case "2":
                    runTask2();
                    answerMenuSelect = true;
                    showMenuOneMoreTime();
                    break;

                case "3":
                    runTask3();
                    answerMenuSelect = true;
                    showMenuOneMoreTime();
                    break;

                case "4":
                    runTask4();
                    answerMenuSelect = true;
                    showMenuOneMoreTime();
                    break;

                case "5":
                    runTask5();
                    answerMenuSelect = true;
                    showMenuOneMoreTime();
                    break;

                case "6":
                    runTask6();
                    answerMenuSelect = true;
                    showMenuOneMoreTime();
                    break;

                case "7":
                    printGoodBye();
                    answerMenuSelect = true;
                    break;

                default:
                    System.out.println("You entered wrong menu item");

            }

        }
    }

    /**
     * Ask user exit from menu or use program one more time
     */
    private void showMenuOneMoreTime() {

        boolean answer = false;

        System.out.println("Do you want to use other operations? ");

        while (!answer) {

            System.out.println("Print Yes or No");

            Scanner scanner = new Scanner(System.in);

            String consoleInput = scanner.nextLine();

            if (consoleInput.equalsIgnoreCase("yes")) {
                runProgram();
                answer = true;
            } else if (consoleInput.equalsIgnoreCase("no")) {
                printGoodBye();
                answer = true;
            } else {
                System.out.println("Wrong input!");
            }

        }
    }

    private void printGoodBye() {
        System.out.println("Good Bye!");
    }

    private void printInputError() {
        System.out.println("Wrong input!");

    }

    private void runTask1() {


        boolean answer = false;

        System.out.println("Print numbers from 0 to x. ");

        while (!answer) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter x: ");
            if (scanner.hasNextInt()) {
                Module4Utils.printNumbers(scanner.nextInt());
                answer = true;
            } else {
                printInputError();
            }
        }
    }

    private void runTask2() {


        int h = 0;
        int l = 0;
        boolean answerLength = false;
        boolean answerHeight = false;

        System.out.println("Draw rectangle with height and length.");


        while (!answerLength) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter int length of rectangle: ");

            if (scanner.hasNextInt()) {
                l = scanner.nextInt();
                answerLength = true;
            } else {
                printInputError();
            }
        }

        while (!answerHeight) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter int the height of rectangle: ");

            if (scanner.hasNextInt()) {
                h = scanner.nextInt();
                answerHeight = true;
            } else {
                printInputError();
            }
        }

        Module4Utils.drawRectangle(h, l);
    }

    private void runTask3() {

        boolean answer = false;
        int sideLength = 0;

        System.out.println("Draw a square with side length.");


        while (!answer) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Please enter int side length: ");

            if (scanner.hasNextInt()) {
                sideLength = scanner.nextInt();
                answer = true;
            } else {
                printInputError();
            }
        }

        Module4Utils.drawRectangle(sideLength);

    }

    private void runTask4() {

        Scanner scanner = new Scanner(System.in);

        Integer a = null;
        Integer b = null;
        Float bFloat = null;
        boolean answerA = false;
        boolean answerB = false;
        boolean answerFromSwitch = false;

        System.out.println("Compare two numbers");


        while (!answerFromSwitch) {

            System.out.println("1. Compare two integers. " +
                    "\n2. Compare integer and float.");

            switch (scanner.nextLine()) {

                case "1":


                    while (!answerA) {

                        Scanner sc = new Scanner(System.in);

                        System.out.println("Enter first integer: ");

                        if (sc.hasNextInt()) {
                            a = sc.nextInt();
                            answerA = true;
                        } else {
                            printInputError();
                        }
                    }

                    while (!answerB) {

                        Scanner sc = new Scanner(System.in);

                        System.out.println("Enter second integer: ");

                        if (sc.hasNextInt()) {
                            b = sc.nextInt();
                            answerB = true;
                        } else {
                            printInputError();
                        }
                    }

                    answerFromSwitch = true;
                    break;

                case "2":


                    while (!answerA) {

                        System.out.println("Enter integer: ");

                        Scanner sc = new Scanner(System.in);


                        if (sc.hasNextInt()) {
                            a = sc.nextInt();
                            answerA = true;
                        } else {
                            printInputError();
                        }
                    }


                    while (!answerB) {

                        Scanner sc = new Scanner(System.in);

                        System.out.println("Enter float: ");

                        if (sc.hasNextFloat()) {
                            bFloat = sc.nextFloat();
                            answerB = true;
                        } else {
                            printInputError();
                        }
                    }
                    answerFromSwitch = true;
                    break;

                default:
                    printInputError();
            }
        }

        if (b != null) {
            System.out.println(Module4Utils.compareTwoNumbers(a, b));
        }
        if (bFloat != null) {
            System.out.println(Module4Utils.compareTwoNumbers(a, bFloat));
        }

    }

    private void runTask5() {


        boolean answer = false;

        System.out.println("Print numbers from 0 to x. ");

        while (!answer) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter int x: ");
            if (scanner.hasNextInt()) {
                System.out.println(Module4Utils.printNumbersWithRecursion(scanner.nextInt()));
                answer = true;
            } else {
                printInputError();
            }
        }
    }

    private void runTask6() {


        int h = 0;
        int l = 0;
        boolean answerLength = false;
        boolean answerHeight = false;

        System.out.println("Draw rectangle with height and length.");


        while (!answerLength) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter int length of rectangle: ");

            if (scanner.hasNextInt()) {
                l = scanner.nextInt();
                answerLength = true;
            } else {
                printInputError();
            }
        }

        while (!answerHeight) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter int height of rectangle: ");

            if (scanner.hasNextInt()) {
                h = scanner.nextInt();
                answerHeight = true;
            } else {
                printInputError();
            }
        }

        System.out.println(Module4Utils.drawRectangleWithRecursion(h, l));
    }

    public void runProgram() {

        showMenuText();
        runMenu();

    }

}
