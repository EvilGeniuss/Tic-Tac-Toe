package evilgenius.tic_tac_toe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context = this;
        Button start = (Button)findViewById(R.id.playButton);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(context, GameActivity.class);
                startActivity(i);
            }
        });
    }
}