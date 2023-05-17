package project.clyde;

public class SlowestTime {
    public static int min(int[] array){

        int maximumValue = array[0];//Set the first item to be the maximum


        //For each item (starting with the second)
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maximumValue) { //If the current item is less than the minimum
                maximumValue = array[i]; //set the current item to be the maximum
            }
        }
        return maximumValue;//return the minimum value to the caller

    }
}


