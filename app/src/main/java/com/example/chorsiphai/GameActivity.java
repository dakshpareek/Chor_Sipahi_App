package com.example.chorsiphai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.VerifiedInputEvent;
import android.view.View;
import android.widget.TextView;

import com.example.chorsiphai.pojo.Game;

public class GameActivity extends AppCompatActivity {

    TextView gameCodeText;
    TextView player1;
    TextView player2;
    TextView player3;
    TextView player4;
    TextView turns;

    public void cancelGame(View view)
    {

    }

    public void rollCards(View view)
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        gameCodeText = findViewById(R.id.gameIdTextView);
        turns = findViewById(R.id.turnsView);

        player1 = findViewById(R.id.player1Name);
        /*
        player2 = findViewById(R.id.player2View);
        player3 = findViewById(R.id.player3View);
        player4 = findViewById(R.id.player4View);


         */
        Intent i = getIntent();
        Game game = (Game)i.getSerializableExtra("gameObject");

        //Set Game Code
        gameCodeText.setText("Game Code: "+game.getGameCode());

        //Set Initial Turns
        turns.setText(""+game.getTurnsRemaining());

        //Set Player 1 Details
        player1.setText(game.getPlayer1().name);

    }
}