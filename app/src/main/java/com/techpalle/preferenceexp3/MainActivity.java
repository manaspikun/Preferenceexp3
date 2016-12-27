package com.techpalle.preferenceexp3;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // MyDialogFrag myDilogFragment=new MyDialogFrag();
        //myDilogFragment.show(getSupportFragmentManager(),null);
        FragmentOne f1=new FragmentOne();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.add(R.id.container1,f1);
        ft.commit();

    }
}
