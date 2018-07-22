package com.example.anupamparihar.afterengg;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
//Go to blank activity via put extra method and pass poition of listview items as key to blacnk activity ..Now Just use switch case for these keys to create new fragments
public class btechbranch extends AppCompatActivity {
ListView listview;
    ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btechbranch);
        listview=(ListView)findViewById(R.id.ls2);
        ArrayList<HashMap<String,String>> obj = new ArrayList<HashMap<String,String>>();
        final String text[]={"COMPUTER SCIENCE ENGG     >","ELECTRICAL ENGG    >","ELECTRONICS ENGG    >","MECHANICAL ENGG    >"};
        final int img[]={R.drawable.cse,R.drawable.eee,R.drawable.ece,R.drawable.me};
        int i;
        for(i=0;i<4;i++)
        {
            HashMap<String,String>  obj2 =new HashMap<String,String>();
            // obj.put(img[i]+"",text[i]);//error was here of type mispmatch which can be solved by using +""

            obj2.put("name",text[i]);
            obj2.put("image",img[i]+"");//yahan par bifercation hua hai MAPPING KE LIYE froom to use hua hai yahan
            obj.add(obj2);
        }

        String[] from={"name","image"};//sending name and image to View is a class
        int[] to={R.id.t1,R.id.im};//add ids of text view and imageview
        customadapter ca=new customadapter(getApplicationContext(),obj,R.layout.list,from,to);//we created a object with  parameters ise hmesha method ke andar krna hai iske
        //now we will use listview
        listview.setAdapter(ca);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int i, long id) {

                        Intent obj=new Intent(btechbranch.this,blankactivity.class);
                        obj.putExtra("pass",i);
                        startActivity(obj);




                //yahan pe item jo list me hai usse click krne r alag alag activity khulegi
            }
        });
    }
}
