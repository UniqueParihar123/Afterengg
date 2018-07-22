package com.example.anupamparihar.afterengg;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class csegatesyllfragment extends Fragment {
WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_csegatesyllfragment, container, false);

        webView=(WebView)view.findViewById(R.id.wv);

        webView.loadUrl("https://unique007.000webhostapp.com/csesyllabus.html");


        return view;
    }




}
