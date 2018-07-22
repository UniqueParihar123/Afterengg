package com.example.anupamparihar.afterengg;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

//isme hm home fragment se pehle card pe click krke naye activity me gye hain
public class homefragment extends Fragment {
   CardView cardview1;
   CardView cardView2;
    CardView cardView6;
    CardView cardView4;
    Button button;
    boolean session;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_homefragment, container, false);
        cardview1=(CardView)view.findViewById(R.id.cv1);
        cardView2=(CardView)view.findViewById(R.id.cv2);
        cardView6=(CardView)view.findViewById(R.id.cv6);
        cardView4=(CardView)view.findViewById(R.id.cv4);
       button=(Button)view.findViewById(R.id.logout);

  SESSION();
        //for logout

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Save.save(getActivity(),"session","false");

                Intent logagain = new Intent(getActivity(),login.class);
                startActivity(logagain);
                getActivity().finish();

            }
        });

       //for branches in engg
        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override //button me getappcontext nhi hota
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), btechbranch.class);
                startActivity(intent);//creating fragment by clicking on main
            }
        });


//For file sharing among users

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 =new Intent(getActivity(),Main2Activity.class);
                startActivity(intent2);
            }
        });
        cardView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent6 =new Intent(getActivity(),feedback.class);
                 startActivity(intent6);

            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent4 =new Intent(getActivity(),newsmain.class);
                startActivity(intent4);

            }
        });
        return view;
    }

    public void SESSION()
    {

         session = Boolean.valueOf(Save.read(getActivity(),"session","false"));

           if(!session)
           {
               //here when user logout
               Intent registerplease =new Intent(getActivity(),login.class);
               startActivity(registerplease);
                getActivity().finish();


           }

           else
               {
                   //here when user logged in
                   //value changed to true
                   Toast.makeText(getActivity(), "Logged In", Toast.LENGTH_SHORT).show();
               }
    }


}
