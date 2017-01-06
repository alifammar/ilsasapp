package com.example.alf.ilsasapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.net.Uri;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //view objects
    private TextView textViewUserEmail;
    private Button buttonLogout;
    private Button buttonEbook1;
    private Button buttonEbook2;
    private Button buttonEbook3;
    private Button buttonEbook4;
    private Button buttonEbook5;
    private Button buttonEbook6;
    private Button buttonEbook7;
    private Button buttonEbook8;
    private Button buttonEbook9;
    private Button buttonEbook10;
    private Button buttonEbook11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonEbook1 = (Button) findViewById(R.id.buttonEbook1);
        buttonEbook2 = (Button) findViewById(R.id.buttonEbook2);
        buttonEbook3 = (Button) findViewById(R.id.buttonEbook3);
        buttonEbook4 = (Button) findViewById(R.id.buttonEbook4);
        buttonEbook5 = (Button) findViewById(R.id.buttonEbook5);
        buttonEbook6 = (Button) findViewById(R.id.buttonEbook6);
        buttonEbook7 = (Button) findViewById(R.id.buttonEbook7);
        buttonEbook8 = (Button) findViewById(R.id.buttonEbook8);
        buttonEbook9 = (Button) findViewById(R.id.buttonEbook9);
        buttonEbook10 = (Button) findViewById(R.id.buttonEbook10);
        buttonEbook11 = (Button) findViewById(R.id.buttonEbook11);

        //displaying logged in user name
        textViewUserEmail.setText("Welcome "+user.getEmail());

        //adding listener to button
        buttonLogout.setOnClickListener(this);
        buttonEbook1.setOnClickListener(this);
        buttonEbook2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view == buttonEbook1) {
            Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
            myWebLink.setData(Uri.parse("https://drive.google.com/file/d/0B2QcMIPOkwo-X2dUOGVPZm00eUE/view?usp=sharing"));
            startActivity(myWebLink);
        }
            //startActivity(new Intent(this, Ebook1Activity.class));

        if (view == buttonEbook2) {
            Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
            myWebLink.setData(Uri.parse("https://drive.google.com/file/d/0B2QcMIPOkwo-X2dUOGVPZm00eUE/view?usp=sharing"));
            startActivity(myWebLink);
        }
        //startActivity(new Intent(this, Ebook1Activity.class));




        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}

/*
    public void onClick(View view) {
        if (view == buttonRegister){
            registerUser();
        }
        if(view == textViewSignin){
            //will open login activity page
            startActivity(new Intent(this, LoginActivity.class));
        }
    }*/
