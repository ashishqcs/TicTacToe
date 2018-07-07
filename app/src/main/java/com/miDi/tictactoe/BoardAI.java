/*
package com.miDi.tictactoe;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class BoardAI extends AppCompatActivity implements View.OnClickListener {

    private Button[][] button;
    private int[][] state;
    private static boolean pTurn , cpuTurn;
    private Button reset;
    private TextView tvScoreX,tvScoreO;
    private static int rounds = 0;
    private int scoreX, scoreO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board_ai);

        state = new int[3][3];
        button = new Button[3][3];
        tvScoreX = findViewById(R.id.score_AI_p1);
        tvScoreO = findViewById(R.id.score_AI_p2);
        reset = findViewById(R.id.btn_AI_reset);
        scoreO = 0;
        scoreX = 0;
        pTurn = true;
        cpuTurn = false;

        for (int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                state[i][j] = -1;
                String btnID = "btnAI"+i +j;
                int resID = getResources().getIdentifier(btnID,"id",getPackageName());
                button[i][j] = findViewById(resID);
                button[i][j].setOnClickListener(this);
            }

        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pTurn = true;
                cpuTurn = false;
                rounds = 0;

                for(int i=0; i<3; i++){
                    for(int j=0; j<3; j++){

                        state[i][j] = -1;
                        button[i][j].setText("");
                        button[i][j].setBackgroundColor(getResources().getColor(R.color.gray));
                        button[i][j].setEnabled(true);
                    }
                }
            }
        });
    }
    //////////////////////////ON CLICK/////////////////////////////////////////

    @Override
    public void onClick(final View v) {

        rounds++;

        int i = 0, j =0 ;
        int id = v.getId();
        int resID = 0;
        for(i=0; i<3; i++) {
            for (j = 0; j < 3; j++) {
                String Btnid = "btn"+i+j;
                resID = getResources().getIdentifier(Btnid, "id", getPackageName());

                if (id == resID){
                    break;
                }
            }

            if (id == resID){
                break;
            }
        }

        if (state[i][j] != -1){

            ((Button)v).setBackgroundColor(getResources().getColor(R.color.red));
            new CountDownTimer(100, 10) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {

                    ((Button)v).setBackgroundColor(getResources().getColor(R.color.white));
                }
            }.start();

            return;
        }

        if (pTurn){

                ((Button)v).setText("X");
                ((Button)v).setBackgroundColor(getResources().getColor(R.color.white));
                state[i][j] = 1;
                // Toast.makeText(this,""+i+" "+j, Toast.LENGTH_SHORT).show();
        }
        else cpuPlay();


        if (pTurn && GameMechanics.playerWin(state)){

            scoreX++;
            Toast.makeText(this, "Player Wins", Toast.LENGTH_SHORT).show();
            endGame();

        }
        if (cpuTurn && GameMechanics.cpuWin(state)){

            scoreO++;
            Toast.makeText(this, "CPU wins", Toast.LENGTH_SHORT).show();
            endGame();
        }
        else if (rounds == 9){

            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
            for(int x=0; x<3; x++){

                for(int y=0; y<3; y++){

                    button[x][y].setEnabled(false);
                }
            }
        }

        switchTurn();
    }

    private void cpuPlay(){

        int[] bstMove = AI.max_value(state);
        state[bstMove[0]][bstMove[1]] = 0;
        button[bstMove[0]][bstMove[1]].setText("O");
        button[bstMove[0]][bstMove[1]].setBackgroundColor(getResources().getColor(R.color.white));

    }

    private void endGame() {
        int x,y;
        tvScoreX.setText(Integer.toString(scoreX));
        tvScoreO.setText(Integer.toString(scoreO));

        for(int i=0; i<3; i++){

            x = GameMechanics.ROW[i];
            y = GameMechanics.COL[i];

            button[x][y].setBackgroundColor(getResources().getColor(R.color.green));

            for(int j=0; j<3; j++){

                button[i][j].setEnabled(false);
            }
        }

    }

    private void switchTurn(){

        cpuTurn = pTurn;
        pTurn = !cpuTurn;
    }

    @Override
    protected void onStop() {
        super.onStop();

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                state[i][j] = -1;
                rounds = 0;
            }
        }
    }
}
*/
