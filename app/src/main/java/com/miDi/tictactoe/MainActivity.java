package com.miDi.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnPvP , btnCPU;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCPU = findViewById(R.id.cpu);
        btnPvP = findViewById(R.id.pvp);

        btnCPU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this , Board.class);
                i.putExtra("type" , "cpu");
                startActivity(i);
            }
        });

        btnPvP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this , Board.class);
                i.putExtra("type" , "pvp");
                startActivity(i);
            }
        });
    }
}
