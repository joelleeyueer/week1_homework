package src;

import java.io.*;

public class MainGOL {

    public static void main(String[] args) throws IOException {
        //1. Read and parse .gol file to a 2d array
 //       String incomingFile = System.console().readLine("Which file would you want to print?"); uncomment later
//        Reader r = new FileReader(incomingFile+".gol"); uncomment later
        Reader r = new FileReader("toad.gol"); //for testing only
        BufferedReader br = new BufferedReader(r);
        int gridRow = 0;
        int gridCol = 0;
        int startingRow = 0;
        int startingCol = 0;
        boolean isData = false;

        String incomingLine;

        //2. Iterate through the file, get the grid size and starting position
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

        //3. Initialise the grid and populate the array with zeros
        //int[][] will automatically populate array with zeros, no need to iterate
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

        //4. Print the starting generation.
        //reference: https://www.geeksforgeeks.org/program-for-conways-game-of-life/
        System.out.println("Printing the first generation");
        printBoard(gridPlayArea, gridRow, gridCol);

        //int printXGenerations = Integer.parseInt(System.console().readLine("How many more generations would you like to print? (E.g. 5)"));
        int printXGenerations = 5;
        generateNextGeneration(gridPlayArea, gridRow, gridCol, printXGenerations);


    }

    public static void generateNextGeneration(int[][] incomingGen, int gridRow, int gridCol, int numberOfGen){
        int[][] boardA = new int[gridRow][gridCol];
        boardA = incomingGen;

        for (int gen = 2; gen < numberOfGen+1; gen++){
            int[][] currentGen = new int[gridRow][gridCol];
            boardA = addBorder(boardA, gridRow, gridCol);
            for (int row = 1; row < gridRow+1; row++){
                for (int col = 1; col < gridCol+1; col++){
                    int tally = countNeighbours(boardA, row, col);
                    //https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
                    if (boardA[row][col] == 1 && (tally==2 || tally==3)) {
                        currentGen[row-1][col-1] = 1;
                    } else if (boardA[row][col] == 0 && tally==3) {
                        currentGen[row-1][col-1] = 1;
                    } else {
                        currentGen[row-1][col-1] = 0;
                    }
                }
            }
            System.out.println("Printing generation " + gen + ":");
            printBoard(currentGen, gridRow, gridCol);
            boardA = currentGen;
        }

    }

    public static int countNeighbours(int[][] incomingGen, int rowCell, int colCell){
        int neighbours = 0;
        for (int row = -1; row <= 1; row++){
            for (int col = -1; col <= 1; col++){
                if (row==0 && col==0){
                    continue;
                }
                if (incomingGen[rowCell+row][colCell+col] == 1){
                    neighbours++;
                }
            }
        }
        return neighbours;
    }

    public static int[][] addBorder(int[][] incomingGen, int gridRow, int gridCol){
        int[][] neighbourCheck = new int[gridRow+2][gridCol+2];
        //add a 'border' to the array
        for (int i = 1; i < gridRow+1; i++){
            for (int j = 1; j < gridCol+1; j++){
                neighbourCheck[i][j] = incomingGen[i-1][j-1];
            }
        }
        return neighbourCheck;
    }

    public static void printBoard(int[][] incomingGen, int gridRow, int gridCol){
        for (int row = 0; row < gridRow; row++){
            String newRow = "";
            for (int col = 0; col < gridCol; col++){
                if (incomingGen[row][col] == 1){
                    newRow += "*";
                } else if (incomingGen[row][col] == 0){
                    newRow += ".";
                }
            }
            System.out.println(newRow);
        }
    }
}
