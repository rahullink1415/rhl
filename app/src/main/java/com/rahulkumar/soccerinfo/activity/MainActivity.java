package com.rahulkumar.soccerinfo.activity;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.rahulkumar.soccerinfo.R;
import com.rahulkumar.soccerinfo.fragment.ImagesFragment;
import com.rahulkumar.soccerinfo.fragment.ListsFragment;
import com.rahulkumar.soccerinfo.fragment.SchedulesFragment;
import com.rahulkumar.soccerinfo.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        fragment =new ListsFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_dashboard:
                        fragment =new SearchFragment();
                        loadFragment(fragment);

                        return true;
                    case R.id.navigation_notifications:
                        fragment =new SchedulesFragment();
                        loadFragment(fragment);

                        return true;
                    case R.id.navigation_image:
                        fragment =new ImagesFragment();
                        loadFragment(fragment);

                        return true;
                }
                return false;
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new ListsFragment());
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
