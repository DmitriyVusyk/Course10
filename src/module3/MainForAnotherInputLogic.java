package module3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * task 3 another version of input array
 */
public class MainForAnotherInputLogic {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString;

        System.out.println("Enter your Array: ");
        inputString = scanner.nextLine();

        String strArr[] = inputString.split(" ");
        int numArr[] = new int[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        System.out.println(Arrays.toString(numArr));

    }
}
