package project.clyde;

public class FastestTime {
    public static int min(int[] array){

        int minimumValue = array[0];//Set the first item to be the minimum


        //For each item (starting with the second)
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minimumValue) { //If the current item is less than the minimum
                minimumValue = array[i]; //set the current item to be the minimum
            }
        }
        return minimumValue;//return the minimum value to the caller

    }
}
