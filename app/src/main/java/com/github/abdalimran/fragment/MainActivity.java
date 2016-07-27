package com.github.abdalimran.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.abdalimran.fragment.fragments.FragmentOne;
import com.github.abdalimran.fragment.fragments.FragmentThree;
import com.github.abdalimran.fragment.fragments.FragmentTwo;
import com.github.abdalimran.fragment.fragments.StartFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        StartFragment startFragment=new StartFragment();
        fragmentTransaction.add(R.id.myFragment,startFragment);
        fragmentTransaction.commit();
    }

    public void replace(View view) {
        Fragment newFragment;
        if(view.getId()==R.id.btn1){
            newFragment=new FragmentOne();
        }else if(view.getId()==R.id.btn2){
            newFragment=new FragmentTwo();
        }else if(view.getId()==R.id.btn3){
            newFragment=new FragmentThree();
        }else {
            newFragment=new StartFragment();
        }
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.myFragment,newFragment);
        fragmentTransaction.setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();


    }
}