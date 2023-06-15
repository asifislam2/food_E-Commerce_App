package com.amyauth.devilfood;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class Load_web_Fragment extends Fragment {

    WebView web_view;

  public static String URl;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_load_web_, container, false);
        web_view = view.findViewById(R.id.web_view);

        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.loadUrl(URl);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.setWebViewClient(new WebViewClient());



        return view;
    }
}