package project.tronku.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PlayActivity extends AppCompatActivity {

    private ImageView player1Hand, player2Hand;
    private TextView player1, player2;
    private Button startButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
        player1Hand = findViewById(R.id.player1_hand);
        player2Hand = findViewById(R.id.player2_hand);
        startButton = findViewById(R.id.start_button);

        Intent intent = getIntent();
        final String player1Name = intent.getStringExtra("player1");
        final String player2Name = intent.getStringExtra("player2");
        player1.setText(player1Name);
        player2.setText(player2Name);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                start(player1Name, player2Name);
            }
        });
    }

    private void start(String player1Name, String player2Name) {
        Random random = new Random();
        int firstHand = random.nextInt(3);
        int secondHand = random.nextInt(3);

        setImage(firstHand, player1Hand);
        setImage(secondHand, player2Hand);

        int winnerCode = checkForWinner(firstHand, secondHand);
        String message = "";
        if (winnerCode==0)
            message = "It's a tie!";
        else if (winnerCode==1)
            message = player1Name + " won!";
        else
            message = player2Name + " won!";

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private int checkForWinner(int firstHand, int secondHand) {
        if (firstHand == secondHand)
            return 0;
        else if (firstHand==0 && secondHand==1) //stone - paper
            return 2;
        else if (firstHand==0 && secondHand==2) //stone - scissor
            return 1;
        else if (firstHand==1 && secondHand==0) //paper - stone
            return 1;
        else if (firstHand==1 && secondHand==2) //paper - scissor
            return 2;
        else if (firstHand==2 && secondHand==0) // scissor - stone
            return 2;
        else // scissor - paper
            return 1;
    }

    private void setImage(int hand, ImageView playerHand) {
        switch (hand) {
            case 0: playerHand.setImageResource(R.drawable.stone);
                    break;
            case 1: playerHand.setImageResource(R.drawable.paper);
                    break;
            case 2: playerHand.setImageResource(R.drawable.scissor);
                    break;
        }

        playerHand.setVisibility(View.VISIBLE);
    }

}
