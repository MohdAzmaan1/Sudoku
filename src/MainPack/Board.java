/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainPack;

import java.util.*;

/**
 *
 * @author mohda
 */ 
public class Board {

    // An AL of the three ALs below
    ArrayList<ArrayList<int[]>> allLinesAL = new ArrayList<ArrayList<int[]>>();

    // An AL of Arrays set to accept 3 arrays.
    ArrayList<int[]> firstLineOfThree = new ArrayList<int[]>(3);
    ArrayList<int[]> secondLineOfThree = new ArrayList<int[]>(3);
    ArrayList<int[]> thirdLineOfThree = new ArrayList<int[]>(3);

    // Integer arrays which represent each row of the Sudoku Game.
    private int[] lineOne = {2, 9, 6, 3, 1, 8, 5, 7, 4};
    private int[] lineTwo = {5, 8, 4, 9, 7, 2, 6, 1, 3};
    private int[] lineThree = {7, 1, 3, 6, 4, 5, 2, 8, 9};
    private int[] lineFour = {6, 2, 5, 8, 9, 7, 3, 4, 1};
    private int[] lineFive = {9, 3, 1, 4, 2, 6, 8, 5, 7};
    private int[] lineSix = {4, 7, 8, 5, 3, 1, 9, 2, 6};
    private int[] lineSeven = {1, 6, 7, 2, 5, 3, 4, 9, 8};
    private int[] lineEight = {8, 5, 9, 7, 6, 4, 1, 3, 2};
    private int[] lineNine = {3, 4, 2, 1, 8, 9, 7, 6, 5};

    private int[][] finalBoard = new int[9][9];

    /**
     * {@code getFinalBoard} produces the a two-dimensional integer array, {@code finalBoard}, to produce
     * @return
     */
    public int[][] getFinalBoard(){
        return finalBoard;
    }


    // Constructs Sudoku Board
    public Board(){

        initializeLinesOfThrees(lineOne, lineTwo, lineThree, lineFour, lineFive, lineSix, lineSeven, lineEight,
                lineNine);

        initializeLinesOfThrees(allLinesAL);

        createBoard();

        hideBoardValues();
    }

    /**
     * {@code constructLinesFromAL} consumes an ArrayList of arrays of ints, {@code al}, and an integer,
     * {@code rowCounter}, and adds it to the final 2d board.
     *
     * @param al The ArrayList with the arrays within it
     * @param rowCounter Additional information needed to determine which row should receive data
     */
    private void constructLinesFromAL(ArrayList<int[]> al, int rowCounter){
        for (int alIndex = 0; alIndex < 3; alIndex++){
            for (int i = 0; i < 9; i++){
                // Ensures that the elements are placed in the proper coordinates of the 2D Array
                finalBoard[rowCounter + alIndex][i] = al.get(alIndex)[i];
            }
        }
    }

    /**
     * {@code createBoard} creates a 2D array of integers after all randomization has been done to the pre-existing
     * board.
     *
     */
    private void createBoard() {
        constructLinesFromAL(firstLineOfThree, 0);
        constructLinesFromAL(secondLineOfThree, 3);
        constructLinesFromAL(thirdLineOfThree, 6);
    }

    /**
     * {@code randomizeRows} uses the three ArrayList of integer arrays, {@code firstLineOfThree},
     * {@code secondLineOfThree} and {@code thirdLineOfThree} and shuffles the integer arrays around while also not
     * breaking the sudoku game laws
     *
     */

    // 0 Values will be placed on board which mimic and empty cell on traditional sudoku boards
    private void hideBoardValues(){
        // any algorithm for hiding the values

        for (int row = 0; row < 9; row++){
            int zeroesToMake = (int) (Math.random() * 3) + 3; // Produces a random int from 3-5.
            double rngTemp;
            double removeZeroChance;

            for (int col = 0; col < 9; col++){
                rngTemp = Math.random();
                removeZeroChance = (double) zeroesToMake / (double) (9 - col);
                // Percent chance determining if we should remove 0
                
                if (removeZeroChance <= rngTemp) {
                    zeroesToMake--;
                    finalBoard[row][col] = 0;
                }
            }
        }
    }

    /**
     * {@code randomizeColumns} does the same thing as {@code randomizeRows}, but first makes the columns into rows.
     *
     */


    private void initializeLinesOfThrees(int[] lineOne, int[] lineTwo, int[] lineThree, int[] lineFour, int[] lineFive,
                                         int[] lineSix, int[] lineSeven, int[] lineEight, int[] lineNine){

        firstLineOfThree.clear();
        secondLineOfThree.clear();
        thirdLineOfThree.clear();

        // Initialize all linesOfThrees
        firstLineOfThree.add(lineOne);
        firstLineOfThree.add(lineTwo);
        firstLineOfThree.add(lineThree);

        secondLineOfThree.add(lineFour);
        secondLineOfThree.add(lineFive);
        secondLineOfThree.add(lineSix);

        thirdLineOfThree.add(lineSeven);
        thirdLineOfThree.add(lineEight);
        thirdLineOfThree.add(lineNine);
    }


    private void initializeLinesOfThrees(ArrayList<ArrayList<int[]>> al){

        for (int i = 0; i < al.size(); i++ ){

            if (i == 0){
                firstLineOfThree = al.get(i);
            } else if (i == 1) {
                secondLineOfThree = al.get(i);
            } else {
                thirdLineOfThree = al.get(i);
            }
        }
    }
}
