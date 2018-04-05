package com.example.max.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by max
 */

public class teacher_home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teacher_home);
    }

    ArrayList<Quiz> quizList = new ArrayList<>();

    public void onButtonClick(View v) {

        if(v.getId() == R.id.Btester) {



            Intent i = new Intent(teacher_home.this, make_quiz.class);
            startActivity(i);
        }

        if(v.getId() == R.id.Broster) {
            Intent i = new Intent(teacher_home.this, manage_roster.class);
            startActivity(i);
        }

    }

}
