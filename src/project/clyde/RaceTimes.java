package project.clyde;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class RaceTimes {

    public static final String NAME_OF_FILE = "src/project/clyde/race.txt";
    public static File fileName; //declared global variables which can be seen by all methods
    public static Scanner in = new Scanner(System.in); //create global scanner which can be seen and used by readFile() and reused for user input
    public static PrintWriter out; //declare global PrintWriter which can be used to write to file using System.print()

    //declare global arrays which can be seen and accessed

    public static String[][] raceTimes = new String[16][3]; //2D array to store data read from file i.e. java array of records

    public static String[] firstNames = new String[16];
    public static String[] lastNames = new String[16];

    public static int[] times = new int[16]; //1D Arrays to store individual data

    public static void main(String[] args) throws IOException {

        String password = ""; //set value for password
        int fail = 3; //set value for number of failed attempts

        //use loop to allow the user to input password multiple times
        do {

            System.out.println("Welcome to Glasgow Clyde Runners Club.");
            System.out.println("Please enter your password to continue: ");
            String login = in.nextLine();
            //use if else statement to validate password
            if (login.equals(password)) {
                System.out.println("Password Validated");
                Menu(); //if password is validated call menu() method
            } else {
                //if password is not validated take one away from fail and repeat loop
                fail--;
                System.out.println("Your Password is incorrect"); //print message to user
                System.out.println("You have " + fail + " attempts left.");
            }

        } while (fail != 0); //set condition for loop
        //if the fail to input password correctly after 3 attempts loop will exit
        //and the following output will be shown to the user

        System.out.println("Number of attempts exceeded. You are now locked out.");
        System.exit(0); //program will exit
    }


    public static void Menu() throws IOException {

        String input;

        //use do loop to allow the user to use menu until they choose to exit
        do {
            System.out.println("\nPlease choose from the following options:");
            System.out.println("1. Read and Display File");
            System.out.println("2. Sort and Print Recorded Times");
            System.out.println("3. Find and Print Fastest Time");
            System.out.println("4. Find and Print Slowest Time");
            System.out.println("5. Search for Time");
            System.out.println("6. Time Occurrence");
            System.out.println("7. Exit Program");
            input = in.next(); //capture users menu option

            //use if else to compare user option and execute associated method
            in.nextLine(); // Consume the newline character after reading the option

            if (input == null || !input.strip().matches("^[1-7]")) {
                System.out.println("Invalid input: " + input);
                continue;
            }
            int option = Integer.parseInt(input.strip());

            if (option == 1) {
                readFile(); //call method to read from the file

            } else if (option == 2) {
                sortAndPrintTimes();

            } else if (option == 3) {
                findAndPrintFastestTime();

            } else if (option == 4) {
                findAndPrintSlowestTime();

            } else if (option == 5) {
                searchTime();

            } else if (option == 6) {
                timeOccurrence();

            } else if (option == 7) {
                in.close(); //close scanner object
                System.out.println("Exiting the program...");
                System.exit(0);

            }
        } while (true);
    }

    public static void readFile() throws FileNotFoundException {
        fileName = new File(NAME_OF_FILE);
        in = new Scanner(fileName); //pass file over to Scanner

        int index = 0;

        //use while loop to check for all the data that is to be read in
        while (in.hasNextLine()) {
            //use for loop to add data to the 2D array until the end of file is reached
            for (int i = 0; i < raceTimes.length; i++) {
                String[] line = in.nextLine().split(" ");
                for (int j = 0; j < line.length; j++) {
                    raceTimes[i][j] = line[j];
                }
            }
        }
        // Print out to check that data has been read and stored into 2D array
        System.out.println("Race Results:\n" + Arrays.deepToString(raceTimes));

        // Use for loop to iterate over the 2D array and extract data required for 1D arrays
        for (int i = 0; i < raceTimes.length; i++) {
            times[i] = Integer.parseInt(raceTimes[i][2]);
            lastNames[i] = raceTimes[i][1];
            firstNames[i] = raceTimes[i][0];
        }

        // Print out 1D array to check the data has been captured
        System.out.println("firstNames: " + Arrays.toString(firstNames));
        System.out.println("lastNames: " + Arrays.toString(lastNames));
        System.out.println("Times: " + Arrays.toString(times));

        in.close(); //close scanner being used for file input
        in = new Scanner(System.in); //create new instance of scanner for reading in user input i.e. menu choice
    }


    public static void sortAndPrintTimes() throws IOException {
        readFile();
        int[] timesArray = new int[16];

        for (int i = 0; i < 16; i++) {
            timesArray[i] = Integer.parseInt(raceTimes[i][2]);
        }

        BubbleSort.sort(timesArray);

        System.out.println("\nSorted Times: ");
        for (int time : timesArray) {
            System.out.println(time);
        }
        //print message to user
        System.out.println("File operation complete.......");
        System.out.println("Please see output file for results.");

        FileOperations.writeToFile("results/sort.txt", timesArray);
    }

    public static void findAndPrintFastestTime() throws IOException {
        readFile();
        int[] timesArray = new int[16];

        for (int i = 0; i < 16; i++) {
            timesArray[i] = Integer.parseInt(raceTimes[i][2]);
        }

        System.out.println("\n Fastest time:");
        int time = FastestTime.min(timesArray);
        System.out.println(time);

        // print message to user
        System.out.println("File operation complete.......");
        System.out.println("Please see output file for results.");

        FileOperations.writeToFile("results/fastest.txt", time);
    }


    public static void findAndPrintSlowestTime() throws IOException {
        readFile();
        int[] timesArray = new int[16];

        for (int i = 0; i < 16; i++) {
            timesArray[i] = Integer.parseInt(raceTimes[i][2]);
        }

        System.out.println("\n Slowest time:");
        int time = SlowestTime.min(timesArray);
        System.out.println(time);


        // print message to user
        System.out.println("File operation complete.......");
        System.out.println("Please see output file for results.");

        FileOperations.writeToFile("results/slowest.txt", time);
    }


    public static void searchTime() throws IOException {
        readFile();
        String operation = "Search Time";
        int[] timesArray = new int[16];

        for (int i = 0; i < 16; i++) {
            timesArray[i] = Integer.parseInt(raceTimes[i][2]);
        }

        System.out.println("Enter a time in seconds to search");
        int search = RaceTimes.in.nextInt(); //get element to be searched for

        printBanner(operation);

        String searchResult= SearchTime.search(timesArray, search);

        FileOperations.writeToFile("results/search.txt", String.valueOf(searchResult));
        printEndBanner(operation);

    }



    public static void timeOccurrence() throws IOException {
        String operation = "Time Occurrence";
        readFile();
        int[] timesArray = new int[16];

        for (int i = 0; i < 16; i++) {
            timesArray[i] = Integer.parseInt(raceTimes[i][2]);
        }

        System.out.println("Enter a time in seconds to find number of occurrences");
        int search = RaceTimes.in.nextInt(); //get element to be searched for

        printBanner(operation);
        String occurrenceResult = CountOccurrence.num(timesArray, search);

        FileOperations.writeToFile("results/countOccurrence.txt", occurrenceResult);
        printEndBanner(operation);

    }

    private static void printBanner(String message) {
        System.out.println("\n************************* " + message + " *************************");
    }

    private static void printEndBanner(String message) {
        printBanner(message+" End");
    }
}
