package com.example.mzxue.fotagmobile;

import android.content.res.Configuration;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.graphics.drawable.Drawable;


import android.view.ViewGroup;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private RecyclerView.LayoutManager lm;
    private ArrayList<ImageModel> pics = new ArrayList<>();
    private MainAdapter ma;
    private ImageView createpics;
    private ImageView trash;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private Drawable filled;
    private Drawable unfilled;
    private int f = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            pics = savedInstanceState.getParcelableArrayList("pics");
            f = savedInstanceState.getInt("f");
        }
        filled = getResources().getDrawable(R.drawable.ic_star_black_24dp, null);
        unfilled = getResources().getDrawable(R.drawable.ic_star_border_black_24dp, null);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.mainview);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            lm = new GridLayoutManager(this, 2);
        } else{
            lm = new LinearLayoutManager(this);
        }

        rv.setLayoutManager(lm);
        create();
        createpics = findViewById(R.id.create);
        trash = findViewById(R.id.trash);
        star1 = findViewById(R.id.star1);
        star2 = findViewById(R.id.star2);
        star3 = findViewById(R.id.star3);
        star4 = findViewById(R.id.star4);
        star5 = findViewById(R.id.star5);

        if (f == 1){
            star1.setImageDrawable(filled);
            star2.setImageDrawable(unfilled);
            star3.setImageDrawable(unfilled);
            star4.setImageDrawable(unfilled);
            star5.setImageDrawable(unfilled);
        } else if (f==2){
            star1.setImageDrawable(filled);
            star2.setImageDrawable(filled);
            star3.setImageDrawable(unfilled);
            star4.setImageDrawable(unfilled);
            star5.setImageDrawable(unfilled);
        } else if (f==3){
            star1.setImageDrawable(filled);
            star2.setImageDrawable(filled);
            star3.setImageDrawable(filled);
            star4.setImageDrawable(unfilled);
            star5.setImageDrawable(unfilled);
        } else if (f==4){
            star1.setImageDrawable(filled);
            star2.setImageDrawable(filled);
            star3.setImageDrawable(filled);
            star4.setImageDrawable(filled);
            star5.setImageDrawable(unfilled);
        } else if (f==5){
            star1.setImageDrawable(filled);
            star2.setImageDrawable(filled);
            star3.setImageDrawable(filled);
            star4.setImageDrawable(filled);
            star5.setImageDrawable(filled);
        }

        createpics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pics.size() == 0) {
                    pics.add(new ImageModel("0.png"));
                    pics.add(new ImageModel("1.png"));
                    pics.add(new ImageModel("2.jpg"));
                    pics.add(new ImageModel("3.jpg"));
                    pics.add(new ImageModel("4.jpg"));
                    pics.add(new ImageModel("5.jpg"));
                    pics.add(new ImageModel("6.png"));
                    pics.add(new ImageModel("7.jpg"));
                    pics.add(new ImageModel("8.jpg"));
                    pics.add(new ImageModel("9.jpg"));
                    createpics.setClickable(false);
                    trash.setClickable(true);
                    create();

                }
            }
        });

        trash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pics.size() != 0) {
                    pics.clear();
                    create();
                    trash.setClickable(false);
                    createpics.setClickable(true);
                }

            }
        });

        star1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageDrawable(filled);
                star2.setImageDrawable(unfilled);
                star3.setImageDrawable(unfilled);
                star4.setImageDrawable(unfilled);
                star5.setImageDrawable(unfilled);
                ma.setfilter(1);
                f=1;
            }
        });

        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageDrawable(filled);
                star2.setImageDrawable(filled);
                star3.setImageDrawable(unfilled);
                star4.setImageDrawable(unfilled);
                star5.setImageDrawable(unfilled);
                ma.setfilter(2);
                f=2;
            }
        });

        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageDrawable(filled);
                star2.setImageDrawable(filled);
                star3.setImageDrawable(filled);
                star4.setImageDrawable(unfilled);
                star5.setImageDrawable(unfilled);
                ma.setfilter(3);
                f=3;
            }
        });

        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageDrawable(filled);
                star2.setImageDrawable(filled);
                star3.setImageDrawable(filled);
                star4.setImageDrawable(filled);
                star5.setImageDrawable(unfilled);
                ma.setfilter(4);
                f=4;
            }
        });

        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star1.setImageDrawable(filled);
                star2.setImageDrawable(filled);
                star3.setImageDrawable(filled);
                star4.setImageDrawable(filled);
                star5.setImageDrawable(filled);
                ma.setfilter(5);
                f=5;
            }
        });

    }
    void create(){
        ma = new MainAdapter(pics, this);
        rv.setAdapter(ma);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putParcelableArrayList("pics", pics);
        savedInstanceState.putInt("f", f);
        super.onSaveInstanceState(savedInstanceState);

    }
}
