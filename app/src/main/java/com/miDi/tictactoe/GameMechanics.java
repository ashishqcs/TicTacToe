package com.miDi.tictactoe;

public class GameMechanics {

    public static int[] ROW,COL;

    public static boolean winState(int[][] state , int player){

        int[] val = new int[3];

        ////////////// ROW WIN//////////////////////////////
        for(int i=0; i<3; i++){

            ROW = new int[3];
            COL = new int[3];
            int k=0;

            for (int j=0; j<3; j++){

               val[j] = state[i][j];
               ROW[k] = i;
               COL[k] = j;
               k++;
            }

            if(val[0] == player && val[1] == player && val[2] == player){
                return true;
            }
        }

        //////////////////// COLUMN WIN///////////////////////////

        for(int i=0; i<3; i++){

            ROW = new int[3];
            COL = new int[3];
            int k=0;
            for (int j=0; j<3; j++){

               val[j] = state[j][i];
                ROW[k] = j;
                COL[k] = i;
                k++;
            }

            if(val[0] == player && val[1] == player && val[2] == player){
                return true;
            }
        }
        ///////////////DIAGONAL WIN////////////////////

        if(state[0][0]==player && state[1][1]==player && state[2][2]==player){

            ROW = new int[]{0, 1, 2};
            COL = new int[]{0, 1, 2};
            return true;
        }

        if(state[2][0]==player && state[1][1]==player && state[0][2]==player){

             ROW = new int[]{2, 1, 0};
            COL = new int[]{0, 1, 2};
            return true;
        }

        return false;
    }

        //////////////////////////// CHECK PLAYER WIN///////////////////////

    public static boolean playerWin(int[][] state){

        if(winState(state , 1))
            return true;

        return false;
    }

    /////////////////// CHECK CPU WIN //////////////////////////////////////

    public static boolean cpuWin(int[][] state){

        if(winState(state , 0))
            return true;

        return false;
    }

    ////////////////////////////GET SCORE/////////////////////////////

    public static int getScore(int[][] state){

        if (playerWin(state)){

            return -10;
        }
        if(cpuWin(state)){

            return 10;
        }

        return 0;
    }
}
