// Name: Joshua Francis
// Course: CSC 135
// Project: FinalProject_Francis_Joshua
// File Name: BarcodeEncoder.java

// This class takes in a string of a digit and converts it into a string output 
// for the correct digit for use of the driver class
public class BarcodeEncoder {

    // variables I used
    String input;
    String output;

    // constructor
    public BarcodeEncoder() {
        input = "";
        output = "";
    }

    //setter 
    public void setOutput(String grabbed) {

        input = grabbed;

    }

    // getter
    public String getOutput() {

        // Converts the input string to an int to be checked against the digits
        int inputToOutput = Integer.parseInt(input);

        // if and else if functions to set the outputs for each digits, 
        // each time it is called upon
        switch (inputToOutput) {
            case 0:
                output = output + "||:::";
                break;
            case 1:
                output = output + ":::||";
                break;
            case 2:
                output = output + "::|:|";
                break;
            case 3:
                output = output + "::||:";
                break;
            case 4:
                output = output + ":|::|";
                break;
            case 5:
                output = output + ":|:|:";
                break;
            case 6:
                output = output + ":||::";
                break;
            case 7:
                output = output + "|:::|";
                break;
            case 8:
                output = output + "|::|:";
                break;
            case 9:
                output = output + "|:|::";
                break;
            default:
                break;
        }
        return output;
    }

    // toString method to  get the output instead of memory location
    @Override
    public String toString() {
        String toPrint = new String();
        toPrint += output;
        return toPrint;
    }

}
