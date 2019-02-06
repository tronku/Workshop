package project.tronku.workshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity {

    private EditText player1, player2;
    private Button proceedButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        player1 = findViewById(R.id.player_1_name);
        player2 = findViewById(R.id.player_2_name);
        proceedButton = findViewById(R.id.proceed_button);
    }

    public void proceed(View view) {
        String player1Name = player1.getText().toString();
        String player2Name = player2.getText().toString();

        //check data for validation
        if (player1Name.isEmpty() || player2Name.isEmpty())
            Toast.makeText(this, "Please enter details", Toast.LENGTH_SHORT).show(); // here this points to NameActivity only
        else {
            // will do later, new Activity!!!
        }

    }
}
