package com.example.max.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class sign_in extends Activity {

    DatabaseReference userDatabase;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);
        userDatabase = FirebaseDatabase.getInstance().getReference("users");
    }

    public void onButtonClick(View v){
        TextView tv1 = findViewById(R.id.ETusername);
        final String username = tv1.getText().toString();

        TextView tv2 = findViewById(R.id.ETpassword);
        final String password = tv2.getText().toString();

        /* Searches the database if the username and password match */
        FirebaseDatabase.getInstance().getReference().child("users")
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Boolean invalidLogin = true;
                        User user = null;

                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            user = snapshot.getValue(User.class);
                            if(((user.username.equals(username)) && (user.password.equals(password)))){

                                invalidLogin = false;
                                if(user.isTeacher){
                                    Intent i = new Intent(getApplicationContext(), teacher_home.class);
                                    startActivity(i);
                                }
                                else if(!user.isTeacher){
                                    Intent i = new Intent(getApplicationContext(), student_home.class);
                                    startActivity(i);
                                }
                            }
                        }
                        if(invalidLogin){
                            makeToast("Username or password are incorrect.");
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }

    public void makeToast(String word){
        Toast.makeText(sign_in.this, word, Toast.LENGTH_SHORT).show();
    }
}