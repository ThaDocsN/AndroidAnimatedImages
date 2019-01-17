package com.example.animations;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;

public class GifFragment extends Fragment {

    ImageView imageView;

    public GifFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       return inflater.inflate(R.layout.fragment_gif, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = view.findViewById(R.id.imageView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    final Drawable drawable1 = ImageDecoder.decodeDrawable(ImageDecoder.createSource(getResources(), R.drawable.android_project));
                    getActivity().runOnUiThread(new Runnable() {
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
