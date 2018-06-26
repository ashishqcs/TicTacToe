public class GameMechanics {

    public static boolean checkWin(int[][] state , int player){

        int[] val = new int[3];

        ////////////// ROW WIN//////////////////////////////
        for(int i=0; i<3; i++){

            for (int j=0; j<3; j++){

               val[j] = state[i][j];
            }

            if(val[0] == player && val[1] == player && val[2] == player){
                return true;
            }
        }

        //////////////////// COLUMN WIN///////////////////////////

        for(int i=0; i<3; i++){

            for (int j=0; j<3; j++){

               val[j] = state[j][i];
            }

            if(val[0] == player && val[1] == player && val[2] == player){
                return true;
            }
        }
        ///////////////DIAGONAL WIN////////////////////

        if(state[0][0]==player && state[1][1]==player && state[2][2]==player){

            return true;
        }

        if(state[2][0]==player && state[1][1]==player && state[0][2]==player){

            return true;
        }

        return false;
    }

        //////////////////////////// CHECK PLAYER WIN///////////////////////

    public static boolean playerWin(int[][] state){

        if(checkWin(state , 1))
            return true;

        return false;
    }

    /////////////////// CHECK CPU WIN //////////////////////////////////////

    public static boolean cpuWin(int[][] state){

        if(checkWin(state , 0))
            return true;

        return false;
    }

        /////////////////////////GET SCORE/////////////////////////////
    public static int getScore(int[][] state ){

        if (playerWin(state)){

            return -10;
        }
        if(cpuWin(state)){

            return 10;
        }

        return 0;
    }
}
