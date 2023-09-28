package com.punchy.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private GameChoice userChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void triggerComputerChoiceAndGameOutcome() {
        int randomInt = new Random().nextInt(GameChoice.values().length);
        GameChoice computerChoice = GameChoice.values()[randomInt];
        setComputerChoiceImage(computerChoice);

        GameOutcome outcome = GameChoice.calculateGameOutcome(userChoice, computerChoice);
        setOutcomeText(outcome);
    }

    private void setOutcomeText(GameOutcome outcome) {
        TextView outcomeView = findViewById(R.id.ResultView);
        switch (outcome) {
            case LOST:
                outcomeView.setText("You lost bro");
                break;
            case TIE:
                outcomeView.setText("It's a tie my friends");
                break;
            case WON:
                outcomeView.setText("You've won! Congrats");
                break;
        }
    }

    private void setComputerChoiceImage(GameChoice computerChoice) {
        ImageView computerChoiceView = findViewById(R.id.ComputerChoiceView);
        switch (computerChoice) {
            case ROCK:
                computerChoiceView.setImageResource(R.drawable.rock);
                break;
            case PAPER:
                computerChoiceView.setImageResource(R.drawable.paper);
                break;
            case SCISSORS:
                computerChoiceView.setImageResource(R.drawable.scissors);
                break;
        }
    }

    public void chooseRock(View view) {
        userChoice = GameChoice.ROCK;
        triggerComputerChoiceAndGameOutcome();
    }

    public void choosePaper(View view) {
        userChoice = GameChoice.PAPER;
        triggerComputerChoiceAndGameOutcome();
    }

    public void chooseScissors(View view) {
        userChoice = GameChoice.SCISSORS;
        triggerComputerChoiceAndGameOutcome();
    }
}