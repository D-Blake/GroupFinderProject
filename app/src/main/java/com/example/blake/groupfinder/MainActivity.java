package com.example.blake.groupfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //
                EditText name = (EditText) findViewById(R.id.editText6);
                TextView email = (TextView) findViewById(R.id.textView6);
                TextView password = (TextView) findViewById(R.id.textView4);
                TextView passwordConfirm = (TextView) findViewById(R.id.textView5);

                EditText errors = (EditText) findViewById(R.id.editText7);
                errors.setText("");

                Animation anim = new AlphaAnimation(0.0f, 1.0f);
                anim.setDuration(50); //You can manage the time of the blink with this parameter
                anim.setStartOffset(20);
                anim.setRepeatMode(Animation.REVERSE);
                anim.setRepeatCount(Animation.INFINITE);

                boolean completeName = true;
                boolean completeEmail = true;
                boolean completePassword = true;

                if(name.toString() == null || name.toString() == ""){
                    completeName = false;
                    errors.setText("Please Enter a Name");
                    errors.startAnimation(anim);
                }
                if(email.toString() == null || email.toString() == ""){
                    completeEmail = false;
                    errors.setText("Please Enter an Email");
                    errors.startAnimation(anim);
                }
                if(password.toString() == null || password.toString() == ""){
                    completePassword = false;
                    errors.setText("Please Enter a Password");
                    errors.startAnimation(anim);
                }
                if(password.toString() != passwordConfirm.toString()){
                    completePassword = false;
                    errors.setText("Passwords Do Not Match");
                    errors.startAnimation(anim);
                }

                if(completeEmail && completeName && completePassword) {
                    long timeMilli = System.currentTimeMillis();
                    long timeSeconds = System.currentTimeMillis() / 1000;

                    User user = new User(name.toString(), email.toString(), password.toString());
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference();
                    myRef.child("users").child(String.valueOf(timeMilli*(timeSeconds/3))).setValue(user);
                }
                //editText6 name
                //textView4 pw
                //textView6 email
            }
        });
    }

    public void eventsPage(View view){
        setContentView(R.layout.events_page);
    }
    public void goTo_Create(View view) {
        setContentView(R.layout.create);
    }
    public void chatPage(View view){
        setContentView(R.layout.chat_room);
    }
    public void profilePage(View view){
        setContentView(R.layout.activity_profile);
    }
    public void loginPage(View view){
        setContentView(R.layout.login);
    }
    public void homePage(View view){
        setContentView(R.layout.activity_main);
    }
}
