package com.example.ticket;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.ticket.ui.home.HomeFragment;
import com.example.ticket.ui.mypage.MypageFragment;
import com.example.ticket.ui.pub.PubFragment;
import com.example.ticket.ui.schedule.ScheduleFragment;
import com.example.ticket.ui.ticket.TicketFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    Fragment homeFragment;
    Fragment scheduleFragment;
    Fragment pubFragment;
    Fragment ticketFragment;
    Fragment mypageFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragment = new HomeFragment();
        scheduleFragment = new ScheduleFragment();
        pubFragment = new PubFragment();
        ticketFragment = new TicketFragment();
        mypageFragment = new MypageFragment();
        //최화면 설정
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, homeFragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.navigation_home:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container, homeFragment).commit();
                                return true;
                            case R.id.navigation_schedule:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,scheduleFragment).commit();
                                return true;
                            case R.id.navigation_pub:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,pubFragment).commit();
                                return true;
                            case R.id.navigation_ticket:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,ticketFragment).commit();
                                return true;
                            case R.id.navigation_mypage:
                                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,mypageFragment).commit();
                                return true;
                        }
                        return false;
                    }
                });

    }



}