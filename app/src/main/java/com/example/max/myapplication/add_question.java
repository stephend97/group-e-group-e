package com.example.max.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by sarahpomeroy on 4/3/18.
 */

public class add_question extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_question);
    }

    Quiz quiz1 = new Quiz();

    public void onButtonClick(View v) {

        if(v.getId() == R.id.Bsave) {

            TextView tv1 = findViewById(R.id.ETchoice1);
            String str1 = tv1.getText().toString();

            TextView tv2 = findViewById(R.id.ETchoice2);
            String str2 = tv2.getText().toString();

            TextView tv3 = findViewById(R.id.ETchoice3);
            String str3 = tv3.getText().toString();

            TextView tv4 = findViewById(R.id.ETchoice4);
            String str4 = tv4.getText().toString();

            Question q1 = new Question();

            q1.setQuest(str1);

            q1.setChoiceList(str1);
            q1.setChoiceList(str2);
            q1.setChoiceList(str3);
            q1.setChoiceList(str4);

            // via check mark
            q1.setAnswer(str1);

            Intent i = new Intent(add_question.this, add_question.class);
            startActivity(i);
        }
        if(v.getId() == R.id.Bdone) {

            Intent i = new Intent(add_question.this, teacher_home.class);
            startActivity(i);
        }
    }

    // TODO: user enters question: setquestion()

    //Question [] questions = {
    //        new Question(q1, );
    //}

    // TODO: user enters answer: setanswer()

}