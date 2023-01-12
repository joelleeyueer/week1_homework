package src;

import java.io.*;

public class MainGOL {

    public static void main(String[] args) throws IOException {
 //       String incomingFile = System.console().readLine("Which file would you want to print?"); uncomment later
//        Reader r = new FileReader(incomingFile+".gol"); uncomment later
        Reader r = new FileReader("glider.gol"); //for testing only
        BufferedReader br = new BufferedReader(r);
        int gridRow = 0;
        int gridCol = 0;
        int startingRow = 0;
        int startingCol = 0;
        boolean isData = false;

        String incomingLine;

        while (null != (incomingLine = br.readLine())){
            String[] incomingLineArray = incomingLine.split(" ");

                //is a comment
                if (incomingLineArray[0].equalsIgnoreCase("#")){
                    continue;
                } else if (incomingLineArray[0].equalsIgnoreCase("GRID")){
                    gridRow = Integer.parseInt(incomingLineArray[1]);
                    gridCol = Integer.parseInt(incomingLineArray[2]);
                    continue;
                } else if (incomingLineArray[0].equalsIgnoreCase("START")){
                    startingRow = Integer.parseInt(incomingLineArray[1]);
                    startingCol = Integer.parseInt(incomingLineArray[2]);
                    continue;
                } else if (incomingLineArray[0].equalsIgnoreCase("DATA")){
                    isData = true;
                    break;
            }

        }

        //initialise the grid and populate the array with zeros
        int[][] gridPlayArea = new int[gridRow][gridCol];

        if (isData = true){ }
        else {
            System.err.println("You did not initialise the configuration");
            return;
        }

        int currentRow = startingRow-1;
        int currentCol = startingCol;

        while (null != (incomingLine = br.readLine())) {
            currentCol = startingCol;
            currentRow++;
            String[] incomingLineArray = incomingLine.split("");
            for (int i = 0; i < incomingLineArray.length; i++){
                if (incomingLineArray[i].equalsIgnoreCase("*")){
                    gridPlayArea[currentRow][currentCol] = 1;
                    currentCol++;
                } else if (incomingLineArray[i].equalsIgnoreCase(" ")){
                    currentCol++;
                } else {
                    System.err.println("Error in the starting configuration. Please input \" \" or \"*\" only ");
                    return;
                }
            }
        }



    }
}
