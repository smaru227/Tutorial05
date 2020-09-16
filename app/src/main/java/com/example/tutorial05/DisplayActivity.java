package com.example.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        textView = findViewById(R.id.txtDetails);

        String details;

        details = "First Name: "+intent.getStringExtra("first_name")
                +"\nLast Name: "+intent.getStringExtra("last_name")
                +"\nUsername: "+intent.getStringExtra("username")
                +"\nPassword: "+intent.getStringExtra("password")
                +"\nCity: "+intent.getStringExtra("city")
                +"\nGender: "+intent.getStringExtra("gender")
                +"\nStatus: "+intent.getStringExtra("status");

        textView.setText(details);
    }
}