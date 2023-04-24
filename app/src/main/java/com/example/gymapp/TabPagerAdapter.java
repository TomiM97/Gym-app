package com.example.gymapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.gymapp.fragments.FragmentFrontPage;
import com.example.gymapp.fragments.FragmentGraphs;
import com.example.gymapp.fragments.FragmentWeight;
import com.example.gymapp.fragments.fragmentNewWorkout;

public class TabPagerAdapter extends FragmentStateAdapter{
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentFrontPage();
            case 1:
                return new fragmentNewWorkout();
            case 2:
                return new FragmentGraphs();
            case 3:
                return new FragmentWeight();
            default:
                return new FragmentFrontPage();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
