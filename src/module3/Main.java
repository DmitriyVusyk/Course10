package module3;

import java.util.Scanner;

/**
 * task 1.1 and 1.2
 */
class Main {

    public static void main(String[] args) {

        int arrayCapacity;
        boolean check = false;
        Scanner in = new Scanner(System.in);


        System.out.println("Enter array capacity:");
        arrayCapacity = in.nextInt();
        in.nextLine();

        int[] array = new int[arrayCapacity];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter your number: ");
            array[i] = in.nextInt();
        }

        System.out.println("Max number in array: ");
        System.out.println(Module3Utils.getMin(array));

        System.out.println("Min number in array: ");
        System.out.println(Module3Utils.getMax(array));

        System.out.println("Counts of 5 in array: ");
        System.out.println(Module3Utils.getCountOfFivesInArray(array));

        System.out.println("Max count of identical numbers in array: ");
        System.out.println(Module3Utils.countMaxCountOfIdenticalNumbersInArray(array));

        System.out.println("Max count of identical numbers in array: ");
        System.out.println(Module3Utils.countMinCountOfIdenticalNumbersInArray(array));

    }
}
