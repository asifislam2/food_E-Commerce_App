package com.amyauth.devilfood;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Profile_Fragment extends Fragment {


    FirebaseUser firebaseUser;

    DatabaseReference databaseReference;

    List<Database_People> database_people;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,    Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile_, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView name = view.findViewById(R.id.name);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView area = view.findViewById(R.id.area);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView phone = view.findViewById(R.id.phone);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView id = view.findViewById(R.id.id);

        database_people = new ArrayList<>();

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("user").child(firebaseUser.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Database_People database_people = snapshot.getValue(Database_People.class);
                String DBNAME = database_people.getUseerName();
                String DBAREA_NAME = database_people.getArea();
                String DB_PHONE = database_people.getUser_Phone();
                String DB_ID = database_people.getUser_Id();

                name.append(""+DBNAME);
                area.append(""+DBAREA_NAME);
                phone.append(""+DB_PHONE);
                id.append(""+DB_ID);

                Log.i("TAG", "onDataChange: "+ database_people.getUseerName());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        return view;

    }


}