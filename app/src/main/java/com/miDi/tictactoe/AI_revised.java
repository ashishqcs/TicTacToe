package com.miDi.tictactoe;

public class AI_revised {

    public static int[] bstMove;
    //public static int[][] bstMoveScore;

    public static void bestMove(int[][] state, int rounds){

        bstMove = new int[2];
        //bstMoveScore = new int[3][3];
        int val = max_value(state , rounds);
    }

    public static int max_value(int[][] state , int rounds) {

        if (GameMechanics.playerWin(state) || GameMechanics.cpuWin(state) || rounds ==9){

            return GameMechanics.getScore(state);
        }

        int[][] scoreBoard = new int[][]{{-20,-20,-20},{-20,-20,-20},{-20,-20,-20}};

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){

                if(state[i][j] == -1){

                    state[i][j] = 0;
                    scoreBoard[i][j] = min_value(state,rounds+1);
                    state[i][j] = -1;
                }
            }
        }

        //bstMoveScore = scoreBoard;

        return max(scoreBoard);
    }

    public static int min_value(int[][] state , int rounds) {

        if(GameMechanics.playerWin(state) || GameMechanics.cpuWin(state) || rounds == 9){

            int val = GameMechanics.getScore(state);
            return val;
        }

        int[][] scoreBoard = new int[][]{{-20,-20,-20},{-20,-20,-20},{-20,-20,-20}};

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){

                if(state[i][j] == -1){

                    state[i][j] = 1;
                    scoreBoard[i][j] = max_value(state,rounds+1);
                    state[i][j] = -1;
                }
            }
        }
         return min(scoreBoard);
    }

    private static int max(int[][] scoreBoard) {

        int maxVal = -10000000;

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){

                if(scoreBoard[i][j] > maxVal && scoreBoard[i][j] != -20){

                    maxVal = scoreBoard[i][j];
                    bstMove[0] = i;
                    bstMove[1] = j;
                }
            }
        }

        return maxVal;

    }

    private static int min(int[][] scoreBoard) {

        int minVal = 10000000;

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){

                if(scoreBoard[i][j] < minVal && scoreBoard[i][j] != -20){

                    minVal = scoreBoard[i][j];
                    bstMove[0] = i;
                    bstMove[1] = j;
                }
            }
        }

        return minVal;
    }
}
