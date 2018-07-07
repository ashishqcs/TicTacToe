package com.miDi.tictactoe;

public class AI {

    public static int[] min_ij,max_ij, final_ij;

    public static void bestMove(int[][] state , int rounds){

        min_ij = new int[2];
        max_ij = new int[2];
        final_ij = new int[2];

        int[] bstMove = max_value(state , rounds);

    }

    public static int[] max_value(int[][] state , int rounds) {

        int[] bstMove = new int[2];
        if (GameMechanics.playerWin(state) || GameMechanics.cpuWin(state) || rounds == 9){

            bstMove[0] = GameMechanics.getScore(state);
            return bstMove;
        }
        bstMove[1] = -20;

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){

                if(state[i][j] == -1){

                    state[i][j] = 0;
                    max_ij[0] = i;
                    max_ij[1] = j;
                    bstMove = max(bstMove, min_value(state, rounds+1));
                    state[i][j] = -1;
                }
            }
        }

        return bstMove;
    }

    public static int[] min_value(int[][] state , int rounds) {

        int[] bstMove = new int[2];
        if(GameMechanics.playerWin(state) || GameMechanics.cpuWin(state) || rounds == 9){

            bstMove[0] = GameMechanics.getScore(state);
            return bstMove;
        }

        bstMove[1] = 20;

        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){

                if(state[i][j] == -1){

                    state[i][j] = 1;
                    min_ij[0] = i;
                    min_ij[1] = j;
                    bstMove = min(bstMove, max_value(state,rounds+1));
                    state[i][j] = -1;
                }
            }
        }

        return bstMove;

    }

    private static int[] max(int[] a, int[] b) {

        if (a[0] > b[0]){

            a[1] = a[1] + b[1];
            final_ij = max_ij;
            return a;
        }

       if (b[0] > a[0]){

            b[1] = a[1] + b[1];
            final_ij = min_ij;
            return b;
        }

        if (a[1] < b[1]){

            final_ij = min_ij;
            b[1] += a[1];
            return b;
        }

        final_ij = max_ij;
        a[1] += b[1];
        return a;

    }

    private static int[] min(int[] a, int[] b) {

        if (a[0] < b[0]) {

            final_ij = min_ij;
            return a;
        }


            final_ij = max_ij;
            return b;

    }

}













