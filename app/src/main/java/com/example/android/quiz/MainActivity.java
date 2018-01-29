package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //**This method is called when button is clicked

    public void submitTest(View view) {


        /**
         * gets customer name from name field
         *
         */
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        Log.v("MainActivity", "Name" + name);


        RadioButton questionOne = (RadioButton) findViewById(R.id.answer_1);
        boolean answerQ1 = questionOne.isChecked();

        RadioButton questionTwo = (RadioButton) findViewById(R.id.answer_2);
        boolean answerQ2 = questionTwo.isChecked();

        RadioButton questionThree = (RadioButton) findViewById(R.id.answer_3);
        boolean answerQ3 = questionThree.isChecked();

        RadioButton questionFour = (RadioButton) findViewById(R.id.answer_4);
        boolean answerQ4 = questionFour.isChecked();

        RadioButton questionFive = (RadioButton) findViewById(R.id.answer_5);
        boolean answerQ5 = questionFive.isChecked();


        Log.v("MainActivity", "Score" + answerQ1 + answerQ2 + answerQ3 + answerQ4);




        int finalScore = calculateScore(answerQ1,answerQ2,answerQ3,answerQ4,answerQ5);

        displayMessage(getString(R.string.final_score_message ) + finalScore + " / 5 " + name);

    }


    /**
     * calculates the score results of the test
     *
     * @param answerQ1 answer for 1st Q
     * @param answerQ2 answer for 2nd Q
     * @param answerQ3 answer for 3rd Q
     * @param answerQ4 answer for 4th Q
     * @param answerQ5 answer for 5th Q
     */
    private int calculateScore(boolean answerQ1, boolean answerQ2, boolean answerQ3, boolean answerQ4, boolean answerQ5) {
        // base score of the test

        int startScore = 0;

        if (answerQ1) {
            startScore = startScore + 1;
        }
        if (answerQ2) {
            startScore = startScore + 1;
        }
        if (answerQ3) {
            startScore = startScore + 1;
        }
        if (answerQ4) {
            startScore = startScore + 1;
        }
        if (answerQ5) {
            startScore = startScore + 1;
        }
        if (startScore==5){
            Toast.makeText(this, getString(R.string.toast_one), Toast.LENGTH_LONG).show();
            //exit this method early as there is nothing else to do
        }
        if  (startScore ==4) {
            Toast.makeText(this,getString(R.string.toast_two),Toast.LENGTH_SHORT).show();
        }
        if (startScore <=3) {
            Toast.makeText(this,getString(R.string.toast_three) ,Toast.LENGTH_SHORT).show();

        }
        return startScore;

    }


        /**
         * This method displays the given text on the screen.
         */

    private void displayMessage(String message) {

        TextView testSummaryTextView = (TextView) findViewById(R.id.test_summary);

        testSummaryTextView.setText(message);


    }
}
