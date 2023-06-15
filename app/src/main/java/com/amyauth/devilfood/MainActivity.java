package com.amyauth.devilfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    TextView Registation_button;
    AppCompatButton login_button;
    TextInputEditText ed_myemial,ed_password;

    FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Registation_button = findViewById(R.id.Registation_button);
        ed_myemial = findViewById(R.id.ed_myemial);
        ed_password = findViewById(R.id.ed_password);
        login_button = findViewById(R.id.login_button);

        firebaseAuth = FirebaseAuth.getInstance();

        Registation_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Registation.class);
                startActivity(intent);
                finish();

            }
        });


        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String EMAIL = ed_myemial.getText().toString().trim();
                String PASSWORD = ed_password.getText().toString().trim();

                if (EMAIL.equals("")){
                    Toast.makeText(MainActivity.this, "Empty Email Field", Toast.LENGTH_SHORT).show();
                }else if (PASSWORD.equals("")){
                    Toast.makeText(MainActivity.this, "Empty Password field", Toast.LENGTH_SHORT).show();
                }else {


                    if (firebaseAuth !=null){

                        Intent intent = new Intent(MainActivity.this, Home.class);
                        startActivity(intent);
                        finish();

                    }else {

                        Intent intent = new Intent(MainActivity.this, Registation.class);
                        startActivity(intent);
                        finish();

                    }

                }




            }
        });




    }
}