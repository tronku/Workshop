package project.tronku.workshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
}
