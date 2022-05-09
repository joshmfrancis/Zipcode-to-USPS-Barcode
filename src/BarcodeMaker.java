// Name: Joshua Francis
// Course: CSC 135 
// Project: FinalProject_Francis_Joshua
// File Name: BarcodeMaker.java

// Driver class for this project
// This program takes in a zip code and prints out a barcode representation 
// of it, if the zip code is 5 digits in length, it proccesses the +4 part 
// of the zipcode as 0s, and if the zip code is 9 digits in length, it continues
// on proccessing. The barcode also has bar frames on the left and right, and a 
// check digit to validate the barcode if it has been damaged or scuffed up in 
// any way. This program makes use of multiple classes, this driver class, 
// 'BarcpdeMaker', and a class that encodes the barcode titled 'BarcodeEncoder'. 
// Imports I used
import java.util.Scanner;

public class BarcodeMaker {

    public static void main(String[] args) {
        // Creates a scanner object for use of the do loop and input of zip code
        Scanner scan = new Scanner(System.in);

        // creates a counter and a string for use of the do 
        // loop to ask at the end of the program
        int count = 0;
        String redo;
        // Start of loop
        do {
            // BarcodeEncoder objects that I use later down the line to pass in the 
            // zipcode digits to be encoded to be a barcode
            BarcodeEncoder digitOne, digitTwo, digitThree, digitFour,
                    digitFive, digitSix, digitSeven, digitEight, digitNine, digitCheck;
            digitOne = new BarcodeEncoder();
            digitTwo = new BarcodeEncoder();
            digitThree = new BarcodeEncoder();
            digitFour = new BarcodeEncoder();
            digitFive = new BarcodeEncoder();
            digitSix = new BarcodeEncoder();
            digitSeven = new BarcodeEncoder();
            digitEight = new BarcodeEncoder();
            digitNine = new BarcodeEncoder();
            digitCheck = new BarcodeEncoder();

            // Variables I used
            int zipCode = 0;
            int checkDigit;
            int correctionDigit;
            String correctionDigitEncode;

            // Asks for and stores a zip code value from the user
            System.out.println("Enter zipcode:");
            if (scan.hasNextInt()) {
                zipCode = scan.nextInt();
            } else {
                //If the integer inputted is over the int limit or not an int
                // it will return 0
                System.out.println("Error!");
                scan.next();
            }

            // Formats and creates "check" variables to make sure that the 
            // input from the user is a valid zipcode
            String checkZipCode = Integer.toString(zipCode);
            int fiveLengthCheck = 5;
            int nineLengthCheck = 9;

            // While statement to handle if the input is false
            while ((checkZipCode.length() != fiveLengthCheck) && (checkZipCode.length() != nineLengthCheck)) {

                // Prints out a false statement
                System.out.println(zipCode + " is not a valid zipcode!");
                // Reprompts the user to try again 
                System.out.println("Try again! Enter a valid zipcode: ");
                if (scan.hasNextInt()) {
                    zipCode = scan.nextInt();
                } else {
                    //If the integer inputted is over the int limit or not an int
                    // it will return 0
                    System.out.println("Error!");
                    scan.next();
                }
                // Rescans the users input and rereferences the checkZipCode for the 
                // while and if statements (while - above, if - below)

                checkZipCode = Integer.toString(zipCode);
            }

            // if statement to handle if the zipCode is correct
            if ((checkZipCode.length() == fiveLengthCheck) || (checkZipCode.length() == nineLengthCheck)) {
                System.out.println(zipCode + " is a valid zipcode!");
            }

            // If the passed in digit is only 5, it appends four 0s at the end, 
            // if the zipcode is 9 digits it skips this step
            if (checkZipCode.length() == 5) {
                zipCode = Integer.valueOf(String.valueOf(zipCode)
                        + String.valueOf("0000"));
            }

            // Code to rereference the checkZipCode count, 
            // as it changed with any five digit input
            checkZipCode = Integer.toString(zipCode);

            // Starts formatting the output with a left frame bar
            String output = "|";

            // Code to split up the inputted zipcode into individual strings
            String one = checkZipCode.split("")[0];
            String two = checkZipCode.split("")[1];
            String three = checkZipCode.split("")[2];
            String four = checkZipCode.split("")[3];
            String five = checkZipCode.split("")[4];
            String six = checkZipCode.split("")[5];
            String seven = checkZipCode.split("")[6];
            String eight = checkZipCode.split("")[7];
            String nine = checkZipCode.split("")[8];

            // passes the digits of the zipcode as strings to 
            // the digit encoder using the digit objects
            digitOne.setOutput(one);
            digitTwo.setOutput(two);
            digitThree.setOutput(three);
            digitFour.setOutput(four);
            digitFive.setOutput(five);
            digitSix.setOutput(six);
            digitSeven.setOutput(seven);
            digitEight.setOutput(eight);
            digitNine.setOutput(nine);

            // code to change the strings to integers for proccessing
            // only for use of the checkdigit, since the checkdigit is proccesses 
            // in this driver class
            int oneChanged = Integer.parseInt(one);
            int twoChanged = Integer.parseInt(two);
            int threeChanged = Integer.parseInt(three);
            int fourChanged = Integer.parseInt(four);
            int fiveChanged = Integer.parseInt(five);
            int sixChanged = Integer.parseInt(six);
            int sevenChanged = Integer.parseInt(seven);
            int eightChanged = Integer.parseInt(eight);
            int nineChanged = Integer.parseInt(nine);

            //Adds all of the digits together for use of the correction digit
            checkDigit = oneChanged + twoChanged + threeChanged + fourChanged
                    + fiveChanged + sixChanged + sevenChanged + eightChanged + nineChanged;

            // Math to determine the correction digit for the inputted zip code
            correctionDigit = (((checkDigit / 10) + 1) * 10) - checkDigit;

            // converts the full correction digit to a string to be passes to the 
            // digit encoder, because the digit encoder 
            // only accepts strings as an input
            correctionDigitEncode = Integer.toString(correctionDigit);

            // Gets the correction digit ready to be encoded
            digitCheck.setOutput(correctionDigitEncode);

            // Gets the barcode representation ready to be outputted
            // - sends to barcode encoder
            output = output + digitOne.getOutput() + digitTwo.getOutput()
                    + digitThree.getOutput() + digitFour.getOutput() + digitFive.getOutput()
                    + digitSix.getOutput() + digitSeven.getOutput() + digitEight.getOutput()
                    + digitNine.getOutput() + digitCheck.getOutput();

            // Right Frame Bar 
            output = output + "|";

            // Outputs for the user to read
            System.out.println(output);

            // Sets the count to 1 for use of the do loop
            count++;

            // Print statement for the user to read if they want 
            // to rerun the program again
            System.out.println("Say 'YES' if you want to input again, "
                    + "or 'NO' if you want to stop. (All Caps)");
            redo = scan.next();

            // Handler for the count if the user wants to rerun the program again
            if (redo.matches("YES")) {
                count--;
            }
            // If the count is 0 at the end of the program that means the user 
            // has accepted to wanting the program to run again
        } while (count == 0);

    }
}
