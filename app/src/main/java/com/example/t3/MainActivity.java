package com.example.t3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.t3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setListeners();
    }

    View.OnClickListener OnclickListener(TextView view) {
        return v -> {

            view.setText(setXOrO());
            possibleOutcomes();
            view.setEnabled(false);
            if(binding.tapToContinue.getVisibility() != View.VISIBLE){
                playerTurn();
            }
        };
    }
    void OnclickListener(TextView view, TextView view2, TextView view3) {

        view.setBackground(getDrawable(R.drawable.new_bg_buttons));
        view2.setBackground(getDrawable(R.drawable.new_bg_buttons));
        view3.setBackground(getDrawable(R.drawable.new_bg_buttons));

        checkWin();
        continueGame();
    }

    private void setListeners() {
        binding.one.setOnClickListener(OnclickListener(binding.one));
        binding.two.setOnClickListener(OnclickListener(binding.two));
        binding.three.setOnClickListener(OnclickListener(binding.three));
        binding.four.setOnClickListener(OnclickListener(binding.four));
        binding.five.setOnClickListener(OnclickListener(binding.five));
        binding.six.setOnClickListener(OnclickListener(binding.six));
        binding.seven.setOnClickListener(OnclickListener(binding.seven));
        binding.eight.setOnClickListener(OnclickListener(binding.eight));
        binding.nine.setOnClickListener(OnclickListener(binding.nine));
    }

    public String setXOrO() {
        String XO = "X";
        if (!binding.player.getText().equals("Player 1")) {
            XO = "O";
        }
        return XO;
    }

    private void playerTurn() {
        if (binding.player.getText().equals("Player 1")) {
            binding.player.setText("Player 2");
            binding.sign.setText("O");
        } else {
            binding.player.setText("Player 1");
            binding.sign.setText("X");
        }
    }

    private void buttonColor() {

    }

    private void newGame(){

    }
    private void checkWin() {
        binding.playerWhoWins.setText(binding.player.getText() + " wins!");
        binding.playerWhoWins.setVisibility(View.VISIBLE);
    }

    private void continueGame() {
        binding.tapToContinue.setVisibility(View.VISIBLE);

        binding.tapToContinue.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void checkDraw() {

    }

    private void possibleOutcomes() {

        if ((!binding.one.getText().toString().isEmpty()) &&
                (binding.one.getText().equals(binding.two.getText()) &&
                        (binding.two.getText()).equals(binding.three.getText()))) {

            OnclickListener(binding.one, binding.two, binding.three);

        } else if ((!binding.four.getText().toString().isEmpty()) &&
                (binding.four.getText().equals(binding.five.getText()) &&
                        (binding.five.getText()).equals(binding.six.getText()))) {

            OnclickListener(binding.four, binding.five, binding.six);

        } else if ((!binding.seven.getText().toString().isEmpty()) &&
                (binding.seven.getText().equals(binding.eight.getText()) &&
                        (binding.eight.getText()).equals(binding.nine.getText()))) {

            OnclickListener(binding.seven, binding.eight, binding.nine);

        } else if ((!binding.one.getText().toString().isEmpty()) &&
                (binding.one.getText().equals(binding.four.getText()) &&
                        (binding.four.getText()).equals(binding.seven.getText()))) {

            OnclickListener(binding.one, binding.four, binding.seven);

        } else if ((!binding.two.getText().toString().isEmpty()) &&
                (binding.two.getText().equals(binding.five.getText()) &&
                        (binding.five.getText()).equals(binding.eight.getText()))) {

            OnclickListener(binding.two, binding.five, binding.eight);

        } else if ((!binding.three.getText().toString().isEmpty()) &&
                (binding.three.getText().equals(binding.six.getText()) &&
                        binding.six.getText().equals(binding.nine.getText()))) {

            OnclickListener(binding.three, binding.six, binding.nine);

        } else if ((!binding.one.getText().toString().isEmpty()) &&
                (binding.one.getText().equals(binding.five.getText()) &&
                        binding.five.getText().equals(binding.nine.getText()))) {

            OnclickListener(binding.one, binding.five, binding.nine);
        }
    }
}
