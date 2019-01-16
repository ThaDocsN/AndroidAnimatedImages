package com.example.animations;

import android.graphics.ImageDecoder;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        addTabs(viewPager);

       // final ImageView imageView = findViewById(R.id.animated_image_view);

        // gif animation
        /*new Thread(new Runnable() {
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
        }).start();*/

        // wolverine animation
       /* imageView.setImageDrawable(getDrawable(R.drawable.animation_playground));
        final Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable){
            ((Animatable)drawable).start();
        }*/

       //vector images
     /* imageView.setImageDrawable(getDrawable(R.drawable.avd_anim));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageDrawable(getDrawable(R.drawable.avd_anim));
                final Drawable drawable = imageView.getDrawable();
                if (drawable instanceof Animatable) {
                    ((Animatable) drawable).start();
                }
            }
        });*/
    }

    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GifFragment(), "Gif");
        adapter.addFragment(new WolverineFragment(), "Wolverine");
        adapter.addFragment(new VectorFragment(), "Vectors");
        viewPager.setAdapter(adapter);
    }

     class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> titleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title){
            fragmentList.add(fragment);
            titleList.add(title);
        }

         @Nullable
         @Override
         public CharSequence getPageTitle(int position) {
             return titleList.get(position);
         }
     }
}