package project.clyde;

public class CountOccurrence {
    public static String num(int[] array, int searchParam) {

        int count = 0;//initialise count

        //use for loop to iterate award array
        for(int i = 0; i < array.length; i++) {
            if (searchParam == array[i]){
                count ++;
            }
        }
        String occurrenceResult = "Number of occurrences of the time " + searchParam + " is "+ count;
        //Print the element and its occurrence
        System.out.println(occurrenceResult);

        return occurrenceResult;
    }
}
