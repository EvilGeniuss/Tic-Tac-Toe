package evilgenius.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by nikis on 8.6.2016 г..
 */
public class GameActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    boolean move = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        SetButtonOnClickListener(button1);
        SetButtonOnClickListener(button2);
        SetButtonOnClickListener(button3);
        SetButtonOnClickListener(button4);
        SetButtonOnClickListener(button5);
        SetButtonOnClickListener(button6);
        SetButtonOnClickListener(button7);
        SetButtonOnClickListener(button8);
        SetButtonOnClickListener(button9);
        ShowCurrentPlayer();
    }


    public void SetButtonOnClickListener(final Button button)
    {
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button.setText(move ? "X" : "O");
                button.setEnabled(false);
                move = !move;
                ShowCurrentPlayer();
                ShowGameResultIfCompleted();
            }
        });
    }

    public void ShowGameResultIfCompleted() {
        CharSequence winner = "";

        if (button1.getText() == button2.getText() && button1.getText() == button3.getText()) {
            winner = button1.getText();
        } else if (button4.getText() == button5.getText() && button4.getText() == button6.getText()) {
            winner = button4.getText();
        } else if (button7.getText() == button8.getText() && button7.getText() == button9.getText()) {
            winner = button7.getText();
        } else if (button1.getText() == button4.getText() && button4.getText() == button7.getText()) {
            winner = button4.getText();
        } else if (button2.getText() == button5.getText() && button2.getText() == button8.getText()) {
            winner = button2.getText();
        } else if (button3.getText() == button6.getText() && button3.getText() == button9.getText()) {
            winner = button3.getText();
        } else if (button1.getText() == button5.getText() && button1.getText() == button9.getText()) {
            winner = button1.getText();
        } else if (button3.getText() == button5.getText() && button3.getText() == button7.getText()) {
            winner = button3.getText();
        }

        if (winner != "") {
            Intent intent = new Intent(this, WinActivity.class);
            intent.putExtra("winner", winner);
            startActivity(intent);
            ClearButtonsState();
        } else {
            boolean isGameInProgress = button1.getText() == ""
                    || button2.getText() == ""
                    || button3.getText() == ""
                    || button4.getText() == ""
                    || button5.getText() == ""
                    || button6.getText() == ""
                    || button7.getText() == ""
                    || button8.getText() == ""
                    || button9.getText() == "";

            if (!isGameInProgress) {
                Intent intent = new Intent(this, DrawActivity.class);
                startActivity(intent);
                ClearButtonsState();
            }
        }

    }

    public void ShowCurrentPlayer()
    {
        TextView CurrentPlayer = (TextView)findViewById(R.id.currentPlayerTurn);
        CurrentPlayer.setText(move ? "Current Player X" : "Current Player O");
    }

    public void ClearButtonsState(){
        button1.setText("");
        button1.setEnabled(true);
        button2.setText("");
        button2.setEnabled(true);
        button3.setText("");
        button3.setEnabled(true);
        button4.setText("");
        button4.setEnabled(true);
        button5.setText("");
        button5.setEnabled(true);
        button6.setText("");
        button6.setEnabled(true);
        button7.setText("");
        button7.setEnabled(true);
        button8.setText("");
        button8.setEnabled(true);
        button9.setText("");
        button9.setEnabled(true);
    }
}
