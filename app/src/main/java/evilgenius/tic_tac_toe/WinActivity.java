package evilgenius.tic_tac_toe;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by nikis on 8.6.2016 г..
 */
public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        Intent intent = getIntent();
        String winner = intent.getStringExtra("winner");

        TextView winTextView = (TextView)findViewById(R.id.wintxt);
        winTextView.setText(winner);

        Button winButton = (Button)findViewById(R.id.play_again);

        winButton.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View v) {
                finish();
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBackPressed() {
        finish();
    }
}
