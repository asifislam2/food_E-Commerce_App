package com.amyauth.devilfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    DrawerLayout drawer_layout;
    MaterialToolbar materialToolbar;
    FrameLayout fram_layout;
    NavigationView navigation_view;

    ProgressBar progressBar_cyclic;

    BottomNavigationView bottom_nagivation;




    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        drawer_layout = findViewById(R.id.drawer_layout);
        materialToolbar = findViewById(R.id.materialToolbar);
        fram_layout = findViewById(R.id.fram_layout);
        navigation_view = findViewById(R.id.navigation_view);
        progressBar_cyclic = findViewById(R.id.progressBar_cyclic);
        bottom_nagivation = findViewById(R.id.bottom_nagivation);

        firebaseAuth = FirebaseAuth.getInstance();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                Home.this, drawer_layout, materialToolbar,R.string.Close_Drawer,R.string.Open_Drawer
        );
        drawer_layout.addDrawerListener(toggle);

        progressBar_cyclic.setVisibility(View.VISIBLE);
        Load_web_Fragment.URl = "https://hungrynaki.com/";
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fram_layout, new Load_web_Fragment());
        transaction.commit();
        progressBar_cyclic.setVisibility(View.GONE);



        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId()==R.id.log_out){

                    firebaseAuth.signOut();
                    Intent intent = new Intent(Home.this, MainActivity.class);
                    startActivity(intent);

                }else if (item.getItemId()==R.id.developer_contract){

                    Load_web_Fragment.URl = "https://developers.google.com/";
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.add(R.id.fram_layout, new Load_web_Fragment());
                    transaction.commit();

                }else if (item.getItemId()==R.id.rate_app){

                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=PackageName")));

                }else if (item.getItemId()==R.id.share_app){

                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    String shareSubText = "WhatsApp - The Great Chat App";
                    String shareBodyText = "https://play.google.com/store/apps/details?id=com.whatsapp&hl=en";
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubText);
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                    startActivity(Intent.createChooser(shareIntent, "Share With"));

                }else if (item.getItemId()==R.id.more_app){

                    String str ="https://play.google.com/store/apps/details?id=ws.crandell.newspaperpuzzles";
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));

                }else if (item.getItemId()==R.id.Profile){

                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.add(R.id.fram_layout, new Profile_Fragment());
                    transaction.commit();

                }

                return false;
            }
        });


        bottom_nagivation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem instance) {

                if (instance.getItemId()==R.id.food_network){

                    Load_web_Fragment.URl = "https://hungrynaki.com/contact";
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.add(R.id.fram_layout, new Load_web_Fragment());
                    transaction.commit();

                }else if (instance.getItemId()==R.id.Delish){

                    Load_web_Fragment.URl = "https://hungrynaki.com/contact";
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.add(R.id.fram_layout, new Load_web_Fragment());
                    transaction.commit();

                }else if (instance.getItemId()==R.id.TheKitchn){

                    Load_web_Fragment.URl = "https://www.minellasdiner.com/online-menu";
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.add(R.id.fram_layout, new Load_web_Fragment());
                    transaction.commit();

                }else if (instance.getItemId()==R.id.Seriouseats){


                    Load_web_Fragment.URl = "https://www.minellasdiner.com/contact";
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.add(R.id.fram_layout, new Load_web_Fragment());
                    transaction.commit();


                }

                return true;
            }
        });
        



    }
}