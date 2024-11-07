package com.example.gamblinggame;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView Title;
    private TextView[] Dice = new TextView[5];
    private TextView ScoreCurrentThrow;
    private TextView GameScore;
    private TextView ThrowCounter;
    private Button ThrowDices;
    private Button ResetButton;

    private int Score = 0;
    private int NumberOfThrows = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Title = findViewById(R.id.Title);
        Dice[0] = findViewById(R.id.Dice1);
        Dice[1] = findViewById(R.id.Dice2);
        Dice[2] = findViewById(R.id.Dice3);
        Dice[3] = findViewById(R.id.Dice4);
        Dice[4] = findViewById(R.id.Dice5);
        ScoreCurrentThrow = findViewById(R.id.ScoreCurrentThrow);
        GameScore = findViewById(R.id.GameScore);
        ThrowCounter = findViewById(R.id.ThrowCounter);
        ThrowDices = findViewById(R.id.ThrowDices);
        ResetButton = findViewById(R.id.ResetButton);

        ThrowDices.setOnClickListener(v -> DiceThrow());
        ResetButton.setOnClickListener(v -> GameReset());
    }

    private void DiceThrow() {
        int[] diceResults = new int[6];
        int totalScore = 0;

        for (int i = 0; i < 5; i++) {
            int diceRoll = (int) (Math.random() * 6) + 1;
            Dice[i].setText(String.valueOf(diceRoll));
            diceResults[diceRoll - 1]++;
        }

        for (int i = 0; i < diceResults.length; i++) {
            if (diceResults[i] > 1) {
                totalScore += (i + 1) * diceResults[i];
            }
        }

        ScoreCurrentThrow.setText("Wynik tego losowania: " + totalScore);
        NumberOfThrows++;
        ThrowCounter.setText("Liczba rzutów: " + NumberOfThrows);

        Score += totalScore;
        GameScore.setText("Wynik Gry: " + Score);
    }

    private void GameReset() {
        Score = 0;
        NumberOfThrows = 0;

        ScoreCurrentThrow.setText("Wynik tego losowania: 0");
        GameScore.setText("Wynik Gry: 0");
        ThrowCounter.setText("Liczba rzutów: 0");

        for (TextView kosciText : Dice) {
            kosciText.setText("");
        }
    }
}

