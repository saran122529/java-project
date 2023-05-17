package project.clyde;

public class BubbleSort {

    public static void sort(int[] array){
        boolean swapped = true;
        while(swapped) {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                int a = array[i];
                int b = array[i + 1];
                if (a > b) {
                    System.out.println("swapping " + a + " and " + b);
                    ArrayUtils.swap(array, i, i + 1);
                    swapped = true;
                }
            }
        }
    }
}
