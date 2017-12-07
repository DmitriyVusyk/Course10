package module4.mainMethodForTests;

import module4.utils.Module4Utils;

/**
 * Check the homework to the task6 without menu
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Task 1: ");
        Module4Utils.printNumbers(5);

        System.out.println("Task 2: ");
        Module4Utils.drawRectangle(4,10);

        System.out.println("Task 3: ");
        Module4Utils.drawRectangle(4);

        System.out.println("Task 4: ");
        System.out.println(Module4Utils.compareTwoNumbers(4, 5));
        System.out.println(Module4Utils.compareTwoNumbers(4, 4.4f));

        System.out.println("Task 5: ");
        System.out.println(Module4Utils.printNumbersWithRecursion(5));

        System.out.println("Task 6: ");
        System.out.println(Module4Utils.drawRectangleWithRecursion(4, 5));
    }
}
