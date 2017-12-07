package module4.utils;

/**
 * This class is utility and contains methods for module 4 all homework's
 */
public class Module4Utils {

    private Module4Utils() {
    }

    //task1

    /**
     * this function print numbers from 0 to the number <code>x</code>
     *
     * @param x number which is to be output
     */
    public static void printNumbers(int x) {

        for (int i = 0; i <= x; i++) {
            System.out.println(i);
        }
    }

    //task2

    /**
     * this method draw Rectangle
     *
     * @param height height of rectangle
     * @param length length of rectangle
     */
    public static void drawRectangle(int height, int length) {
        if (height <= 0 || length <= 0) {
            System.out.println("Length or height of rectangle is zero or negative. " +
                    "Please check parameter");
        } else {

            for (int i = 0; i < height; i++) {

                for (int j = 0; j < length; j++) {
                    System.out.print(" + ");
                }

                System.out.print("\n");
            }
        }
    }

    //task3

    /**
     * this method draw a Rectangle
     *
     * @param sideLength the length of a side of a square
     */
    public static void drawRectangle(int sideLength) {

        if (sideLength == 0) {
            System.out.println("The Length of a side of rectangle is zero or negative. " +
                    "Please check parameter");
        } else {
            for (int i = 0; i < sideLength; i++) {

                for (int j = 0; j < sideLength; j++) {
                    System.out.print(" + ");
                }

                System.out.print("\n");
            }
        }
    }

    //Task4

    /**
     * this method compare two numbers and returns the biggest one
     *
     * @param a first number
     * @param b second number
     * @return the biggest one
     */
    public static int compareTwoNumbers(int a, int b) {

        if (a < b) {
            return b;
        } else if (a > b) {
            return a;
        } else {
            System.out.println("numbers are equal");
            return 0;
        }
    }

    /**
     * this method compare two numbers and returns the biggest one
     *
     * @param a first number
     * @param b second number
     * @return the biggest one
     */
    public static float compareTwoNumbers(int a, float b) {

        float c = (float) a;

        if (c < b) {
            return b;
        } else if (c > b) {
            return c;
        } else {
            System.out.println("numbers are equal");
            return 0;
        }
    }

    //Task5

    /*
     * task1 without loops but with recursion
     */
    public static String printNumbersWithRecursion(int x) {

        if (x == 0) {
            return "0";
        }
        return printNumbersWithRecursion(x - 1) + " " + x;
    }

    //Task 6

    /*
    task2 with recursion
     */
    public static String drawRectangleWithRecursion(int height, int length) {

        if (height <= 0 || length <= 0) {
            System.out.println("Length or height of rectangle is zero or negative. " +
                    "Please check parameter");
        }

        if (height <= 0) {
            return " ";
        } else {

            for (int i = 0; i < height; i++) {

                for (int j = 0; j < length; j++) {
                    System.out.print(" + ");
                }

                System.out.print("\n");
                return drawRectangleWithRecursion(height - 1, length);
            }
        }
        return "";
    }

}
