package com.example.anupamparihar.afterengg;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by anupam parihar on 10-07-2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{


    RecyclerView recyclerView;
    Context context;
    ArrayList<String> items=new ArrayList<>();
    ArrayList<String> urls =new ArrayList<>();

    public void update (String name,String url)
    {
             items.add(name);
        urls.add(url);
        notifyDataSetChanged();//refreshes recyclerview automaticallly

    }

    public MyAdapter(RecyclerView recyclerView, Context context, ArrayList<String> items,ArrayList<String> urls) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.items = items;
        this.urls=urls;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //create views for listitems
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    //initialize value of individual items
        holder.itemtextview.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        //return number of items

        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemtextview;


        public ViewHolder(View itemView) {
            //reprsent individula list items
            super(itemView);


            itemtextview= (TextView) itemView.findViewById(R.id.itemtextview);
                  itemView.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          int position=recyclerView.getChildLayoutPosition(v);
                          //use intent to open browser
                          Intent intent=new Intent();
                          intent.setType(intent.ACTION_VIEW);
                          intent.setData(Uri.parse(urls.get(position)));
                          context.startActivity(intent);

                      }
                  });

        }
    }
}
