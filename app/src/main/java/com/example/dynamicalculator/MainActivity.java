package com.example.dynamicalculator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager viewPager;
    Toolbar tool;

    CalculatorFragment calculatorFragment;
    HistoryFragment historyFragment;
    Slabs slabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab=findViewById(R.id.tabLayout);
        tool=findViewById(R.id.toolbar);
        viewPager=findViewById(R.id.viewPager);
        setSupportActionBar(tool);

        calculatorFragment=new CalculatorFragment();
        historyFragment= new HistoryFragment();
        slabs=new Slabs();

        tab.setupWithViewPager(viewPager);
        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager(),0);
        adapter.addFragment(slabs,"Slabs");
        adapter.addFragment(calculatorFragment,"Calculator");
        adapter.addFragment(historyFragment,"HIstory");
        viewPager.setAdapter(adapter);

    }
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragments = new ArrayList<>();
        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment, String title) {
            fragments.add(fragment);
            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return fragmentTitle.get(position);
        }
    }
}