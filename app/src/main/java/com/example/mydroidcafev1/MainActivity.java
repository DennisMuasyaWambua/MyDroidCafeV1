package com.example.mydroidcafev1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inflate your toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //create an instance of the the tab layout and add the tabs
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_label_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.pasta));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.store));
        //set the tab to fill the layout
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //use pager adapter to manage screens
        //create an instance of the view pager
        final ViewPager2 viewPager = findViewById(R.id.vew_pager);
        //create an instance of the PagerAdapter
        FragmentManager fm = getSupportFragmentManager();
        PagerAdapter pagerAdapter  = new PagerAdapter(fm,getLifecycle());
        //set the adapter to the view pager
        viewPager.setAdapter(pagerAdapter);
        //handling the clicks
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }
}