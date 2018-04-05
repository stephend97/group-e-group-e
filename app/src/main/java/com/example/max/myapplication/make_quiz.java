package com.example.max.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by max
 */

public class make_quiz extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.make_quiz);
    }

    public void onButtonClick(View v) {

        if(v.getId() == R.id.Baddqs) {
            Intent i = new Intent(make_quiz.this, add_question.class);
            startActivity(i);
        }

        if(v.getId() == R.id.Bcomplete) {
            Intent i = new Intent(make_quiz.this, teacher_home.class);
            startActivity(i);
        }
    }
}