package com.example.numberconverterpluscalculator;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.google.android.material.appbar.AppBarLayout;

public class PageAdapter extends FragmentPagerAdapter {
    int tabcount;
    public PageAdapter(FragmentManager fm, int behavior){
        super(fm,behavior);
        tabcount = behavior;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new Fragment1();
            case 1: return new Fragment2();
            case 2: return new Fragment3();
            default: return null;
        }//end of switch statement

    }//end of getItem method

    @Override
    public int getCount() {
        return tabcount;
    }
}

