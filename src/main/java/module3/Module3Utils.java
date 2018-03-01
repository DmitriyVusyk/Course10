package module3;

/**
 * This class is utility and contains methods for module 3 all homework's
 */
class Module3Utils {

    private Module3Utils() {
    }

//task1

    /**
     * This method search for minimal number in Array
     *
     * @return <code>result</code> minimal number in array
     */
    static int getMin(int array[]) {

        int result = array[0];

        for (int item : array) {
            if (item < result)
                result = item;
        }
        return result;
    }

    /**
     * This method search for maximal number in Array
     *
     * @return <code>result</code> maximal number in array
     */
    static int getMax(int array[]) {

        int result = array[0];

        for (int item : array) {
            if (item > result)
                result = item;
        }
        return result;
    }

    /**
     * This method count total of 5 in array
     *
     * @return <code>result</code> count of 5 in array
     */
    static int getCountOfFivesInArray(int array[]) {

        int result = 0;
        for (int item :
                array) {
            if (item == 5) {
                result++;
            }
        }
        return result;
    }

//task2

    /**
     * This method counts the maximum number of identical numbers in the <code>array</code>
     *
     * @param array array which will record the ongoing count
     * @return <code>result</code> max identical numbers
     */
    static int countMaxCountOfIdenticalNumbersInArray(int array[]) {

        int result = 0;

        int[] countsArray = new int[array.length];
        int j = 0;

        for (int number : array) {

            int counts = 0;

            for (int i = 0; i < array.length; i++) {
                if (number == array[i]) {
                    counts++;
                }
            }

            countsArray[j++] = counts;
        }

        for (int resultNumber : countsArray) {
            for (int i = 0; i < countsArray.length; i++) {
                if (resultNumber > countsArray[i]) {
                    result = resultNumber;
                }
            }
        }

        return result;
    }

    /**
     * This method counts the minimal number of identical numbers in the <code>array</code>
     *
     * @param array array which will record the ongoing count
     * @return <code>result</code> min identical numbers
     */
    static int countMinCountOfIdenticalNumbersInArray(int array[]) {

        int result = 0;

        int[] countsArray = new int[array.length];
        int j = 0;

        for (int number : array) {

            int counts = 0;

            for (int i = 0; i < array.length; i++) {
                if (number == array[i]) {
                    counts++;
                }
            }

            countsArray[j++] = counts;
        }

        for (int resultNumber : countsArray) {
            for (int i = 0; i < countsArray.length; i++) {
                if (resultNumber < countsArray[i]) {
                    result = resultNumber;
                }
            }
        }

        return result;
    }

}
