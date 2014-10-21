package com.wilsonkoder.therandomnumber;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class mainActivity extends Activity {

    public int randomNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonGuess = (Button)findViewById(R.id.buttonGuess);
        Button buttonNewNumber = (Button)findViewById(R.id.buttonNewNumber);
        final EditText editTextNumber = (EditText)findViewById(R.id.textFieldNumber);
        final TextView textViewMessage = (TextView)findViewById(R.id.textViewMessage);

        buttonNewNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int min = 1;
                int max = 101;
                Random rand = new Random();
                randomNum = rand.nextInt((max - min) + 1) + min;

            }
        });

        buttonGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tempVal = editTextNumber.getText().toString();
                int value = Integer.parseInt(tempVal);
                if(value < randomNum)
                {
                    textViewMessage.setText("A bit higher!");
                    textViewMessage.setTextColor(Color.rgb(255, 0, 0));
                }
                else if(value > randomNum)
                {
                    textViewMessage.setText("A bit lower!");
                    textViewMessage.setTextColor(Color.rgb(0, 255, 0));
                }
                else if(value == randomNum)
                {
                    textViewMessage.setText("You Win!");
                    textViewMessage.setTextColor(Color.rgb(0, 255, 0));
                }

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
