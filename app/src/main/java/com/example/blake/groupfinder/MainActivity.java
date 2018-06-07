package com.example.blake.groupfinder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

