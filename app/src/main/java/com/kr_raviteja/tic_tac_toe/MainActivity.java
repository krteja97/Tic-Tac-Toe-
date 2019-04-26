package com.kr_raviteja.tic_tac_toe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int count;
    int user_score;
    int bot_score;
    int[] slots = new int[10];

    MainActivity() {
        this.count = 0;
        user_score = 0;
        bot_score = 0;
        for(int i=0;i<10;i++)
        {
            this.slots[i] = 0;
        }
    }

    public int check_finished() {

        if(slots[1] == 1 && slots[2] == 1 && slots[3] == 1)
            return 1;
        if(slots[4] == 1 && slots[5] == 1 && slots[6] == 1)
            return 1;
        if(slots[7] == 1 && slots[8] == 1 && slots[9] == 1)
            return 1;
        if(slots[1] == 1 && slots[4] == 1 && slots[7] == 1)
            return 1;
        if(slots[2] == 1 && slots[5] == 1 && slots[8] == 1)
            return 1;
        if(slots[3] == 1 && slots[6] == 1 && slots[9] == 1)
            return 1;
        if(slots[1] == 1 && slots[5] == 1 && slots[9] == 1)
            return 1;
        if(slots[3] == 1 && slots[5] == 1 && slots[7] == 1)
            return 1;

        if(slots[1] == 2 && slots[2] == 2 && slots[3] == 2)
            return 2;
        if(slots[4] == 2 && slots[5] == 2 && slots[6] == 2)
            return 2;
        if(slots[7] == 2 && slots[8] == 2 && slots[9] == 2)
            return 2;
        if(slots[1] == 2 && slots[4] == 2 && slots[7] == 2)
            return 2;
        if(slots[2] == 2 && slots[5] == 2 && slots[8] == 2)
            return 2;
        if(slots[3] == 2 && slots[6] == 2 && slots[9] == 2)
            return 2;
        if(slots[1] == 2 && slots[5] == 2 && slots[9] == 2)
            return 2;
        if(slots[3] == 2 && slots[5] == 2 && slots[7] == 2)
            return 2;



        return 0;
    }

    public void setalltobegin() {
        count = 0;
        for(int i=0;i<10;i++) {
            slots[i] = 0;
        }

        Button btn;
        btn = (Button)findViewById(R.id.button1);
        btn.setText("");
        btn = (Button)findViewById(R.id.button2);
        btn.setText("");
        btn = (Button)findViewById(R.id.button3);
        btn.setText("");
        btn = (Button)findViewById(R.id.button4);
        btn.setText("");
        btn = (Button)findViewById(R.id.button5);
        btn.setText("");
        btn = (Button)findViewById(R.id.button6);
        btn.setText("");
        btn = (Button)findViewById(R.id.button7);
        btn.setText("");
        btn = (Button)findViewById(R.id.button8);
        btn.setText("");
        btn = (Button)findViewById(R.id.button9);
        btn.setText("");

    }

    public void press_button(View view) {
        Button b = (Button) view;
        String text = b.getText().toString();

        if(text == "") {
            b.setText("O");
            count++;

            switch(view.getId()) {
                case R.id.button1:
                    slots[1] = 1;
                    break;
                case R.id.button2:
                    slots[2] = 1;
                    break;
                case R.id.button3:
                    slots[3] = 1;
                    break;
                case R.id.button4:
                    slots[4] = 1;
                    break;
                case R.id.button5:
                    slots[5] = 1;
                    break;
                case R.id.button6:
                    slots[6] = 1;
                    break;
                case R.id.button7:
                    slots[7] = 1;
                    break;
                case R.id.button8:
                    slots[8] = 1;
                    break;
                case R.id.button9:
                    slots[9] = 1;
                    break;
            }

            int isfinished = check_finished();
            if(isfinished == 1) {
                //user winsL
                Toast.makeText(MainActivity.this,"User wins",Toast.LENGTH_LONG).show();
                setalltobegin();
                user_score++;

                TextView t_user = (TextView) findViewById(R.id.user_score);
                t_user.setText(Integer.toString(user_score));
            }

            else if(isfinished == 2) {
                //computer wins
                Toast.makeText(MainActivity.this,"Computer wins",Toast.LENGTH_LONG).show();
                setalltobegin();
                bot_score++;

                TextView t_bot = (TextView) findViewById(R.id.bot_score);
                t_bot.setText(Integer.toString(bot_score));
            }



            else if(isfinished == 0 && count < 9) {

                Random rand = new Random();
                int n;

                do {
                    n = rand.nextInt(9) + 1;
                }
                while(slots[n] != 0);


                if(slots[n] == 0) {

                    slots[n] = 2;
                    count++;
                    Button btn;
                    switch(n) {
                        case 1:
                            btn = (Button)findViewById(R.id.button1);
                            btn.setText("X");
                            break;
                        case 2:
                            btn = (Button)findViewById(R.id.button2);
                            btn.setText("X");
                            break;
                        case 3:
                            btn = (Button)findViewById(R.id.button3);
                            btn.setText("X");
                            break;
                        case 4:
                            btn = (Button)findViewById(R.id.button4);
                            btn.setText("X");
                            break;
                        case 5:
                            btn = (Button)findViewById(R.id.button5);
                            btn.setText("X");
                            break;
                        case 6:
                            btn = (Button)findViewById(R.id.button6);
                            btn.setText("X");
                            break;
                        case 7:
                            btn = (Button)findViewById(R.id.button7);
                            btn.setText("X");
                            break;
                        case 8:
                            btn = (Button)findViewById(R.id.button8);
                            btn.setText("X");
                            break;
                        case 9:
                            btn = (Button)findViewById(R.id.button9);
                            btn.setText("X");
                            break;
                    }

                    int checkfinished = check_finished();
                    if(checkfinished == 2) {
                        Toast.makeText(MainActivity.this,"Computer wins",Toast.LENGTH_LONG).show();
                        setalltobegin();
                    }
                }
            }

            if(count == 9) {
                Toast.makeText(MainActivity.this,"Drawww",Toast.LENGTH_LONG).show();
                setalltobegin();
            }

        }




    }
}


