package com.example.max.myapplication;

import android.app.Activity;
        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.CheckBox;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.ValueEventListener;

/**
 * Created by administrator on 4/3/18.
 */

public class sign_up extends Activity {

    String username;
    boolean teacher = true;
    boolean noDuplicate = false; //to test and see if there is duplicate username in database
    DatabaseReference userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
        userDatabase = FirebaseDatabase.getInstance().getReference("users");
    }

    public void itemClicked(View v) {
        CheckBox checkBox = (CheckBox)v;
        if (checkBox.isChecked()) {
            teacher = true;
        } else {
            teacher = false;
        }
    }

    public void onButtonClick(View v) {

        if(v.getId() == R.id.Bsignup) {
            TextView ETfirstname = findViewById(R.id.ETfirstname);
            String first =  ETfirstname.getText().toString().trim();

            TextView ETlastname = findViewById(R.id.ETlastname);
            String last = ETlastname.getText().toString().trim();

            username = first + "." + last; //standard format for the username

            TextView ETpassword = findViewById(R.id.ETpassword);
            String password = ETpassword.getText().toString().trim();

            TextView ETconfirm = findViewById(R.id.ETconfirm);
            String confirm = ETconfirm.getText().toString().trim();


            FirebaseDatabase.getInstance().getReference().child("users")
                    .addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            long totalChildren = dataSnapshot.getChildrenCount();
                            int currentChild = 0;

                            User user = null;

                            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                                currentChild++;
                                user = snapshot.getValue(User.class);
                                if( ( ( (user.username).equals(username) ) && currentChild<totalChildren) ) {
                                    System.out.println("There is a duplicate " + "(user.username) " +
                                            (user.username) + " == " + "username " + username);

                                    makeToast("Username taken, add a number to name and try again.");

                                    noDuplicate = false;
                                    break;
                                }
                                //else {
                                    //System.out.println("There is no duplicate " + "(user.username) " +
                                            //(user.username) + " != " + "username " + username);
                               // }
                            }
                            System.out.println("totalChildren" + totalChildren);
                        }
                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                        }
                    });

            if ((password.length()>0 && confirm.length()>0) && !noDuplicate) {
                if (password.equals(confirm)) {
                    if (teacher == true) {
                        User u = new User(first, last, username, password, teacher);
                        userDatabase.push().setValue(u);
                    } else {
                        User u = new User(first, last, username, password, teacher);
                        userDatabase.push().setValue(u);
                    }
                    makeToast("Account created.");
                } else {
                    makeToast("Passwords do not match!");
                }
            }
        }
    }

    public void makeToast(String word){
        Toast.makeText(sign_up.this, word, Toast.LENGTH_SHORT).show();
    }

}
