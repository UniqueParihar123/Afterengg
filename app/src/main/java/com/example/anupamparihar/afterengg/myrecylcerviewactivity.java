package com.example.anupamparihar.afterengg;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by anupam parihar on 10-07-2018.
 */

public class myrecylcerviewactivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myrecylerview);
        final DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String fileName=dataSnapshot.getKey();
                String url=dataSnapshot.getValue(String.class);
                ((MyAdapter)recyclerView.getAdapter()).update(fileName,url);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

   recyclerView = (RecyclerView) findViewById(R.id.rv);
           //for recycler view use custom adapter always
        recyclerView.setLayoutManager(new LinearLayoutManager(myrecylcerviewactivity.this));
                 MyAdapter myAdapter=new MyAdapter(recyclerView,myrecylcerviewactivity.this,new ArrayList<String>(),new ArrayList<String>());
recyclerView.setAdapter(myAdapter);

    }
}
