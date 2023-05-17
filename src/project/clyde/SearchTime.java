package project.clyde;

import java.util.Arrays;

public class SearchTime {
    public static String search(int[] array, int searchParam) {

        int value;
        String result = null;
        for (value = 0; value < array.length; value++) {//for each item in the array
            if (array[value] == searchParam) { //if this time matches the time being searched for
                //store the position (index value) and print out where the element was found
                result = searchParam + " is present at position " + (value + 1) + " and at index " + value + ".";
                System.out.println(result);
                System.out.println(Arrays.toString(array)); //print array so that you can see the position inside array i.e. check result
            }
        }

        if (value != searchParam) {
            System.out.println(searchParam + " is not present in the array");
        }
        System.out.println(Arrays.toString(array)); //print array so that you can see the position inside array i.e. check result
        return result;
    }
}
