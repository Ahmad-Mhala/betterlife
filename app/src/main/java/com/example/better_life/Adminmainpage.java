package com.example.better_life;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Adminmainpage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmainpage);
        CardView cd=findViewById(R.id.cardadmindonationmao);

    }

    public void donationmap(View view) {
        Intent in =new Intent(this,Donationmapforadmin.class);
        startActivity(in);

    }

    public void historyforadmin(View view) {
        Intent in =new Intent(this,userdataforadmin.class);
        startActivity(in);
    }

    public void logoutadmin(View view) {
        Intent in =new Intent(this,mainpageactivity.class);
        startActivity(in);
        finish();
    }
}