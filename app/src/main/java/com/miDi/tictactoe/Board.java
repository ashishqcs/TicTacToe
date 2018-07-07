package com.miDi.tictactoe;

import android.content.Intent;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;

public class Board extends AppCompatActivity implements View.OnClickListener {

    private static boolean p1Turn , p2Turn;
    private static int[][] state;
    private Button[][] button;
    private Button reset;
    private TextView tvScoreX,tvScoreO;
    private String gameType;
    private static int rounds = 0;
    int scoreX, scoreO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        state = new int[3][3];
        button = new Button[3][3];
        tvScoreX = findViewById(R.id.score_x);
        tvScoreO = findViewById(R.id.score_o);
        reset = findViewById(R.id.btn_reset);
        scoreO = 0;
        scoreX = 0;

        gameType = getIntent().getExtras().getString("type");

        p1Turn = true;
        p2Turn = false;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                state[i][j] = -1;
                String buttonID = "btn"+i +j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                button[i][j] = findViewById(resID);

                button[i][j].setOnClickListener(this);

            }
        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                p1Turn = true;
                p2Turn = false;
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

        int i = 0, j = 0;
        int id = v.getId();
        int resID = 0;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                String Btnid = "btn" + i + j;
                resID = getResources().getIdentifier(Btnid, "id", getPackageName());

                if (id == resID) {
                    break;
                }
            }

            if (id == resID) {
                break;
            }
        }
        if (state[i][j] != -1) {

            ((Button) v).setBackgroundColor(getResources().getColor(R.color.red));
            new CountDownTimer(100, 10) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {

                    ((Button) v).setBackgroundColor(getResources().getColor(R.color.white));
                }
            }.start();

            return;
        }

        if (p1Turn) {

            state[i][j] = 1;
            ((Button) v).setText("X");
            rounds++;
            ((Button) v).setBackgroundColor(getResources().getColor(R.color.white));
            // Toast.makeText(this,""+i+" "+j, Toast.LENGTH_SHORT).show();
            if (GameMechanics.playerWin(state)) {

                scoreX++;
                Toast.makeText(this, "Player X Wins", Toast.LENGTH_SHORT).show();
                endGame();

            }
        }
        if (p2Turn) {

            state[i][j] = 0;
            ((Button) v).setText("O");
            rounds++;
            ((Button) v).setBackgroundColor(getResources().getColor(R.color.white));
            //Toast.makeText(this,""+i+" "+j, Toast.LENGTH_SHORT).show();
            if (GameMechanics.cpuWin(state)) {

                scoreO++;
                Toast.makeText(this, "Player O Wins", Toast.LENGTH_SHORT).show();
                endGame();

            }
        }

        if (rounds == 9 && !GameMechanics.cpuWin(state) && !GameMechanics.playerWin(state)) {

            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show();
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {

                    button[x][y].setEnabled(false);
                }
            }
        }

        if (gameType.equals("cpu") /*&& p1Turn */&& rounds<9) {

            cpuPlay();
            rounds++;
            switchTurn();
            if (GameMechanics.cpuWin(state)) {

                scoreO++;
                Toast.makeText(this, "CPU Wins", Toast.LENGTH_SHORT).show();
                endGame();

            }
        }

        switchTurn();

    }

    private void cpuPlay(){

         int[][] tempState = state;
         int tempRounds = rounds;
        AI_revised.bestMove(tempState , tempRounds);
        int i = AI_revised.bstMove[0];
        int j = AI_revised.bstMove[1];
        if (state[i][j] == -1){

            state[i][j] = 0;
            button[i][j].setText("O");
            button[i][j].setBackgroundColor(getResources().getColor(R.color.white));
        }
        else Toast.makeText(this, "CPU CONFUSED", Toast.LENGTH_SHORT).show();
    }

    ////////////////////////////////END GAME ///////////////////////////////////

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

        p2Turn = p1Turn;
        p1Turn = !p2Turn;
    }

    @Override
    protected void onStop() {
        super.onStop();

        rounds = 0;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                state[i][j] = -1;
            }
        }
    }
}



















