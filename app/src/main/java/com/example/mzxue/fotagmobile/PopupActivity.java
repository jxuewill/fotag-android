package com.example.mzxue.fotagmobile;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class PopupActivity extends AppCompatActivity {
    String filename;
    ImageView image;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoom);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            filename = extras.getString("image");
        }

        image = findViewById(R.id.pic);
        try {
            InputStream ims = getAssets().open(filename);
            Drawable photo = Drawable.createFromStream(ims, null);
            image.setImageDrawable(photo);
            ims.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    };
}
