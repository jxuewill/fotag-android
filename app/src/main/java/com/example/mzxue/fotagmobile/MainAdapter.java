package com.example.mzxue.fotagmobile;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder> {
    private ArrayList<ImageModel> pics= new ArrayList<>();
    private ArrayList<ImageModel> ogpics = new ArrayList<>();
    private Context c;
    private Drawable unfilled;
    private Drawable filled;
    private int filter;

    MainAdapter(ArrayList<ImageModel> photos, Context context){
        ogpics = photos;
        c = context;
        filter = 5;
        filled = c.getResources().getDrawable(R.drawable.ic_star_black_24dp, null);
        unfilled = c.getResources().getDrawable(R.drawable.ic_star_border_black_24dp, null);
        update();
    }

    static class Holder extends RecyclerView.ViewHolder{
        ImageView star1;
        ImageView star2;
        ImageView star3;
        ImageView star4;
        ImageView star5;
        ImageView delete;
        ImageView image;
        Holder(LinearLayout ll){
            super(ll);
            star1 = ll.findViewById(R.id.star1);
            star2 = ll.findViewById(R.id.star2);
            star3 = ll.findViewById(R.id.star3);
            star4 = ll.findViewById(R.id.star4);
            star5 = ll.findViewById(R.id.star5);
            delete = ll.findViewById(R.id.delete);
            image = ll.findViewById(R.id.mainimage);
        }
    }
    @Override
    public int getItemCount(){
        return pics.size();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout layview = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);
        return new Holder(layview);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final String fa = pics.get(position).filename;
        try {
            InputStream ims = c.getAssets().open(fa);
            Drawable photo = Drawable.createFromStream(ims, null);
            holder.image.setImageDrawable(photo);
            ims.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        int rate = pics.get(position).rating;
        if (rate == 1){
            holder.star1.setImageDrawable(filled);
            holder.star2.setImageDrawable(unfilled);
            holder.star3.setImageDrawable(unfilled);
            holder.star4.setImageDrawable(unfilled);
            holder.star5.setImageDrawable(unfilled);
        } else if (rate == 2){
            holder.star1.setImageDrawable(filled);
            holder.star2.setImageDrawable(filled);
            holder.star3.setImageDrawable(unfilled);
            holder.star4.setImageDrawable(unfilled);
            holder.star5.setImageDrawable(unfilled);
        } else if (rate == 3){
            holder.star1.setImageDrawable(filled);
            holder.star2.setImageDrawable(filled);
            holder.star3.setImageDrawable(filled);
            holder.star4.setImageDrawable(unfilled);
            holder.star5.setImageDrawable(unfilled);
        } else if (rate == 4){
            holder.star1.setImageDrawable(filled);
            holder.star2.setImageDrawable(filled);
            holder.star3.setImageDrawable(filled);
            holder.star4.setImageDrawable(filled);
            holder.star5.setImageDrawable(unfilled);
        } else if (rate == 5){
            holder.star1.setImageDrawable(filled);
            holder.star2.setImageDrawable(filled);
            holder.star3.setImageDrawable(filled);
            holder.star4.setImageDrawable(filled);
            holder.star5.setImageDrawable(filled);
        }

        final int p = position;
        holder.star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pics.get(p).setrating(1);
                update();
            }
        });

        holder.star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pics.get(p).setrating(2);
                update();
            }
        });

        holder.star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pics.get(p).setrating(3);
                update();
            }
        });

        holder.star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pics.get(p).setrating(4);
                update();
            }
        });

        holder.star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pics.get(p).setrating(5);
                update();
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pics.get(p).setrating(5);
                update();
            }
        });

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(c, PopupActivity.class);
                i.putExtra("image", fa);
                c.startActivity(i);
            }
        });


    }
    void setfilter(int f){
        filter =f;
        update();
    }

    void update() {
        ArrayList<ImageModel> temp = new ArrayList<ImageModel>();
        for (ImageModel image : ogpics) {
            if (image.rating >= filter) {
                temp.add(image);
            }
        }
        pics.clear();
        pics = temp;
        notifyDataSetChanged();
    }
}
