package com.example.animations;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView = findViewById(R.id.animated_image_view);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Drawable drawable1 = ImageDecoder.decodeDrawable(ImageDecoder.createSource(getResources(), R.drawable.android_project));

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setImageDrawable(drawable1);
                        }
                    });
                    if (drawable1 instanceof Animatable){
                        ((AnimatedImageDrawable)drawable1).start();

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
