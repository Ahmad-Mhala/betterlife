package com.example.better_life;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class mainpageactivity extends AppCompatActivity {
private TabLayout tablayout;
private ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpageactivity);
        tablayout =findViewById(R.id.tabLayout);
        viewpager=findViewById(R.id.viewpager);
        tablayout.setupWithViewPager(viewpager);
        mainpageadapter ad=new mainpageadapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ad.addfragment(new loginfragment(),"Log in");
        ad.addfragment(new signup(),"Register");
        ad.addfragment(new Adminloginfragment(),"Admin");
        ad.addfragment(new contactusfragment(),"About us");

        viewpager.setAdapter(ad);

    }
}