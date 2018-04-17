package com.example.max.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: add firebase instantiations here
    }

    public void onButtonClick(View v) {

        if(v.getId() == R.id.Bsignin) {
            Intent i = new Intent(MainActivity.this, sign_in.class);
            startActivity(i);
        }

        else if(v.getId() == R.id.Bsignup) {
            Intent i = new Intent(MainActivity.this, sign_up.class);
            startActivity(i);
        }

    }

}
