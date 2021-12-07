package ics3.Single.DanielYe10;

/*
* Daniel Ye
* December 6, 2021
* Ms. Basaraba
* This program searches a file named "File IO Pizza Prices.txt" for various pizza prices, printing out the corresponding
* price for a store and size that the user enters
 */

// imports
import java.io.*;
import hsa.Console;

// FileIO (Main) class
public class FileIO {

    public final String storeFile = "File IO Pizza Prices.txt"; // the name of the text file
    String store, size; // the store the user chose and the pizza size they want to know the price for
    int linesSkip; // the number of lines to skip when finding the price
    Console c; // the interface for user input and output

    // FileIO class constructor
    public FileIO(){
        // initialize the console
        c = new Console("Pizza Place Searcher");
    } // class constructor

    // displays an introduction to the program
    public void intro(){
        // roughly center the output by printing out 6 new lines
        c.print("\n\n\n\n\n\n");
        // Display "Pizza Place Searcher" in the middle of the screen
        c.print(' ', 30);
        c.println("Pizza Place Searcher");

        // display a description of the program, roughly centered
        c.print(' ', 10);
        c.println("Enter a store and a size, and this program will search a");
        c.print(' ', 15);
        c.println("giant database for the corresponding price");

        // display a blank line before the next part of the program
        c.println();
    } // intro method

    // asks the user for data
    public void askData(){
        // prompts the user for the store name
        c.print(' ', 10);
        c.print("Please enter the store name and press <ENTER>: ");

        // reads the store
        store = c.readLine();

        boolean valid = false; // stores whether or not the pizza size is a valid size

        // prompts the user for the size of the pizza
        c.print(' ', 5);
        c.println("Please enter the size of the pizza you wish to order and press <ENTER>");
        c.print(' ', 2);
        c.print("It must be one of 'large', 'medium', 'small', or 'single slice': ");

        // while the size is not valid, prompt the user for input
        while(!valid){
            // read the size input
            size = c.readLine();

            // valid starts as true, changing to false if the input is not valid
            valid = true;

            // calculate the corresponding number of lines to skip when reading the file
            if(size.equals("large")){
                linesSkip = 0;
            } else if(size.equals("medium")){
                linesSkip = 1;
            } else if(size.equals("small")){
                linesSkip = 2;
            } else if(size.equals("single slice")){
                linesSkip = 3;
            } else{
                // if it is not any of the corresponding sizes, then display an error message and set [valid] to false
                c.print(' ', 2);
                c.print("Please enter one of 'large', 'medium', 'small', and 'single slice': ");
                valid = false;
            } // else block for parsing size to # of lines to skip
        } // while loop for validity
    } // askData method

    // displays the price
    public void displayPrice(){
        try{
            // initialize a BufferedReader for the data file
            BufferedReader br = new BufferedReader(new FileReader(storeFile));

            // gets the current line for the current store
            String line;
            // stores whether or not we found the store
            boolean foundStore = false;

            // while we haven't reached the end of the file and we haven't found the store yet
            while((line = br.readLine()) != null && !foundStore){
                // if the current line is the store the user is looking for
                if(line.equals(store)){
                    foundStore = true;

                    // skip the number of lines corresponding to the pizza size
                    for(int i = 0; i < linesSkip; i++){
                        br.readLine();
                    }

                    // get the price (as a string, as we are just reiterating it to the user)
                    String price = br.readLine();

                    // display the price
                    c.print(' ', 7);
                    c.println("The price for a " + size + " pizza from " + store + " is $" + price);
                } else{
                    // otherwise, if this is not the right store, skip 4 lines
                    for(int i = 0; i < 4; i++){
                        br.readLine();
                    } // for loop for skipping lines
                } // else block for if the current store is the user choice
            } // while loop for displaying price

            // if the store was not found, inform the user of such
            if(!foundStore){
                c.print(' ', 10);
                c.println("Unfortunately, we could not find your store!");
            } // if store was not found

            // print an extra line before the next part of the program
            c.println();
        } catch(FileNotFoundException e){
            // for FileNotFoundException, inform the user that it could not find the file
            c.println("This program could not find the dataset file");
            c.println(e.getMessage());
        } catch(IOException e){
            // for IOException, inform the user that something went wrong
            c.println("Something went wrong");
            c.println(e.getMessage());
        } // catch block for displayPrice
    } // displayPrice method

    // prompts the user for if they want to continue
    public boolean toContinue(){
        // prompt the user for input
        c.print(' ', 15);
        c.print("Would you like to continue (Y/N then press <ENTER>): ");

        // get the user input
        String line = c.readLine();

        // while the input is not valid
        while(!line.equals("Y") && !line.equals("N")){
            // prompt the user for "Y" or "N"
            c.print(' ', 20);
            c.print("Please enter 'Y' or 'N': ");

            // reread the input
            line = c.readLine();
        } // while input is not valid

        // print a line before the next part of the program
        c.println();

        // return if the user wants to continue
        return line.equals("Y");
    } // toContinue method

    // main method
    public static void main(String[] args){
        // initialize the program
        FileIO program = new FileIO();
        program.intro(); // display the introduction
        do{
            program.askData(); // as the user for data
            program.displayPrice(); // display the price
        } while(program.toContinue()); // rerun the main part of the program while the wants to do so
    } // main method
} // FileIO class