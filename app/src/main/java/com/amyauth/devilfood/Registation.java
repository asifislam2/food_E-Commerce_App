package com.amyauth.devilfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registation extends AppCompatActivity {

    TextInputEditText ed_name,ed_phone,ed_email,ed_pass,ed_area;
    AppCompatButton signin_button;

    FirebaseAuth firebaseAuth;

    DatabaseReference databaseReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registation);

        ed_name = findViewById(R.id.ed_name);
        ed_phone = findViewById(R.id.ed_phone);
        ed_email = findViewById(R.id.ed_email);
        ed_pass = findViewById(R.id.ed_pass);
        ed_area = findViewById(R.id.ed_area);
        signin_button = findViewById(R.id.signin_button);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("user");


        signin_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String NAME = ed_name.getText().toString();
                String PHONE = ed_phone.getText().toString();
                String EMAIL = ed_email.getText().toString();
                String PASS = ed_pass.getText().toString();
                String AREA = ed_area.getText().toString();

                if (NAME.equals("")){
                    Toast.makeText(Registation.this, "Empty Name Field", Toast.LENGTH_SHORT).show();
                }else if (PHONE.equals("")){
                    Toast.makeText(Registation.this, "Empty Phone Field", Toast.LENGTH_SHORT).show();
                }else if (EMAIL.equals("")){
                    Toast.makeText(Registation.this, "Empty Email Field", Toast.LENGTH_SHORT).show();
                }else if (PASS.equals("")){
                    Toast.makeText(Registation.this, "Empty Pass Field", Toast.LENGTH_SHORT).show();
                }else if (AREA.equals("")){
                    Toast.makeText(Registation.this, "Empty Area Field", Toast.LENGTH_SHORT).show();
                }else {


                    firebaseAuth.createUserWithEmailAndPassword(EMAIL, PASS).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){

                                FirebaseUser firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
                                String User_Id = firebaseUser.getUid();

                                HashMap<String , Object> hashMap = new HashMap<>();
                                hashMap.put("useerName", NAME);
                                hashMap.put("User_Id", User_Id);
                                hashMap.put("user_Phone", PHONE);
                                hashMap.put("area", AREA);
                                databaseReference.child(User_Id).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {

                                        Intent intent = new Intent(Registation.this, Home.class);
                                        startActivity(intent);
                                        finish();

                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {

                                        Toast.makeText(Registation.this, ""+e, Toast.LENGTH_SHORT).show();

                                    }
                                });


                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(Registation.this, ""+e, Toast.LENGTH_SHORT).show();

                        }
                    });


                }

            }
        });




    }
}